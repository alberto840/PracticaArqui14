package com.example.PruebaArqui.Empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/enterprises")
public class Empresacontroller {

    private final Empresaservice empresaservice;

    @Autowired
    public Empresacontroller(Empresaservice empresaservice) {
        this.empresaservice = empresaservice;
    }

    @GetMapping
    public List<Empresaentity> getEmpresas(){
        return empresaservice.getEmpresas();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewEnterprise(@RequestBody Empresaentity empresa){
        return this.empresaservice.addNewEmpresa(empresa);
    }

}