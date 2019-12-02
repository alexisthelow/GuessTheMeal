package engine;

import nodes.Node;
import tree.MealTree;

public class Engine {
    
    private boolean playAgain = false;
    private boolean gameOver = false;
    private MealTree tree;

    public static void main(String[] args) {
        //TODO should just call mainLoop()
    }
    
    public void mainLoop() {
        //TODO -- are we initializing a default tree, or loading an external tree?
        // for now just load default tree
        tree = new MealTree(); 
        tree.buildDefault();
        Node currentNode = tree.getRoot(); // holds node we're currently working on
        
        do { // run through once, then ask if player wants to play again
            // LOOP while !gameOver
                // process current node--question or meal?
                    // if a question:
                        // get response
                        // follow correct path for response
                        // set currentNode to node found with that path
                        // restart loop
                    // if a meal
                        // set gameOver = true;
                        // ask if player is thinking of indicated meal
                            // if yes:
                                // exit loop
                            // if no:
                                // String newMeal = what player was thinking of
                                // String newQuestion = response to "give me a question that will distinguish [meal comp guessed] from [meal player thought of]"
                                // boolean yesOrNo = response to "what is the correct answer for [meal comp guessed]? (true if yes, false if no)"
                                // call tree.addMeal(currentNode, newMeal, newQuestion, yesOrNo)
                                // exit loop
            // end LOOP
            // ask if player wants to play again 
            // set playAgain to response
            
            
            
            
        } while (playAgain);
        // if we get here we're not playing again
        // TODO when serialization is added, announce that the game is being saved
        // say goodbye
        
    }

}
