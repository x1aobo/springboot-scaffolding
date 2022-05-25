#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.utils.result;

import java.io.Serializable;

/**
 * 通用Rest请求返回参数
 *
 * @author cjunl
 */
public class Result<T> extends ToString implements Serializable {
    private static final long serialVersionUID = 1393009084346246687L;

    private boolean success;

    private ErrorInfo errorInfo;

    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> failed(ErrorInfo errorInfo) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setErrorInfo(errorInfo);
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.success = false;
        this.errorInfo = errorInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.success = true;
        this.data = data;
    }
}
