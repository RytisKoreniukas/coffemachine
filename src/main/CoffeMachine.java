
package src.main;

/**
 * Simple coffemachine app, created 2017.10
 */
public class CoffeMachine implements CoffeMaker {
    private final String name;
    private ProductCapacity productCapacity;
    private Consumables consumables;
    private int usageCounter;
    private final int MAX_USED = 100;
    private final CupsCapacity cupsCapacity;
    private StoredCups storedCups;


    public void setProductCapacity(ProductCapacity productCapacity) {
        this.productCapacity = productCapacity;
    }

    public CoffeMachine() {
        this("Defoltinis", 200, 200, 4, 100, 100, 10, 20, 10);
    }

    public CoffeMachine(String name, int sugarCapacity, int coffeCapacity, double waterCapacity, int milkCapacity, int chocholateCapacity, int smallCups, int mediumCups, int largeCups) {
        this.productCapacity = new ProductCapacity(sugarCapacity, coffeCapacity, waterCapacity, milkCapacity, chocholateCapacity);
        this.name = name;
        this.consumables = new Consumables(0, 0, 0, 0, 0);
        this.usageCounter = 0;
        this.cupsCapacity = new CupsCapacity(smallCups, mediumCups, largeCups);
        this.storedCups = new StoredCups(0,0,0);
    }

    public String getName() {
        return name;
    }

    public int getSugarCapacity() {
        return this.productCapacity.getSugarCapacity();
    }

    public int getCoffeCapacity() {
        return this.productCapacity.getCoffeCapacity();
    }

    public double getWaterCapacity() {
        return this.productCapacity.getWaterCapacity();
    }

    public int getMilkCapacity() {
        return this.productCapacity.getMilkCapacity();
    }

    public int getChocolateCapacity() {
        return this.productCapacity.getChocolateCapacity();
    }

    public int getSugarLeft() {
        return this.consumables.getSugarLeft();
    }

    public int getCoffeLeft() {
        return this.consumables.getCoffeLeft();
    }

    public double getWaterLeft() {
        return this.consumables.getWaterLeft();
    }

    public int getMilkLeft() {
        return this.consumables.getMilkLeft();
    }

    public int getChocolateLeft() {
        return this.consumables.getChocholateLeft();
    }


    public boolean fillWater(double water) {
        if (water <= (getWaterCapacity() - getWaterLeft())) {
            this.consumables.setWaterLeft(getWaterLeft() + water);
            System.out.println("Aparatas papildytas vandeniu " + water + " l");
            return true;
        } else {
            System.out.println("Sumazinkyte norimo ipilti vandens kieki, aparato " + getName() + "talpa  yra tik" +
                    getWaterCapacity());
            return false;
        }
    }

    public boolean fillSugar(int sugar) {
        if (sugar <= (getSugarCapacity() - getSugarLeft())) {
            this.consumables.setSugarLeft(getSugarLeft() + sugar);
            System.out.println("Aparatas papildytas cukrumi " + sugar + " g");
            return true;
        } else {
            System.out.println("Sumazinkyte norimo ipilti cukraus kieki, aparato " + getName() + " talpa  yra tik " +
                    getSugarCapacity() + "g");
            return false;
        }
    }

    public boolean fillCoffe(int coffe) {
        if (coffe <= (getCoffeCapacity() - getCoffeLeft())) {
            this.consumables.setCoffeLeft(this.consumables.getCoffeLeft() + coffe);
            System.out.println("Aparatas papildytas kava " + coffe + " g");
            return true;
        } else {
            System.out.println("Sumazinkyte norimo ipilti kavos kieki, aparato " + getName() + " talpa  yra tik " +
                    getCoffeCapacity() + " g ");
            return false;
        }
    }

    public boolean fillMilk(int milk) {
        if (milk <= (getMilkCapacity() - getMilkLeft())) {
            this.consumables.setMilkLeft(getMilkLeft() + milk);
            System.out.println("Aparatas papildytas kava " + milk + " g");
            return true;
        } else {
            System.out.println("Sumazinkyte norimo ipilti kavos kieki, aparato " + getName() + " talpa  yra tik " +
                    getMilkCapacity() + " g ");
            return false;
        }
    }

    public boolean fillChocolate(int chocolate) {
        if (chocolate <= (getChocolateCapacity() - getChocolateLeft())) {
            this.consumables.setChocholateLeft(getChocolateLeft() + chocolate);
            System.out.println("Aparatas papildytas kava " + chocolate + " g");
            return true;
        } else {
            System.out.println("Sumazinkyte norimo ipilti kavos kieki, aparato " + getName() + " talpa  yra tik " +
                    getChocolateCapacity() + " g ");
            return false;
        }
    }


    public void consume(Recepys recepy) {
        String name = recepy.getPavadinimas();

        this.consumables.setCoffeLeft(getCoffeLeft() - recepy.getCoffe());
        this.consumables.setWaterLeft(getWaterLeft() - recepy.getWater());
        this.consumables.setSugarLeft(getSugarLeft() - recepy.getSugar());
        this.consumables.setMilkLeft(getMilkLeft() - recepy.getMilk());
        this.consumables.setChocholateLeft(getChocolateLeft() - recepy.getChocolate());
        useCup(recepy);
        this.usageCounter++;
        System.out.println("Paruosta kava: " + name);

    }

    public boolean useCup(Recepys recepy) {
        if (recepy.getRequiredCupType() == Cup.SMALL.getIndex()) {
            storedCups.setSmallCups(storedCups.getSmallCups() - 1);
            return true;
        } else if (recepy.getRequiredCupType() == Cup.LARGE.getIndex()) {
            storedCups.setLargeCups(storedCups.getLargeCups() - 1);
            return true;
        } else if (recepy.getRequiredCupType() == Cup.MEDIUM.getIndex()){
            storedCups.setMediumCups(storedCups.getMediumCups() - 1);
            return true;
        }return false;
    }


    public void makeCoffe(int recepyIndex) {
        if (isReady() && (this.usageCounter < MAX_USED)) {
            consume(Recepys.getRecepyByIndex(recepyIndex));
        } else {
            printAlert();
        }

    }

    public void clearAparatus() {
        System.out.println("Aparatas isvalytas");
        this.usageCounter = 0;
    }

    public void querryProd() {
        System.out.println("Kavos yra:" + this.consumables.getCoffeLeft());
        System.out.println("Vandens yra: " + this.consumables.getWaterLeft());
        System.out.println("Cukraus yra: " + this.consumables.getSugarLeft());
        System.out.println("Pieno yra: " + this.consumables.getMilkLeft());
        System.out.println("Shokolado yra: " + this.consumables.getChocholateLeft());
        System.out.println("Mazu puodeliu yra: " + this.storedCups.getSmallCups());
        System.out.println("Vidutiniu puodeliu yra: " + this.storedCups.getMediumCups());
        System.out.println("Dideliu puodeliu yra: " + this.storedCups.getLargeCups());
        System.out.println("Naudota : " + this.usageCounter);

    }

    public ProductCapacity getProductCapacity() {
        return productCapacity;
    }

    public boolean isReady() {
        if (
                (getCoffeLeft() > 0) &&
                        (getWaterLeft() > 0) &&
                        (getMilkLeft() > 0) &&
                        (getSugarLeft() > 0) &&
                        (getChocolateLeft() > 0) &&
                        (this.storedCups.getSmallCups() > 0) &&
                        (this.storedCups.getMediumCups() > 0) &&
                        (this.storedCups.getLargeCups() > 0)
                ) {
            System.out.println("Aparatas darbui pasiruoses");
            return true;
        }
        return false;

    }

    public void printAlert() {
        if (usageCounter == MAX_USED) {

            System.out.println("Valom aparata");
        }
        if (getSugarLeft() <= 4) {
            System.out.println("Cukraus truksta, reikalinga papildyti");

        }
        if (getWaterLeft() <= 0.1) {
            System.out.println("Vandens nebera papildyk");

        }
        if (getCoffeLeft() <= 4) {
            System.out.println("Papildom kavutes, aparatas tuscias");

        }
        if (getMilkLeft() <= 1) {
            System.out.println("Pieno milteliai baigesi, papildykit");

        }
        if (getChocolateLeft() <= 4) {
            System.out.println("Jau reikia papildyti sokolado milteliu");

            if (storedCups.getSmallCups() == 0 || storedCups.getMediumCups() == 0 || storedCups.getLargeCups() == 0) {
                System.out.println("Truksta puodeliu");
            }
        }
    }

    public void fillAllToMax() {
        this.consumables.setCoffeLeft(getCoffeCapacity());
        this.consumables.setSugarLeft(getSugarCapacity());
        this.consumables.setWaterLeft(getWaterCapacity());
        this.consumables.setMilkLeft(getMilkCapacity());
        this.consumables.setChocholateLeft(getChocolateCapacity());
        fillAllCups();


    }

    public void fillAllCups() {
        this.storedCups.setSmallCups(cupsCapacity.getSmallCups());
        this.storedCups.setMediumCups(cupsCapacity.getMediumCups());
        this.storedCups.setLargeCups(cupsCapacity.getLargeCups());

    }

}




