package com.example.turismo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turismo.dto.CustomerDTO;
import com.example.turismo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/get-customers")
	public ResponseEntity<List<CustomerDTO>> getChecklist() {
		return ResponseEntity.ok(this.customerService.getAllCustomer());
	}
	
	@PostMapping("/saveOrUpdate-customer")
	public ResponseEntity<HttpStatus> saveOrUpdateChecklist(@RequestBody CustomerDTO customerDTO) {
		this.customerService.saveOrUpdateCustomer(customerDTO);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/get-customer-by-id/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Integer id) {
		CustomerDTO customer = this.customerService.findById(id);
		if(customer != null) {
			return ResponseEntity.ok(customer);
		}
		return ResponseEntity.ok(null);
	}

}
