package br.maua.cic303.ast;

import br.maua.cic303.Environment;

public class WhileNode extends ASTNode {

    private final ASTNode condition;
    private final ASTNode body;

    public WhileNode(ASTNode condition, ASTNode body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public Double avaliar(Environment env) {

        Double result = 0.0;

        while (condition.avaliar(env) != 0.0) {
            result = body.avaliar(env);
        }

        return result;
    }
}