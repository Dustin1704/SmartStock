package ddb.models;

import java.util.List;

public class ShoppingList {

    //---------- PROPERTIES ----------//
    private int id;
    private List<Item> items;

    //---------- CONSTRUCTORS ----------//
    /**
     * Empty ShoppingList Constructor
     */
    public ShoppingList(){}

    /**
     * ShoppingList Constructor
     */
    public ShoppingList(int id, List<Item> items){
        this.id = id;
        this.items = items;
    }

    //---------- GETTERS/SETTERS ----------//
    public int getId(){ return this.id; }
    public void setId(int id){ this.id = id; }

    public List<Item> getItems(){ return this.items; }
    public void setItems(List<Item> items){ this.items = items; }



}
