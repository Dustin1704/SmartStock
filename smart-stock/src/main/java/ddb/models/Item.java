package ddb.models;

import java.text.spi.DateFormatSymbolsProvider;
import java.util.Date;

public class Item {

    //---------- PROPERTIES ----------//
    private int id;
    private String name;
    private int quantity;
    private String unit;
    private Date expiryDate;
    private boolean isEssential;

    //---------- CONSTRUCTORS ----------//
    /**
     * Empty Constructor Method
     */
    public Item(){}

    /**
     * Constructor Method
     * 
     * @param id - id of the item
     * @param name - name of the item
     * @param quantity - quanity of the item
     * @param unit - unit the item is meaured in
     * @param expiryDate - the date the item expires
     * @param isEssential - whether the item is an essential
     */
    public Item(int id, String name, int quantity, String unit, Date expiryDate, boolean isEssential){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.expiryDate = expiryDate;
        this.isEssential = isEssential;
    }

    //---------- GETTERS/SETTERS ----------//
    /**
     * Get the Item Id
     * @return Id of the item
     */
    public int getId(){ return this.id; }

    /**
     * Set the Item Id
     * @param id - the new Id
     */
    public void setId(int id){ this.id = id; }

    /**
     * Get the Item Id
     * @return Id of the item
     */
    public String getName(){ return this.name; }

    /**
     * Set the Item name
     * @param name - the new name
     */
    public void setName(String name){ this.name = name; }

    /**
     * Get the Item quantity
     * @return quantity of the item
     */
    public int getQuantity(){ return this.quantity; }

    /**
     * Set the Item quantity
     * @param quantity - the new quantity
     */
    public void setQuantity(int quantity){ this.quantity = quantity; }

    /**
     * Get the Item unit
     * @return unit of the item
     */
    public String getUnit(){ return this.unit; }

    /**
     * Set the Item unit
     * @param unit - the new unit
     */
    public void setUnit(String unit){ this.unit = unit; }

    /**
     * Get the Item expiry date
     * @return expiry date of the item
     */
    public Date getExpiryDate(){ return this.expiryDate; }

    /**
     * Set the Item expiry date
     * @param expiryDate - the new expiry date
     */
    public void setExpiryDate(Date expiryDate){ this.expiryDate = expiryDate; }

    /**
     * Is the Item essential
     * @return if item is essential
     */
    public boolean isItemEssential(){ return this.isEssential; }

    /**
     * Set whether the Item is essential
     * @param isEssential - whether the item is essential
     */
    public void setEssential(boolean isEssential){ this.isEssential = isEssential; }

    //---------- ----------//
}
