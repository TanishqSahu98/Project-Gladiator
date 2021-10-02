package com.example.demo.layer4;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.layer2.ClaimDetail;

@Service
public interface ClaimDetailService {
	
	ClaimDetail findClaimDetailByPolicyNoService(int policyno);
	List<ClaimDetail> findAllClaimDetailService();
	void insertNewClaimDetail(ClaimDetail newClaim);
}
