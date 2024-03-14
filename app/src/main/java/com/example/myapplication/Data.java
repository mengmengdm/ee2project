package com.example.myapplication;

public class Data {

    private String id;
    private String date;
    private String time;
    private String weekday;
    private String temperature;
    private String humidity;

    public Data(String id, String date, String time, String weekday, String temperature, String humidity) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.weekday = weekday;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getWeekday() {
        return weekday;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }
}
