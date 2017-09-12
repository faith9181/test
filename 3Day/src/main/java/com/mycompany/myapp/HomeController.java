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
	//	logger �� �״�� �α׸� ���������. ��ġ�� ���� ������ ����ϱ� ����. 
	
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
		// model ����, ������Ʈ�� ���� ���� �����ϴ� ������. serverTime �̷��̸����� formattedDate �� ���� �ְڴ�.
		
		return "home";
	}
	
	@RequestMapping(value = "/move")	// (value = "/move") �̸����� ��. 
	public String move() {
		logger.info("/move");
		// ������ �������� �̸�(Ȯ���� ����)
		return "move";
	}
	
	@RequestMapping(value = "/loginProc")	 
	public String login() {
		
		return "loginForm";		// ���� �о���� jsp �����̴�. Ȯ���� ����. 
	}
	
}
