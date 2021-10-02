package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Crop;
import com.example.demo.layer2.Farmer;
import com.example.demo.layer2.InsuranceRequest;

@Service
public interface InsuranceRequestService {
	
	InsuranceRequest findInsuranceByRequestNO(int requestno);
	List<InsuranceRequest> findAllInsuranceRequest();
	List<InsuranceRequest> findInsuranceByFID(int fid);
	void insertNewInsuranceRequestService(InsuranceRequest newRequest);//, Crop crop, Farmer f);
}
