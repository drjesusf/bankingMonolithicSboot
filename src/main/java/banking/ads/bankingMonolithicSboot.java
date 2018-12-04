package banking.ads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

//@ServletComponentScan
@SpringBootApplication
public class bankingMonolithicSboot {

	public static void main(String[] args) {
		SpringApplication.run(bankingMonolithicSboot.class, args);
	}
	
	@Bean
	public FilterRegistrationBean getFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	    registrationBean.setFilter(new JwtFilter());
	    registrationBean.addUrlPatterns("/secure/*");

	    return registrationBean;
	}
	
}
