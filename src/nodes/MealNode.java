package nodes;

import java.io.Serializable;

public class MealNode implements Node, Serializable {
    
    // this class is only ever gonna be a leaf
    private static final long serialVersionID = 1L; // serial ID for saving game
    private String mealName;    // name of this meal
    private Node parent;        // parent is only ever gonna be an ingredientnode
    
    public MealNode() {
        super();
    }
    
    public MealNode(String meal) {
        this.mealName = meal;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    
}
