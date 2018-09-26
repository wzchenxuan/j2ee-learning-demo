package com.zjnuctf.ctfplatform.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjnuctf.ctfplatform.domian.Greeting;

@Controller
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s";
	private static final AtomicLong COUNTER = new AtomicLong(0);
	
	@ResponseBody
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public Greeting demo1(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(COUNTER.incrementAndGet(), String.format(TEMPLATE, name));

	}

}
