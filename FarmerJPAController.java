package com.example.demo.layer5;

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

import com.example.demo.layer2.Farmer;
import com.example.demo.layer3.FarmerRepository;
import com.example.demo.layer4.FarmerService;


@CrossOrigin(origins = "*", value = "*")
@RestController
public class FarmerJPAController {

	@Autowired
	FarmerService farmerService;

	@Autowired 
	FarmerRepository farmerRepo;
	
	public FarmerJPAController() {
		System.out.println("FarmerJPAController...");
	}

	@GetMapping
	@RequestMapping(path="/getJPAFarmers/") //localhost:8080/getJPAFarmers
	public List<Farmer> getAllFarmers() {
		System.out.println("getAllFarmers");
		return farmerService.findAllFarmersService();
	}
	
	/*@GetMapping
	@RequestMapping(path="/getJPAFarmers/") //localhost:8080/getFarmers/
	public List<Farmer> getAllFarmers() {
		System.out.println("getAllFarmers");
		return farmerRepo.selectAllFarmers();
	}*/
	
	@GetMapping
	@RequestMapping(path="/getJPAFarmer/{fid}") // localhost:8080/getJPAFarmer/101
	public Farmer getSingleFarmer(@PathVariable("fid") int farmerIDToFind) throws NotFoundException 
	{
		System.out.println("getFarmer : "+farmerIDToFind);
		Farmer foundDept = null;
		foundDept = farmerService.findFarmerByIdService(farmerIDToFind);
	
		if(foundDept == null) {
			NotFoundException d = new NotFoundException("FarmerID Not Found "+ farmerIDToFind);
		}
		return foundDept;
	}
	
	@PostMapping
	@RequestMapping(path="/addNewFarmer/") // localhost:8080/addNewFarmer/
	public void addNewFarmer(@RequestBody Farmer newFarmer) throws NotFoundException{
		farmerService.insertNewFarmer(newFarmer);
	}
	
	
	

	@PostMapping
	@RequestMapping(path="/loginFarmer/") // localhost:8080/loginFarmer/
	public Farmer loginFarmer(@RequestBody FarmerLogin newFarmer) throws NotFoundException{
		
		String email = newFarmer.getEmail();
		String password =  newFarmer.getPassword();
	
		Farmer foundFarmer = farmerService.loginFarmer(email, password);
		//System.out.println(foundFarmer.getFid());
		return foundFarmer;
	}
}

class FarmerLogin{
	
	private String email;
	private String password;
	
	public FarmerLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
