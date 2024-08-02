public class Ingredient {
    // Private member variables to store the properties of an ingredient
    private String nameOfIngredient;
    private float numberOfCups;
    private int numberCaloriesPerCup;
    private double totalCalories;

    // Constructor to initialize the Ingredient object
    public Ingredient(String nameOfIngredient, float numberOfCups, int numberCaloriesPerCup) {
        this.nameOfIngredient = nameOfIngredient;
        this.numberOfCups = numberOfCups;
        this.numberCaloriesPerCup = numberCaloriesPerCup;
        this.totalCalories = calculateTotalCalories(); // Calculate total calories upon initialization
    }

    // Accessor method to get the name of the ingredient
    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    // Accessor method to get the number of cups
    public float getNumberOfCups() {
        return numberOfCups;
    }

    // Accessor method to get the number of calories per cup
    public int getNumberCaloriesPerCup() {
        return numberCaloriesPerCup;
    }

    // Accessor method to get the total calories
    public double getTotalCalories() {
        return totalCalories;
    }

    // Mutator method to set the name of the ingredient
    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }

    // Mutator method to set the number of cups and recalculate total calories
    public void setNumberOfCups(float numberOfCups) {
        this.numberOfCups = numberOfCups;
        this.totalCalories = calculateTotalCalories(); // Recalculate total calories
    }

    // Mutator method to set the number of calories per cup and recalculate total calories
    public void setNumberCaloriesPerCup(int numberCaloriesPerCup) {
        this.numberCaloriesPerCup = numberCaloriesPerCup;
        this.totalCalories = calculateTotalCalories(); // Recalculate total calories
    }

    // Mutator method to set the total calories directly
    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    // Private method to calculate total calories based on number of cups and calories per cup
    private double calculateTotalCalories() {
        return this.numberOfCups * this.numberCaloriesPerCup;
    }

    // Override the toString method to provide a string representation of the Ingredient object
    @Override
    public String toString() {
        return nameOfIngredient + ": " + numberOfCups + " cups, " + totalCalories + " calories";
    }
}
