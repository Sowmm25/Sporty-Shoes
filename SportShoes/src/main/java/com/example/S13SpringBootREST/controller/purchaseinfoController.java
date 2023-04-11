package com.example.S13SpringBootREST.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class purchaseinfoController {
@GetMapping("/purchaseinfo")
public String purchaseinfo() {
	return "purchaseinfo";
}

}
