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
    private Integer enterpriseId;
    @Column(unique = true)
    private String enterpriseName;

    //Constructor vacio
    public Empresaentity() {
    }

    //Constructor lleno
    public Empresaentity(Integer enterpriseId,
        String documentId, String enterpriseName,
        String enterpriseEmail, String username, String password){
            this.enterpriseId=enterpriseId;
            this.enterpriseName=enterpriseName;
    }

    //Setters y getters
    public Integer getEnterpriseId() {
        return enterpriseId;
    }
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
    public String getEnterpriseName() {
        return enterpriseName;
    }
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    

}