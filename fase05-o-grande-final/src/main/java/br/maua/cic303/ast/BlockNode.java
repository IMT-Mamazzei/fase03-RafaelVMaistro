package br.maua.cic303.ast;

import br.maua.cic303.Environment;
import java.util.List;

public class BlockNode extends ASTNode {

    private List<ASTNode> statements;

    public BlockNode(List<ASTNode> statements) {
        this.statements = statements;
    }

    @Override
    public Double avaliar(Environment env) {
        Double resultado = 0.0;

        for (ASTNode stmt : statements) {
            resultado = stmt.avaliar(env);
        }

        return resultado;
    }
}