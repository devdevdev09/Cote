package com.code.solv;

import com.exam.Solution;
import com.exam.SolutionImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolvApplication {

	public static void main(String[] args) {
		Solution sol = new SolutionImpl();
		sol.test();
		//SpringApplication.run(SolvApplication.class, args);
	}

}
