package com.lezValentini.EsRestAPI.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String reverse(String x) {
		return new StringBuilder(x).reverse().toString();
	}
	
}
