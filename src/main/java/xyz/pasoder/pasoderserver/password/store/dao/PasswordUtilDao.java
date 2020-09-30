package xyz.pasoder.pasoderserver.password.store.dao;

import xyz.pasoder.pasoderserver.password.store.pojo.PasswordUnit;

import java.util.List;

public interface PasswordUtilDao {
    List<PasswordUnit> findPasswordsByIp(String ip);
}
