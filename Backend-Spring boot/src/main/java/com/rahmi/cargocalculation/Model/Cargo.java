package com.rahmi.cargocalculation.Model;

// Kargo isminde sınıf oluşturuldu.
// Construtor, getter ve setterlar generate edildi.
public class Cargo {


    private int sevenCount;


    private int twoCount;


    private int totalKg;

    public Cargo() {
    }

    public Cargo(int sevenCount, int twoCount, int totalKg) {
        this.sevenCount = sevenCount;
        this.twoCount = twoCount;
        this.totalKg = totalKg;
    }

    public int getSevenCount() {
        return sevenCount;
    }

    public void setSevenCount(int sevenCount) {
        this.sevenCount = sevenCount;
    }

    public int getTwoCount() {
        return twoCount;
    }

    public void setTwoCount(int twoCount) {
        this.twoCount = twoCount;
    }

    public int getTotalKg() {
        return totalKg;
    }

    public void setTotalKg(int totalKg) {
        this.totalKg = totalKg;
    }
}
