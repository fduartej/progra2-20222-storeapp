package com.acme.storeapp.repository;

import com.acme.storeapp.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface  UsuarioRepository extends JpaRepository<Usuario, String>{
    
}
