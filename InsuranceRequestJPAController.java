package com.example.demo.layer5;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.ClaimDetail;
import com.example.demo.layer2.Crop;
import com.example.demo.layer2.Farmer;
import com.example.demo.layer2.InsuranceRequest;
import com.example.demo.layer2.PolicyDetail;
import com.example.demo.layer3.FarmerRepository;
import com.example.demo.layer4.CropService;
import com.example.demo.layer4.FarmerService;
import com.example.demo.layer4.InsuranceRequestService;
import com.example.demo.layer4.PolicyDetailService;

@CrossOrigin(origins="",value="")
@RestController
public class InsuranceRequestJPAController {

	@Autowired
	InsuranceRequestService IRser;
	
	@Autowired 
	CropService cropService;
	
	@Autowired
	FarmerService farmerService;
	
	@Autowired
	PolicyDetailService policyService;
	
	public InsuranceRequestJPAController() {
		System.out.println("DeptJPAController().....");
	}
	
	@GetMapping
	@RequestMapping(path="/getIR/{requestno}")   //http://localhost:8080/getIR/20001
	public InsuranceRequest selectRequestNo(@PathVariable("requestno") int RequestNoToFind) throws NotFoundException 
	{
		System.out.println("getInsurance : "+RequestNoToFind);
		InsuranceRequest foundRequest = null;
		foundRequest = IRser.findInsuranceByRequestNO(RequestNoToFind);
		if(foundRequest == null) {
			NotFoundException d = new NotFoundException("Insurance Number Not Found "+RequestNoToFind);
		}
		return foundRequest;
	}
	
	@GetMapping
	@RequestMapping(path="/getIRs") //localhost:8080/getIRs
	public List<InsuranceRequest> selectAllRequest() {
		System.out.println("getAllRequest");
		return IRser.findAllInsuranceRequest();
	}
	
	@GetMapping
	@RequestMapping(path="/getIRFid/{fid}")//http://localhost:8080/getIRFid/101/
	public List<InsuranceRequest> selectInsuranceReqestByFID(@PathVariable("fid") int FIDToFind) throws NotFoundException 
	{
		System.out.println("getAllInsurancesByFarmer : "+FIDToFind);
		List<InsuranceRequest> foundRequest = null;
		foundRequest = IRser.findInsuranceByFID(FIDToFind);
		if(foundRequest == null) {
			NotFoundException d = new NotFoundException("No Insurance Request Found for this farmer with "+FIDToFind);
		}
		return foundRequest;
	}
	
	@PostMapping
	@RequestMapping(path="/insertRequest") //http://localhost:8080/insertRequest/
	public void addNewInsuranceRequest(@RequestBody InsertInsuranceDTO requestToInsert) throws NotFoundException 
	{
		//System.out.println("addDepartment2 : "+requestToInsert.getNomineeName() +" "+requestToInsert.getCompany()); 		
		InsuranceRequest newRequest = requestToInsert.getInsuranceRequest();
		int fid = requestToInsert.getFid();
		String cropName = requestToInsert.getCropName();
		
		Farmer f = farmerService.findFarmerByIdService(fid);
		Crop crop = cropService.findCropByNameService(cropName);
		
		newRequest.setCrop(crop);
		newRequest.setFarmer(f);
	
		IRser.insertNewInsuranceRequestService(newRequest);
		
		//After entering in insurance table, this will enter in the policy details also
		//PolicyDetail newPolicyDetail = new PolicyDetail();
		
		//newPolicyDetail.setSumInsured(newRequest.getSumInsured());
		//newPolicyDetail.setYear(newRequest.getYear());
		//newPolicyDetail.setCompany(newRequest.getCompany());
		//newPolicyDetail.setPolicyno(newRequest.getRequestno());
		
		//policyService.insertNewPolicyDetail(newPolicyDetail);
	}
	
	
}

class InsertInsuranceDTO{
	
	InsuranceRequest insuranceRequest;
	int fid;
	String cropName;
	
	
	
	public InsertInsuranceDTO(InsuranceRequest insuranceRequest, int fid, String cropName) {
		super();
		this.insuranceRequest = insuranceRequest;
		this.fid = fid;
		this.cropName = cropName;
	}
	public InsuranceRequest getInsuranceRequest() {
		return insuranceRequest;
	}
	public void setInsuranceRequest(InsuranceRequest insuranceRequest) {
		this.insuranceRequest = insuranceRequest;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
}
