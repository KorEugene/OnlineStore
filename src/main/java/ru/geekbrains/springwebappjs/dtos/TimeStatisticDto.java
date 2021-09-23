package ru.geekbrains.springwebappjs.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeStatisticDto {

    private String service;
    private long time;
}
