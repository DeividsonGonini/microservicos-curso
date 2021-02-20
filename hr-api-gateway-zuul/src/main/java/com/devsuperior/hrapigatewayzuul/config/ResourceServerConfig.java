package com.devsuperior.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Autowired
	private JwtTokenStore tokenStore;
	
	private static final String[] PUBLIC = {"/hr-oauth/oauth/token"};
	private static final String[] OPERATOR = {"/hr-worker/**"};
	private static final String[] ADMIN = {"/hr-payroll/**, /hr-user/**"};
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeRequests()
		//antMachers define as autorizações
		//todos os caminhos definidos no vetor PUBLIC, poderao ser acessados sem logar
		.antMatchers(PUBLIC).permitAll()
		//Autorização de GET para o vetor Operator para o perfis de Operator ou Admin
		.antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
		//So pode acessar as rotas de ADMIN se tiver o Perfil de Admin
		.antMatchers(ADMIN).hasRole("ADMIN")
		//Qualquer outra rota so podera ser acessada caso o usuario esteja autenticado
		.anyRequest().authenticated();
	}
	
	

	
}
