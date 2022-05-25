#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.core.model;

import ${package}.${parentArtifactId}.common.utils.result.ToString;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @Author: cjunl
 * @Date: 2021/12/29 10:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseModel extends ToString {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 更新人
     */
    private String lastModifier;

}
