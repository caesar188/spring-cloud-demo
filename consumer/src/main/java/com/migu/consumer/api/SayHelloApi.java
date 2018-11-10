package com.migu.consumer.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "Say Hello Demo", description = "Say Hello Demo API")
public interface SayHelloApi
{
	
	@RequestMapping(value="/sayHello",method = RequestMethod.GET)
	@ApiOperation(value="say hello",notes="say hello to provider service",response=String.class,tags={ "Consumer Demo", })
	@ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "成功", response =  String.class),
	        @ApiResponse(code = 500, message = "内部错误") })
	String sayHelloToA(@PathVariable("name") String name);



}
