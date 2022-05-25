package it.pkg.basic.common.utils.util;

import it.pkg.basic.common.utils.enums.BidTypeEnum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

/**
 * 通用bid生成工具类
 *
 * @author cjunl
 */
public class BidGenerator {
    private static final String SPLIT_TOKEN = "-";

    /**
     * 生成bid
     *
     * @param bidTypeEnum
     * @return
     */
    public static String gen(BidTypeEnum bidTypeEnum) {
        return gen(bidTypeEnum, () -> new SimpleDateFormat("yyMMdd").format(new Date()));
    }

    /**
     * 生成bid
     *
     * @param bidTypeEnum
     * @return
     */
    public static String gen(BidTypeEnum bidTypeEnum, Supplier<String> action) {
        StringBuilder sb = new StringBuilder(32);

        //三位id类型
        sb.append(bidTypeEnum.getPrefix()).append(SPLIT_TOKEN);

        //6位hash值,可用于分库分表
        sb.append(action.get());

        //22位唯一值
        sb.append(shortUuid());

        return sb.toString();
    }

    public static String shortUuid() {
        ShortUuid shortUuid = new ShortUuid.Builder().build();
        return shortUuid.toString();
    }
}
