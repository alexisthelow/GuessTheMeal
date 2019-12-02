package engine;

import nodes.MealNode;
import nodes.Node;
import nodes.QuestionNode;
import tree.MealTree;

public class Engine {
    
    private boolean playAgain = false;
    private boolean gameOver = false;
    private MealTree tree;
    private ScannerResponseGetter srg;

    public static void main(String[] args) {
        Engine e = new Engine();
        e.mainLoop();
    }
    
    public void mainLoop() {
        //TODO -- are we initializing a default tree, or loading an external tree?
        // for now just load default tree
        tree = new MealTree(); 
        tree.buildDefault();
        
        // initialize ScannerResponseGetter
        srg = new ScannerResponseGetter();
        
        Node currentNode; // holds node we're currently working on; at start, 
        
        do { // run through once, then ask if player wants to play again
            gameOver = false;
            currentNode = tree.getRoot(); // work starts from the root
            
            while (!gameOver) {// loop while !gameOver
                
                // process current node--question or meal?
                if (currentNode instanceof QuestionNode) { // it's a question
                    
                    // cast currentNode to a QuestionNode
                    QuestionNode q = (QuestionNode) currentNode; 
                    
                    // ask the question
                    System.out.println(q.getQuestion());
                    
                    // get response
                    boolean response = srg.requestConfirmation("Please enter \"yes/y\" or \"no/n\": ");
                    
                    // follow correct path for response, set currentNode to that node
                    currentNode = response ? q.getYes() : q.getNo(); // i flippin love ternary operators, yo
                    
                    // allow loop to restart
                } else { // it's a meal
                    
                    // cast currentNode to a MealNode
                    MealNode m = (MealNode) currentNode;
                    
                    // set gameOver = true (if we reach a meal node, the game is over)
                    gameOver = true;
                    
                    // ask if player is thinking of indicated meal
                    boolean response = srg.requestConfirmation("Were you thinking of " + m.getMealName() + "?: ");
                    
                    if (!response) { // if we guessed incorrectly, we gotta do a bunch of stuff now
                        
                        // ask what player was thinking of
                        String newMeal = srg.stringRequest("What meal were you thinking of?: ");
                        
                        // prompt for differentiation question
                        String newQuestion = srg.stringRequest("What is a question that distinguishes " + 
                                m.getMealName() + " and " + newMeal + "?: ");
                        
                        // ask "what is the correct answer for [meal comp guessed]? (true if yes, false if no)"
                        boolean yesOrNo = srg.requestConfirmation("What is the correct answer to that question for " +
                                m.getMealName() + "?: ");
                        
                        // call tree.addMeal(currentNode, newMeal, newQuestion, yesOrNo)
                        tree.addMeal(m, newMeal, newQuestion, yesOrNo);
                    }
                    
                    // if we guessed correctly, we just allow the loop to finish 

                } // end node processing
                
            } // end game loop
            
            // ask if player wants to play again, set playAgain to response
            playAgain = srg.requestConfirmation("Do you want to play again?: ");
            
        } while (playAgain);
        // if we get here we're not playing again
        // TODO when serialization is added, announce that the game is being saved
        // close scanner, because it's important to be tidy
        srg.close();
        // say goodbye
        System.out.println("Thanks for playing! Goodbye!");
        
    }

}
