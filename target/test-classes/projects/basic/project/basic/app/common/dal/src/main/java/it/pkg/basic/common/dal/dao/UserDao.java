package it.pkg.basic.common.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import it.pkg.basic.common.dal.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表 Mapper 接口
 *
 * @author cjunl
 */
@Mapper
public interface UserDao extends BaseMapper<UserDO> {
}
