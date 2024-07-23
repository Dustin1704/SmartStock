package ddb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ddb.models.Ingredient;
import ddb.models.Recipe;
import ddb.util.DBConnection;

public class RecipeDAO {

    //---------- PROPERTIES ----------//
    private Connection connection;

    //---------- CONSTRUCTORS ----------//
    /**
     * RecipeDAO Constructor
     */
    public RecipeDAO(){
        this.connection = DBConnection.getConnection();
    }

    //---------- CREATE OPERATIONS ----------//
    /**
     * Add a Recipe to the Database
     * @param recipe - The recipe to add
     * @throws SQLException
     */
    public void addRecipe(Recipe recipe) throws SQLException{
        String query = "INSERT INTO recipes (name, servings) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, recipe.getName());
        preparedStatement.setInt(2, recipe.getServings());
        preparedStatement.executeUpdate();

        // Add each ingredient in the recipe to the DB
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int recipeId = generatedKeys.getInt(1);
            for (Ingredient ingredient : recipe.getIngredients()) {
                addIngredientToRecipe(recipeId, ingredient);
            }
        }
    }

    /**
     * Add an ingredient to a recipe
     * @param recipieId - The id for the recipe 
     * @param ingredient - The Ingredient to add
     */
    public void addIngredientToRecipe(int recipeId, Ingredient ingredient) throws SQLException{
        String query = "INSERT INTO recipe_ingredients (recipie_id, item_id, quantity, unit) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, recipeId);
        preparedStatement.setInt(2, ingredient.getItemId());
        preparedStatement.setInt(3, ingredient.getQuantity());
        preparedStatement.setString(4, ingredient.getUnit());
        preparedStatement.executeUpdate();
    }

    //---------- READ OPERATIONS ----------//
    /**
     * Get a Recipe from its ID
     * @param recipeId - Id of the recipe
     * @return The Recipe
     * @throws SQLException
     */
    public Recipe getRecipeById(int recipeId) throws SQLException{
        String query = "SELECT * FROM recipes WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, recipeId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            Recipe recipe = new Recipe();
            recipe.setId(resultSet.getInt("id"));
            recipe.setName(resultSet.getString("name"));
            recipe.setServings(resultSet.getInt("servings"));
            recipe.setIngredients(getIngredientsByRecipeId(recipeId));
            return recipe;
        }
        return null;
    }

    /**
     * Get a list of ingredients from a recipeId
     * @param recipeId - Id of the recipe
     * @return The list of ingredients
     * @throws SQLException
     */
    public List<Ingredient> getIngredientsByRecipeId(int recipeId) throws SQLException{
        String query = "SELECT * FROM ingredients WHERE recipe_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, recipeId);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create list of all ingredients
        List<Ingredient> ingredients = new ArrayList<>();
        if (resultSet.next()){
            Ingredient ingredient = new Ingredient();
            ingredient.setId(resultSet.getInt("id"));
            ingredient.setItemId(resultSet.getInt("item_id"));
            ingredient.setQuantity(resultSet.getInt("quanitity"));
            ingredient.setUnit(resultSet.getString("unit"));
            ingredients.add(ingredient);
        }
        return ingredients;
    }


    //---------- UPDATE OPERATIONS ----------//


    //---------- DELETE OPERATIONS ----------//


}
