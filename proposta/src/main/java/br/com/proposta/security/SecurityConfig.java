package br.com.proposta.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors()
//                .and().authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/proposta/**").hasAuthority("SCOPE_proposta:read")
//                .antMatchers(HttpMethod.POST, "/proposta/**").hasAuthority("SCOPE_proposta:write")
//                .anyRequest().authenticated()
//                .and().oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        http.authorizeRequests(authorizeRequests ->
                        authorizeRequests
                        .antMatchers(HttpMethod.GET, "/proposta/**").hasAuthority("SCOPE_proposta:read")
                        .antMatchers(HttpMethod.POST, "/proposta/**").hasAuthority("SCOPE_proposta:write")
                        .anyRequest().authenticated()
                    )
        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
