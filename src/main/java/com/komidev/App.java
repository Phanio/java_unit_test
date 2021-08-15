package com.komidev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		//SpringApplication.run(App.class, args);
		SomeBusinessImp someBusinessImp = new SomeBusinessImp();
		int s = someBusinessImp.calculateSum(new int[]{});
		System.out.println(s);
	}

}
