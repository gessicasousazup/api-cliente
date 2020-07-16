package com.br.zup.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String age;
    private String phone;
    private String cpf;
    private String email;
    private boolean admin;

    @PrePersist
    private void onCreate(){
        this.admin = false;
    }
}
