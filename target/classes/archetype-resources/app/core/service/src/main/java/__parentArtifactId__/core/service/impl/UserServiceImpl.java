#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${package}.${parentArtifactId}.common.dal.dao.UserDao;
import ${package}.${parentArtifactId}.common.dal.entity.UserDO;
import ${package}.${parentArtifactId}.common.utils.consts.GlobalConst;
import ${package}.${parentArtifactId}.core.convert.user.UserConvert;
import ${package}.${parentArtifactId}.core.model.user.UserModel;
import ${package}.${parentArtifactId}.core.service.UserService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

/**
 * @Author: cjunl
 * @Date: 2022/2/15 14:24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserDO> implements UserService {

    @Override
    public Page<UserModel> queryUserList(UserModel userModel, int pageStart, int pageSize, String sortField, String orderDir) {

        Page page = new Page(pageStart, pageSize);
        if (StringUtils.isNotEmpty(sortField)) {
            OrderItem orderItem = new OrderItem(sortField, GlobalConst.ASC.equalsIgnoreCase(orderDir));
            page.setOrders(Lists.newArrayList(orderItem));
        }

        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery();
        if (StringUtils.isNotEmpty(userModel.getName())){
            queryWrapper.like(UserDO::getName,userModel.getName());
        }

        Page<UserDO> pageResult = baseMapper.selectPage(page, queryWrapper);
        //数据转换
        Page<UserModel> userModelPage = new Page<>();
        if (!CollectionUtils.isEmpty(pageResult.getRecords())) {
            userModelPage.setRecords(pageResult.getRecords().stream().map(UserConvert.INSTANCE::userDo2Model).collect(Collectors.toList()));
        }
        userModelPage.setTotal(pageResult.getTotal());
        userModelPage.setCurrent(pageResult.getCurrent());
        userModelPage.setSize(pageResult.getSize());
        return userModelPage;
    }
}
