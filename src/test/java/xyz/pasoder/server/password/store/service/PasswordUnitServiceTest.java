package xyz.pasoder.server.password.store.service;

import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import xyz.pasoder.server.password.store.dao.PasswordUtilDao;
import xyz.pasoder.server.password.store.pojo.PasswordUnit;
import xyz.pasoder.server.password.store.pojo.PasswordUnitDO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@Slf4j
@SpringBootTest
public class PasswordUnitServiceTest {

    @InjectMocks
    PasswordUnitService biz;


    @Autowired(required = true)
    Mapper dozerMapper;

    @Mock
    PasswordUtilDao passwordUtilDao;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(biz, "dozerMapper", dozerMapper);
    }

    @Test
    public void findPasswordUnitByIp() {
        final List<PasswordUnitDO> testResult = new ArrayList<>();
        final PasswordUnitDO dbo = new PasswordUnitDO();
        final String ip = "testIP";
        final String password = "password";
        final String name = "name";
        final String desc = "desc";
        final int id = 123;
        dbo.setIp(ip);
        dbo.setPassword(password);
        dbo.setName(name);
        dbo.setDescription(desc);
        dbo.setPasswordUnitId(id);
        testResult.add(dbo);
        when(passwordUtilDao.findPasswordsByIp("testIP")).thenReturn(testResult);

        final List<PasswordUnit> bizResult = biz.findPasswordUnitByIp("testIP");
        final List<PasswordUnit> expectedResult = new ArrayList<>();
        final PasswordUnit expectedBo = new PasswordUnit();
        expectedBo.setEnCryPassword(password);
        expectedBo.setName(name);
        expectedBo.setDescription(desc);
        expectedBo.setPasswordUnitId(id);
        expectedBo.setIp(ip);
        expectedResult.add(expectedBo);
        assertEquals(expectedResult, bizResult);
    }

    @Test
    public void doPassShouldMap2EncryPass() {
        final PasswordUnitDO dbo = new PasswordUnitDO();
        final String testWord = "helloworld";
        dbo.setPassword(testWord);

        final PasswordUnit result = dozerMapper.map(dbo, PasswordUnit.class);
        assertEquals(testWord, result.getEnCryPassword());

    }
}