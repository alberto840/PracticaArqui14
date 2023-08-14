package com.example.PruebaArqui.Empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Empresaentity {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empresaId;
    @Column(unique = true)
    private String empresaName;

    //Constructor vacio
    public Empresaentity() {
    }

    //Constructor lleno
    public Empresaentity(Integer empresaId, String empresaName) {
        this.empresaId = empresaId;
        this.empresaName = empresaName;
    }

    //Setters y getters
    public Integer getEmpresaId() {
        return empresaId;
    }
    public void setEmpresaId(Integer enterpriseId) {
        this.empresaId = enterpriseId;
    }
    public String getEmpresaName() {
        return empresaName;
    }
    public void setEmpresaName(String enterpriseName) {
        this.empresaName = enterpriseName;
    }

    

}