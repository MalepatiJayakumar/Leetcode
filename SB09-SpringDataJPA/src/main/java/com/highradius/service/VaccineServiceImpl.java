package com.highradius.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highradius.dto.CovidVaccineDTO;
import com.highradius.entity.CovidVaccine;
import com.highradius.repository.VaccineRepo;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineRepo vaccineRepo;

	@Override
	public void saveCovidVaccineProvider(CovidVaccineDTO vaccine) {
		CovidVaccine vaccineEntity = new CovidVaccine();
		BeanUtils.copyProperties(vaccine, vaccineEntity);
		vaccineRepo.save(vaccineEntity);
	}

	@Override
	public List<CovidVaccineDTO> getAllVaccines() {
		Iterable<CovidVaccine> vaccineEntities = vaccineRepo.findAll();
		List<CovidVaccineDTO> vaccines = new ArrayList<>();
		for (CovidVaccine vaccineEntity : vaccineEntities) {
			CovidVaccineDTO vaccine = new CovidVaccineDTO();
			BeanUtils.copyProperties(vaccineEntity, vaccine);
			vaccines.add(vaccine);
		}
		return vaccines;
	}
}