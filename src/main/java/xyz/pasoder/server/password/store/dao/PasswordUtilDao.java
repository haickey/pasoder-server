package xyz.pasoder.server.password.store.dao;

import xyz.pasoder.server.password.store.pojo.PasswordUnitDO;

import java.util.List;

public interface PasswordUtilDao {
    List<PasswordUnitDO> findPasswordsByIp(String ip);

    int insertSelective(PasswordUnitDO doPojo);

    int updateByPrimaryKey(PasswordUnitDO doPojo);

    int deleteByPrimaryKey(long pojoId);
}
