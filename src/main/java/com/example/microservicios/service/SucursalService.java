package com.example.microservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicios.model.Sucursal;
import com.example.microservicios.repository.SucursalRepository;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;


    public List<Sucursal> sucursales(){
        return sucursalRepository.findAll();
    }

    public Sucursal guardarSucursal(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }

    public Optional<Sucursal> findById(Integer id) {
        return sucursalRepository.findById(id);
    }

}    