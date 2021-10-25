package ru.geekbrains.webmarket.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.webmarket.api.dtos.TimeStatisticDto;
import ru.geekbrains.webmarket.core.services.StatisticService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statistic")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatisticController {
    private final StatisticService statisticService;

    @GetMapping
    public List<TimeStatisticDto> getStatistic() {
        return statisticService.getTimeStatistic();
    }
}
