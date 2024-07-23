package ddb.models;

import java.util.List;

public class Recipe {
//---------- PROPERTIES ----------//
    private int id;
    private String name;
    private List<Ingredient> ingredients;
    private int servings;

    //---------- CONSTRUCTORS ----------//
    /**
     * Empty Recipe Constructor
     */
    public Recipe(){}

    /**
     * Recipe Constructor
     * 
     * @param id - Recipe Id
     * @param name - Recipe Name
     * @param ingredients - List of Ingredients
     * @param servings - Number of Servings 
     */
    public Recipe(int id, String name, List<Ingredient> ingredients, int servings){
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.servings = servings;
    }

    //---------- GETTERS/SETTERSS ----------//
    public int getId(){ return this.id; }
    public void setId(int id){ this.id = id; }

    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }

    public List<Ingredient> getIngredients(){ return this.ingredients; }
    public void setIngredients(List<Ingredient> ingredient){ this.ingredients = ingredients; }

    public int getServings(){ return this.servings; }
    public void setServings(int servings){ this.servings = servings; }
}
