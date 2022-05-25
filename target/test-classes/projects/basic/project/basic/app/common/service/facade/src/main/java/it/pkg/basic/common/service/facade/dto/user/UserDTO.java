package it.pkg.basic.common.service.facade.dto.user;

import it.pkg.basic.common.service.facade.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: cjunl
 * @Date: 2022/2/15 14:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO {
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 姓名
     */
    private String name;

    /**
     * 工号
     */
    private String workCode;
}
