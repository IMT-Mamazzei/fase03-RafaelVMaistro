package br.maua.cic303.ast;

import br.maua.cic303.Environment;

public class IdentifierNode extends ASTNode {

    private String name;

    public IdentifierNode(String name) {
        this.name = name;
    }

    @Override
    public Double avaliar(Environment env) {
        return env.getVariable(name);
    }
}