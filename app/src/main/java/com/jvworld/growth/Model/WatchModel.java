package com.jvworld.growth.Model;

import android.graphics.drawable.Drawable;

public class WatchModel {
    String symbol,symbolName,symbolSrc;
    double value,incrementPoint,incrementPercent;

    public WatchModel(String symbol, String symbolName, String symbolSrc, double value, double incrementPoint, double incrementPercent) {
        this.symbol = symbol;
        this.symbolName = symbolName;
        this.symbolSrc = symbolSrc;
        this.value = value;
        this.incrementPoint = incrementPoint;
        this.incrementPercent = incrementPercent;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public String getSymbolSrc() {
        return symbolSrc;
    }

    public double getValue() {
        return value;
    }

    public double getIncrementPoint() {
        return incrementPoint;
    }

    public double getIncrementPercent() {
        return incrementPercent;
    }
}
