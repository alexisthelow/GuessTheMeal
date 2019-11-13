package nodes;

public class QuestionNode extends Node {

    private String question;
    private Node yes;           // might be another questionNode, might be a mealNode
    private Node no;
    
    public QuestionNode() {
        super();
    }
    
    public QuestionNode(String question) {
        this.question = question;
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

}
