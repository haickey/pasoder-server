package xyz.pasoder.server.base.bean;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DozerBean {
    @Bean
    public Mapper dozerMapper() {
        final DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Arrays.asList(
                "dozer/main-dozerMap.xml"
                ));
        return mapper;
    }
}
