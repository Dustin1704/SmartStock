package ddb.models;

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
    public int getId(){ return this.id; }
    public void setId(int id){ this.id = id; }

    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }
     
    public int getQuantity(){ return this.quantity; }
    public void setQuantity(int quantity){ this.quantity = quantity; }

    public String getUnit(){ return this.unit; }
    public void setUnit(String unit){ this.unit = unit; }

    public Date getExpiryDate(){ return this.expiryDate; }
    public void setExpiryDate(Date expiryDate){ this.expiryDate = expiryDate; }

    public boolean isItemEssential(){ return this.isEssential; }
    public void setEssential(boolean isEssential){ this.isEssential = isEssential; }

    //---------- ----------//
}
