package com.firstWebApp.myWebApp.login;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	//private Logger logger = LoggerFactory.getLogger(getClass());

	/*
	 * private AuthenticationService authenticationService;
	 * 
	 * public LoginController(AuthenticationService authenticationService) {
	 * super(); this.authenticationService = authenticationService; }
	 */

	// @RequestMapping("login")
	/*
	 * public String goToLoginPage(@RequestParam String name, ModelMap model) {
	 * logger.debug("Request param is debug level {}", name);
	 * logger.info("Request param is info level {}", name); model.put("name", name);
	 * return "login"; }
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goWelcomePage(ModelMap model) {
		model.put("name", getLoggedUserName());
		return "welcome";
	}

	/*
	 * @RequestMapping(value = "login", method = RequestMethod.POST) public String
	 * goToWelcomePage(@RequestParam String name, @RequestParam String password,
	 * ModelMap model) { logger.debug("Request param is debug level {}", name);
	 * logger.info("Request param is info level {}", name);
	 * 
	 * 
	 * if (authenticationService.authenticate(name, password)) { model.put("name",
	 * name); return "welcome"; }
	 * 
	 * 
	 * model.put("errorMessage", "Invalid Username or Password"); return "login"; }
	 */

	public String getLoggedUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
}
