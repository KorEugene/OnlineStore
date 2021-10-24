package ru.geekbrains.webmarket.api.dtos;

public class TimeStatisticDto {

    private String service;
    private long time;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public TimeStatisticDto() {
    }

    public TimeStatisticDto(String service, long time) {
        this.service = service;
        this.time = time;
    }
}
