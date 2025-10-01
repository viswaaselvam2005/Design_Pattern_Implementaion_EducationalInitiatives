package Exercise_1.Behavioral.Interpreter;

public class NotExpression implements Expression {

    private Expression expr;

    public NotExpression(Expression expr) {
        this.expr = expr;
    }

    @Override
    public boolean interpret(String context) {
        return !expr.interpret(context);
    }
}
