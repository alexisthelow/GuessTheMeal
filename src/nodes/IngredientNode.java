package nodes;

public class IngredientNode implements Node {

    private String ingredient;  // name of ingredient
    private Node yes;           // might be another questionNode, might be a mealNode
    private Node no;            
    private Node parent;        // might be null sometimes
    
    public IngredientNode() {
        super();
    }
    
    public IngredientNode(String ingredient) {
        this.ingredient = ingredient;
    }
    
    public IngredientNode(String ingredient, Node yes, Node no) {
        this.ingredient = ingredient;
        this.yes = yes;
        this.no = no;
    }
    
    public String getIngredient() {
        return ingredient;
    }
    
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
    
    public Node getYes() {
        return yes;
    }
    
    public void setYes(Node yes) {
        this.yes = yes;
    }
    
    public Node getNo() {
        return no;
    }
    
    public void setNo(Node no) {
        this.no = no;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    
}
