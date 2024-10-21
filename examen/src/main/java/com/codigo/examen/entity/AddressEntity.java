package com.codigo.examen.entity;

import com.codigo.examen.util.Constantes;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = Constantes.AVENUE + Constantes.VALIDATION_BLANK)
    @Size(max = 100, message = Constantes.AVENUE + Constantes.VALIDATION_SIZE_100)
    @JsonProperty("avenida")
    @Column(name = "avenue", nullable = false, length = 100)
    private String avenue;

    @NotNull(message = Constantes.NUMBER + Constantes.VALIDATION_NULL)
    @JsonProperty("numero")
    @Column(name = "number", nullable = false)
    private Integer number;

    @NotBlank(message = Constantes.DISTRICT + Constantes.VALIDATION_BLANK)
    @Size(max = 100, message = Constantes.DISTRICT + Constantes.VALIDATION_SIZE_100)
    @JsonProperty("distrito")
    @Column(name = "district", nullable = false, length = 100)
    private String district;

    @NotBlank(message = Constantes.PROVINCE + Constantes.VALIDATION_BLANK)
    @Size(max = 100, message = Constantes.PROVINCE + Constantes.VALIDATION_SIZE_100)
    @JsonProperty("provincia")
    @Column(name = "province", nullable = false, length = 100)
    private String province;

    @NotBlank(message = Constantes.DEPARTMENT + Constantes.VALIDATION_BLANK)
    @Size(max = 100, message = Constantes.DEPARTMENT + Constantes.VALIDATION_SIZE_100)
    @JsonProperty("departamento")
    @Column(name = "department", nullable = false, length = 100)
    private String department;


}
