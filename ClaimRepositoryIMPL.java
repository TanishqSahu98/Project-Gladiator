package com.example.demo.layer3;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.ClaimDetail;
import com.example.demo.layer2.Farmer;

@Repository
public class ClaimRepositoryIMPL extends BaseRepository implements ClaimRepository {

	@Transactional
	public void insertClaimRequest(ClaimDetail claim_detail) {
		super.persist(claim_detail);	
	}

	@Transactional
	public ClaimDetail selectClaimRequestByPolicyNo(int policyno) {
		return super.find(ClaimDetail.class, policyno);
	}

	@Transactional
	public List<ClaimDetail> selectAllClaimDetails() {
		return super.findAll("ClaimDetail");
	}

	@Transactional
	public void updateSingleClaimDetail(ClaimDetail claim_detail) {
		super.merge(claim_detail);
	}

	@Transactional
	public void deleteSingleClaimDetail(int policyno) {
		super.remove(Farmer.class, policyno);
	}

}
