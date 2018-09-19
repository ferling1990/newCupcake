package data;

import java.util.ArrayList;

public class Recipe {
    private ArrayList<Ingredient> ingredients;
    private String instructions;
    private String imgURL;
    private String recipeName;
    private String rating;

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRating() {
        return rating;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }


    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    
    
    public Recipe() {
        ingredients = new ArrayList();
    }

    public Recipe(String instructions, String imgURL) {
        this.instructions = instructions;
        this.imgURL = imgURL;    
        ingredients = new ArrayList<>();
    }
    
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }
    
}
