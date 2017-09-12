package com.mycompany.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//	logger 말 그대로 로그를 남기기위한. 위치에 대한 정보를 출력하기 위한. 
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)	 
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(
				DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		logger.info(formattedDate);
		model.addAttribute("serverTime", formattedDate );
		// model 세션, 리퀘스트와 같은 값을 전달하는 전달자. serverTime 이런이름으로 formattedDate 이 값을 넣겠다.
		
		return "home";
	}
	
	@RequestMapping(value = "/move")	// (value = "/move") 이름으로 들어감. 
	public String move() {
		logger.info("/move");
		// 접속할 페이지의 이름(확장자 제외)
		return "move";
	}
	
	@RequestMapping(value = "/loginProc")	 
	public String login() {
		
		return "loginForm";		// 내가 읽어들일 jsp 파일이다. 확장자 제외. 
	}
	
}
