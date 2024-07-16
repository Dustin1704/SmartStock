package ddb.models;

public class Ingredient {


    //----------- PROPERTIES ----------//
    private int id;
    private int itemId;
    private int quantity;
    private String unit;

    //---------- CONSTRUCTORS -----------//
    /**
     * Empty Ingredient Constructor
     */
    public Ingredient(){}

    /**
     * Ingredient Constructor
     * @param id - Ingredient Id
     * @param itemId - Item Id
     * @param quantity - Quantity Of Item
     * @param unit - Units of Quantity
     */
    public Ingredient(int id, int itemId, int quantity, String unit){
        this.id = id;
        this. itemId = itemId;
        this.quantity = quantity;
        this.unit = unit;
    }

    //---------- GETTERSS/SETTERS ----------//
    public int getId(){ return this.id; }
    public void setId(int id){ this.id = id; }

    public int getItemId(){ return this.itemId; }
    public void setItemId(int itemId){ this.itemId = itemId; }

    public int getQuantity(){ return this.quantity; }
    public void setQuantity(int quantity){ this.quantity = quantity; }

    public String getUnit(){ return this.unit; }
    public void setUnit(String unit){ this.unit = unit; }
}
