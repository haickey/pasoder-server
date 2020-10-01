package xyz.pasoder.pasoderserver.password.store.dao;

import xyz.pasoder.pasoderserver.password.store.pojo.PasswordUnit;

import java.util.List;

public interface PasswordUtilDao {
    List<PasswordUnit> findPasswordsByIp(String ip);

    int insertSelective(PasswordUnit doPojo);

    int updateByPrimaryKey(PasswordUnit doPojo);

    int deleteByPrimaryKey(PasswordUnit doPojo);
}
