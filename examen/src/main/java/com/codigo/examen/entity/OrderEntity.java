package com.codigo.examen.entity;

import com.codigo.examen.util.Constantes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = Constantes.DESCRIPTION + Constantes.VALIDATION_BLANK)
    @Size(max = 200, message = Constantes.DESCRIPTION + Constantes.VALIDATION_SIZE_200)
    @JsonProperty("descripcion")
    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @NotNull(message = Constantes.QUANTITY + Constantes.VALIDATION_NULL)
    @Min(value = 1, message = Constantes.QUANTITY + Constantes.VALIDATION_MIN_1)
    @JsonProperty("cantidad")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotBlank(message = Constantes.STATUS + Constantes.VALIDATION_BLANK)
    @Pattern(regexp = Constantes.ORDER_ALL_STATUS, message = Constantes.VALIDATION_ORDER_STATUS)
    @JsonProperty("estado")
    @Column(name = "status", nullable = false)
    private String status;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    @JsonProperty("persona")
    private PersonEntity person;

}
