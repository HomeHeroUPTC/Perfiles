package com.homehero.perfiles.PerfilesDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDTO {
    private int id;
    private String name;
    private String image_url;
    private String address;
}
