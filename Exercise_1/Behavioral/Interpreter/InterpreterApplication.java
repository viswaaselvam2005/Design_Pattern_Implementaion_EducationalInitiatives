package Exercise_1.Behavioral.Interpreter;

/*
    Interpreter Pattern Demo with AND, OR, NOT
 */
public class InterpreterApplication {

    // Rule: Robert and John are male
    public static Expression getMaleExpression(){
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    // Rule: Julie is a married woman
    public static Expression getMarriedWomanExpression(){
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    // Rule: Someone who is NOT married
    public static Expression getNotMarriedExpression(){
        Expression married = new TerminalExpression("Married");
        return new NotExpression(married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();
        Expression isNotMarried = getNotMarriedExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married woman? " + isMarriedWoman.interpret("Married Julie"));
        System.out.println("Robert is NOT married? " + isNotMarried.interpret("Robert"));
        System.out.println("Julie is NOT married? " + isNotMarried.interpret("Married Julie"));
    }
}
