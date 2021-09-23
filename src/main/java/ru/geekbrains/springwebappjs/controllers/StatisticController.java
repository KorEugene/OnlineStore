package ru.geekbrains.springwebappjs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.springwebappjs.dtos.TimeStatisticDto;
import ru.geekbrains.springwebappjs.services.StatisticService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statistic")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;

    @GetMapping
    public List<TimeStatisticDto> getStatistic() {
        return statisticService.getTimeStatistic();
    }
}
