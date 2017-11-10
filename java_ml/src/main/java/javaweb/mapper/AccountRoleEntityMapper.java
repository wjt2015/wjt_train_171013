package javaweb.mapper;

import javaweb.entity.AccountRoleEntity;

public interface AccountRoleEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountRoleEntity record);

    int insertSelective(AccountRoleEntity record);

    AccountRoleEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountRoleEntity record);

    int updateByPrimaryKey(AccountRoleEntity record);
}