package banking.ads.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name",defaultValue="World") String name) {
		return "Hello : " + name;
	}
	
}
