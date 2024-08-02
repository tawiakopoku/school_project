// Importing necessary Java utility classes
import java.util.ArrayList;
import java.util.Scanner;

// Defining the RecipeBox class
public class RecipeBox {
    // List to hold all recipes
    private ArrayList<Recipe> listOfRecipes;

    // Default constructor to initialize list and add default recipes
    public RecipeBox() {
        this.listOfRecipes = new ArrayList<>();
        addDefaultRecipes();
    }

    // Constructor with an existing list of recipes
    public RecipeBox(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
        addDefaultRecipes();
    }

    // Method to add default recipes to the list
    private void addDefaultRecipes() {
        // Creating and adding Pancake recipe
        Recipe recipe1 = new Recipe();
        recipe1.setRecipeName("Pancake");
        recipe1.setServings(4);
        recipe1.createNewIngredient("Flour", 4, 200);
        recipe1.createNewIngredient("Milk", 3, 180);
        recipe1.createNewIngredient("Eggs", 4, 170);
        recipe1.createNewIngredient("Vanilla", 1, 100);
        listOfRecipes.add(recipe1);

        // Creating and adding Vegi Omelette recipe
        Recipe recipe2 = new Recipe();
        recipe2.setRecipeName("Vegi Omelette");
        recipe2.setServings(3);
        recipe2.createNewIngredient("Eggs", 4, 170);
        recipe2.createNewIngredient("Cheese", 2, 200);
        recipe2.createNewIngredient("Vegi", 2, 200);
        listOfRecipes.add(recipe2);

        // Creating and adding French Toast recipe
        Recipe recipe3 = new Recipe();
        recipe3.setRecipeName("French Toast");
        recipe3.setServings(3);
        recipe3.createNewIngredient("Eggs", 3, 120);
        recipe3.createNewIngredient("Cheese", 2, 150);
        recipe3.createNewIngredient("Milk", 2, 180);
        listOfRecipes.add(recipe3);
    }

    // Getter for list of recipes
    public ArrayList<Recipe> getListOfRecipes() {
        return listOfRecipes;
    }

    // Setter for list of recipes
    public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

    // Method to print details of all recipes
    public void printAllRecipeDetails() {
        for (Recipe recipe : listOfRecipes) {
            recipe.printRecipe();
            System.out.println();
        }
    }

    // Method to print names of all recipes
    public void printAllRecipeNames() {
        for (int i = 0; i < listOfRecipes.size(); i++) {
            System.out.println((i + 1) + ". " + listOfRecipes.get(i).getRecipeName());
        }
    }

    // Method to create a new recipe
    public Recipe createNewRecipe(String name, int servings) {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(name);
        recipe.setServings(servings);
        this.listOfRecipes.add(recipe);
        return recipe;
    }

    // Method to add a new recipe to the list
    public void addNewRecipe(Recipe recipe) {
        this.listOfRecipes.add(recipe);
    }

    // Method to remove a recipe by index
    public void removeRecipe(int index) {
        if (index >= 0 && index < listOfRecipes.size()) {
            listOfRecipes.remove(index);
        } else {
            System.out.println("Invalid index. Cannot remove recipe.");
        }
    }

    // Method to edit an existing recipe by index
    public void editRecipe(int index) {
        if (index >= 0 && index < listOfRecipes.size()) {
            Scanner scanner = new Scanner(System.in);
            Recipe recipe = listOfRecipes.get(index);
            System.out.println("Editing recipe " + recipe.getRecipeName());

            // Editing recipe name
            System.out.print("Enter new recipe name (or press enter to keep the current name): ");
            String newName = scanner.nextLine();
            if (!newName.trim().isEmpty()) {
                recipe.setRecipeName(newName);
            }

            // Editing number of servings
            System.out.print("Enter new number of servings (or 0 to keep the current number): ");
            int newServings = scanner.nextInt();
            if (newServings > 0) {
                recipe.setServings(newServings);
            }
            scanner.nextLine();  // Consume newline left-over

            // Editing ingredients
            boolean editing = true;
            while (editing) {
                System.out.println("Options:");
                System.out.println("1. Modify existing ingredient");
                System.out.println("2. Add new ingredient");
                System.out.println("3. Finish editing");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch (choice) {
                    case 1:
                        // Modify existing ingredient
                        System.out.println("Existing ingredients:");
                        for (int i = 0; i < recipe.getRecipeIngredients().size(); i++) {
                            System.out.println((i + 1) + ". " + recipe.getRecipeIngredients().get(i));
                        }
                        System.out.print("Select an ingredient to modify (or 0 to cancel): ");
                        int ingredientIndex = scanner.nextInt();
                        scanner.nextLine();  // Consume newline left-over
                        if (ingredientIndex > 0 && ingredientIndex <= recipe.getRecipeIngredients().size()) {
                            Ingredient ingredient = recipe.getRecipeIngredients().get(ingredientIndex - 1);
                            System.out.print("Enter new ingredient name (or press enter to keep the current name): ");
                            String newIngredientName = scanner.nextLine();
                            if (!newIngredientName.trim().isEmpty()) {
                                ingredient.setNameOfIngredient(newIngredientName);
                            }
                            System.out.print("Enter new number of cups (or -1 to keep the current number): ");
                            float newCups = scanner.nextFloat();
                            if (newCups >= 0) {
                                ingredient.setNumberOfCups(newCups);
                            }
                            System.out.print("Enter new calories per cup (or -1 to keep the current number): ");
                            int newCalories = scanner.nextInt();
                            if (newCalories >= 0) {
                                ingredient.setNumberCaloriesPerCup(newCalories);
                            }
                            scanner.nextLine();  // Consume newline left-over
                        } else {
                            System.out.println("Invalid selection.");
                        }
                        break;

                    case 2:
                        // Add new ingredient
                        System.out.print("Enter ingredient name: ");
                        String ingredientName = scanner.nextLine();
                        System.out.print("Enter number of cups: ");
                        float cups = scanner.nextFloat();
                        System.out.print("Enter calories per cup: ");
                        int caloriesPerCup = scanner.nextInt();
                        scanner.nextLine();  // Consume newline left-over
                        recipe.createNewIngredient(ingredientName, cups, caloriesPerCup);
                        break;

                    case 3:
                        // Finish editing
                        editing = false;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Invalid index. Cannot edit recipe.");
        }
    }

    // Main method to run the RecipeBox application
    public static void main(String[] args) {
        RecipeBox recipeBox = new RecipeBox();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main menu loop
        while (running) {
            System.out.println("\nRecipe Box Menu:");
            System.out.println("1. Add a new recipe");
            System.out.println("2. List all recipes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    // Add a new recipe
                    addNewRecipe(recipeBox, scanner);
                    break;

                case 2:
                    // List all recipes
                    listAllRecipes(recipeBox, scanner);
                    break;

                case 3:
                    // Exit the application
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Method to handle adding a new recipe through user input
    private static void addNewRecipe(RecipeBox recipeBox, Scanner scanner) {
        System.out.println("\nAdding a new recipe:");
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();
        System.out.print("Enter number of servings: ");
        int servings = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        Recipe newRecipe = recipeBox.createNewRecipe(name, servings);

        boolean addingIngredients = true;
        while (addingIngredients) {
            System.out.println("\nAdd an ingredient:");
            System.out.print("Enter ingredient name: ");
            String ingredientName = scanner.nextLine();
            System.out.print("Enter number of cups: ");
            float cups = scanner.nextFloat();
            System.out.print("Enter calories per cup: ");
            int caloriesPerCup = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            newRecipe.createNewIngredient(ingredientName, cups, caloriesPerCup);

            System.out.print("Do you want to add another ingredient? (yes/no): ");
            String answer = scanner.nextLine();
            addingIngredients = answer.equalsIgnoreCase("yes");
        }

        System.out.println("Recipe added successfully!");
    }

    // Method to handle listing all recipes and performing actions on them
    private static void listAllRecipes(RecipeBox recipeBox, Scanner scanner) {
        while (true) {
            System.out.println("\nAll Recipes:");
            recipeBox.printAllRecipeNames();
            System.out.print("\nSelect a recipe (or 0 to go back): ");
            int recipeChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            if (recipeChoice == 0) {
                break;
            }

            if (recipeChoice > 0 && recipeChoice <= recipeBox.getListOfRecipes().size()) {
                Recipe selectedRecipe = recipeBox.getListOfRecipes().get(recipeChoice - 1);

                boolean viewingRecipe = true;
                while (viewingRecipe) {
                    System.out.println("\nOptions for " + selectedRecipe.getRecipeName() + ":");
                    System.out.println("1. View recipe details");
                    System.out.println("2. Edit recipe");
                    System.out.println("3. Delete recipe");
                    System.out.print("Choose an option: ");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over

                    switch (subChoice) {
                        case 1:
                            // View recipe details
                            selectedRecipe.printRecipe();
                            break;
                        case 2:
                            // Edit recipe
                            recipeBox.editRecipe(recipeChoice - 1);
                            break;
                        case 3:
                            // Delete recipe
                            recipeBox.removeRecipe(recipeChoice - 1);
                            System.out.println("Recipe deleted successfully.");
                            viewingRecipe = false;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            } else {
                System.out.println("Invalid recipe number.");
            }
        }
    }
}
