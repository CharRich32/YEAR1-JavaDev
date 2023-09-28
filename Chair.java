package ica;

/**
 *
 * @author b1044146 - Charlie Richardson
 */

public class Chair extends FurnitureItem {  //  inherits from FurnitureItem
    private static final int STANDARD_UNITS = 1625;  //  sets these automatically / these will not change
    private static final int ARM_UNITS = 250;
    private boolean hasArms;
    
    public Chair()
    {
        hasArms = false;
        woodType = woodTypes.OAK;  //   sets these 
        quantity = 1;
        calculatePrice();
    }

    public Chair(boolean hasArms, int woodType, int quantity)  //  set as they are needed to calculate the chair
    { 
        this.hasArms = hasArms;      
        setWoodType(woodType);  //   sets these 
        this.quantity = quantity;
        calculatePrice();       
    }

    
    public boolean getHasArms()
    {
        return hasArms;  //  gets if the chair has arms 
    }
    
    public void setHasArms(boolean hasArms)  
    {
        this.hasArms = hasArms;  //  sets if they have arms or not
    } 
    
    @Override
    protected final void calculatePrice()  //  calculates the total cost of the chair
    {
        itemPrice = STANDARD_UNITS;
        itemPrice += (hasArms)?ARM_UNITS:0;          
        itemPrice *= unitPrice;
        itemPrice *= quantity;
    }

    @Override
    protected String getImageString()  //  gets the image of the FurnitureItem 
    {
        String path = "";
        path += (getWoodType() == 0) ? "Oak" : "Walnut";
        path += " --- Chair --- ";
        path += (hasArms) ? "Arms" : "No Arms";
        return path;
    }
}

