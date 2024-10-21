package com.codigo.examen.entity;

import com.codigo.examen.util.Constantes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "person")
@Getter
@Setter
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = Constantes.NAME + Constantes.VALIDATION_BLANK)
    @Size(max = 50, message = Constantes.NAME + Constantes.VALIDATION_SIZE_50)
    @JsonProperty("nombres")
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotBlank(message = Constantes.LAST_NAME + Constantes.VALIDATION_BLANK)
    @Size(max = 50, message = Constantes.LAST_NAME + Constantes.VALIDATION_SIZE_50)
    @JsonProperty("apellidos")
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @NotBlank(message = Constantes.ID_NUMBER + Constantes.VALIDATION_BLANK)
    @Size(max = 20, message = Constantes.ID_NUMBER + Constantes.VALIDATION_SIZE_20)
    @JsonProperty("nroDocumento")
    @Column(name = "id_number", nullable = false, length = 20, unique = true)
    private String idNumber;

    @NotBlank(message = Constantes.STATUS + Constantes.VALIDATION_BLANK)
    @Pattern(regexp = Constantes.PERSON_ALL_STATUS, message = Constantes.VALIDATION_PERSON_STATUS)
    @JsonProperty("estado")
    @Column(name = "status", nullable = false)
    private String status;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JsonProperty("direccion")
    private AddressEntity addressEntity;

    @JsonManagedReference
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonProperty("pedidos")
    private List<OrderEntity> orders = new ArrayList<>();

}
