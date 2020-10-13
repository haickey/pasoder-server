package xyz.pasoder.server.password.store.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xyz.pasoder.server.password.store.pojo.PasswordUnitDO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class PasswordUtilDaoTest {

    public static final String TESTHOST = "testhost";
    @Autowired
    PasswordUtilDao biz;

    @Test
    public void testBiznotNull() {
        assertNotNull(biz);
    }

    @Test
    @Transactional
    public void testFindPasswordsByIp() {
        log.info("given");
        final PasswordUnitDO pass1 = new PasswordUnitDO();
        pass1.setIp("0.0.0.0");
        pass1.setName("wasadmin");
        pass1.setPassword("pass4was");
        biz.insertSelective(pass1);
        final PasswordUnitDO pass2 = new PasswordUnitDO();
        pass2.setIp(TESTHOST);
        pass2.setName("wasadmin2");
        pass2.setPassword("pass4was");
        biz.insertSelective(pass2);

        log.info("when");
        final List<PasswordUnitDO> result = biz.findPasswordsByIp("testhost");

        log.info("then");
        assertEquals(1, result.size());
    }

    @Test
    @Transactional
    public void testInsert() {
        final PasswordUnitDO pass = new PasswordUnitDO();
        pass.setIp(TESTHOST);
        pass.setName("wasadmin2");
        pass.setPassword("pass4was");
        biz.insertSelective(pass);

        final List<PasswordUnitDO> passwordsByIp = biz.findPasswordsByIp(TESTHOST);
        assertEquals(1, passwordsByIp.size());
    }

    @Transactional
    @Test
    public void testInsertIdWasGenerate() {
        final PasswordUnitDO pass = new PasswordUnitDO();
        pass.setIp(TESTHOST);
        pass.setName("wasadmin2");
        pass.setPassword("pass4was");
        biz.insertSelective(pass);

        final List<PasswordUnitDO> passwordsByIp = biz.findPasswordsByIp(TESTHOST);
        final PasswordUnitDO passwordUnit = passwordsByIp.get(0);
        assertNotNull(passwordUnit.getPasswordUnitId());
    }

    @Transactional
    @Test
    public void testUpdate() {
        final PasswordUnitDO pass = new PasswordUnitDO();
        pass.setIp(TESTHOST);
        pass.setName("wasadmin2");
        pass.setPassword("pass4was");
        biz.insertSelective(pass);

        final List<PasswordUnitDO> passwordsByIp = biz.findPasswordsByIp(TESTHOST);
        final PasswordUnitDO passupdate = passwordsByIp.get(0);
        passupdate.setPassword("helloworld");
        biz.updateByPrimaryKey(passupdate);

        final List<PasswordUnitDO> passListNew = biz.findPasswordsByIp(TESTHOST);
        final PasswordUnitDO passNew = passListNew.get(0);
        assertEquals("helloworld", passNew.getPassword());
    }

    @Transactional
    @Test
    public void testDelete() {
        final PasswordUnitDO pass = new PasswordUnitDO();
        pass.setIp(TESTHOST);
        pass.setName("wasadmin2");
        pass.setPassword("pass4was");
        biz.insertSelective(pass);

        final List<PasswordUnitDO> passwordsByIp = biz.findPasswordsByIp(TESTHOST);
        final PasswordUnitDO passIns = passwordsByIp.get(0);
        biz.deleteByPrimaryKey(passIns.getPasswordUnitId());

        final List<PasswordUnitDO> passListNew = biz.findPasswordsByIp(TESTHOST);
        assertEquals(0, passListNew.size());
    }


}