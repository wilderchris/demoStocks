package com.demo.nasdaq.app.demoStocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.nasdaq.app.demoStocks.Utility.NasdaqApiUtil;

@SpringBootApplication
public class DemoStocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStocksApplication.class, args);
		//System.out.println(NasdaqApiUtil.StockQuery("OPEC"));
	}

}
