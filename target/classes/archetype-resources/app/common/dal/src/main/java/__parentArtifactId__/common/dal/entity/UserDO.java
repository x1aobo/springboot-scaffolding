#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.dal.entity;

import com.baomidou.mybatisplus.annotation.*;
import ${package}.${parentArtifactId}.common.utils.result.ToString;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class UserDO extends ToString {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 年龄
     */
    @TableField("age")
    private String age;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 是否删除
     */
    @TableField("deleted")
    @TableLogic(value = "0", delval = "1")
    private Integer deleted;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @TableField("gmt_modified")
    private LocalDateTime gmtModified;

    /**
     * 创建人
     */
    @TableField("creator")
    private String creator;

    /**
     * 最后修改人
     */
    @TableField("last_modifier")
    private String lastModifier;
}
