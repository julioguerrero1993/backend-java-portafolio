package com.example.turismo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turismo.dto.ReservaDTO;
import com.example.turismo.entity.ReservaChecklistEntity;
import com.example.turismo.entity.ReservaEntity;
import com.example.turismo.repository.ReservaChecklistRepository;
import com.example.turismo.repository.ReservaRepository;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
	
	Logger logger = LoggerFactory.getLogger(ReservaController.class);
	
	@Autowired
	private ReservaRepository reservaRepo;
	
	
	@GetMapping("/get-reservas")
	public ResponseEntity<List<ReservaEntity>> getReservas(){
		return ResponseEntity.ok(reservaRepo.findAll());
	}

	@GetMapping("/get-reserva-enable/{date}/{id_departamento}/{id_customer}")
	public ResponseEntity<ReservaEntity> getBookingsEnable(
			@PathVariable("date") String date, @PathVariable("id_departamento") int id_departamento, @PathVariable("id_customer") int id_customer ){
		String fecha = date;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    try {
			Date dateStr = sdf.parse(fecha);
			logger.info("search booking by {} and {}", dateStr, id_departamento);
			
			if(reservaRepo.getBookingQuery(dateStr, id_departamento) == null) {
				
				List<ReservaEntity> listReserva = reservaRepo.findAll();
				List<Integer> numbers = new ArrayList<Integer>();
 
				
				
				if(listReserva.size() > 0){
					for(ReservaEntity e : listReserva) {
						numbers.add(e.getId_reserva());
					}
				}
				
				int idaux = 1;
				
				if(numbers.size() > 0) {
					Collections.sort(numbers);
					Collections.reverse(numbers);
					idaux = numbers.get(0)+1;
				}
				
				
				logger.info("last reserva id {}", idaux);
				ReservaEntity reserva = new ReservaEntity();
				reserva.setId_reserva(idaux);
				reserva.setCliente(id_customer);
				reserva.setDepartamento(id_departamento);
				reserva.setEstado(0);
				reserva.setFecha_final(dateStr);
				reserva.setFecha_inicio(dateStr);
				reserva.setPrecio_total(200000);
				reservaRepo.save(reserva);

				return ResponseEntity.ok(reserva);
			}
			
			return ResponseEntity.ok(null);
		} catch (ParseException e) {
			logger.error("error with search booking");
			return ResponseEntity.ok(reservaRepo.getBookingQuery(new Date(), 1));
		}
		
	}
	
	@PostMapping("/create-reserva")
	public ResponseEntity<HttpStatus> createReservva(@RequestBody ReservaDTO reservaDto){
		ReservaEntity reserva = new ReservaEntity();
		reserva.setId_reserva(reservaDto.getId_reserva());
		reserva.setCliente(reservaDto.getCliente());
		reserva.setDepartamento(reservaDto.getDepartamento());
		reserva.setEstado(0);
		reserva.setFecha_final(reservaDto.getFecha_final());
		reserva.setFecha_inicio(reservaDto.getFecha_inicio());
		reserva.setPrecio_total(reservaDto.getPrecio_total());
		reservaRepo.save(reserva);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/confirm-reserva/{id}")
	public ResponseEntity<ReservaEntity> bookingsEnable(@PathVariable("id") int id){
		ReservaEntity ent = reservaRepo.findById(id).get();
		ent.setEstado(1);
		reservaRepo.save(ent);
		return ResponseEntity.ok(ent);
	}
	
	@GetMapping("/search-reserva-by-customer/{id}")
	public ResponseEntity<List<ReservaEntity>> searchBooking(@PathVariable("id") int id){
		List<ReservaEntity> listEnt = reservaRepo.getBookingByCustomerQuery(id);
		return ResponseEntity.ok(listEnt);
	}
	
	@GetMapping("/delete-reserva-by-id/{id}")
	public ResponseEntity<ReservaEntity> deleteBooking(@PathVariable("id") int id){
		ReservaEntity ent = reservaRepo.findById(id).get();
		reservaRepo.delete(ent);
		return ResponseEntity.ok(new ReservaEntity());
	}
	
	
}
