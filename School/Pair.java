package School;

public class Pair { /** class declaration */
    private int xCoordinate; /** instance variables */
    private int yCoordinate;
    String value = "Hello World";

    /**
     * Pair constructor
     *
     * @param x The x-coordinate
     * @param y The y-coordinate
     */
    public Pair(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    /** This method returns the xCoordinate*/
    public int getxCoordinate() {
        return xCoordinate;
    }

    /** This method changes the value of xCoordinate*/
    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
