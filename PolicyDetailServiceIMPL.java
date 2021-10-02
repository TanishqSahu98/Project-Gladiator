package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.PolicyDetail;
import com.example.demo.layer3.PolicyDetailRepository;

@Service
public class PolicyDetailServiceIMPL implements PolicyDetailService {

	
	@Autowired
	PolicyDetailRepository Pref;
	
	
	public PolicyDetail findPolicyDetailByID(int policyno) {
		// TODO Auto-generated method stub
		System.out.println("PolicyDetail impl....");
		if(policyno<0) {
			RuntimeException rte = new RuntimeException("Farmer ID Cannot be Negative");
			throw rte;
		}
		return Pref.selectPolicyDetailByID(policyno);
	}

	
	public List<PolicyDetail> findAllPolicyDetails() {
		// TODO Auto-generated method stub
		return Pref.selectAllPolicyDetails();
	}


	@Override
	public void insertNewPolicyDetail(PolicyDetail newPolicy) {
		Pref.insertPolicyDetail(newPolicy);
	}

}
