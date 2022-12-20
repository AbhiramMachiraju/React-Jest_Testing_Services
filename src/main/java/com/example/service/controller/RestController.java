package com.example.service.controller;

import java.sql.SQLException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.model.BioDataTO;
import com.example.service.model.RestInfo;
import com.example.service.model.RestListInfo;
import com.example.service.model.UserTO;
import com.example.service.services.BioService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/BioDataServices")
public class RestController {

	@Autowired
	private BioService serviceLayer;
	
	
	@GetMapping("/Test")
	public String test()
	{
		return "Application is UP";
	}
	
	
	@GetMapping("/getbyId/{id}")
	public RestInfo<BioDataTO> getbyId( @PathVariable("id") Long autoId)
	{
		RestInfo<BioDataTO> info = new RestInfo<BioDataTO>();
		try {
			info.setOperationCode(0);
			info.setMessage("SUCESS");
			Optional<BioDataTO> res=serviceLayer.findbyId(autoId);
			info.setData(res.get());
		} catch (Exception e) {
			info.setOperationCode(-1);
			info.setMessage("FAIL" + e.getLocalizedMessage());
		}
		return info;
	}

	@PostMapping("/saveBioData")
	public RestInfo<BioDataTO> saveBioDataTO(@Valid @RequestBody BioDataTO requestTO) throws SQLException {

		RestInfo<BioDataTO> info = new RestInfo<BioDataTO>();
			try {

				info.setOperationCode(0);
				info.setMessage("SUCESS");
				info.setData(serviceLayer.save(requestTO));
			}catch (Exception e) {
				info.setOperationCode(-1);
				info.setMessage("FAIL" + e.getLocalizedMessage());
			}

			return info;
	}

	@GetMapping("/getAllBio")
	public RestListInfo<BioDataTO> fetchAllBio() {

		RestListInfo<BioDataTO> info = new RestListInfo<BioDataTO>();
		try {

			info.setOperationCode(0);
			info.setMessage("SUCESS");
			info.setData(serviceLayer.fetch());
		} catch (Exception e) {
			info.setOperationCode(-1);
			info.setMessage("FAIL" + e.getLocalizedMessage());
		}

		return info;
	}

	@GetMapping("/getAllUsers")
	public RestListInfo<UserTO> fetchAllUsers() {
		
		RestListInfo<UserTO> info = new RestListInfo<UserTO>();
		try {
			
			info.setOperationCode(0);
			info.setMessage("SUCESS");
			info.setData(serviceLayer.getAllUsers());
		} catch (Exception e) {
			info.setOperationCode(-1);
			info.setMessage("FAIL" + e.getLocalizedMessage());
		}
		
		return info;
	}

	@PutMapping("/updateBioData/{id}")
	public RestInfo<BioDataTO> updateBioDataTO(@Valid @RequestBody BioDataTO requestTO, @PathVariable("id") Long autoId) throws SQLException {
		RestInfo<BioDataTO> info = new RestInfo<BioDataTO>();
		try {
			info.setOperationCode(0);
			info.setMessage("SUCESS");
			info.setData(serviceLayer.updateBioDataTO(requestTO, autoId));
		} catch (Exception e) {
			info.setOperationCode(-1);
			info.setMessage("FAIL" + e.getLocalizedMessage());
		}

		return info;
	}

	// Delete operation
	@DeleteMapping("/deleteBioData/{id}")
	public RestInfo<String> deleteDepartmentById(@PathVariable("id") Long autoId) {
		RestInfo<String> info = new RestInfo<String>();
		try {
			serviceLayer.deleteById(autoId);
			info.setOperationCode(0);
			info.setMessage( " Successfully");
			info.setData("Deleted Successfully");
		} catch (Exception e) {
			info.setOperationCode(-1);
			info.setMessage("FAIL" + e.getLocalizedMessage());
		}
		return info;
	}

}
