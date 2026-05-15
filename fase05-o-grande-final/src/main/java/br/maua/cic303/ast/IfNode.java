package br.maua.cic303.ast;

import br.maua.cic303.Environment;

public class IfNode extends ASTNode {

    private final ASTNode condition;
    private final ASTNode thenBlock;
    private final ASTNode elseBlock;

    public IfNode(ASTNode condition, ASTNode thenBlock, ASTNode elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public Double avaliar(Environment env) {

        Double cond = condition.avaliar(env);

        if (cond != 0.0) {
            return thenBlock.avaliar(env);
        }

        if (elseBlock != null) {
            return elseBlock.avaliar(env);
        }

        return 0.0;
    }
}