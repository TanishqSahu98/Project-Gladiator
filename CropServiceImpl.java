package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Crop;
////import com.example.demo.layer2.Farmer;
//import com.example.demo.layer3.FarmerRepository;
import com.example.demo.layer3.CropRepository;
@Service
public class CropServiceImpl implements CropService {

	@Autowired
	CropRepository CRepo;

	@Override
	public Crop findCropByNameService(String cropname) {
		System.out.println("findCropByNameService..");
		return CRepo.selectCropByname(cropname);
	}

	@Override
	public List<Crop> findAllCropsService() {
		
		System.out.println("findAllCropsService..");
		return CRepo.selectAllCrops();
	}
	
	
}


