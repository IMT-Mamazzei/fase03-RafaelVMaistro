package br.maua.cic303.ast;

import br.maua.cic303.Environment;

public class NumberNode extends ASTNode {

    private final Double value;

    public NumberNode(Double value) {
        this.value = value;
    }

    @Override
    public Double avaliar(Environment env) {
        return value;
    }
}