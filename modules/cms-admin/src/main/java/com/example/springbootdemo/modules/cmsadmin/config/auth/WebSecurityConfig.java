package com.example.springbootdemo.modules.cmsadmin.config.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全控制中心
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailHandler myAuthenticationFailHandler;

    @Autowired
    private MyAuthenticationProvider provider;  //注入我们自己的AuthenticationProvider

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/login/form")
            .successHandler(myAuthenticationSuccessHandler)
            .failureHandler(myAuthenticationFailHandler)
            .permitAll() //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .csrf().disable();

        // region 注掉
        /*
        //解决不允许显示在iframe的问题
        http.headers().frameOptions().disable();

        http
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/login/form")
            //.failureUrl("/login-error")
            //.defaultSuccessUrl("/helloHtml")
            .successHandler(myAuthenticationSuccessHandler)//登陆成功处理
            .failureHandler(myAuthenticationFailHandler)//登陆失败处理
            .permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
            .and()
            .logout()
            .permitAll()
            .and()
            .httpBasic()
            // "rememberMe" 的功能 start
            .and()
            .rememberMe()
            .rememberMeParameter("remember-me").userDetailsService(userDetailsService)
            .tokenRepository(persistentTokenRepository())
            .tokenValiditySeconds(60)
            // "rememberMe" 的功能 end
            .and()
            .authorizeRequests()
        //filterIgnorePropertiesConfig.getUrls().forEach(url -> registry.antMatchers(url).permitAll()

            .anyRequest().access("@rbacService.hasPermission(request,authentication)")    //必须经过认证以后才能访问
            //.anyRequest()
            //.authenticated()

            .and()
            .csrf().disable();*/

        //endregion

    }

}


