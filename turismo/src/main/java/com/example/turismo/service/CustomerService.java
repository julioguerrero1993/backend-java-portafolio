package com.example.turismo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.turismo.dto.CustomerDTO;
import com.example.turismo.entity.ClienteEntity;
import com.example.turismo.repository.ClienteRepository;

@Service
public class CustomerService {

	private ClienteRepository customerRepo;
	
	public CustomerService(ClienteRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	public List<CustomerDTO> getAllCustomer() {
		List<ClienteEntity> customerFromDB =  this.customerRepo.findAll();
		List<CustomerDTO> listCustomerDTO = null;
		if(customerFromDB != null && !customerFromDB.isEmpty()) {
			listCustomerDTO = new ArrayList<CustomerDTO>();
			for(ClienteEntity entity : customerFromDB) {
				listCustomerDTO.add(this.toDTO(entity));
			}
		}
		return listCustomerDTO;
	}
	
	public CustomerDTO findById(Integer id) {
		return this.toDTO(this.customerRepo.findById(id).get());
	}
	
	public void saveOrUpdateCustomer(CustomerDTO customer) {
		ClienteEntity customerResultQueryById = null;
		try {
			customerResultQueryById = this.customerRepo.findById(customer.getId_cliente()).get();
		}
		catch(Exception e) {
			
		}
		
		if(customer != null) {
			
			if(customerResultQueryById != null) {
				customerResultQueryById.setComuna(customer.getComuna());
				customerResultQueryById.setFecha_nacimiento(customer.getFecha_nacimiento());
				customerResultQueryById.setCliente_user(customer.getCliente_user());
				customerResultQueryById.setMail(customer.getMail());
				customerResultQueryById.setNombre(customer.getNombre());
				customerResultQueryById.setTelefono(customer.getTelefono());
				
				this.customerRepo.save(customerResultQueryById);
			} else {
				this.customerRepo.save(this.toEntity(customer));
			}
		}
	}
	
	public CustomerDTO toDTO(ClienteEntity entity){
		if(entity != null) {
			return new CustomerDTO(entity.getId_cliente(), 
					entity.getComuna(), 
					entity.getNombre(), 
					entity.getFecha_nacimiento(), 
					entity.getTelefono(), 
					entity.getMail(), 
					entity.getId_cliente());
		}
		return null;
	}
	
	public ClienteEntity toEntity(CustomerDTO customer) {
		if(customer != null) {
			return new ClienteEntity(customer.getId_cliente(), 
					customer.getComuna(), 
					customer.getNombre(), 
					customer.getFecha_nacimiento(), 
					customer.getTelefono(), 
					customer.getMail(), 
					customer.getCliente_user());
		}
		return null;
	}
}
