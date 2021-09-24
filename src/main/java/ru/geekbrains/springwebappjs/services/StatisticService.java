package ru.geekbrains.springwebappjs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.springwebappjs.aspect.log.WebAppAspectLogging;
import ru.geekbrains.springwebappjs.dtos.TimeStatisticDto;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticService {

    public List<TimeStatisticDto> getTimeStatistic() {
        List<TimeStatisticDto> statisticDtoList = new ArrayList<>();
        statisticDtoList.add(new TimeStatisticDto(WebAppAspectLogging.CART_SERVICE_NAME, WebAppAspectLogging.cartServiceTime));
        statisticDtoList.add(new TimeStatisticDto(WebAppAspectLogging.CATEGORY_SERVICE_NAME, WebAppAspectLogging.categoryServiceTime));
        statisticDtoList.add(new TimeStatisticDto(WebAppAspectLogging.ORDER_SERVICE_NAME, WebAppAspectLogging.orderServiceTime));
        statisticDtoList.add(new TimeStatisticDto(WebAppAspectLogging.PRODUCT_SERVICE_NAME, WebAppAspectLogging.productServiceTime));
        statisticDtoList.add(new TimeStatisticDto(WebAppAspectLogging.USER_SERVICE_NAME, WebAppAspectLogging.userServiceTime));
        return statisticDtoList;
    }
}
