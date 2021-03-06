package com.is.sistemaparqueovehiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/css/**", "/js/**").permitAll()
                .antMatchers("/Vigilante/mostrarUsuarios", "/Vigilante/crearUsuario", "/Vigilante/mostrarRegistros", "/Vigilante/*").hasAnyRole("VIGILANTE")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error_403");
    }

    @Autowired
    public void ConfigurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder users = User.builder().passwordEncoder((encoder::encode));
        builder.inMemoryAuthentication()
                .withUser(users.username("312").password("12345").roles("VIGILANTE"))
                .withUser(users.username("andres").password("12345").roles("CLIENTE"))
                .withUser(users.username("123").password("12345").roles("CLIENTE"));
    }
}
