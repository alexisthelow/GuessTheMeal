package nodes;

public class QuestionNode implements Node {

    private String question;    // string containing this node's question
    private Node yes;           // might be another questionNode, might be a mealNode
    private Node no;            
    private Node parent;        // might be null sometimes
    
    public QuestionNode() {
        super();
    }
    
    public QuestionNode(String question) {
        this.question = question;
    }
    
    public QuestionNode(String question, Node yes, Node no) {
        this.question = question;
        this.yes = yes;
        this.no = no;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
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
