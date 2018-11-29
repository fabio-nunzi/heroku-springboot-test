package com.example.herokuspringboottest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class DemoApplication {

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/")
	@ResponseBody
	String home () {

		return "Now we got postgres... maybe..";

	}

	@RequestMapping("/secret")
	@ResponseBody
	String secret () {

		return "You found it!";

	}

	@GetMapping("/getJson")
    @ResponseBody
    public Response sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Response(counter.incrementAndGet(), name);
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
