package com.example.PruebaArqui.Empresa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Integer> {
    Optional<EmpresaEntity> findEnterpriseByName(String email);

}