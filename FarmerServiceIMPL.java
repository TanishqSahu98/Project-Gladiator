package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Farmer;
import com.example.demo.layer3.FarmerRepository;

@Service
public class FarmerServiceIMPL implements FarmerService {

	@Autowired
	FarmerRepository fRepo;
	
	public Farmer findFarmerByIdService(int fid) {
		//service code here..any business logic here
		System.out.println("FarmerServiceIMPL...");
		if (fid < 0) {
			RuntimeException rte = new RuntimeException("Farmer Id cannot be Negative");
			throw rte;
		}
		return fRepo.selectFarmerByID(fid);
	}

	public List<Farmer> findAllFarmersService() {
		System.out.println("findAllFarmersService() code is running...");
		//scope to write the business code here
		return fRepo.selectAllFarmers();
	}

	@Override
	public void insertNewFarmer(Farmer farmer) {
		// TODO Auto-generated method stu
		fRepo.insertFarmer(farmer);
		
	}

	@Override
	public Farmer loginFarmer(String email, String password) {
		
		Farmer foundFarmer;
		List<Farmer> allFarmers = fRepo.selectAllFarmers();
		for(Farmer f : allFarmers) {
			
			String email1 = f.getEmail();
			String password1 = f.getPassword();
			if(email1.equals(email) && password1.equals(password))
				{
					System.out.println(f.getFid());
					return f;
				}
		}
		return null;
	}
}
