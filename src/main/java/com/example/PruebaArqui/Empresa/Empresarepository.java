package com.example.PruebaArqui.Empresa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Empresarepository extends JpaRepository<Empresaentity, Integer> {
}
