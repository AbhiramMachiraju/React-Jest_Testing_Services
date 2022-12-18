package com.example.service.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.model.BioDataTO;
import com.example.service.repo.BioDao;
import com.example.service.services.BioService;

@Service
public class BioServiceImpl implements BioService {

	@Autowired
	BioDao daoLayer;
	
	@Override
	public BioDataTO save(BioDataTO BioDataTO) {
		return daoLayer.save(BioDataTO);
	}

	@Override
	public List<BioDataTO> fetch() {
		return (List<BioDataTO>) daoLayer.findAll();
	}

	@Override
	public BioDataTO updateBioDataTO(BioDataTO bioDataTO, Long autoId) {
		
		BioDataTO to_DB = daoLayer.findById(autoId).get();

		if (Objects.nonNull(bioDataTO.getName()) && !"".equalsIgnoreCase(bioDataTO.getName()))
		   {to_DB.setName(bioDataTO.getName()); }

		if (Objects.nonNull(bioDataTO.getAdrs()) && !"".equalsIgnoreCase(bioDataTO.getAdrs()))
		     {to_DB.setAdrs(bioDataTO.getAdrs()); }

		if (Objects.nonNull(bioDataTO.getState()) && !"".equalsIgnoreCase(bioDataTO.getState()))
		{to_DB.setState(bioDataTO.getState()); }

		if (Objects.nonNull(bioDataTO.getCountry()) && !"".equalsIgnoreCase(bioDataTO.getCountry()))
		{to_DB.setCountry(bioDataTO.getCountry()); }
		
		if (Objects.nonNull(bioDataTO.getAge()) && bioDataTO.getAge()!=0)
		{to_DB.setAge(bioDataTO.getAge()); }

		if (Objects.nonNull(bioDataTO.getMobile()) &&!"".equalsIgnoreCase(bioDataTO.getMobile()))
		{to_DB.setMobile(bioDataTO.getMobile()); }
		

		return daoLayer.save(to_DB);
	}

	@Override
	public void deleteById(Long autoId) {
		daoLayer.deleteById(autoId);

	}

	@Override
	public Optional<BioDataTO> findbyId(Long autoId) {
		// TODO Auto-generated method stub
		return daoLayer.findById(autoId);
	}

}
