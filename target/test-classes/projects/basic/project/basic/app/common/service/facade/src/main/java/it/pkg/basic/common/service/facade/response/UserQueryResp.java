package it.pkg.basic.common.service.facade.response;

import it.pkg.basic.common.service.facade.dto.user.UserDTO;
import it.pkg.basic.common.utils.result.Pagination;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cjunl
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserQueryResp extends Pagination<UserDTO> {
}
