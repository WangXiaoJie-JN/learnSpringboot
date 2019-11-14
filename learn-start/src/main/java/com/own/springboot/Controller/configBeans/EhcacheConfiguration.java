package com.own.springboot.Controller.configBeans;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 整合ehcache
 */
@Configuration
@EnableCaching
public class EhcacheConfiguration {

    @Bean
    public EhCacheManagerFactoryBean enChacheManagerFactoryBean(){

        EhCacheManagerFactoryBean ehCacheManagerFB = new EhCacheManagerFactoryBean();
        ehCacheManagerFB.setConfigLocation( new ClassPathResource("ehcache.xml"));
        ehCacheManagerFB.setShared(true);
        return  ehCacheManagerFB;
    }


    @Bean("ehcacheCacheManager")
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean factoryBean){
        return new EhCacheCacheManager(factoryBean.getObject());
    }
}
