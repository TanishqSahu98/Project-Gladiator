package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Bidder;
import com.example.demo.layer3.BidderRepository;

@Service
public class BidderServiceIMPL implements BidderService {
	@Autowired
	BidderRepository bRepo;
	
	
	public Bidder findBidderByIdService(int bid) {
		// TODO Auto-generated method stub
		System.out.println("bidder service impl....");
		if(bid<0) {
			RuntimeException rte = new RuntimeException("Bidder ID Cannot be Negative");
			throw rte;
		}
		return bRepo.selectBidderbyId(bid);
	}

	public List<Bidder> findAllBiddersService() {
		// TODO Auto-generated method stub
		return bRepo.selectAllBidders();
	}
}