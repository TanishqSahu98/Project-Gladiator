package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.demo.layer2.PolicyDetail;

@Service
public interface PolicyDetailService {

	PolicyDetail findPolicyDetailByID(int policyno);
	List<PolicyDetail> findAllPolicyDetails();
	void insertNewPolicyDetail(PolicyDetail newPolicy);
}
