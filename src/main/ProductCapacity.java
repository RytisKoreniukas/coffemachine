package src.main;

/**
 * Created by rkore on 10/9/2017.
 */
public class ProductCapacity {
    private final int sugarCapacity;
    private final int coffeCapacity;
    private  final double waterCapacity;
    private final int milkCapacity;
    private final int chocolateCapacity;

    public ProductCapacity() {
        this(200,200,2,100,100);
    }

    public ProductCapacity(int sugarCapacity, int coffeCapacity, double waterCapacity, int milkCapacity, int chocolateCapacity) {
        this.sugarCapacity = sugarCapacity;
        this.coffeCapacity = coffeCapacity;
        this.waterCapacity = waterCapacity;
        this.milkCapacity = milkCapacity;
        this.chocolateCapacity = chocolateCapacity;
    }



    public int getSugarCapacity() {
        return sugarCapacity;
    }

    public int getCoffeCapacity() {
        return coffeCapacity;
    }

    public double getWaterCapacity() {
        return waterCapacity;
    }

    public int getMilkCapacity() {
        return milkCapacity;
    }

    public int getChocolateCapacity() {
        return chocolateCapacity;
    }

}
