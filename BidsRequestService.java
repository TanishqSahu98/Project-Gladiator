package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.BidsRequest;


@Service
public interface BidsRequestService {
	BidsRequest findBidsRequestByIDService(int requestno);
	List<BidsRequest> findAllBidsRequestService();
	void insertNewBidsRequest(BidsRequest newBidRequest);
	void updateBidRequest(BidsRequest request);
}