package com.example.demo.layer5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer5.NotFoundException;
import com.example.demo.layer2.BidsRequest;
import com.example.demo.layer2.Crop;
import com.example.demo.layer2.Farmer;
import com.example.demo.layer2.InsuranceRequest;
import com.example.demo.layer3.BidsRequestRepository;
import com.example.demo.layer3.FarmerRepository;
import com.example.demo.layer4.BidsRequestService;
import com.example.demo.layer4.CropService;
import com.example.demo.layer4.FarmerService;


@CrossOrigin(origins = "", value = "")
@RestController
public class BidsRequestJPAController {

	@Autowired
	BidsRequestService bidsRequestService;

	@Autowired
	CropService cropService;
	
	@Autowired
	FarmerService farmerService;
	
	//@Autowired 
	//FarmerRepository farmerRepo;
	
	public BidsRequestJPAController() {
		System.out.println("BidsRequestJPAController...");
	}

	
	//ADMIN USED URLS
	
	//1. Admin to view the entire bids requests
	@GetMapping
	@RequestMapping(path="/getJPABidsRequest/") //localhost:8080/getJPABidsRequest/
	public List<BidsRequest> getAllBidsRequest() {
		System.out.println("getAllBidsRequest");
		
		//List<BidsRequest> allBidsRequest = bidsRequestService.findAllBidsRequestService();
		//List<BidsRequest> approvedBidsRequest = [];
		
		//for(BidsRequest br : allBidsRequest) {
			//if(br.getStatus().equals("Approved")) {
					//approvedBidsRequest.add(br);
			//}
		//}
		return bidsRequestService.findAllBidsRequestService();
	}
	
	//2. To approve bid request by requestno
	@PostMapping
	@RequestMapping(path="/approveJPABidRequest/{requestno}") //localhost:8080/approveJPABidRequest/40001
	public void approveSingleBidRequest(@PathVariable("requestno") int requestnoToApprove) throws NotFoundException 
	{
		System.out.println("getbidsRequest : "+requestnoToApprove);
	
		BidsRequest request = bidsRequestService.findBidsRequestByIDService(requestnoToApprove);
		
		//To update the status of bid request sent as approved
		System.out.println(request.getRequestno() + " " + request.getStatus());
		request.setStatus("Approved");
		
		bidsRequestService.updateBidRequest(request);
	}
	
	
	//To show only approved bids to the bidder of all types
	@GetMapping
	@RequestMapping(path="/getApprovedBidsRequest/") //localhost:8080/getApprovedBidsRequest
	public List<BidsRequest> getApprovedBidsRequest() {
		System.out.println("getApprovedBidsRequest");
		
		List<BidsRequest> allBidsRequest = bidsRequestService.findAllBidsRequestService();
		List approvedBidsRequest = new ArrayList<BidsRequest>();
		
		for(BidsRequest br : allBidsRequest) {
			if(br.getStatus().equals("Approved")) {
					approvedBidsRequest.add(br);
			}
		}
		return approvedBidsRequest;
		//return bidsRequestService.findAllBidsRequestService();
	}
	
	
	//Search Bids By Crop Name
	@GetMapping
	@RequestMapping(path="/getApprovedBidsRequestByCrop/{cropName}") //localhost:8080/getApprovedBidsRequestByCrop
	public List<BidsRequest> getApprovedBidsRequestByCropName(@PathVariable("cropName") String cropName) {
		
		System.out.println("getApprovedBidsRequestByCropName");
		
		List<BidsRequest> allBidsRequest = bidsRequestService.findAllBidsRequestService();

		List<BidsRequest> approvedBidRequestByCrop = new ArrayList<BidsRequest>();
		
		for(BidsRequest br : allBidsRequest) {
			//System.out.println(br.getCrop().getCropname());
			if(br.getStatus().equals("Approved") && br.getCrop().getCropname().equals(cropName)) {
				approvedBidRequestByCrop.add(br);
			}
		}
		return approvedBidRequestByCrop;
	}
	
	
	
	
	@GetMapping
	@RequestMapping(path="/getJPABidsRequest/{requestno}") // localhost:8080/getJPABidsRequest/20001
	public BidsRequest getSingleBidsRequest(@PathVariable("requestno") int requestnoToFind) throws NotFoundException 
	{
		System.out.println("getbidsRequest : "+requestnoToFind);
		BidsRequest foundbidsrequest = null;
		foundbidsrequest = bidsRequestService.findBidsRequestByIDService(requestnoToFind);
	
		if(foundbidsrequest == null) {
			NotFoundException b = new NotFoundException("BiddingID Not Found "+ requestnoToFind);
		}
		return foundbidsrequest;
	}
	
	
	
	@PostMapping
	@RequestMapping(path="/insertBidRequest") //http://localhost:8080/insertBidRequest/
	public void addNewBidRequest(@RequestBody insertBidRequestCropDTO requestToInsert) throws NotFoundException 
	{
		//System.out.println("addDepartment2 : "+requestToInsert.getNomineeName() +" "+requestToInsert.getCompany()); 		
		BidsRequest newRequest = requestToInsert.getNewBidRequest();
		String cropName = requestToInsert.getCropName();
		int fid = requestToInsert.getFid();
		
		Crop crop = cropService.findCropByNameService(cropName);
		Farmer farmer = farmerService.findFarmerByIdService(fid);
		
		newRequest.setCrop(crop);
		newRequest.setFarmer(farmer);
		newRequest.setStatus("Pending");
		
		bidsRequestService.insertNewBidsRequest(newRequest);
	}
}


class insertBidRequestCropDTO{
	
	BidsRequest newBidRequest;
	String CropName;
	int fid;
	
	public insertBidRequestCropDTO(BidsRequest newBidRequest, String cropName, int fid) {
		super();
		this.newBidRequest = newBidRequest;
		CropName = cropName;
		this.fid = fid;
	}
	
	public int getFid() {
		return fid;
	}


	public void setFid(int fid) {
		this.fid = fid;
	}


	public BidsRequest getNewBidRequest() {
		return newBidRequest;
	}
	public void setNewBidRequest(BidsRequest newBidRequest) {
		this.newBidRequest = newBidRequest;
	}
	public String getCropName() {
		return CropName;
	}
	public void setCropName(String cropName) {
		CropName = cropName;
	}

}
/*
{
"fid" : 102,
"newBidRequest":{
	"fertilizer": "Phospohorus", 
	"phCertificate": 2.5,
	"qty": 5
	},
"CropName": "WHEAT"
},*/