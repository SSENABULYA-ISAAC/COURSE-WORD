package Class;

import javax.swing.text.PasswordView;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//                 .antMatchers("/admin/**").hasRole("ADMIN")
//                 .antMatchers("/seller/**").hasRole("SELLER")
//                 .antMatchers("/buyer/**").hasRole("BUYER")
//                 .antMatchers("/**").permitAll()
//                 .and()
//             .formLogin()
//                 .loginPage("/login")
//                 .permitAll()
//                 .and()
//             .logout()
//                 .permitAll();
//     }

//     @Bean
//     public PasswordView passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }