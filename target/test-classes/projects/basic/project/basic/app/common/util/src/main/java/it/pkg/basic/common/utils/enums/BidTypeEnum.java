package it.pkg.basic.common.utils.enums;

import org.apache.commons.lang.StringUtils;
/**
 * Bid类型枚举
 */
public enum BidTypeEnum implements IBidType {

    //===========用户相关================
    TENANT("tnt", "租户bid"),
    USER("usr", "用户bid"),
    ;

    /**
     * 确保唯一
     */
    private final String prefix;

    /**
     * bid描述
     */
    private final String desc;

    /**
     * 构造函数
     *
     * @param prefix 前缀
     * @param desc   描述
     */
    BidTypeEnum(String prefix, String desc) {
        this.prefix = prefix;
        this.desc = desc;
    }

    /**
     * 根据prefix查找对应类型.
     */
    public static BidTypeEnum of(String prefix) {
        for (BidTypeEnum item : BidTypeEnum.values()) {
            if (StringUtils.equals(prefix, item.getPrefix())) {
                return item;

            }
        }
        return null;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public String getDesc() {
        return desc;
    }

}
