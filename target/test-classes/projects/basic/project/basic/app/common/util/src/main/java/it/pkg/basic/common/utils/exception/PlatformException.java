package it.pkg.basic.common.utils.exception;

import java.util.Optional;

/**
 * 平台运行时异常
 */
public class PlatformException extends RuntimeException {
    /**
     * 错误枚举code
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 内部信息
     */
    private String innerMessage;

    /**
     * 构造函数
     *
     * @param errorCode
     */
    public PlatformException(IErrorCode errorCode) {
        super();
        this.errorCode = errorCode.getCode();
        this.errorMsg = errorCode.getMsg();
    }

    /**
     * 构造函数
     *
     * @param errorCode
     * @param e
     */
    public PlatformException(IErrorCode errorCode, Throwable e) {
        super(e);
        this.errorCode = errorCode.getCode();
        this.errorMsg = errorCode.getMsg();
    }

    /**
     * 构造函数,支持指定自定义错误信息
     *
     * @param errorCode
     * @param errMsg
     */
    public PlatformException(IErrorCode errorCode, String errMsg) {
        super(errMsg);
        this.errorCode = errorCode.getCode();
        this.errorMsg = errMsg;
    }

    /**
     * 构造函数,支持指定自定义错误信息
     *
     * @param errorCode
     * @param errMsg
     */
    public PlatformException(IErrorCode errorCode, String errMsg, String innerMessage) {
        super(errMsg);
        this.errorCode = errorCode.getCode();
        this.errorMsg = Optional.ofNullable(errMsg).orElse(errorCode.getMsg());
        this.innerMessage = innerMessage;
    }

    /**
     * 构造函数,支持指定自定义错误信息
     *
     * @param errorCode
     * @param errMsg
     * @param e
     */
    public PlatformException(IErrorCode errorCode, String errMsg, Throwable e) {
        super(errMsg, e);
        this.errorCode = errorCode.getCode();
        this.errorMsg = errMsg;
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     *
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Getter method for property <tt>errorMsg</tt>.
     *
     * @return property value of errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    public String getInnerMessage() {
        return innerMessage;
    }

}
