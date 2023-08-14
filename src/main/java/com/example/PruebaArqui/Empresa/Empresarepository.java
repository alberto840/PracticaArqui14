package com.example.PruebaArqui.Empresa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Empresarepository extends JpaRepository<Empresaentity, Integer> {
    Optional<Empresaentity> findEnterpriseByName(String email);

}
