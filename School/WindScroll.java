package School;

/**
 This class represents a magical scroll filled with a
 wind/air elemental spell

 ICS4UO Ms Krasteva
 @author Kayla Lin
 */

public class WindScroll extends BlankMagicalScroll{
    private double windSpeed; //in m/s
    private int windTemp;
    private double windLastsFor; //in days
    private String[] windComposition;
    private String windDirection;
    private boolean windSpin;


    public WindScroll(){
        windSpeed = 0.5;
        windTemp = 15;
        windLastsFor = 1;
        windComposition = setToNormalWindComp();
        windDirection = "none";
        windSpin = false;
    }

    public WindScroll(double speed, int temp, double daysLastsFor, String direction, boolean spin){
        windSpeed = speed;
        windTemp = temp;
        windLastsFor = daysLastsFor;
        windComposition = new String[10];
        windDirection = direction;
        windSpin = spin;
    }

    public double getWindSpeed(){
        return windSpeed;
    }

    public void setWindSpeed(double wSpeed){
        windSpeed = wSpeed;
    }

    public int getWindTemp(){
        return windTemp;
    }

    public void setWindTemp(int wTemp){
        windTemp = wTemp;
    }
    public double getWindLastsFor(){
        return windLastsFor;
    }

    public void setWindLastsFor(double wLastsFor){
        windLastsFor = wLastsFor;
    }

    public boolean addGas(String gas){
        boolean success = false;
        for(int i = 0; i < windComposition.length; i++) {
            if(windComposition[i].equals("")){
                windComposition[i] = gas;
                success = true;
            }
        }
        return success;
    }

    public String getWindDirection(){
        return windDirection;
    }

    public void setWindDirection(String direction){
        windDirection = direction;
    }

    public boolean getWindSpin(){
        return windSpin;
    }

    public void setWindSpin(boolean spin){
        windSpin = spin;
    }

    public String[] setToNormalWindComp(){
        String[] elements = {"Nitrogen", "Oxygen", "Argon", "Neon", "Hydrogen", "Helium", "", "", "", ""};
        return elements;
    }

    public void setToHurricane(){
        windSpeed = 33;
        windLastsFor = 14;
    }

    public void setToTornado(){
        windSpeed = 40;
        windLastsFor = 0.5;
        windSpin = true;
    }
}