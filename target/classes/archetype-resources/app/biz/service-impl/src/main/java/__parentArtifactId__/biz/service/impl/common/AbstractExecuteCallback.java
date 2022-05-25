#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.biz.service.impl.common;

/**
 * 执行回调基本实现
 *
 * @author cjunl
 */
public abstract class AbstractExecuteCallback<T> implements ExecuteCallback<T> {


    @Override
    public abstract void check();

    @Override
    public abstract T execute();

    @Override
    public T postExecute(T t) {
        //默认实现直接返回
        return t;
    }
}
