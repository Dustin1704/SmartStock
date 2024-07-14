package ddb.models;

import java.util.List;

public class Recipie {
//---------- PROPERTIES ----------//
    private int id;
    private String name;
    private List<Ingredient> ingredients;
    private int servings;

    //---------- CONSTRUCTORS ----------//
    /**
     * Empty Recipe Constructor
     */
    public Recipie(){}

    /**
     * Recipe Constructor
     * 
     * @param id - Recipe Id
     * @param name - Recipe Name
     * @param ingredients - List of Ingredients
     * @param servings - Number of Servings 
     */
    public Recipie(int id, String name, List<Ingredient> ingredients, int servings){
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.servings = servings;
    }

    //---------- GETTERS/SETTERSS ----------//
    /**
     * Get the Recipie Id
     * @return recipie id
     */
    public int getId(){ return this.id; }

    /**
     * Set the Recipie Id
     * @param id - id of the recipie
     */
    public void setId(int id){ this.id = id; }

    /**
     * Get the Recipie Name
     * @return recipie name
     */
    public String getName(){ return this.name; }

    /**
     * Set the Recipie Name
     * @param name - name of the recipie
     */
    public void setName(String name){ this.name = name; }

    /**
     * Get the Recipie Ingredients
     * @return list of ingredients
     */
    public List<Ingredient> getIngredients(){ return this.ingredients; }

    /**
     * Set the Recipie Ingredients
     * @param ingredients - list of ingredients
     */
    public void setIngredients(List<Ingredient> ingredient){ this.ingredients = ingredients; }

    /**
     * Get the number of Recipe Servings
     * @return recipie servings
     */
    public int getServings(){ return this.servings; }

    /**
     * Set the number of Recipie Servings
     * @param servings - number of recipe servings
     */
    public void setServings(int servings){ this.servings = servings; }
}
