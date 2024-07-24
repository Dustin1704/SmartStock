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
     * Get all recipes
     * @return List of all recipes
     * @throws SQLException
     */
    public List<Recipe> getAllRecipes() throws SQLException{
        String query = "SELECT * FROM recipes";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create an arraylist of each recipe
        List<Recipe> recipes = new ArrayList<>();
        if(resultSet.next()){
            Recipe recipe = new Recipe();
            recipe.setId(resultSet.getInt("id"));
            recipe.setName(resultSet.getString("name"));
            recipe.setServings(resultSet.getInt("servings"));
            recipe.setIngredients(getIngredientsByRecipeId(recipe.getId()));
            recipes.add(recipe);
        }
        return recipes;
    }

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
            ingredient.setRecipeId(resultSet.getInt("recipe_id"));
            ingredient.setItemId(resultSet.getInt("item_id"));
            ingredient.setQuantity(resultSet.getInt("quanitity"));
            ingredient.setUnit(resultSet.getString("unit"));
            ingredients.add(ingredient);
        }
        return ingredients;
    }

    /**
     * Get an ingredient from its Id
     * @param ingredientId - Id of the ingredient
     * @return The ingredient
     * @throws SQLEXception
     */
    public Ingredient getIngredientById(int ingredientId) throws SQLException{
        String query = "SELECT * FROM ingredients WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, ingredientId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            Ingredient ingredient = new Ingredient();
            ingredient.setId(resultSet.getInt("id"));
            ingredient.setRecipeId(resultSet.getInt("recipe_id"));
            ingredient.setItemId(resultSet.getInt("item_id"));
            ingredient.setQuantity(resultSet.getInt("quanitity"));
            ingredient.setUnit(resultSet.getString("unit"));
            return ingredient;
        }
        return null;
    }

    //---------- UPDATE OPERATIONS ----------//

    /**
     * Update a recipe with its current properties
     * @param recipe - the recipe to update
     * @throws SQLException
     */
    public void updateRecipe(Recipe recipe) throws SQLException{
        String query = "UPDATE recipes SET name=?, servings=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, recipe.getName());
        preparedStatement.setInt(2, recipe.getServings());
        preparedStatement.setInt(3, recipe.getId());
        preparedStatement.executeUpdate();

        // Delete all ingredients belonging to the Recipe
        deleteIngredientsFromRecipeId(recipe.getId());
        // Re-add all the ingredients
        for (Ingredient ingredient : recipe.getIngredients()) {
            addIngredientToRecipe(recipe.getId(), ingredient);
        }
    }

    //---------- DELETE OPERATIONS ----------//
    /**
     * Delete a recipe from it's Id
     * @param recipeId - The recipe Id
     * @throws SQLException
     */
    public void deleteRecipeFromId(int recipeId) throws SQLException{
        String query = "DELETE FROM recipes WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, recipeId);
        preparedStatement.executeUpdate();
    }

    /**
     * Delete all ingredients from a recipeId
     * @param recipeId - The Recipe id which ingredients belong to
     * @throws SQLException
     */
    public void deleteIngredientsFromRecipeId(int recipeId) throws SQLException{
        String query = "DELETE FROM ingredients WHERE recipe_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, recipeId);
        preparedStatement.executeUpdate();
    }

}
