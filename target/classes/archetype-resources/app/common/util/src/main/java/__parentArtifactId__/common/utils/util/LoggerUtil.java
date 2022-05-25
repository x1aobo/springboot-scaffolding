#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.utils.util;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 规范化日志打印工具，注意日志的级别选择
 *
 * @author cjunl
 */
public final class LoggerUtil {
    /**
     * 日志参数前缀"("
     */
    private static final String LOG_PARAM_PREFIX = "(";
    /**
     * 日志参数后缀")"
     */
    private static final String LOG_PARAM_SUFFIX = ")";
    /**
     * 线程编号修饰符
     */
    private static final char THREAD_RIGHT_TAG = ']';
    /**
     * 线程编号修饰符
     */
    private static final char THREAD_LEFT_TAG = '[';
    /**
     * 键值对连接符
     */
    private static final String KEY_VALUE_CONNECTOR = "=";
    /**
     * 键值对分隔符
     */
    private static final String KEY_VALUE_SEPARATOR = ";";
    /**
     * 键值对分隔符
     */
    private static final String LOG_ITEM_TOKEN = ",";

    /**
     * 禁用构造函数
     */
    private LoggerUtil() {
        // 禁用构造函数
    }

    /**
     * 生成<font color="blue">调试</font>级别日志<br> 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger 调用方使用的logger
     * @param obj    附加参数信息
     */
    public static void debug(Logger logger, Object... obj) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogString(obj));
        }
    }

    /**
     * 生成<font color="blue">调试</font>级别日志<br>
     *
     * @param logger 调用方使用的logger
     * @param e      捕获到的异常
     */
    public static void debug(Logger logger, Throwable e) {
        if (logger.isDebugEnabled()) {
            logger.debug("", e);
        }
    }

    /**
     * 输出调试信息
     *
     * @param logger 调用方使用的logger
     * @param obj    附加参数信息
     */
    public static void debugDetail(Logger logger, Object... obj) {
        if (logger.isDebugEnabled()) {
            logger.debug(getDetailLogString(obj));
        }
    }

    /**
     * 生成<font color="blue">通知</font>级别日志<br> 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger 调用方使用的logger
     * @param obj    附加参数信息
     */
    public static void info(Logger logger, Object... obj) {
        if (logger.isInfoEnabled()) {
            logger.info(getLogString(obj));
        }
    }

    /**
     * 生成<font color="blue">通知</font>级别日志<br> 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费 说明：
     * 对比上面的info方法，此方法输出的日志信息更加详细，使用时请注意输出对性能的影响
     *
     * @param logger 调用方使用的logger
     * @param obj    附加参数信息
     */
    public static void infoDetail(Logger logger, Object... obj) {
        if (logger.isInfoEnabled()) {
            logger.info(getDetailLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">警告</font>级别日志<br> 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger 调用方使用的logger
     * @param obj    附加参数信息
     */
    public static void warn(Logger logger, Object... obj) {
        if (logger.isWarnEnabled()) {
            logger.warn(getLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">警告</font>级别日志<br> 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger 调用方使用的logger
     * @param desc   输出信息
     * @param t      异常
     * @param obj    附加参数信息
     */
    public static void warn(Logger logger, String desc, Throwable t, Object... obj) {
        if (logger.isWarnEnabled()) {
            logger.warn(getThrowableLogString(desc, obj), t);
        }
    }

    /**
     * 打印带format格式的error级别日志
     *
     * @param logger 调用方使用的logger
     * @param obj    附加参数信息
     */
    public static void error(Logger logger, Object... obj) {
        logger.error(getLogString(obj));
    }

    /**
     * 打印带format格式的error级别日志
     *
     * @param logger 调用方使用的logger
     * @param desc   输出信息
     * @param t      异常
     * @param obj    附加参数信息
     */
    public static void error(Logger logger, String desc, Throwable t, Object... obj) {
        logger.error(getThrowableLogString(desc, obj), t);
    }

    /**
     * 生成输出到日志的字符串
     *
     * @param obj 任意个要输出到日志的参数
     * @return 非空
     */
    private static String getLogString(Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append(parseBasicLog());
        if (obj != null && obj.length > 0) {
            log.append(LOG_PARAM_PREFIX);
            for (int i = 0; i < obj.length; i++) {
                log.append(obj[i]);
                if (obj.length - 1 != i) {
                    log.append(LOG_ITEM_TOKEN);
                }
            }
            log.append(LOG_PARAM_SUFFIX);
        }
        return log.toString();
    }

    /**
     * 生成带异常堆栈输出到日志的字符串
     *
     * @param obj 任意个要输出到日志的参数
     * @return 非空
     */
    private static String getThrowableLogString(String desc, Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append(parseBasicLog());
        log.append(LOG_PARAM_PREFIX);
        log.append(desc);
        if (obj != null && obj.length > 0) {
            log.append(LOG_ITEM_TOKEN);
            for (int i = 0; i < obj.length; i++) {
                log.append(obj[i]);

                if (obj.length - 1 != i) {
                    log.append(LOG_ITEM_TOKEN);
                }
            }
        }
        log.append(LOG_PARAM_SUFFIX);
        return log.toString();
    }

    /**
     * 生成输出到日志的字符串(对比getLogString，本方法会详细输出List,map等指定集合信息)
     *
     * @param obj 任意个要输出到日志的参数
     * @return 非空
     */
    @SuppressWarnings("unchecked")
    private static String getDetailLogString(Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append(THREAD_LEFT_TAG).append(Thread.currentThread().getId()).append(THREAD_RIGHT_TAG);
        for (Object o : obj) {
            if (o instanceof Map) {
                log.append(objectMap2string((Map) o));
            } else if (o instanceof String) {
                log.append((String) o);
            } else if (o instanceof List) {
                log.append(objectList2String((List) o));
            } else {
                log.append(ToStringBuilder.reflectionToString(o));
            }
            log.append(KEY_VALUE_SEPARATOR);
        }
        return log.toString();
    }

    /**
     * List对象转成String
     *
     * @param list null返回null
     * @return value;value
     */
    private static String objectList2String(List<Object> list) {
        if (null == list) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            sb.append(ToStringBuilder.reflectionToString(obj));
            sb.append(KEY_VALUE_SEPARATOR);
        }
        return sb.toString();
    }

    /**
     * Map对象转成String
     *
     * @param map 为null返回null
     * @return key=value;
     */
    private static String objectMap2string(Map<String, Object> map) {
        if (null == map) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key);
            sb.append(KEY_VALUE_CONNECTOR);
            sb.append(Optional.ofNullable(map.get(key)).orElse(""));
            sb.append(KEY_VALUE_SEPARATOR);
        }
        return sb.toString();
    }

    /**
     * 组装特定的日志key
     *
     * @return 日志
     */
    private static String parseBasicLog() {

        return THREAD_LEFT_TAG +
                parseCommonTokens("tracerId", System.nanoTime() + "") +
                THREAD_RIGHT_TAG;
    }

    /**
     * 链接KV
     *
     * @param key   key
     * @param value value
     * @return key=value;
     */
    private static String parseCommonTokens(String key, String value) {
        return key + KEY_VALUE_CONNECTOR + value + KEY_VALUE_SEPARATOR;
    }
}
