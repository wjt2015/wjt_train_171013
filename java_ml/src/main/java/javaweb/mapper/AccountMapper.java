package javaweb.mapper;

import javaweb.entity.AccountEntity;

public interface AccountMapper {
    int delete(Integer id);

    int save(AccountEntity record);

    int save(AccountEntity record);

    AccountEntity query(Integer id);

    int update(AccountEntity record);

    int update(AccountEntity record);
}