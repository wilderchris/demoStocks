package com.demo.nasdaq.app.demoStocks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.nasdaq.app.demoStocks.Model.Data;
import com.demo.nasdaq.app.demoStocks.Service.DataService;

@RestController
@RequestMapping(path="/api/v1/stockprices")
@CrossOrigin(origins = "http://localhost:4200")// added for an angular app if future additions needed
public class DataController {

	private static DataService dataServ;

	@Autowired
	public DataController(DataService dataServ) {
		DataController.dataServ = dataServ;
	}
	
	
	
	@GetMapping(path = "/{stock}")
	public ResponseEntity<Data> getStockByQuery(@PathVariable String stock){
		Data data = dataServ.getStockByQuery(stock);
		if (data != null)
			return ResponseEntity.ok(data);
		else
			return ResponseEntity.notFound().build();
	}
	
}
