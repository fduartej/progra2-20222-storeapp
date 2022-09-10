package com.acme.storeapp.model;

import javax.validation.constraints.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "t_person")
public class Persona {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String phone; 
    @NotNull
    private String reason; 

    private String comments; 

}
