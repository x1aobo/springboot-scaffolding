#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.common.service.facade.dto;

import ${package}.${parentArtifactId}.common.utils.result.ToString;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: cjunl
 * @Date: 2021/12/29 11:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseDTO extends ToString {
}
