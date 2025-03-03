public class Feeder {
    /**
     * The amount of food, in grams, currently in the bird feeder; initialized in
     * the constructor and
     * always greater than or equal to zero
     */
    private int currentFood;

    /**
     * Constructor that initializes the feeder with a specific amount of food
     * 
     * @param initialFood the initial amount of food in grams
     */
    public Feeder(int initialFood) {
        this.currentFood = Math.max(0, initialFood); // Ensure non-negative value
    }

    /**
     * Simulates one day with numBirds birds or possibly a bear at the bird feeder.
     * Normal conditions (95% chance): Each bird eats between 10-50 grams of food
     * (random).
     * Abnormal conditions (5% chance): A bear empties the feeder.
     * Updates the currentFood instance variable accordingly.
     * 
     * Precondition: numBirds > 0
     */
    public void simulateOneDay(int numBirds) {
        // Check if there's a bear visit (5% chance of abnormal conditions)
        if (Math.random() < 0.05) {
            // Bear visits and empties the feeder
            currentFood = 0;
        } else {
            // Normal conditions - birds visit

            // Randomly determine how much food each bird will eat today (10-50 grams)
            int gramsPerBird = (int) (Math.random() * 41) + 10; // Generates a number from 10 to 50

            // Calculate total food needed for all birds
            int totalFoodNeeded = numBirds * gramsPerBird;

            // Update the food in the feeder
            if (currentFood >= totalFoodNeeded) {
                // There's enough food for all birds
                currentFood -= totalFoodNeeded;
            } else {
                // Not enough food, the birds empty the feeder
                currentFood = 0;
            }
        }
    }

    /**
     * Returns the number of days birds or a bear found food to eat at the feeder in
     * this simulation.
     * The simulation runs for at most numDays consecutive days or until the feeder
     * is empty.
     * 
     * Preconditions: numBirds > 0, numDays > 0
     * 
     * @param numBirds the number of birds visiting the feeder each day
     * @param numDays  the maximum number of days to simulate
     * @return the number of days that birds or a bear found food at the feeder
     */
    public int simulateManyDays(int numBirds, int numDays) {
        int daysWithFood = 0;

        for (int day = 0; day < numDays; day++) {
            // Check if there's any food in the feeder before simulating the day
            if (currentFood <= 0) {
                break; // No food left, end simulation
            }

            // Remember the amount of food before the day's simulation
            int foodBeforeDay = currentFood;

            // Simulate one day of feeding
            simulateOneDay(numBirds);

            // If food amount decreased, then birds or a bear found food
            if (currentFood < foodBeforeDay) {
                daysWithFood++;
            }
        }

        return daysWithFood;
    }

    /**
     * Gets the current amount of food in the feeder
     * 
     * @return the amount of food in grams
     */
    public int getCurrentFood() {
        return currentFood;
    }

    /**
     * Adds food to the feeder
     * 
     * @param amount the amount of food to add in grams
     */
    public void addFood(int amount) {
        if (amount > 0) {
            currentFood += amount;
        }
    }
}