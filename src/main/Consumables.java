package src.main;

/**
 * Created by rkore on 10/10/2017.
 */
public class Consumables {

    private int sugarLeft;
    private int coffeLeft;
    private double waterLeft;
    private int milkLeft;
    private int chocholateLeft;


    public Consumables(int sugarLeft, int coffeLeft, double waterLeft, int milkLeft, int chocholateLeft) {
        this.sugarLeft = sugarLeft;
        this.coffeLeft = coffeLeft;
        this.waterLeft = waterLeft;
        this.milkLeft = milkLeft;
        this.chocholateLeft = chocholateLeft;

    }

    public int getSugarLeft() {
        return sugarLeft;
    }

    public int getCoffeLeft() {
        return coffeLeft;
    }

    public double getWaterLeft() {
        return waterLeft;
    }

    public int getMilkLeft() {
        return milkLeft;
    }

    public int getChocholateLeft() {
        return chocholateLeft;
    }


    public void setSugarLeft(int sugarLeft) {
        this.sugarLeft = sugarLeft;
    }

    public void setCoffeLeft(int coffeLeft) {
        this.coffeLeft = coffeLeft;
    }

    public void setWaterLeft(double waterLeft) {
        this.waterLeft = waterLeft;
    }

    public void setMilkLeft(int milkLeft) {
        this.milkLeft = milkLeft;
    }

    public void setChocholateLeft(int chocholateLeft) {
        this.chocholateLeft = chocholateLeft;
    }



    public void setAllConsumablesTo0(){
        this.setSugarLeft(0);
        this.setWaterLeft(0.0);
        this.setCoffeLeft(0);
    }




}
