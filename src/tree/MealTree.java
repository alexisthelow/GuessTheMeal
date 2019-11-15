package tree;

import nodes.IngredientNode;
import nodes.MealNode;

public class MealTree {
    
    private IngredientNode root;
    
    public MealTree() {
        super();
    }
    
    public void buildDefault() {
        MealNode pizza = new MealNode("pizza");
        MealNode chickenSoup = new MealNode("chicken soup");
        IngredientNode tomatoSauce = new IngredientNode("tomato sauce", pizza, chickenSoup);
        chickenSoup.setParent(tomatoSauce);
        pizza.setParent(tomatoSauce);
        this.root = tomatoSauce;
    }
    
    public void addMeal(MealNode failPoint, String newMealName, String newIngredientName, boolean yesOrNo) {
        
        // get parent node of the fail point (meal we guessed that was wrong)
        IngredientNode parent = (IngredientNode) failPoint.getParent();
        
        // make new meal (what player was thinking of)
        MealNode newMeal = new MealNode(newMealName);
        
        // make new ingredient (distinguishes meal player was thinking of from meal we guessed)
        IngredientNode newIngredient = new IngredientNode(newIngredientName);
        
        // set parent of both meals to the new ingredient
        newMeal.setParent(newIngredient);
        failPoint.setParent(newIngredient);
        
        // we asked player if the fail point had this ingredient--what was the response?
        if (yesOrNo) { // fail point has this ingredient
            // so the new ingredient's yes is the fail point
            newIngredient.setYes(failPoint);
            // and the new ingredient's no is the new meal
            newIngredient.setNo(newMeal);
        }
        else { // fail point does not have this ingredient
            // so the new ingredient's yes is the new meal
            newIngredient.setYes(newMeal);
            // and the new ingredient's no is the fail point
            newIngredient.setNo(failPoint);
        }
        
        // was the fail point on the yes or the no of the parent? get the parent's yes route and compare to the fail point
        if (parent.getYes() == failPoint) { // they match 
            // newIngredientNode should be set to parent's yes
            parent.setYes(newIngredient);
        }
        else { // they don't match 
            // newIngredientNode should be set to parent's no
            parent.setNo(newIngredient);
        }
        
        // i think we're done now
        
        
        
    }
    
}
