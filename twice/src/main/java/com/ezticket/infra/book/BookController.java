package com.ezticket.infra.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	
	private String str = "/usr/book";
	@RequestMapping(value = "/useBookOne")
	public String useBookOne() throws Exception
	{
		
		return str + "/useBookOne";
	}
	@RequestMapping(value = "/useBookTow")
	public String useBookTow() throws Exception
	{
		
		return str + "/useBookTow";
	}
	@RequestMapping(value = "/useBookBuy")
	public String useBookBuy() throws Exception
	{
		
		return str + "/useBookBuy";
	}
	@RequestMapping(value = "/useBookfinal")
	public String useBookfinal() throws Exception
	{
		
		return str + "/useBookfinal";
	}
	
}
