package com.jvworld.growth.Model;

public class StocksModel {
    String symbol,symbolName,symbolSrc;
    double value,incrementPoint,incrementPercent;
    int share;

    public StocksModel(String symbol, String symbolName, String symbolSrc, double value, double incrementPoint, double incrementPercent, int share) {
        this.symbol = symbol;
        this.symbolName = symbolName;
        this.symbolSrc = symbolSrc;
        this.value = value;
        this.incrementPoint = incrementPoint;
        this.incrementPercent = incrementPercent;
        this.share = share;
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

    public int getShare() {
        return share;
    }
}
