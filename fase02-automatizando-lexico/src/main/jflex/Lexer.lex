package br.maua.cic303;

%%

%class Lexer
%public
%unicode
%type Token

%{

private Token token(Tag tag) {
    return new Token(tag, yytext());
}

%}

DIGIT      = [0-9]
LETTER     = [a-zA-Z]
ID         = {LETTER}({LETTER}|{DIGIT}|_)*
NUMBER     = {DIGIT}+(\.{DIGIT}+)?([eE][+-]?{DIGIT}+)?

%%

/* espaços */
[ \t\r\n]+                 { }

/* palavras reservadas */
"if"                       { return token(Tag.IF); }
"then"                     { return token(Tag.THEN); }
"else"                     { return token(Tag.ELSE); }
"while"                    { return token(Tag.WHILE); }

/* operadores relacionais */
"==" | "!=" | "<=" | ">=" | "<" | ">"
                           { return token(Tag.REL_OP); }

/* atribuição */
"="                        { return token(Tag.ASSIGN); }

/* operadores aditivos */
"+" | "-"
                           { return token(Tag.ADD_OP); }

/* operadores multiplicativos */
"*" | "/" | "%"
                           { return token(Tag.MUL_OP); }

/* símbolos */
"("                        { return token(Tag.LPAREN); }
")"                        { return token(Tag.RPAREN); }
"{"                        { return token(Tag.LBRACE); }
"}"                        { return token(Tag.RBRACE); }
";"                        { return token(Tag.SEMI); }

/* números */
{NUMBER}                   { return token(Tag.NUMBER); }

/* identificadores */
{ID} {
    if (yytext().length() > 32)
        return token(Tag.ERROR);

    return token(Tag.ID);
}

/* erro */
.                          { return token(Tag.ERROR); }

<<EOF>>                    { return new Token(Tag.EOF, "EOF"); }