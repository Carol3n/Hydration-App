package com.example.hydrationapp.ui.dashboard;

public class HistoryItem {
    private String name;
    private String date;
    private int timesPerDay;
    private int totalLitres;
    private String timings;

    public HistoryItem(String name, String date, int timesPerDay, int totalLitres, String timings) {
        this.name = name;
        this.date = date;
        this.timesPerDay = timesPerDay;
        this.totalLitres = totalLitres;
        this.timings = timings;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getTimesPerDay() {
        return timesPerDay;
    }

    public int getTotalLitres() {
        return totalLitres;
    }

    public String getTimings() {
        return timings;
    }
}
