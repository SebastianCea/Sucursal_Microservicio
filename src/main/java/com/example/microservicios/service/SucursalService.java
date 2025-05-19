package com.example.microservicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicios.model.Sucursal;
import com.example.microservicios.repository.SucursalRepository;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    /*public List<Sucursal> findAll(){
        return sucursalRepository.findAll();
    }*/

    public Sucursal guardarSucursal(Sucursal sucursal){
        return sucursalRepository.create(sucursal);
    }

    public List<Sucursal> listarTodas(){
        return sucursalRepository.readAll();
    }

    public Sucursal buscarxIdSucursal(int id_sucursal){
        return sucursalRepository.read(id_sucursal);
    }

    public Sucursal modificarSucursal(int id_sucursal, Sucursal smodificada){

        return sucursalRepository.update(id_sucursal, smodificada);
    }

    public String eliminarSucursal(int id_sucursal){
        return sucursalRepository.delete(id_sucursal);
    }
}
