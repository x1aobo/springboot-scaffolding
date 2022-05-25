#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.utils.result;

import ${package}.${parentArtifactId}.common.utils.exception.IErrorCode;

import java.io.Serializable;

/**
 * 通用错误信息
 *
 * @author cjunl
 */
public class ErrorInfo extends ToString implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 928039782894241077L;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 构造函数
     */
    public ErrorInfo(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ErrorInfo() {
    }

    public static ErrorInfo of(IErrorCode error) {
        if (error == null) {
            throw new IllegalArgumentException();
        }
        return new ErrorInfo(error.getCode(), error.getMsg());
    }
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
