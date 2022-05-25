#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.utils.exception;

/**
 * @author cjunl
 */
public interface IErrorCode {
    String getCode();

    String getMsg();
}
