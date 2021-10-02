package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.ClaimDetail;
import com.example.demo.layer2.Farmer;
import com.example.demo.layer4.ClaimDetailService;
import com.example.demo.layer4.FarmerService;

@CrossOrigin(origins = "*", value = "*")
@RestController
public class ClaimDetailJPAController {

	@Autowired
	ClaimDetailService claimDetailService;

	//@Autowired 
	//FarmerRepository farmerRepo;
	
	public ClaimDetailJPAController() {
		System.out.println("ClaimDetailJPAController...");
	}

	@GetMapping
	@RequestMapping(path="/getJPAAllClaimDetails/") //localhost:8080/AllClaimDetails
	public List<ClaimDetail> getAllAllClaimDetails() {
		System.out.println("getAllAllClaimDetails");
		return claimDetailService.findAllClaimDetailService();
	}
	
	@GetMapping
	@RequestMapping(path="/getJPAClaimDetail/{policyno}") // localhost:8080/getJPAClaimDetail/40001
	public ClaimDetail getSingleFarmer(@PathVariable("policyno") int PolicyNoToFind) throws NotFoundException 
	{
		System.out.println("getClaimDetail : "+PolicyNoToFind);
		ClaimDetail foundClaimDetail = null;
		foundClaimDetail = claimDetailService.findClaimDetailByPolicyNoService(PolicyNoToFind);
	
		if(foundClaimDetail == null) {
			NotFoundException d = new NotFoundException("Policy Not Found of this number"+ PolicyNoToFind);
		}
		return foundClaimDetail;
	}
}