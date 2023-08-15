package com.example.PruebaArqui.Empresa;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository enterpriseRepository){
        this.empresaRepository = enterpriseRepository;
    }

    public List<EmpresaEntity>getEmpresas(){
        return this.empresaRepository.findAll();
    }
    public ResponseEntity<Object> addNewEmpresa(EmpresaEntity empresa){
        Optional<EmpresaEntity> res = empresaRepository.findEnterpriseByName(empresa.getEmpresaName());
        HashMap<String, Object> datos = new HashMap<>();

        if(res.isPresent()){
            datos.put("error", true);
            datos.put("message", "Ya existe empresa con ese nombre");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        empresaRepository.save(empresa);
        datos.put("datos", empresa);
        datos.put("message", "Se registró con exito");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }
}