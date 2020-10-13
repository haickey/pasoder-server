package xyz.pasoder.server.password.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.pasoder.server.password.store.dao.PasswordUtilDao;
import xyz.pasoder.server.password.store.pojo.PasswordUnit;
import xyz.pasoder.server.password.store.pojo.PasswordUnitDO;

import java.util.List;

@Service
public class PasswordUnitService {

    @Autowired
    PasswordUtilDao passwordUtilDao;

    public List<PasswordUnit> findPasswordUnitByIp(final String ip) {
        final List<PasswordUnitDO> passwords = passwordUtilDao.findPasswordsByIp(ip);


        return null;
    }


}
