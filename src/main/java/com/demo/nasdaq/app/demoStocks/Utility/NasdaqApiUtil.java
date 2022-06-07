package com.demo.nasdaq.app.demoStocks.Utility;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.demo.nasdaq.app.demoStocks.Model.Data;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NasdaqApiUtil {
	static Dotenv dotenv = Dotenv.load();

	private final static String API_KEY = dotenv.get("API_KEY");
	private static int responsecode = 0;
	private static URL queryUrl = null;

	public static Data StockQuery(String stock) {

		try {
			queryUrl = new URL("https://data.nasdaq.com/api/v3/datasets/WIKI/" + stock + ".json" 
								+ "?rows=10" + "?api_key=" + API_KEY);// limited results to 10
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) queryUrl.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get the required object from the above created object
		JSONObject obj = Connection(conn);
		Data data = new Data();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//		for (int i = 0; i < obj.size(); i++) {
//
//			// takes the JSONArray and writes to JSONObject the to string array
//			JSONObject new_obj = (JSONObject) obj.get(i);
			data = mapper.convertValue(obj, Data.class);
//
//		}

		return data;
	}

	public static JSONObject Connection(HttpURLConnection conn) {

		JSONObject data_obj;

		try {

			conn.setRequestMethod("GET");// hard coded my api key for now
			conn.connect();

			// Getting the response code
			responsecode = conn.getResponseCode();

			if (responsecode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			} else {

				String inline = "";
				String sb = "";

				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

				while ((inline = br.readLine()) != null) {
					sb += (inline + "\n");
				}

				br.close();

				// Using the JSON simple library parse into a json object
				JSONParser parse = new JSONParser();
				data_obj = (JSONObject) parse.parse(sb);

			}
			System.out.println(data_obj.get("dataset"));
			return (JSONObject) data_obj.get("dataset");

		} catch (Exception e) {
			return null;

		}
	}
}
