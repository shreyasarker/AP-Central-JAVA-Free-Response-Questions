# Bird Feeder Simulation Explained Simply

Explaination of the bird feeder program in simple terms:

## What the Program Does

This program simulates birds (and occasionally a bear) visiting a bird feeder over time. It tracks how much food remains in the feeder and counts how many days animals found food to eat.

## The Main Parts

### 1. The Bird Feeder
- The feeder starts with a certain amount of food (measured in grams)
- We keep track of how much food is left after animals eat from it
- The feeder can never have less than 0 grams of food

### 2. One Day of Feeding (`simulateOneDay`)
This part simulates what happens on a single day:

- **Normal Days (95% of the time):**
  - Only birds visit the feeder
  - Each bird eats somewhere between 10-50 grams of food
  - The exact amount changes randomly each day
  - We multiply this amount by the number of birds to find the total food eaten
  - If there's not enough food for all birds, they just eat whatever is available

- **Abnormal Days (5% of the time):**
  - A bear visits instead of birds!
  - The bear eats ALL the food in the feeder, leaving nothing

### 3. Multiple Days of Feeding (`simulateManyDays`)
This part simulates feeding over multiple days:

- We keep track of how many days birds or a bear found food
- Each day, we check if there's any food left in the feeder
- If there's food, we simulate one day of feeding
- If animals ate any food that day, we count it as a successful feeding day
- If the feeder becomes empty, we stop the simulation early
- At the end, we report how many days animals found food to eat

## Examples

**Example 1:** 
- Feeder starts with 2400 grams of food
- We simulate 10 birds visiting for up to 4 days
- Each day, birds eat some food but don't empty the feeder
- Result: On all 4 days, animals found food (returns 4)

**Example 2:**
- Feeder starts with 250 grams of food
- We simulate 10 birds visiting for up to 5 days
- On day 1, birds eat some food
- On day 2, birds (or a bear) eat all remaining food
- The feeder is now empty, so we stop simulating
- Result: On 2 days, animals found food (returns 2)

**Example 3:**
- Feeder starts with 0 grams of food (empty)
- We simulate 5 birds visiting for up to 10 days
- There's no food to begin with, so no animals find food
- Result: On 0 days, animals found food (returns 0)

Think of this program like keeping a diary of your bird feeder at home - tracking how much food remains each day and noting when animals successfully found something to eat!