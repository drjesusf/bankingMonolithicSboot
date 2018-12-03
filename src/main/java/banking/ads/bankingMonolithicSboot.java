package banking.ads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ServletComponentScan
@SpringBootApplication
public class bankingMonolithicSboot {

	public static void main(String[] args) {
		SpringApplication.run(bankingMonolithicSboot.class, args);
	}
	
	/*@Bean
	public FilterRegistrationBean corsFilter() {
		final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);
	    final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	    bean.setOrder(0);
		return bean;
	}*/
	
}
