#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.service.facade.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 升序降序枚举
 *
 * @author cjunl
 */
public enum SortEnum {

    /**
     * 升序
     */
    ASC("ASC", "升序"),

    /**
     * 降序
     */
    DESC("DESC", "降序"),
    ;

    private static final Map<String, SortEnum> CACHE =
            Arrays.stream(SortEnum.values()).collect(Collectors.toMap(SortEnum::getCode, v -> v));
    /**
     * 编码
     */
    private final String code;

    /**
     * 描述
     */
    private final String desc;


    SortEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code找到枚举项
     */
    public static SortEnum of(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        return CACHE.get(code);
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
