package com.example.PracticaArqui14.Empresa;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;
    private final OkHttpClient okHttpClient;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository, OkHttpClient okHttpClient) {
        this.empresaRepository = empresaRepository;
        this.okHttpClient = okHttpClient;
    }

    public String consumeApi(String apiUrl) throws IOException {
        Request request = new Request.Builder()
            .url(apiUrl)
            .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public List<EmpresaEntity> getInternships(){        
        return empresaRepository.findAll();
    }

    public ResponseEntity<Object> addNewInternship(EmpresaEntity empresa) {  
        HashMap<String, Object> datos = new HashMap<>();

        empresaRepository.save(empresa);
        datos.put("datos", empresa);
        datos.put("message", "Secreo correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    } 
}