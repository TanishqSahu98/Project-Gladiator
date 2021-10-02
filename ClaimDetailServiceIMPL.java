package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.ClaimDetail;

@Service
public class ClaimDetailServiceIMPL implements ClaimDetailService {

	@Autowired
	ClaimDetailService claimDetailService;
	
	@Override
	public ClaimDetail findClaimDetailByPolicyNoService(int policyno) {
		System.out.println("ClaimDetailServiceIMPL...");
		if (policyno < 0) {
			RuntimeException rte = new RuntimeException("Policy No cannot be Negative");
			throw rte;
		}
		//return new ClaimDetail();
		return claimDetailService.findClaimDetailByPolicyNoService(policyno);
	}

	@Override
	public List<ClaimDetail> findAllClaimDetailService() {
		System.out.println("findAllClaimDetailService() code is running...");
		//scope to write the business code here
		return claimDetailService.findAllClaimDetailService();
	}

	@Override
	public void insertNewClaimDetail(ClaimDetail newClaim) {
		// TODO Auto-generated method stub
		
	}

}
