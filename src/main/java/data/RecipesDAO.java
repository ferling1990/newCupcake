/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonab
 */
public class RecipesDAO {

    private DBConnector con;
    private Recipe recipe;

    public RecipesDAO(){
        try {
            this.con = new DBConnector();
        } catch (Exception ex) {
            Logger.getLogger(RecipesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.recipe = new Recipe();
    }

    public void createRecipe() {
        ResultSet rs = null;

        try {
            Statement stmt = con.getConnection().createStatement();
            String query = "insert into Recipe\n"
                    + "values ('Farmors flotte kager', 'Kom alle ingredienser i en skål og så smid det i ovnen', 'Tommel op', null),\n"
                    + "('Bedstemor med slag i', 'Fuld drøn på røremaskinen og så 400 grader i ovnen 20 min', 'Tommel op', null);";

            stmt.executeUpdate(query);
//            System.out.println(rs);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String displaySingleRecipe(String recipeName) {
        ResultSet rs;

        try {
            Statement stmt = con.getConnection().createStatement();
            String query = "SELECT *"
                    + "FROM `Recipe`"
                    + "WHERE recipeName = '" + recipeName + "';";

            rs = stmt.executeQuery(query);
            if (rs.next()) {
                String res = rs.toString();
                System.out.println(res);
            }
            System.out.println(rs);
            return rs.toString();

        } catch (Exception e) {
            return e.toString();
        }

    }

    public Recipe displaySingleRecipe1() {
        ResultSet rs = null;
        ResultSet rs2 = null;

        try {
            db_GetRecipeData();
            db_GetIngredientsData();
            return recipe;

        } catch (Exception e) {
//            return e.toString();
        }
        return null;
    }

    private void db_GetIngredientsData() throws SQLException {
        ResultSet rs2;
        Statement stmt2 = con.getConnection().createStatement();
        String query2 = "SELECT * FROM IngredientDetails\n"
                + "where recipeName = 'Bedstemor med slag i';";
        rs2 = stmt2.executeQuery(query2);
        int i = 1;
        while (rs2.next()) {
            Ingredient ingredient = new Ingredient(rs2.getString("ingredientName"), rs2.getString("qty"));
            recipe.addIngredient(ingredient);
            i++;
        }
    }

    private void db_GetRecipeData() throws SQLException {
        ResultSet rs;
        Statement stmt = con.getConnection().createStatement();
        String query = "SELECT * FROM cupcakeRecipes.Recipe\n"
                + "where recipeName = 'Farmors flotte kager';";
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            recipe.setRecipeName(rs.getString("recipeName"));
            recipe.setInstructions(rs.getString("instructions"));
            recipe.setRating(rs.getString("rating"));
            recipe.setImgURL(rs.getString("image"));
        }
    }
}
