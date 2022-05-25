package it.pkg.basic.biz.service.impl.common;

import it.pkg.basic.common.utils.enums.CommonErrorEnum;
import it.pkg.basic.common.utils.exception.PlatformException;
import it.pkg.basic.common.utils.result.ErrorInfo;
import it.pkg.basic.common.utils.result.Result;
import it.pkg.basic.common.utils.util.LoggerUtil;
import org.apache.ibatis.exceptions.IbatisException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

/**
 * 执行模版
 *
 * @author cjunl
 */
public class ExecuteTemplate {
    private static final Logger logger = LoggerFactory.getLogger(ExecuteTemplate.class);

    public static <T> Result<T> execute(ExecuteCallback<T> callback) {
        Result<T> result = new Result<T>();
        try {
            callback.check();
            T t = callback.execute();
            t = callback.postExecute(t);
            result.setData(t);
        } catch (PlatformException e) {
            LoggerUtil.warn(logger, "platform service invoke exception", e.getErrorMsg(), e.getInnerMessage());
            result.setErrorInfo(new ErrorInfo(e.getErrorCode(), e.getErrorMsg()));
        } catch (DataAccessException e) {
            LoggerUtil.error(logger, "data access exception", e, e.getMessage());
            result.setErrorInfo(new ErrorInfo(CommonErrorEnum.DATA_ACCESS_ERROR.getCode(),
                    CommonErrorEnum.DATA_ACCESS_ERROR.getMsg()));
        } catch (IbatisException e) {
            LoggerUtil.error(logger, "ibatis access exception", e, e.getMessage());
            result.setErrorInfo(new ErrorInfo(CommonErrorEnum.DATA_ACCESS_ERROR.getCode(),
                    CommonErrorEnum.DATA_ACCESS_ERROR.getMsg()));
        } catch (Exception e) {
            LoggerUtil.error(logger, "other service exception", e, e.getMessage());
            result.setErrorInfo(new ErrorInfo(CommonErrorEnum.SYSTEM_ERROR.getCode(),
                    CommonErrorEnum.SYSTEM_ERROR.getMsg() + ": " + e.getMessage()));
        }
        return result;
    }
}
