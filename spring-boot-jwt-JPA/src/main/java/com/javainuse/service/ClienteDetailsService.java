package com.javainuse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.dao.ClienteDao;
import com.javainuse.model.Cliente;
import com.javainuse.model.ClienteDTO;

@Service
public class ClienteDetailsService {
	
	@Autowired
	private ClienteDao clienteDao;

	public Cliente save(ClienteDTO cliente) {
		Cliente auxCliente = new Cliente();
		auxCliente.setNombre(cliente.getNombre());
		auxCliente.setApellido(cliente.getApellido());
		auxCliente.setEdad(cliente.getEdad());
		return clienteDao.save(auxCliente);
	}
	
	public void update(ClienteDTO cliente, Long id) {
		
		clienteDao.updateById(cliente.getNombre(), cliente.getApellido(), cliente.getEdad(), id);
		
	}
	
	public Iterable<Cliente> getAll(){
		return clienteDao.findAll();
	}
	
	public Optional<Cliente> getById(Long id){
		return clienteDao.findById(id);
	}
	
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}
	
}
