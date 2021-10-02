package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Bidder;

@Service
public interface BidderService {
	Bidder findBidderByIdService(int bid);
	List<Bidder> findAllBiddersService();
}
