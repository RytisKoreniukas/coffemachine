package src.main;

/**
 * Created by rkore on 10/13/2017.
 */
public enum Recepys {

        EKSPRESSO(1,"Espresso", 2, 0, 0.1,0,0,1),
        JUODA_AMERIKIETISKA(2,"Juoda Amerikietiska",2,2,0.2,0,0,3),
        VANDUO_SU_CUKRUMI(3,"Vanduo su Cukrumi",0,2,0.2,0,0,2),
        CAPPUCINO(4,"Capucino",2,3,0.2,2,2,3),
        DEFOLTINE_JUODA(5,"Juoda", 2,2,0.2,0,0,2);


        private final int index;
        private final String name;
        private final double water;
        private final int milk;
        private final int coffe;
        private final int sugar;
        private final int chocolate;
        private final int requiredCupType;


        Recepys (int index, String rusis, int coffe, int sugar, double water, int milk, int chocolate, int cupType) {
            this.index = index;
            this.name = rusis;
            this.sugar = sugar;
            this.milk = milk;
            this.water = water;
            this.chocolate = chocolate;
            this.coffe = coffe;
            this.requiredCupType = cupType;
        }

    public String getPavadinimas() {
        return name;
    }

    public double getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffe() {
        return coffe;
    }

    public int getSugar() {
        return sugar;
    }

    public int getChocolate() {
        return chocolate;
    }

    public int getRequiredCupType() {
        return requiredCupType;
    }

    public static Recepys getRecepyByIndex(int index) {
            for(Recepys type : Recepys.values()) {
                if(type.index == index) {
                    return type;
                }
            }
        System.out.println("Netiksliai ivedete pavadinima, todel paruosime paprasta juoda kava");
            return Recepys.DEFOLTINE_JUODA;
        }
}
