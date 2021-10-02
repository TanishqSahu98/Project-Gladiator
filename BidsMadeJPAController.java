package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer5.NotFoundException;
import com.example.demo.layer2.BidsMade;
import com.example.demo.layer3.BidsMadeRepository;
import com.example.demo.layer4.BidsMadeService;


@CrossOrigin(origins = "", value = "")
@RestController
public class BidsMadeJPAController {

	@Autowired
	BidsMadeService bidsMadeService;

	//@Autowired 
	//FarmerRepository farmerRepo;
	
	public BidsMadeJPAController() {
		System.out.println("BidsMadeJPAController...");
	}

	//No use
	@GetMapping
	@RequestMapping(path="/getJPABidsMade/") //localhost:8080/getJPABidsMade/
	public List<BidsMade> getAllBidsMade() {
		System.out.println("getAllBidsMade");
		//List<BidsMade> allBidsList = bidsMadeService.findAllBidsMadeService();
		//for(BidsMade bm : allBidsList) {
		//	if(bm.get)
		//}
				
		return bidsMadeService.findAllBidsMadeService();
	}
	
	@GetMapping
	@RequestMapping(path="/getJPABidsMade/{biddingId}") // localhost:8080/getJPABidsMade/502/
	public BidsMade getSingleBidsMade(@PathVariable("biddingId") int biddingIDToFind) throws NotFoundException 
	{
		System.out.println("getDepartment : "+biddingIDToFind);
		BidsMade foundbidsmade = null;
		foundbidsmade = bidsMadeService.findBidsMadeByIDService(biddingIDToFind);
	
		if(foundbidsmade == null) {
			NotFoundException b = new NotFoundException("BiddingID Not Found "+ biddingIDToFind);
		}
		return foundbidsmade;
	}
	
	@PostMapping
	@RequestMapping(path="/getJPABidsMadeById/{bid}") // getJPABidsMadeById/502/
	public List<BidsMade> getBidsMadeBybid(@PathVariable("bid") int bidToFind) throws NotFoundException 
	{
		System.out.println("getDepartment : "+bidToFind);
		List<BidsMade> foundbidsmade = null;
		foundbidsmade = bidsMadeService.findAllBidsMadeByBidService(bidToFind);
	
		if(foundbidsmade == null) {
			NotFoundException b = new NotFoundException("BiddingID Not Found "+ bidToFind);
		}
		return foundbidsmade;
	}
}