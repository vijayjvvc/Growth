package com.jvworld.growth.Model;

public class MarketModel {
    String symbolName;
    double value,incrementPercent;

    public MarketModel(String symbolName, double value, double incrementPercent) {
        this.symbolName = symbolName;
        this.value = value;
        this.incrementPercent = incrementPercent;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public double getValue() {
        return value;
    }

    public double getIncrementPercent() {
        return incrementPercent;
    }
}
