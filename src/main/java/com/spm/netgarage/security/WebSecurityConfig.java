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

			//Laptop Endpoint
			.antMatchers("/laptop/add/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop/get/**").permitAll()
			.antMatchers("/laptop/get-by-id/**").permitAll()
			.antMatchers("/laptop/delete/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop/update/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop/update-status/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop/get-by-status/**").permitAll()
			.antMatchers("/laptop/get-object-by-id/**").permitAll()
			.antMatchers("/laptop/update-image/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop/delete-selected/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop/get-by-brand/**").permitAll()
			.antMatchers("/laptop/get-by-ram/**").permitAll()
			.antMatchers("/laptop/get-by-processor/**").permitAll()
			.antMatchers("/laptop/report-all/**").hasAnyRole("EDITOR","ADMIN")

			//Laptop Brand Endpoint
			.antMatchers("/laptop-brand/add/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-brand/get/**").permitAll()
			.antMatchers("/laptop-brand/get-by-id/**").permitAll()
			.antMatchers("/laptop-brand/delete/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-brand/update/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-brand/check/**").hasAnyRole("EDITOR","ADMIN")

			//Laptop Graphic Endpoint
			.antMatchers("/laptop-graphic/add/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-graphic/get/**").permitAll()
			.antMatchers("/laptop-graphic/get-by-id/**").permitAll()
			.antMatchers("/laptop-graphic/delete/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-graphic/update/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-graphic/check/**").hasAnyRole("EDITOR","ADMIN")

			//Laptop OS Endpoint
			.antMatchers("/laptop-os/add/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-os/get/**").permitAll()
			.antMatchers("/laptop-os/get-by-id/**").permitAll()
			.antMatchers("/laptop-os/delete/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-os/update/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-os/check/**").hasAnyRole("EDITOR","ADMIN")

			//Laptop Processor Endpoint
			.antMatchers("/laptop-processor/add/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-processor/get/**").permitAll()
			.antMatchers("/laptop-processor/get-by-id/**").permitAll()
			.antMatchers("/laptop-processor/delete/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-processor/update/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-processor/check/**").hasAnyRole("EDITOR","ADMIN")

			//Laptop Images Endpoint
			.antMatchers("/laptop-image/add/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-image/get/**").permitAll()
			.antMatchers("/laptop-image/get-by-id/**").permitAll()
			.antMatchers("/laptop-image/get-by-lid/**").permitAll()
			.antMatchers("/laptop-image/update/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-image/update-main/**").hasAnyRole("EDITOR","ADMIN")
			.antMatchers("/laptop-image/delete/**").hasAnyRole("EDITOR","ADMIN")

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
			.antMatchers("/api/phone/phones/getPublihsedPhones/**").permitAll()
			
			//limited access control for phone related functionality
			.antMatchers("/api/phone/phones/getAllPhones/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/addPhone/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/updatePhone/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/deletePhone/**").hasAnyRole("EDITOR", "ADMIN")
			.antMatchers("/api/phone/phones/isPhoneAvailable/**").hasAnyRole("EDITOR", "ADMIN")
			//.antMatchers("/api/phone/phones/getPublihsedPhones/**").hasAnyRole("EDITOR", "ADMIN")
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
