package xyz.pasoder.pasoderserver.password.store.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.pasoder.pasoderserver.password.store.pojo.PasswordUnit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PasswordUtilDaoTest {

    @Autowired
    PasswordUtilDao biz;

    @Test
    public void testBiznotNull() {
        assertNotNull(biz);
    }

    @Test
    public void testBizNotNull() {
        final List<PasswordUnit> result = biz.findPasswordsByIp("0.0.0");
        System.out.println(result);
    }
}