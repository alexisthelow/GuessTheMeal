package nodes;

public class MealNode implements Node {
    
    // this class is only ever gonna be a leaf
    
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
