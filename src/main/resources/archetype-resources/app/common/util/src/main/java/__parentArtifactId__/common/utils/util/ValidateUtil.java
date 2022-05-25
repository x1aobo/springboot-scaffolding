#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.utils.util;

import ${package}.${parentArtifactId}.common.utils.enums.CommonErrorEnum;
import ${package}.${parentArtifactId}.common.utils.exception.IErrorCode;
import ${package}.${parentArtifactId}.common.utils.exception.PlatformException;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 通用校验工具类
 *
 * @author cjunl
 */
public class ValidateUtil {

    public static void notEmpty(Object param, String message, IErrorCode errorCode) {
        if (isEmpty(param)) {
            throw new PlatformException(errorCode, message);
        }
    }

    public static void notEmpty(Object param, IErrorCode errorCode) {
        if (isEmpty(param)) {
            throw new PlatformException(errorCode, errorCode.getMsg());
        }
    }
    public static void notEmpty(Object param, String message) {
        notEmpty(param, message, CommonErrorEnum.PARAM_INVALID);
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new PlatformException(CommonErrorEnum.PARAM_INVALID, message);
        }
    }

    /**
     * 判真，不真则抛异常
     *
     * @param condition 条件
     * @param message   message
     */
    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new PlatformException(CommonErrorEnum.PARAM_INVALID, message);
        }
    }

    private static boolean isEmpty(Object param) {
        return param == null
                || (param instanceof String && StringUtils.isBlank((String) param))
                || (param instanceof Collection<?> && CollectionUtils.isEmpty((Collection<?>) param))
                || (param instanceof List<?> && CollectionUtils.isEmpty((List<?>) param))
                || (param instanceof Map<?, ?> && CollectionUtils.isEmpty((Map<?, ?>) param));
    }
}
