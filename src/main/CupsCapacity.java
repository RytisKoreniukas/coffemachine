package src.main;

/**
 * Created by rkore on 10/14/2017.
 */
public class CupsCapacity {
    private final int smallCups;
    private final int mediumCups;
    private final int largeCups;

    public CupsCapacity(int smallCups, int mediumCups, int largeCups) {
        this.smallCups = smallCups;
        this.mediumCups = mediumCups;
        this.largeCups = largeCups;
    }

    public int getSmallCups() {
        return smallCups;
    }

    public int getMediumCups() {
        return mediumCups;
    }

    public int getLargeCups() {
        return largeCups;
    }


}
