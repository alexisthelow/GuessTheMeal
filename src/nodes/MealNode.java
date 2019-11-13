package nodes;

public class MealNode extends Node {
    
    // this class is only ever gonna be a leaf
    
    private String mealName;
    
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
    
}
