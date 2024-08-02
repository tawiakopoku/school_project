import java.util.ArrayList;

public class Recipe {
    // Private member variables to store the properties of a recipe
    private String recipeName;
    private int servings;
    private ArrayList<Ingredient> recipeIngredients;
    private double totalRecipeCalories;

    // Constructor to initialize the Recipe object with an empty ingredient list
    public Recipe() {
        this.recipeIngredients = new ArrayList<>();
    }

    // Accessor method to get the recipe name
    public String getRecipeName() {
        return recipeName;
    }

    // Mutator method to set the recipe name
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    // Accessor method to get the number of servings
    public int getServings() {
        return servings;
    }

    // Mutator method to set the number of servings
    public void setServings(int servings) {
        this.servings = servings;
    }

    // Accessor method to get the list of recipe ingredients
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    // Mutator method to set the list of recipe ingredients and recalculate total recipe calories
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
        calculateTotalRecipeCalories(); // Recalculate total recipe calories
    }

    // Accessor method to get the total recipe calories
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

    // Mutator method to set the total recipe calories directly
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }

    // Method to create a new ingredient and add it to the recipe, then recalculate total recipe calories
    public void createNewIngredient(String name, float cups, int caloriesPerCup) {
        Ingredient ingredient = new Ingredient(name, cups, caloriesPerCup);
        this.recipeIngredients.add(ingredient);
        calculateTotalRecipeCalories(); // Recalculate total recipe calories
    }

    // Method to add an existing ingredient to the recipe, then recalculate total recipe calories
    public void addNewIngredient(Ingredient ingredient) {
        this.recipeIngredients.add(ingredient);
        calculateTotalRecipeCalories(); // Recalculate total recipe calories
    }

    // Private method to calculate total recipe calories by summing the calories of all ingredients
    private void calculateTotalRecipeCalories() {
        this.totalRecipeCalories = 0; // Initialize total recipe calories to 0
        for (Ingredient ingredient : recipeIngredients) {
            this.totalRecipeCalories += ingredient.getTotalCalories(); // Add each ingredient's calories to the total
        }
    }

    // Method to print the recipe details, including name, servings, ingredients, and total calories
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
