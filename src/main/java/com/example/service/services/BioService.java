package com.example.service.services;

import java.util.List;
import java.util.Optional;

import com.example.service.model.BioDataTO;
import com.example.service.model.UserTO;

public interface BioService {

	public BioDataTO save(BioDataTO department);
	
	public Optional<BioDataTO> findbyId(Long autoId);

	public List<BioDataTO> fetch();

	public void deleteById(Long autoId);

	public BioDataTO updateBioDataTO(BioDataTO bioDataTO, Long autoId);

	public List<UserTO> getAllUsers();
}
