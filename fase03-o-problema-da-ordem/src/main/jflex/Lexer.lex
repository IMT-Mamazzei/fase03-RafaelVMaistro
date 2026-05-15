package br.maua.cic303;

import java_cup.runtime.Symbol;

%%

%public
%class Lexer
%unicode
%cup
%line
%column

%{

private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
}

%}

WHITESPACE = [ \t\r\n]+
ID = [a-zA-Z_][a-zA-Z0-9_]*
NUMBER = [0-9]+

%%

{WHITESPACE}      { }

"if"              { return symbol(sym.IF); }
"then"            { return symbol(sym.THEN); }
"else"            { return symbol(sym.ELSE); }
"while"           { return symbol(sym.WHILE); }

"="               { return symbol(sym.ASSIGN); }

"+"               { return symbol(sym.ADD_OP); }
"-"               { return symbol(sym.ADD_OP); }

"*"               { return symbol(sym.MUL_OP); }
"/"               { return symbol(sym.MUL_OP); }
"%"               { return symbol(sym.MUL_OP); }

"=="              { return symbol(sym.REL_OP); }
"!="              { return symbol(sym.REL_OP); }
">="              { return symbol(sym.REL_OP); }
"<="              { return symbol(sym.REL_OP); }
">"               { return symbol(sym.REL_OP); }
"<"               { return symbol(sym.REL_OP); }

"("               { return symbol(sym.LPAREN); }
")"               { return symbol(sym.RPAREN); }

"{"               { return symbol(sym.LBRACE); }
"}"               { return symbol(sym.RBRACE); }

";"               { return symbol(sym.SEMI); }

{NUMBER}          { return symbol(sym.NUMBER); }
{ID}              { return symbol(sym.ID); }

.                 { return symbol(sym.ERROR); }