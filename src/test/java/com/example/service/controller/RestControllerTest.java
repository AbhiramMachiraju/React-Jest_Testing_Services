package com.example.service.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.service.model.BioDataTO;
import com.example.service.model.RestInfo;
import com.example.service.services.BioService;
import com.example.service.utility.TestData;


//@WebMvcTest(value=RestControllerTest.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class RestControllerTest {
	
	@Autowired
	private MockMvc mockmvc; 

	@MockBean
	private BioService serviceLayer;
	

	
	@Test
	@Order(1)
	@DisplayName("TEST_1 :: testSaveBioData")
	public void testSaveBioData() throws Exception
	{
		
		BioDataTO testObj = TestData.testSaveData();
		Mockito.when(serviceLayer.save(Mockito.any(BioDataTO.class))).thenReturn(testObj);
		

		RestInfo<BioDataTO> info = new RestInfo<BioDataTO>();
		info.setOperationCode(0);
		info.setMessage("SUCESS");
		info.setData(testObj);
		String expectedOutPut=TestData.mapToJson(info);
		String URI="/BioDataServices/saveBioData";
		RequestBuilder reqBuilder =MockMvcRequestBuilders
				                .post(URI)
				                .accept(MediaType.APPLICATION_JSON)
				                .content(TestData.mapToJson(testObj))
				                .contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockmvc.perform(reqBuilder).andReturn();
		MockHttpServletResponse mockResponse=result.getResponse();
		String outPutResponse=mockResponse.getContentAsString();
		assertThat(outPutResponse).isEqualTo(expectedOutPut);
		assertEquals(HttpStatus.OK.value(), mockResponse.getStatus());
		
		
	}
	
	
	@Test
	@Order(2)
	@DisplayName("TEST_2 :: TestGetbyId")
	public void TestGetbyId() throws Exception
	{
		
		Optional<BioDataTO> testObj = TestData.TestGetbyIdData();
		Mockito.when(serviceLayer.findbyId(1L)).thenReturn(testObj);
		

		RestInfo<BioDataTO> info = new RestInfo<BioDataTO>();
		info.setOperationCode(0);
		info.setMessage("SUCESS");
		info.setData(testObj.get());
		String inputJson=TestData.mapToJson(info);
		
		String URI="/BioDataServices/getbyId/1";
		RequestBuilder reqBuilder =MockMvcRequestBuilders
				                .get(URI)
				                .accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockmvc.perform(reqBuilder).andReturn();
		MockHttpServletResponse mockResponse=result.getResponse();
		String outPutResponse=mockResponse.getContentAsString();
		assertThat(outPutResponse).isEqualTo(inputJson);
		assertEquals(HttpStatus.OK.value(), mockResponse.getStatus());
		
		
	}

}
