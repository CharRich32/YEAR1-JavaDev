package ica;

/**
 *
 * @author b1044146 - Charlie Richardson
 */

public class Table extends FurnitureItem {  //  inherits from FurnitureItem
    @Override
    protected String getImageString(){   
        String path = "";  //  sets the path for when the user selects table
        path += (getWoodType() == 0) ? "Oak" : "Walnut";  
        path += " --- Table --- ";
        path += (baseType == baseTypes.WOOD) ? " Wooden" : " Chrome";
        path += " Base";
        return path;
    }
    enum baseTypes{WOOD, CHROME}
    private int diameter;
    private baseTypes baseType;  //  sets variables 
    private static final double WOOD_PRICE = 45.00;  //  these do not change
    private static final double CHROME_PRICE = 35.00;
        
    public Table(int diameter, int woodType, double baseType)  //  set as they are needed to calculate the table 
    {
        this.diameter = diameter;
        setWoodType(woodType);
        setBaseType((int) baseType);
        calculatePrice();
    }
    public Table()
    {
        diameter = 100;  //  sets diameter then calculates based off users path
        calculatePrice();
    } 

    public int getDiameter()
    {
        return diameter;  //  gets the diameter 
    }

    public void setDiameter(int diameter)
    {
        this.diameter = diameter;  //  sets the diameter 
    }
    
    public int getBaseType()
    {
        switch (baseType)
        {
            case WOOD:
                return 0;
            case CHROME:
                return 1;
            default:
                return 777;  //  if 1 or 0 is not pressed
        }
    }

    public final void setBaseType(int baseType)
    {
        switch (baseType)
        {
            case 0:
                this.baseType = baseTypes.WOOD;
                break;
            case 1:
                this.baseType = baseTypes.CHROME;  
                break;
            default:
                break;  //  breaks if 0 or 1 not pressed 
        }
    }
    
    @Override
    protected final void calculatePrice()  //  calculates the over cost of the table
    {
        itemPrice = (diameter * diameter);
        itemPrice *= unitPrice;
        
        switch(baseType)
        {
            case WOOD:
                itemPrice += WOOD_PRICE;
                break;
            case CHROME:
                itemPrice += CHROME_PRICE;  
                break;  //  breaks after each calculation has been done
        }
    }
}
