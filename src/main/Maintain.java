
package src.main;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkore on 10/10/2017.
 */
public class Maintain implements Maintainer{
    private ProductCapacity productCapacity;
    private Consumables consumables;


    public Consumables returnCopyOfConsumable(Consumables original) {
        Consumables copy = new Consumables(original.getSugarLeft(), original.getCoffeLeft(), original.getWaterLeft(), original.getMilkLeft(),original.getChocholateLeft());
        return copy;
    }

    public CoffeMachine createDefaultCoffemachine() {
        return new CoffeMachine();
    }

    public CoffeMachine createSpepcialCoffemachine(String name, int sugar, double water, int coffe,int milk, int chocolate, int smallcups, int mediumCups, int largeCups) {
        return new CoffeMachine(name, sugar, coffe, water,milk,chocolate,smallcups,mediumCups,largeCups);
    }

    public void cleanCoffeMachine(CoffeMachine coffemachine) {
        coffemachine.clearAparatus();
    }


    public List<CoffeMachine> produceCoffeMachines(int quantity, CoffeMachine prototype) {
        List<CoffeMachine> serie = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            serie.add(prototype);
        }
        return serie;

    }

    public void clearCoffeMachinesProducts(List<CoffeMachine> machines) {
        int totalSugar = 0;
        double totalWater = 0.0;
        int totalCoffe = 0;
        for (CoffeMachine o : machines) {
            this.productCapacity = o.getProductCapacity();
            totalSugar += this.consumables.getSugarLeft();
            totalCoffe += this.consumables.getCoffeLeft();
            totalWater += this.consumables.getWaterLeft();
            this.consumables.setAllConsumablesTo0();

        }
        System.out.println("Suma visos aparatu kavos:" + totalCoffe);
        System.out.println("Suma viso aparatu cukraus:" + totalSugar);
        System.out.println("Suma viso aparatu vandens:" + totalWater);
        System.out.println("Visu aparatu produktai nunulinti");
    }

    public void clearAllCoffeMachines(CoffeMachine[] machines) {
        for (CoffeMachine machine : machines) {
            machine.clearAparatus();
        }
        System.out.println("Visi aparatai isvalyti");
    }

    public CoffeMachine[] fillDefaultProducts(CoffeMachine[] machines, ProductCapacity productCapacity) {
        for (CoffeMachine o : machines) {
            o.setProductCapacity(productCapacity);
        }
        return machines;
    }


}
