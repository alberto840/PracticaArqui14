package com.example.PracticaArqui14.Empresa;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<EmpresaEntity> getInternships(){
        return empresaRepository.findAll();
    }

    public ResponseEntity<Object> addNewInternship(EmpresaEntity empresa){  
        HashMap<String, Object> datos = new HashMap<>();

        empresaRepository.save(empresa);
        datos.put("datos", empresa);
        datos.put("message", "Se registró con exito");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    } 
    
}