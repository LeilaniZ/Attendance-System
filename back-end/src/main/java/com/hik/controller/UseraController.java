package com.hik.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hik.model.Usera;
import com.hik.service.UseraService;


@RequestMapping("/loggin")
@RestController
public class UseraController {
	  @Autowired
	    private  UseraService userservice;
	  @RequestMapping(method = RequestMethod.GET)
	    public String logginuser() throws Exception{
		    JSONArray ar=new JSONArray();
	         List <Usera> li= userservice.getalluser();
	         for(int i=0;i<li.size();i++) {
	        	 JSONObject jo= new JSONObject();
	        	 jo.put("id", li.get(i).getEid());
	        	 jo.put("password", li.get(i).getPassword());
	        	 ar.add(jo);
	         }
	         JSONObject re = new JSONObject();
	          re.put("users", ar);
		       return re.toString();
	     }
	  }

