package tree;

import java.io.Serializable;

import nodes.MealNode;
import nodes.QuestionNode;

public class MealTree implements Serializable {
    
    private static final long serialVersionID = 1L; // version number for serialization
    private QuestionNode root; // top node of this tree
    
    public MealTree() {
        super();
    }
    
    public void buildDefault() {
        MealNode pizza = new MealNode("pizza");
        MealNode chickenSoup = new MealNode("chicken soup");
        QuestionNode tomatoSauce = new QuestionNode("Does the meal have tomato sauce?", pizza, chickenSoup);
        chickenSoup.setParent(tomatoSauce);
        pizza.setParent(tomatoSauce);
        this.root = tomatoSauce;
    }
    
    public void addMeal(MealNode failPoint, String newMealName, String newQuestion, boolean yesOrNo) {
        
        // get parent node of the fail point (meal we guessed that was wrong)
        QuestionNode parent = (QuestionNode) failPoint.getParent();
        
        // make new meal (what player was thinking of)
        MealNode newMeal = new MealNode(newMealName);
        
        // make new ingredient (distinguishes meal player was thinking of from meal we guessed)
        QuestionNode newQuestionNode = new QuestionNode(newQuestion);
        
        // set parent of both meals to the new ingredient
        newMeal.setParent(newQuestionNode);
        failPoint.setParent(newQuestionNode);
        
        // we asked player if the fail point had this ingredient--what was the response?
        if (yesOrNo) { // fail point has this ingredient
            // so the new question's yes is the fail point
            newQuestionNode.setYes(failPoint);
            // and the new question's no is the new meal
            newQuestionNode.setNo(newMeal);
        }
        else { // fail point does not have this ingredient
            // so the new question's yes is the new meal
            newQuestionNode.setYes(newMeal);
            // and the new question's no is the fail point
            newQuestionNode.setNo(failPoint);
        }
        
        // was the fail point on the yes or the no of the parent? get the parent's yes route and compare to the fail point
        if (parent.getYes() == failPoint) { // they match 
            // newIngredientNode should be set to parent's yes
            parent.setYes(newQuestionNode);
        }
        else { // they don't match 
            // newIngredientNode should be set to parent's no
            parent.setNo(newQuestionNode);
        }
        
        // i think we're done now
        
    }

    public QuestionNode getRoot() {
        return root;
    }

    public void setRoot(QuestionNode root) {
        this.root = root;
    }
    
}
