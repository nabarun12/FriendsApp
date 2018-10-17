package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.dataservice.DataService;
import com.example.model.Sampledata;
import com.example.restcall.CallFeignClientApi;
import com.google.common.base.Optional;
import com.google.common.collect.BinaryTreeTraverser;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@CrossOrigin
@RestController
@RequestMapping(value = "/service")
public class RequestController {
	
	
	
	@Autowired
	EurekaClient eureka;
	
	@Autowired
	CallFeignClientApi callClient;
	
	@Autowired
	DataService dataService;
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET , produces = "application/json")
	public List<Sampledata> getData(){
		
		return dataService.getData();
		
		 
		
	}
	
	@RequestMapping(value = "/getOfficeData", method = RequestMethod.GET , produces = "application/json")
	public String getOfficeData(){
		Application application = eureka.getApplication("office");
		System.out.println("Application host:"+ application.getInstances().get(0).getHostName());
		System.out.println("Application host:"+ application.getInstances().get(0).getPort());
		return callClient.getOfficeData();
		
		 
		
	}
}
