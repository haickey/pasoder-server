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

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
@SpringBootTest
public class PasswordUnitServiceTest {

    @InjectMocks
    PasswordUnitService biz;


    @Autowired(required=true)
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