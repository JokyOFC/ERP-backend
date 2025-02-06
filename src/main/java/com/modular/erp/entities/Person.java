package com.modular.erp.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.OffsetDateTime;

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

//    @JsonProperty("name")
    @Column(name = "name")
    private String name;

//    @JsonProperty("corporateName")
    @Column(name = "corporate_name")
    private String corporateName;

//    @JsonProperty("socialName")
    @Column(name = "social_name")
    private String socialName;

//    @JsonProperty("ieRg")
    @Column(name = "ie_rg")
    private Integer ieRg;

//    @JsonProperty("cpfCnpj")
    @Column(name = "cpf_cnpj", length = 14)
    private String cpfCnpj;

//    @JsonProperty("email")
    @Column(name = "email")
    private String email;

//    @JsonProperty("creationDate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "creation_date")
    private LocalDate creationDate;

}
