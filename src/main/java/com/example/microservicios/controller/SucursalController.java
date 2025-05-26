package com.example.microservicios.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


    @PostMapping
    public ResponseEntity<Sucursal> postSucursal(@RequestBody Sucursal sucursal) {
        Sucursal nuevo;
        try {
            nuevo = sucursalService.guardarSucursal(sucursal);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // 409 si los clientes están duplicados
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getSucursal(@PathVariable Integer id) {
        Sucursal buscado=sucursalService.findById(id).orElse(null); //.orElse controla el tipo Optional<Cliente>
        if(buscado==null)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(buscado,HttpStatus.OK);
    }




    @DeleteMapping
    public String deleteSucursal(@PathVariable int id_sucursal){
        return sucursalService.eliminarSucursal(id_sucursal);
    }

}
