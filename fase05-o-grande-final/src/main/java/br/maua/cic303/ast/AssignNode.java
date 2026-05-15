package br.maua.cic303.ast;

import br.maua.cic303.Environment;

public class AssignNode extends ASTNode {

    private final String variable;
    private final ASTNode expression;

    public AssignNode(String variable, ASTNode expression) {
        this.variable = variable;
        this.expression = expression;
    }

    @Override
    public Double avaliar(Environment env) {
        Double value = expression.avaliar(env);
        env.setVariable(variable, value);
        return value;
    }
}