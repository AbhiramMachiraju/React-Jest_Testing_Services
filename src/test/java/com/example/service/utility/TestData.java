package com.example.service.utility;

import java.util.Optional;

import com.example.service.model.BioDataTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestData {

	public static BioDataTO testSaveData() {
		BioDataTO to = new BioDataTO();
		to.setAutoId(0L);
		to.setName("TEST_NAME");
		to.setAge(23);
		to.setCountry("TETS_COUN");
		to.setMobile("00000000000");
		to.setState("TEST_STATE");
		to.setAdrs("TEST_ADRS12123124243242342343423");
		return to;
	}
	
	public static Optional<BioDataTO> TestGetbyIdData() {
		BioDataTO to = new BioDataTO();
		to.setAutoId(1L);
		to.setName("TEST_NAME");
		to.setAge(23);
		to.setCountry("TETS_COUN");
		to.setMobile("00000000000");
		to.setState("TEST_STATE");
		to.setAdrs("TEST_ADRS12123124243242342343423");
		Optional<BioDataTO> opt = Optional.ofNullable(to);  
		return opt;
	}
	
	
	
	public static String mapToJson(Object obj) throws JsonProcessingException
	{
		return new ObjectMapper().writeValueAsString(obj);
	}

}
