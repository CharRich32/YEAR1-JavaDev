package ica;

import javax.swing.ImageIcon;  //  the import that has been used

/**
 *
 * @author b1044146 - Charlie Richardson
 */

public abstract class FurnitureItem  //  the class is set as abstract as it has implementations 
{
    protected enum woodTypes{OAK, WALNUT}  //  sets variables 
    protected woodTypes woodType;  
    protected int itemPrice;  
    protected int unitPrice;
    protected int quantity;
    protected static final int OAK_PRICE = 4;
    protected static final int WALNUT_PRICE = 3;
    protected ImageIcon image;

    public final int getItemPrice()
    {
        return itemPrice;  //  gets the item price 
    }

    public final int getQuantity()
    {
        return quantity;  //  gets the quantity 
    }

    public final void setQuantity(int quantity)
    {
        this.quantity = quantity;  //  then sets the quantity
    }

    public final ImageIcon getImage()
    {
        return image;  //  gets the image
    }

    public final void setImage(ImageIcon image)
    {
        this.image = image;  //  then sets the image 
    }

    public final int getWoodType()
    {
        switch (woodType)
        {
            case OAK:  //  gets the wood type 
                return 0;
            case WALNUT: 
                return 1;
            default:
                return 999;
        }
    }

    public final void setWoodType(int woodType)
    {
        switch (woodType)  //  switch for the type of wood the user selects 
        {
            case 0:
                this.woodType = woodTypes.OAK;
                unitPrice = OAK_PRICE;
                break;
            case 1:
                this.woodType = woodTypes.WALNUT;
                unitPrice = WALNUT_PRICE;
                break;
            default:
                break;
        }
    }

    protected abstract void calculatePrice();
    protected abstract String getImageString();  //  to get image chosen
}
    

