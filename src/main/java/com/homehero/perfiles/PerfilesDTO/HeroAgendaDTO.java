package com.homehero.perfiles.PerfilesDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeroAgendaDTO {
    private String daysOfWeek;
    private int init_hour;
    private int end_hour;
}
