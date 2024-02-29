package com.example.hydrationapp.ui.home;

public class HomeItem {

    private String weight;
    private String litresSummary;

    public HomeItem(String medicineName, String dosageSummary) {
        this.weight = medicineName;
        this.litresSummary = litresSummary;
    }

    String getMedicineName() {
        return weight;
    }

    String getDosageSummary() {
        return litresSummary;
    }
}
