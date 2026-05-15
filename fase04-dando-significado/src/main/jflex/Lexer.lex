package br.maua.cic303;

import java_cup.runtime.Symbol;

%%

%class Lexer
%public
%cup
%unicode
%line
%column

%{

private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
}

private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
}

%}

DIGIT      = [0-9]
LETTER     = [a-zA-Z]
ID         = {LETTER}({LETTER}|{DIGIT}|_)*
NUMBER     = {DIGIT}+(\.{DIGIT}+)?

%%

/* espaços */
[ \t\r\n]+                 { }

/* palavras reservadas */
"if"                       { return symbol(sym.IF); }
"then"                     { return symbol(sym.THEN); }
"else"                     { return symbol(sym.ELSE); }
"while"                    { return symbol(sym.WHILE); }

/* operadores relacionais */
"==" | "!=" | "<=" | ">=" | "<" | ">"
                           { return symbol(sym.REL_OP, yytext()); }

/* atribuição */
"="                        { return symbol(sym.ASSIGN); }

/* operadores aditivos */
"+" | "-"
                           { return symbol(sym.ADD_OP, yytext()); }

/* operadores multiplicativos */
"*" | "/" | "%"
                           { return symbol(sym.MUL_OP, yytext()); }

/* símbolos */
"("                        { return symbol(sym.LPAREN); }
")"                        { return symbol(sym.RPAREN); }
"{"                        { return symbol(sym.LBRACE); }
"}"                        { return symbol(sym.RBRACE); }
";"                        { return symbol(sym.SEMI); }

/* números */
{NUMBER}                   { return symbol(sym.NUMBER, yytext()); }

/* identificadores */
{ID} {
    return symbol(sym.ID, yytext());
}

/* erro */
. {
    throw new Error("Caractere inválido: " + yytext());
}