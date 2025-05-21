package com.example.microservicios.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicios.model.Sucursal;
import com.example.microservicios.service.SucursalService;

@RestController
@RequestMapping("/api/v1/sucursales")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<Sucursal>> getSucursales(){
        List<Sucursal> sucursales=sucursalService.sucursales();
        if(sucursales.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sucursales,HttpStatus.OK);
    }

}
