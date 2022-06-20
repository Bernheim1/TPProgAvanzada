package com.javainuse.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Cliente;
import com.javainuse.model.ClienteDTO;
import com.javainuse.service.ClienteDetailsService;

@RestController
public class ClientesController {

	@Autowired
	private ClienteDetailsService clienteDetailsService;
	
	@GetMapping("/clientes")
	public Iterable<Cliente> getClientes(){
		
		return clienteDetailsService.getAll();
		
	}
	
	@GetMapping("/cliente/{id}")
	public Optional<Cliente> getClienteById(@PathVariable Long id){
		
		return clienteDetailsService.getById(id);
		
	}
	
	@PostMapping("/cliente")
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> insertCliente(@RequestBody ClienteDTO cliente){
		
		return ResponseEntity.ok(clienteDetailsService.save(cliente));
		
	}
	
	@PutMapping("/cliente/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void updateCliente(@RequestBody ClienteDTO cliente, @PathVariable Long id) {
		
		clienteDetailsService.update(cliente, id);
		
	}
	
	@DeleteMapping("/cliente/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteCliente(@PathVariable Long id) {
		
		clienteDetailsService.delete(id);
		
	}
	
}
