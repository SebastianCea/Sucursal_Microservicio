package com.example.microservicios.repository;

import java.util.ArrayList;
import java.util.List;

/*import org.springframework.data.jpa.repository.JpaRepository;*/
import org.springframework.stereotype.Repository;

import com.example.microservicios.model.Sucursal;

@Repository
public class  SucursalRepository  /*extends JpaRepository <Sucursal, Integer>*/ {
    
    private List<Sucursal> sucursales=new ArrayList<>();
    
    /*/List <Sucursal> findAll();*/

    public Sucursal create(Sucursal sucursal){
        sucursales.add(sucursal);
        System.out.println(sucursales.toString());
        return sucursal;
        }

    public List<Sucursal> readAll(){
        return sucursales;
    }

    public Sucursal read(int id_sucursal){
        for (Sucursal sucursal : sucursales){
            if(sucursal.getId_sucursal()==id_sucursal){
                return sucursal;
            }
        }
        return null;
    }

    

    public Sucursal update(int id_sucursal, Sucursal smodificada){
        Sucursal su=read(id_sucursal);
        if(su!=null){
            su.setNombre_sucursal(smodificada.getNombre_sucursal());
            su.setDireccion_sucursal(smodificada.getDireccion_sucursal());
            su.setRegion_sucursal(smodificada.getRegion_sucursal());
            return su;
        }
        return null;
    }

    public String delete (int id_sucursal){
        Sucursal kill=read(id_sucursal);
        if(kill!=null){
            sucursales.remove(kill);
            return "Sucursal Eliminada";
        }
        return "Sucursal no encontrada";
    }
}
