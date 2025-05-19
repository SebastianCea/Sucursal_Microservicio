package com.example.microservicios.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;*/
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicios.model.Sucursal;
import com.example.microservicios.service.SucursalService;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public List<Sucursal> getSucursales(){
        return sucursalService.listarTodas();
    }

    @PostMapping
    public Sucursal postSucursal(@RequestBody Sucursal sucursal){
        return sucursalService.guardarSucursal(sucursal);
    }

    @GetMapping("/{id}")
    public Sucursal getSucursal(@PathVariable int id_sucursal){
        return sucursalService.buscarxIdSucursal(id_sucursal);
    }

    @PutMapping
    public Sucursal putSucursal(@PathVariable int id_sucursal, @RequestBody Sucursal smodificada){
        return sucursalService.modificarSucursal(id_sucursal, smodificada);
    }

    @DeleteMapping
    public String deleteSucursal(@PathVariable int id_sucursal){
        return sucursalService.eliminarSucursal(id_sucursal);
    }
}
