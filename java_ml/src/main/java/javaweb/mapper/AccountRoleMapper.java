package javaweb.mapper;

import javaweb.entity.AccountRoleEntity;

public interface AccountRoleMapper {
    int delete(Integer id);

    int save(AccountRoleEntity record);

    int save(AccountRoleEntity record);

    AccountRoleEntity query(Integer id);

    int update(AccountRoleEntity record);

    int update(AccountRoleEntity record);
}