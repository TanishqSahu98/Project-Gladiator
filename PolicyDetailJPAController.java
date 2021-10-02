package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Crop;
import com.example.demo.layer2.Farmer;
import com.example.demo.layer2.InsuranceRequest;
import com.example.demo.layer2.PolicyDetail;

import com.example.demo.layer4.PolicyDetailService;

@CrossOrigin(origins = "", value = "")
@RestController
public class PolicyDetailJPAController {

	@Autowired
	PolicyDetailService Pser;
	
	public PolicyDetailJPAController() {
		System.out.println("PolicyDetailJPAController().....");
	}
	
	@GetMapping
	@RequestMapping(path="/getPD/{policyno}")
	public PolicyDetail selectPolicyNo(@PathVariable("policyno") int PolicyNoToFind) throws NotFoundException 
	{
		System.out.println("getPolicy : "+PolicyNoToFind);
		PolicyDetail foundPolicy = null;
		foundPolicy = Pser.findPolicyDetailByID(PolicyNoToFind);
		if(foundPolicy == null) {
			NotFoundException d = new NotFoundException("Department Number Not Found "+PolicyNoToFind);
		}
		return foundPolicy;
	}
	
	@GetMapping
	@RequestMapping(path="/getPDs") //localhost:8080/getPDs/
	public List<PolicyDetail> selectAllRequest() {
		System.out.println("getAllPolicy");
		return Pser.findAllPolicyDetails();
	}
	
	/*@PostMapping
	@RequestMapping(path="/insertRequest") //http://localhost:8080/insertRequest/
	public void addNewInsuranceRequest(@RequestBody PolicyDetail newPolicy) throws NotFoundException 
	{
		//System.out.println("addDepartment2 : "+requestToInsert.getNomineeName() +" "+requestToInsert.getCompany()); 			
		//Pser.insertNewInsuranceRequestService(newPolicy);
	}*/
}
