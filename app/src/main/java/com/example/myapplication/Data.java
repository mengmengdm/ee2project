package com.example.myapplication;

public class Data {

    private String id;
    private String date;
    private String time;
    private String weekday;
    private String temperature;
    private String humidity;
    private String sound;
    private String people;
    public Data(String id, String date, String time, String weekday, String temperature, String humidity,String sound,String people) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.weekday = weekday;
        this.temperature = temperature;
        this.humidity = humidity;
        this.sound = sound;
        this.people = people;
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

    public String getSound() {return sound;}

    public String getPeople(){return people;}
}
