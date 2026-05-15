package br.maua.cic303;

public class LexerManual {

    private String entrada;
    private int posicao;

    public LexerManual(String entrada) {
        this.entrada = entrada;
        this.posicao = 0;
    }

    public Token nextToken() {

        // Ignorar espaços em branco
        while (posicao < entrada.length() &&
                Character.isWhitespace(entrada.charAt(posicao))) {
            posicao++;
        }

        // EOF
        if (posicao >= entrada.length()) {
            return new Token(Tag.EOF, "");
        }

        char c = entrada.charAt(posicao);

        // ASSIGN
        if (c == '=') {
            posicao++;
            return new Token(Tag.ASSIGN, "=");
        }

        // ADD_OP
        if (c == '+' || c == '-') {
            posicao++;
            return new Token(Tag.ADD_OP, String.valueOf(c));
        }

        // MUL_OP
        if (c == '*' || c == '/') {
            posicao++;
            return new Token(Tag.MUL_OP, String.valueOf(c));
        }

        // NUMBER
        if (Character.isDigit(c)) {

            int inicio = posicao;

            while (posicao < entrada.length() &&
                    (Character.isDigit(entrada.charAt(posicao)) ||
                     entrada.charAt(posicao) == '.')) {
                posicao++;
            }

            return new Token(
                    Tag.NUMBER,
                    entrada.substring(inicio, posicao)
            );
        }

        // ID
        if (Character.isLetter(c)) {

            int inicio = posicao;

            while (posicao < entrada.length() &&
                    (Character.isLetterOrDigit(entrada.charAt(posicao)) ||
                     entrada.charAt(posicao) == '_')) {
                posicao++;
            }

            return new Token(
                    Tag.ID,
                    entrada.substring(inicio, posicao)
            );
        }

        // ERROR
        posicao++;
        return new Token(Tag.ERROR, String.valueOf(c));
    }
}