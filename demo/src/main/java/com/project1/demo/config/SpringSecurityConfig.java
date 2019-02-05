package com.project1.demo.config;//package com.project1.demo.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().anyRequest().permitAll();
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/css/**", "/home", "/about").permitAll()
                    .antMatchers("/admin/**", "/crud").hasAnyRole("ADMIN")
                    .antMatchers("/user/**").hasAnyRole("USER")
                    .anyRequest().authenticated()
//                    .anyRequest().denyAll()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher(“/logout”)).logoutSuccessUrl(“/”)
                .and()
                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        log.info("Setting in-memory security using the user input...");

//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                    .and()
                .withUser("admin").password(passwordEncoder().encode("password")).roles("ADMIN")
                    .and()
                .withUser("mcoelho").password(passwordEncoder().encode("password")).roles("ADMIN");
//                .authorities("ADMIN");
//                .authorities("ROLE_USER");

    }
}