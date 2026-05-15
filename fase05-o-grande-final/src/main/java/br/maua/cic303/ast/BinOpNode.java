package br.maua.cic303.ast;

import br.maua.cic303.Environment;

public class BinOpNode extends ASTNode {

    private final ASTNode left;
    private final String op;
    private final ASTNode right;

    public BinOpNode(ASTNode left, String op, ASTNode right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public Double avaliar(Environment env) {

        Double l = left.avaliar(env);
        Double r = right.avaliar(env);

        switch (op) {
            case "+":
                return l + r;

            case "-":
                return l - r;

            case "*":
                return l * r;

            case "/":
                return l / r;

            case "==":
                return l.equals(r) ? 1.0 : 0.0;

            case "!=":
                return !l.equals(r) ? 1.0 : 0.0;

            case "<":
                return l < r ? 1.0 : 0.0;

            case ">":
                return l > r ? 1.0 : 0.0;

            case "<=":
                return l <= r ? 1.0 : 0.0;

            case ">=":
                return l >= r ? 1.0 : 0.0;
        }

        throw new RuntimeException("Operador inválido: " + op);
    }
}