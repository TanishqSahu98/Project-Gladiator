package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.BidsMade;
import com.example.demo.layer2.Farmer;

@Service
public interface BidsMadeService {
	BidsMade findBidsMadeByIDService(int biddingId);
	List<BidsMade> findAllBidsMadeService();
	List<BidsMade> findAllBidsMadeByBidService(int bid);
}