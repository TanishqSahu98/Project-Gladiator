package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.BidsMade;
import com.example.demo.layer2.BidsRequest;
import com.example.demo.layer3.BidsMadeRepository;
import com.example.demo.layer3.BidsRequestRepository;

@Service
public class BidsRequestServiceImpl implements BidsRequestService {

	@Autowired
	BidsRequestRepository BrRepo;
	
	public BidsRequest findBidsRequestByIDService(int requestno) {
		// TODO Auto-generated method stub
		System.out.println("BidsMade service impl....");
		if(requestno<0) {
			RuntimeException rte = new RuntimeException("Request no Cannot be Negative");
			throw rte;
		}
		return BrRepo.selectBidsRequestByID(requestno);
	}

	
	public List<BidsRequest> findAllBidsRequestService() {
		// TODO Auto-generated method stub
		return BrRepo.selectAllBidsRequest();
	}


	@Override
	public void insertNewBidsRequest(BidsRequest newBidRequest) {
		BrRepo.insertBidsRequest(newBidRequest);
	}


	@Override
	public void updateBidRequest(BidsRequest request) {
		// TODO Auto-generated method stub
		BrRepo.updateSingleBidsRequest(request);
	}
	
}