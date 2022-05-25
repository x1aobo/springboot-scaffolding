#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.service.facade.dto.user;

import ${package}.${parentArtifactId}.common.service.facade.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: cjunl
 * @Date: 2022/2/15 15:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserQueryDTO extends BaseDTO {
    /**
     * 姓名
     */
    private String name;
}
