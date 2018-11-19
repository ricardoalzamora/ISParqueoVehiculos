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
                .antMatchers("/Vigilante/mostrarUsuarios", "/Vigilante/crearUsuario", "/Vigilante/mostrarRegistros").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }

    @Autowired
    public void ConfigurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder users = User.builder().passwordEncoder((encoder::encode));
        builder.inMemoryAuthentication()
                .withUser(users.username("admin").password("12345").roles("ADMIN", "CLIENTE"))
                .withUser(users.username("andres").password("12345").roles("CLIENTE"));
    }
}
