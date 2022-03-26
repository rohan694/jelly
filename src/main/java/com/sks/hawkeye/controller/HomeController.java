package com.sks.hawkeye.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sks.hawkeye.dto.DataRequestDto;
import com.sks.hawkeye.response.DataResponse;

@Controller
public class HomeController {

	@GetMapping("/home2")
	public String getData() {
        return "redirect:/index.html";
	}
	@GetMapping("/home")
	public String greeting( Model model) {
		return "index";
	}
}
