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
public class Usuario {

    @Id
    private int id_usuario;

    private String tipo_documento;

    private String direccion;

    private int telefono;
}
