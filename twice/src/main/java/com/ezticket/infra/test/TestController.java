package com.ezticket.infra.test;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TestController {

	@RequestMapping(value = "/test")
	public String test(Model model) throws Exception
	{
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq?serviceKey=N3YEBL3S%2BptRSuZYd5A3x7XK3VTIf61bowQ48lqXUISpn3BNT64x0ZAv4fEz36B06RS%2FTml5T6otfwpL9jre%2FQ%3D%3D&numOfRows=3&pageNo=1&type=json";
		
		//
		//N3YEBL3S%2BptRSuZYd5A3x7XK3VTIf61bowQ48lqXUISpn3BNT64x0ZAv4fEz36B06RS%2FTml5T6otfwpL9jre%2FQ%3D%3D
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(stringBuilder.toString());
		
		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(0).get("KIT_PROD_QTY").asText());
		
		model.addAttribute("node", node);
		
//		model.addAttribute(node);
		return "test/test";
	}
	
	@RequestMapping(value ="/test2")
	public String test2(Model model)throws Exception
	{
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq?serviceKey=N3YEBL3S%2BptRSuZYd5A3x7XK3VTIf61bowQ48lqXUISpn3BNT64x0ZAv4fEz36B06RS%2FTml5T6otfwpL9jre%2FQ%3D%3D&numOfRows=3&pageNo=1&type=json";
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}
		
		bufferedReader.close();
		httpURLConnection.disconnect();
		
      ObjectMapper objectMapper = new ObjectMapper();
      
      Map<String, Object> map = objectMapper.readValue(stringBuilder.toString(), Map.class);
      
      System.out.println("######## Map");
		for (String key : map.keySet()) {
			String value = String.valueOf(map.get(key));	// ok
			System.out.println("[key]:" + key + ", [value]:" + value);
		}
		
		
		Map<String, Object> header = new HashMap<String, Object>();
		header = (Map<String, Object>) map.get("header");
		
		System.out.println("######## Header");
		for (String key : header.keySet()) {
			String value = String.valueOf(header.get(key));	// ok
			System.out.println("[key]:" + key + ", [value]:" + value);
		}
		
		String aaa = (String) header.get("resultCode");
		
		System.out.println("header.get(\"resultCode\"): " + header.get("resultCode"));
		System.out.println("header.get(\"resultMsg\"): " + header.get("resultMsg"));
		
		Map<String, Object> body = new HashMap<String, Object>();
		body = (Map<String, Object>) map.get("body");
		
		
		System.out.println(body.get("pageNo"));
		
//		List<Home> items = new ArrayList<Home>();
//		items = (List<Home>) body.get("items");
//		
//		System.out.println("items.size(): " + items.size());
//		
//		System.out.println("items.toString(): " + items.toString());
		
//		model.addAllAttributes(map);
		model.addAllAttributes(header);
		model.addAllAttributes(body);
		
//		model.addAttribute("header", header);
//		model.addAttribute("body", body);
		return "test/test2";
	}
	
	
	@RequestMapping(value = "/test3")
	public String test3(Model model) throws Exception
	{
		
		 
		Date today = new Date();

        // Calendar 객체 생성하여 현재 날짜 설정
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        // 현재 날짜에서 하루를 빼기
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        // 뺀 후 날짜 가져오기
        Date yesterday = calendar.getTime();

        // SimpleDateFormat을 사용하여 원하는 형식으로 출력
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        System.out.println("하루 전 날짜 포맷 지정 후: " + dateFormat.format(yesterday));


		String apiUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=288bd6df89e380923abfb16576f35d84&targetDt=" +dateFormat.format(yesterday);
		
		//
		//N3YEBL3S%2BptRSuZYd5A3x7XK3VTIf61bowQ48lqXUISpn3BNT64x0ZAv4fEz36B06RS%2FTml5T6otfwpL9jre%2FQ%3D%3D
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {

			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(stringBuilder.toString());
		
		
		
		model.addAttribute("node", node);
		
		
		
//		model.addAttribute(node);
		return "test/test3";
	}
}
