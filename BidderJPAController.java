package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Bidder;
import com.example.demo.layer4.BidderService;

@CrossOrigin(origins = "*", value = "*")
@RestController
public class BidderJPAController {

	@Autowired
	BidderService bidderService;

	//@Autowired 
	//FarmerRepository farmerRepo;
	
	public BidderJPAController() {
		System.out.println("BidderJPAController...");
	}

	@GetMapping
	@RequestMapping(path="/getJPABidders/") //localhost:8080/getJPABidders/
	public List<Bidder> getAllBidder() {
		System.out.println("getAllFarmers");
		return bidderService.findAllBiddersService();
	}
	
	@GetMapping
	@RequestMapping(path="/getJPABidder/{bid}") // localhost:8080/getJPABidder/501
	public Bidder getSingleBidder(@PathVariable("bid") int bidderIDToFind) throws NotFoundException 
	{
		System.out.println("getBidder : "+bidderIDToFind);
		Bidder foundBidder = null;
		foundBidder = bidderService.findBidderByIdService(bidderIDToFind);
	
		if(foundBidder == null) {
			NotFoundException d = new NotFoundException("BidderID Not Found "+ bidderIDToFind);
		}
		return foundBidder;
	}
	
	/*@GetMapping
	@RequestMapping(path="/getJPABidder/{bid}") // localhost:8080/getJPABidder/501
	public Bidder getAllBidsMadeByBidder(@PathVariable("bid") int bidderIDToFind) throws NotFoundException 
	{
		System.out.println("getBidder : "+bidderIDToFind);
		Bidder foundBidder = null;
		foundBidder = bidderService.findBidderByIdService(bidderIDToFind);
	
		if(foundBidder == null) {
			NotFoundException d = new NotFoundException("BidderID Not Found "+ bidderIDToFind);
		}
		return foundBidder;
	}*/
	
	
	
}