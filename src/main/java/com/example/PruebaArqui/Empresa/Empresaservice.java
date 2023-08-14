package com.example.PruebaArqui.Empresa;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Empresaservice {

    private final Empresarepository empresarepository;

    @Autowired
    public Empresaservice(Empresarepository enterpriseRepository){
        this.empresarepository = enterpriseRepository;
    }

    public List<Empresaentity>getEnterprises(){
        return this.empresarepository.findAll();
    }
    public ResponseEntity<Object> addNewEnterprise(Empresaentity enterprise){
        Optional<Empresaentity> res = empresarepository.findEnterpriseByName(enterprise.getEnterpriseName());
        HashMap<String, Object> datos = new HashMap<>();

        if(res.isPresent()){
            datos.put("error", true);
            datos.put("message", "Ya existe empresa con ese nombre");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        empresarepository.save(enterprise);
        datos.put("datos", enterprise);
        datos.put("message", "Se registró con exito");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }
}
