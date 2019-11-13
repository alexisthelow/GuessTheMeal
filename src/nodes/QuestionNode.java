package nodes;

public class QuestionNode extends Node {

    private String question;
    private Node yes;           // might be another questionNode, might be a mealNode
    private Node no;

}
