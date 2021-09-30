package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.ClaimDetail;
import com.example.demo.layer2.Farmer;

@Repository
public interface ClaimRepository {
	
	void insertClaimRequest(ClaimDetail claim_detail);
	ClaimDetail selectClaimRequestByPolicyNo(int policyno);
	List<ClaimDetail> selectAllClaimDetails();
	void updateSingleClaimDetail(ClaimDetail claim_detail);
	void deleteSingleClaimDetail(int policyno);
}