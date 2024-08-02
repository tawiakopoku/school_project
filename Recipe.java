import java.util.ArrayList;

public class Recipe {
    private String recipeName;
    private int servings;
    private ArrayList<Ingredient> recipeIngredients;
    private double totalRecipeCalories;

    public Recipe() {
        this.recipeIngredients = new ArrayList<>();
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
        calculateTotalRecipeCalories();
    }

    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }

    public void createNewIngredient(String name, float cups, int caloriesPerCup) {
        Ingredient ingredient = new Ingredient(name, cups, caloriesPerCup);
        this.recipeIngredients.add(ingredient);
        calculateTotalRecipeCalories();
    }

    public void addNewIngredient(Ingredient ingredient) {
        this.recipeIngredients.add(ingredient);
        calculateTotalRecipeCalories();
    }

    private void calculateTotalRecipeCalories() {
        this.totalRecipeCalories = 0;
        for (Ingredient ingredient : recipeIngredients) {
            this.totalRecipeCalories += ingredient.getTotalCalories();
        }
    }

    public void printRecipe() {
        System.out.println("Recipe Name: " + recipeName);
        System.out.println("Servings: " + servings);
        System.out.println("Ingredients:");
        for (Ingredient ingredient : recipeIngredients) {
            System.out.println("- " + ingredient);
        }
        System.out.println("Total Recipe Calories: " + totalRecipeCalories);
    }
}
