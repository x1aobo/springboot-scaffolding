#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.core.model.user;

import ${package}.${parentArtifactId}.core.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: cjunl
 * @Date: 2022/2/15 16:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserModel extends BaseModel {
    /**
     * 年龄
     */
    private int age;

    /**
     * 姓名
     */
    private String name;

    /**
     * 工号
     */
    private String workCode;
}
