package com.acme.storeapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acme.storeapp.model.Cliente;
import com.acme.storeapp.model.Usuario;

@Repository
public interface  ClienteRepository extends JpaRepository<Cliente, Integer>{


    @Query(value = "SELECT o FROM Cliente o WHERE o.user=?1")
    Cliente findByUsuario(Usuario user);
    
}
