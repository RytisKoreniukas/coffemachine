package src.main;

/**
 * Created by rkore on 10/12/2017.
 */
public interface Maintainer {

    CoffeMachine createDefaultCoffemachine();

    CoffeMachine createSpepcialCoffemachine(String name, int sugar, double water, int coffe, int milk, int chocolate, int smCups, int medCups, int largeCups);

    void cleanCoffeMachine(CoffeMachine coffemachine);
}