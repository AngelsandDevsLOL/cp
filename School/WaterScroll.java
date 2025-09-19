package School;

/**
 This class represents a magical scroll filled with a
 water elemental spell

 ICS4UO Ms Krasteva
 @author Kayla Lin
 */

public class WaterScroll extends BlankMagicalScroll{

    private int waterAmt;
    private double waterSpeed;
    private String waterState;
    private int waterPressure;

    public WaterScroll(){
        waterAmt = 0;
        waterSpeed = 0;
        waterState = "liquid";
        waterPressure = 0;
    }

    public WaterScroll(int wAmt, int wSpeed, String wState, int wPressure){
        waterAmt= wAmt;
        waterSpeed = wSpeed;
        waterState = wState;
        waterPressure = wPressure;
    }

    public int getWaterAmt() {
        return waterAmt;
    }

    public void setWaterAmt(int wAmt) {
        waterAmt = wAmt;
    }

    public double getWaterSpeed(){
        return waterSpeed;
    }

    public void setWaterSpeed(int wSpeed){
        waterSpeed = wSpeed;
    }

    public String getWaterState(){
        return waterState;
    }

    public void setWaterState(String wState){
        waterState = wState;
    }

    public int getWaterPressure(){
        return waterPressure;
    }

    public void setWaterPressure(int wPressure){
        waterPressure = wPressure;
    }

    public void setToTsunami(){
        waterAmt = 2000;
        waterSpeed = 30000;
        waterState = "liquid";
        waterPressure = 180;
    }

    public void setToFlood(){
        waterAmt = 1000;
        waterSpeed = 3;
        waterState = "liquid";
        waterPressure = 30;
    }

    public void setToHail(){
        waterAmt = 500;
        waterSpeed = 9.8;
        waterState = "solid";
        waterPressure = 0;
    }
}