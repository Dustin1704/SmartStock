package ddb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int recipeId = generatedKeys.getInt(1);
            for (Ingredient ingredient : recipe.getIngredients()) {
                addIngredientToRecipe(recipeId, ingredient);
            }
        }
    }

    //---------- READ OPERATIONS ----------//


    //---------- UPDATE OPERATIONS ----------//


    //---------- DELETE OPERATIONS ----------//


}
