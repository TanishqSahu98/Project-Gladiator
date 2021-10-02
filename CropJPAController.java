package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Crop;

//import com.example.demo.NotFoundException;
//import com.example.demo.layer2.Farmer;
//import com.example.demo.layer3.FarmerRepository;
import com.example.demo.layer4.CropService;


@CrossOrigin(origins = "", value = "")
@RestController
public class CropJPAController {

	@Autowired
	CropService CropService;
	
	public CropJPAController() {
		System.out.println("CropJPAController...");
	}

	@GetMapping
	@RequestMapping(path="/getJPACrops/") //localhost:8080/getJPACrops/
	public List<Crop> getAllCrops() {
		System.out.println("getAllCrops");
		return CropService.findAllCropsService();
	}
	
	
	@GetMapping
	@RequestMapping(path="/getJPACrop/{cropname}") // localhost:8080/getJPACrop/Rice
	public Crop getSingleCrop(@PathVariable("cropname") String CropNameToFind) throws NotFoundException 
	{
		System.out.println("getCropname : "+CropNameToFind);
		Crop cropname = null;
		cropname = CropService.findCropByNameService(CropNameToFind);
	
		if(cropname == null) {
			NotFoundException d = new NotFoundException("CropName Not Found "+ CropNameToFind);
		}
		return cropname;
	}
	
	
	
}