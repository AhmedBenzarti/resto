package de.tekup.resto.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Value("${spring.security.user.name}")
	private String userName;
	
	@Value("${spring.security.user.password}")
	private String password;

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests().antMatchers("/**").hasRole("USER")
	      .and().httpBasic().and().csrf().disable();
	  }

	  @Bean
	  public UserDetailsService userDetailsService() {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    String encodedPassword = passwordEncoder().encode(password);
	    manager.createUser(User.withUsername(userName).password(encodedPassword)
	      .roles("USER").build());
	    return manager;
	  }

	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
}
