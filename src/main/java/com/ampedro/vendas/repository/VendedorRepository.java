package com.ampedro.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ampedro.vendas.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository <Vendedor, Long> {
}
