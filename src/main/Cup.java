package src.main;

/**
 * Created by rkore on 10/14/2017.
 */
public enum Cup {
    SMALL(1,"Small",0.1),
    MEDIUM(2,"Medium",0.2),
    LARGE(3,"Large", 0.3);


    private final int index;
    private final String name;
    private final double size;

    Cup(int index, String name, double size) {
        this.index = index;
        this.name = name;
        this.size = size;
    }

    public int getIndex() {
        return index;
    }




}
