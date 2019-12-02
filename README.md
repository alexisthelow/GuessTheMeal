# GuessTheMeal
A game where you think of a meal, and the computer tries to guess what it is by asking you whether it contains an ingredient. For practice with Binary Tree structures.

## Design Thoughts
When adding an ingredient node, it is because the player thought of a meal that the computer couldn't guess. That will only happen when we have reached a meal node and asked whether the player was thinking of that meal, and the player said no.

So we must:
1) Ask the player what they were thinking of (MealNode newMeal = new MealNode("<response>"));
2) Ask the player what ingredient distinguishes the meal they were thinking of from the meal we guessed (IngredientNode newIngredient = new IngredientNode("<response>"));
3) Ask the player what the correct response is to the question "does [meal we guessed] have [distinguishing ingredient]?" (yes or no);
4) Create a new mealNode with the info from #1;
5) Create a new ingredientNode with the info from #2, where the response from #3 points to [meal we guessed] and the other response points to [meal the player was thinking of];
6) Set the parents of the new meal and the old meal to this new ingredientNode;
7) Replace [meal we guessed] with this new ingredient node;
