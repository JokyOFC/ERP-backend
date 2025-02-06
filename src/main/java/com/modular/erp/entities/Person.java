package com.modular.erp.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "corporate_name")
    private String corporateName;

    @Column(name = "social_name")
    private String socialName;

    @Column(name = "ie_rg")
    private Integer ieRg;

    @Column(name = "cpf_cnpj", length = 14)
    private String cpfCnpj;

    @Column(name = "email")
    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "creation_date")
    private LocalDate creationDate;

}
