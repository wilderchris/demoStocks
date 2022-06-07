package com.demo.nasdaq.app.demoStocks.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.nasdaq.app.demoStocks.Model.Data;
import com.demo.nasdaq.app.demoStocks.Utility.NasdaqApiUtil;

@Service
public class DataServiceImpl implements DataService {


	@Autowired
	public DataServiceImpl() {

	}

	@Override
	public Data getStockByQuery(String stock) {
		return NasdaqApiUtil.StockQuery(stock);
	}

}
