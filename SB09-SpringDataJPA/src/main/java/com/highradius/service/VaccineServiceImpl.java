package com.highradius.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.highradius.dto.CovidVaccineDTO;
import com.highradius.entity.CovidVaccine;
import com.highradius.repository.VaccineJPARepo;
import com.highradius.repository.VaccineRepo;
import com.highradius.repository.VaccineRepoPagination;
import com.highradius.type.ResultView1;
import com.highradius.type.ResultView2;
import com.highradius.type.View;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineRepo vaccineRepo;
	
	@Autowired
	private VaccineRepoPagination vaccineRepo1;
	
	@Autowired
	private VaccineJPARepo vaccineJpaRepo;

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

	@Override
	public Long getVaccineCount() {
		return vaccineRepo.count();
	}

	@Override
	public List<CovidVaccineDTO> getVaccinesOnSortedOrder(String order, List<String> properties) {
		Sort sort = Sort.by(order != null && "ASC".equalsIgnoreCase(order) ? Direction.ASC : Direction.DESC,
				properties.toArray(new String[properties.size()]));
		Iterable<CovidVaccine> vaccineEntities = vaccineRepo1.findAll(sort);
		List<CovidVaccineDTO> vaccines = new ArrayList<>();
		for (CovidVaccine vaccineEntity : vaccineEntities) {
			CovidVaccineDTO vaccine = new CovidVaccineDTO();
			BeanUtils.copyProperties(vaccineEntity, vaccine);
			vaccines.add(vaccine);
		}
		return vaccines;
	}

	@Override
	public List<CovidVaccineDTO> getVaccinesForACompany(String companyName) {
		Iterable<CovidVaccine> vaccineEntities = vaccineJpaRepo.findByCompanyName(companyName);
		List<CovidVaccineDTO> vaccines = new ArrayList<>();
		for (CovidVaccine vaccineEntity : vaccineEntities) {
			CovidVaccineDTO vaccine = new CovidVaccineDTO();
			BeanUtils.copyProperties(vaccineEntity, vaccine);
			vaccines.add(vaccine);
		}
		return vaccines;
	}
	@Override
	public Iterable<ResultView1> getRequestData(String country) {
		return vaccineJpaRepo.findByCountry(country);
	}
/*
	@Override
	public Iterable<View> getVaccinesOnPrice(Double price, String className) {
		return vaccineJpaRepo.findByPrice(price, ResultView2.class);
	}
	*/
}