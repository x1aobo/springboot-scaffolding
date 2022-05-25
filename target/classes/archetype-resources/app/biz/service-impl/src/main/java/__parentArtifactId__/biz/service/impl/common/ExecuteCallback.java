#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.biz.service.impl.common;

/**
 * 模版执行回调
 *
 * @author cjunl
 */
public interface ExecuteCallback<T> {

    /**
     * 检查入参
     */
    void check();

    /**
     * 执行
     */
    T execute();

    /**
     * 执行后操作
     */
    T postExecute(T t);
}
