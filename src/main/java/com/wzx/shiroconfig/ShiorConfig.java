package com.wzx.shiroconfig;




import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Properties;

/**
 * @author wzx
 * @title: ShiorConfig
 * @projectName SmsWzx
 * @description: ww
 * @date 2020/1/39:41
 */
@Configuration
public class ShiorConfig {

    /**
     * 建立shiroFilter Bean -->设置到SecurityManager中，
     * 并把请求规则加入到Filter过滤链中
     * @param securityManager
     * @return
     */
    @Bean   //<bean id=""  class="">
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        //1.定义ShiroFilterFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //2.设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //3.设置默认登录的url地址
        shiroFilterFactoryBean.setLoginUrl("/page/index");
        //4.设置成功登录后跳转的链接地址
        shiroFilterFactoryBean.setSuccessUrl("/welcome");
        //5.设置未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/404");
        //定义LinkedHashMap 是有顺序的，进行有顺序的拦截
        LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<>();
        //配置shiro filter过滤器  shiro自带的logout 登出过滤器
        //设置登录以及主页，静态资源不需要认证
        // 使用shiro自带的anon 匿名过滤器 不需要认证就可以访问
        linkedHashMap.put("/user/**","anon");
        linkedHashMap.put("/page/**","anon");
        linkedHashMap.put("/api/**","anon");
        linkedHashMap.put("/css/**","anon");
        linkedHashMap.put("/fonts/**","anon");
        linkedHashMap.put("/images/**","anon");
        linkedHashMap.put("/js/**","anon");
        linkedHashMap.put("/lib/**","anon");
        //其它的必须认证(登录)后才可以访问  shiro自带authc过滤器
        //必须认证登录后才可以访问
        linkedHashMap.put("/**","authc");
        //把设置好的Map集合放到shiro Filter
        shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
        return shiroFilterFactoryBean;
    }


    /**
     * 将自已的验证加入容器   MyRealm是自定义类，完成认证和授权操作
     * @return
     */
    @Bean
    public MyRealm  myRealm(){
        MyRealm myRealm=new MyRealm();
        return myRealm;
    }

    /**
     * 配置安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        //把自定义的Realm类注入到SecurityManager
        defaultWebSecurityManager.setRealm(myRealm());
        return  defaultWebSecurityManager;
    }

    /**
     * 开启shiro的aop注解
     * 使用代理方式 ,所以需要开启代码支持
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 使shiro注解起作用
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator app=new DefaultAdvisorAutoProxyCreator();
        app.setProxyTargetClass(true);
        return  app;
    }

    /**
     * 处理无权限访问异常跳转到指定页面
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver simpleMappingExceptionResolver=new SimpleMappingExceptionResolver();
        Properties mappings=new Properties();
        mappings.setProperty("UnauthorizedException","/unauthorized");
        simpleMappingExceptionResolver.setExceptionMappings(mappings);
        return simpleMappingExceptionResolver;
    }

    /**
     * shiro标签配置
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return  new ShiroDialect();
    }

    /**
     * Shiro生命周期处理器
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor getlifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

}
