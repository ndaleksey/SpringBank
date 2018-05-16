package com.alex.angular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shishkov A.V. on 16.05.18.
 */
@Controller
@RequestMapping(path = "/greeting")
public class WelcomeController {

	@GetMapping
	public String greeting() {
		return "greeting";
	}
}
