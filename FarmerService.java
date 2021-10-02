package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Farmer;

@Service
public interface FarmerService {
	
	Farmer findFarmerByIdService(int fid);
	List<Farmer> findAllFarmersService();
	void insertNewFarmer(Farmer farmer);
	Farmer loginFarmer(String email, String password);
}
