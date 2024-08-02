public class Ingredient {
    private String nameOfIngredient;
    private float numberOfCups;
    private int numberCaloriesPerCup;
    private double totalCalories;

    // Constructor
    public Ingredient(String nameOfIngredient, float numberOfCups, int numberCaloriesPerCup) {
        this.nameOfIngredient = nameOfIngredient;
        this.numberOfCups = numberOfCups;
        this.numberCaloriesPerCup = numberCaloriesPerCup;
        this.totalCalories = calculateTotalCalories();
    }

    // Accessor methods
    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    public float getNumberOfCups() {
        return numberOfCups;
    }

    public int getNumberCaloriesPerCup() {
        return numberCaloriesPerCup;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    // Mutator methods
    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }

    public void setNumberOfCups(float numberOfCups) {
        this.numberOfCups = numberOfCups;
        this.totalCalories = calculateTotalCalories(); // Recalculate total calories
    }

    public void setNumberCaloriesPerCup(int numberCaloriesPerCup) {
        this.numberCaloriesPerCup = numberCaloriesPerCup;
        this.totalCalories = calculateTotalCalories(); // Recalculate total calories
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    // Calculate total calories based on number of cups and calories per cup
    private double calculateTotalCalories() {
        return this.numberOfCups * this.numberCaloriesPerCup;
    }

    @Override
    public String toString() {
        return nameOfIngredient + ": " + numberOfCups + " cups, " + totalCalories + " calories";
    }
}
