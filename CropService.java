package com.example.demo.layer4;
import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.layer2.Crop;

@Service
public interface CropService {

	Crop findCropByNameService(String cropname);
	List<Crop> findAllCropsService();
}

