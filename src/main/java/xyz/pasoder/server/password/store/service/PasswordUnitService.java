package xyz.pasoder.server.password.store.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.pasoder.server.password.store.dao.PasswordUtilDao;
import xyz.pasoder.server.password.store.pojo.PasswordUnit;
import xyz.pasoder.server.password.store.pojo.PasswordUnitDO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasswordUnitService {

    @Autowired
    PasswordUtilDao passwordUtilDao;

    @Autowired
    Mapper dozerMapper;

    public List<PasswordUnit> findPasswordUnitByIp(final String ip) {
        final List<PasswordUnitDO> doList = passwordUtilDao.findPasswordsByIp(ip);
        return doList.parallelStream()
                .map(d -> dozerMapper.map(d, PasswordUnit.class))
                .collect(Collectors.toList());
    }


}
