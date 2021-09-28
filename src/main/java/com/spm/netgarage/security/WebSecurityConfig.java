package com.spm.netgarage.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spm.netgarage.dal.adapter.UserDetailsServiceImpl;
import com.spm.netgarage.security.jwt.AuthEntryPointJwt;
import com.spm.netgarage.security.jwt.AuthTokenFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	AuthEntryPointJwt unauthorizedHandler;

	//Return new Authentication token
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	//Using Authentication Manager Builder, pass user details to builder
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	//Return authentication Manager Bean and call parent class method
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	//Created for Password Encode
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//set all backEnd URI to access accordingly
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests()

			//All Permit Access Control
			.antMatchers("/user/**").permitAll()

			.antMatchers("/laptop/**").permitAll()
			.antMatchers("/laptop-brand/**").permitAll()
			.antMatchers("/laptop-graphic/**").permitAll()
			.antMatchers("/laptop-image/**").permitAll()
			.antMatchers("/laptop-os/**").permitAll()
			.antMatchers("/laptop-processor/**").permitAll()
			
			//phone access control
			//temporarily permitted all
			//.antMatchers("/api/phone/**").permitAll()
			
			//phone brand access control
			//permit all for external users
			.antMatchers("/api/phone/brand/getAllBrands/**").permitAll()
			
			//limited access to internal brand functions
			.antMatchers("/api/phone/brand/addBrand/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/api/phone/brand/getBrandById/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/api/phone/brand/getBrandByName/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/api/phone/brand/updateBrand/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/api/phone/brand/deleteBrandById/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/api/phone/brand/isBrandAvailable/**").hasAnyRole("EDITOR","ADMIN")
			
			//phone chipset control
			//permit all for external users.
			.antMatchers("/api/phone/chipset/getByBrandModel/**").permitAll()
			.antMatchers("/api/phone/chipset/getAllChipsets/**").permitAll()
			
			//limited access to internal chipset functions
			.antMatchers("/api/phone/chipset/addChipset/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/chipset/getChipsetById/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/chipset/updateChipset/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/chipset/isChipsetAvailable/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/chipset/getByBrandModel/**").hasAnyRole("EDITOR", "ADMIN")
			
			//phone OS access control
			//permit all for external users
			.antMatchers("/api/phone/os/getAllOS/**").permitAll()
			
			//limited access control for Phone OS
			.antMatchers("/api/phone/os/addOS/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/os/getOSById/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/os/update/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/os/deleteOS/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/os/isOsNameAvailable/**").hasAnyRole("EDITOR", "ADMIN")
			
			//phone related access control
			//permit all for external users
			.antMatchers("/api/phone/phones/getPhoneByName/**").permitAll()
			.antMatchers("/api/phone/phones/getPhoneById/**").permitAll()
			.antMatchers("/api/phone/phones/getPublishedPhonesByBrand/**").permitAll()
			.antMatchers("/api/phone/phones/getPublishedPhonesByChipset/**").permitAll()
			.antMatchers("/api/phone/phones/getPublishedPhonesByOs/**").permitAll()
			
			//limited access control for phone related functionality
			.antMatchers("/api/phone/phones/getAllPhones/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/addPhone/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/updatePhone/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/deletePhone/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/isPhoneAvailable/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/getPublihsedPhones/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/getUnpublihsedPhones/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/publishPhone/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/unpublishPhone/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/getPhonesByChipset/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/getPhonesByOs/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/getPhonesByBrand/**").hasAnyRole("EDITOR", "ADMIN")

			.anyRequest().authenticated();


		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
