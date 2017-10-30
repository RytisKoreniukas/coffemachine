package src.main;

/**
 * Created by rkore on 10/12/2017.
 */
public interface CoffeMaker {

    public boolean fillWater(double water);

    public boolean fillSugar(int sugar);

    public boolean fillCoffe(int coffe);

    public boolean isReady();

    public void printAlert ();

    public void fillAllToMax ();
}
