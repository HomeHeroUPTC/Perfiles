package com.homehero.perfiles.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Trabajador {

    @Id
    private int id_trabajador;

    private String tipo_id;

    private String direccion;

    private int telefono;
}
