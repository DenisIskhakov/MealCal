package com.example.mealcal.model;

public enum PercentageSurplusOrDeficit {
    //Только 3 значения : 0.1; 0.15; 0.2

    TEN(0.1),
    FIFTIN(0.15),
    TWENTY(0.2);

    private double percentageSurplusOrDeficit;

    PercentageSurplusOrDeficit(double percentageSurplusOrDeficit) {
        this.percentageSurplusOrDeficit = percentageSurplusOrDeficit;
    }

    public double getPercentageSurplusOrDeficit() {
        return percentageSurplusOrDeficit;
    }
}
