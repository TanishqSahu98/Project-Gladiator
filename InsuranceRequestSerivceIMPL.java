package com.example.demo.layer4;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Crop;
import com.example.demo.layer2.Farmer;
import com.example.demo.layer2.InsuranceRequest;
import com.example.demo.layer3.FarmerRepository;
import com.example.demo.layer3.InsuranceRequestRepository;

@Service
public class InsuranceRequestSerivceIMPL implements InsuranceRequestService {

	@Autowired
	InsuranceRequestRepository IRref;
	
	@Autowired 
	FarmerRepository Fref;
	
	public InsuranceRequest findInsuranceByRequestNO(int requestno) {
		// TODO Auto-generated method stub
		System.out.println("Insurance Request impl....");
		if(requestno<0) {
			RuntimeException rte = new RuntimeException("Farmer ID Cannot be Negative");
			throw rte;
		}
		return IRref.selectRequestNo(requestno);
	}
	
	public List<InsuranceRequest> findAllInsuranceRequest() {
		// TODO Auto-generated method stub
		return IRref.selectAllRequest();
	}

	@Override
	public List<InsuranceRequest> findInsuranceByFID(int fid) {
		
		List<InsuranceRequest> ir;
		Farmer foundFarmerWithFID = Fref.selectFarmerByID(fid);
		System.out.println("Found Farmer :" + foundFarmerWithFID.getName());
		ir = foundFarmerWithFID.getInsuranceRequests();
		return ir;
	}

	@Override
	public void insertNewInsuranceRequestService(InsuranceRequest newRequest) {
		
		System.out.println("insertNewInsuranceRequestService..");
		//newRequest.setCrop(crop);
		//Farmer f = Fref.selectFarmerByID(fid);
		//newRequest.setFarmer(f);
		IRref.insertRequest(newRequest);	
	}

}
