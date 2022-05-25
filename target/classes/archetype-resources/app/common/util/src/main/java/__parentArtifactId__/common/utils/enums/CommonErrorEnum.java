#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.utils.enums;

import ${package}.${parentArtifactId}.common.utils.exception.IErrorCode;

/**
 * @author cjunl
 */

public enum CommonErrorEnum implements IErrorCode {

    PARAM_INVALID("019001", "无效参数"),
    USER_NOT_LOGIN("019002", "用户未登录"),
    PLANET_INIT_ERROR("019003", "系统初始化异常"),
    DATA_ACCESS_ERROR("019004", "数据库操作异常,请联系管理员"),
    SYSTEM_ERROR("019999", "系统异常"),
    ;

    /**
     * error sourcecode
     */
    private final String code;

    /**
     * error description
     */
    private final String msg;

    CommonErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
