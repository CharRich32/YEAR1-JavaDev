package ica;

/**
 *
 * @author b1044146 - Charlie Richardson
 */

public class Desk extends FurnitureItem {   //  inherits from FurnitureItem
    
    private int drawerCount;  //  sets variables
    private static final int HEIGHT = 80; //  this will not change
    private int width;
    private int depth;
    
        public Desk(int drawerCount, int width, int depth, int woodType)  //  set as they are needed to calculate the desk
    {
        this.drawerCount = drawerCount;
        this.width = width;  //   sets these 
        this.depth = depth;
        setWoodType(woodType);
        calculatePrice();
    }
    
    public Desk()
    {
        this.drawerCount = 1;  // sets draw count to 1 automatically 
        this.width = 150;  // sets these automatically 
        this.depth = 80;
        setWoodType(0);
        calculatePrice();
    }

    public int getDrawerCount()
    {
        return drawerCount;  //  gets the amount of draws chosen 
    }
    
    public void setDrawerCount(int drawerCount)
    {
        this.drawerCount = drawerCount;  //  sets the amount of draws chosen 
    }
    
    public int getWidth()
    {
        return width;  //  gets the width of desk 
    }
    
    public void setWidth(int width)  
    {
        this.width = width;  //  sets the width of desk
    }
    
    public int getDepth()
    {
        return depth;  //  gets the depth 
    }
    
    public void setDepth(int depth)
    {
        this.depth = depth;  //  then sets the depth chosen
    }
    
    @Override
    protected final void calculatePrice()  //  calculates the total cost of the desk
    {
        itemPrice = (((HEIGHT + width + depth) * 12) + (depth * width) * unitPrice) + (drawerCount * 850);
    }

    @Override
    protected String getImageString()  //  gets the image of the FurnitureItem
    {
        String path = "";
        path += (getWoodType() == 0) ? "Oak" : "Walnut";
        path += " --- Desk --- ";
        path += drawerCount + " Drawer";
        return path;
    }
}
