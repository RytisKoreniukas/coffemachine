package src.main;

/**
 * Created by rkore on 10/15/2017.
 */
public class StoredCups {
    private int smallCups;
    private int mediumCups;
    private int largeCups;


    public StoredCups(int smallCups, int mediumCups, int largeCups) {
        this.smallCups = smallCups;
        this.mediumCups = mediumCups;
        this.largeCups = largeCups;
    }

    public void setSmallCups(int smallCups) {
        this.smallCups = smallCups;
    }

    public void setMediumCups(int mediumCups) {
        this.mediumCups = mediumCups;
    }

    public void setLargeCups(int largeCups) {
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
