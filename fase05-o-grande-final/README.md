# 🏁 Fase 5: O Grande Final (O Interpretador JACA)

Sua Árvore Sintática Abstrata (AST) está perfeita. Agora é a hora de dar vida a ela!

Um Interpretador funciona "caminhando" pelos nós dessa árvore e executando as instruções que eles representam. Além disso, precisamos de um lugar para guardar nossas variáveis. Chamaremos isso de `Environment` (A Tabela de Símbolos).

## 🎯 O Desafio
Em cada classe do pacote `ast`, você encontrará um método vazio:
`public Double avaliar(Environment env);`

O seu trabalho é implementar a lógica desse método para cada tipo de nó.
* **NumberNode:** Deve apenas retornar o seu próprio valor.
* **BinOpNode:** Deve mandar avaliar o lado esquerdo, avaliar o lado direito, e aplicar a operação correspondente (`+`, `-`, `==`, etc). **Dica:** Para os operadores relacionais, retorne `1.0` se for verdadeiro e `0.0` se for falso.
* **IfNode:** Se a condição avaliada for diferente de `0.0`, avalie o bloco `THEN`. Senão, avalie o `ELSE`.
* **WhileNode:** Crie um laço `while` real no Java que continue avaliando o `BlockNode` enquanto a condição for diferente de `0.0`.

## 🛠️ Passos
1. Traga os seus arquivos `Lexer.lex` e `Parser.cup` das fases anteriores para este projeto.
2. Abra as classes na pasta `ast` e preencha a lógica do método `avaliar`.
3. Use os métodos `env.getVariable("nome")` e `env.setVariable("nome", valor)` quando encontrar variáveis.

## 🚦 A Avaliação Definitiva
Rode o comando mágico:
```bash
mvn test
```

Se o Teste 3 (O Grande Final - Fatorial) ficar verde... Parabéns! Você acaba de construir um compilador e interpretador funcional e Turing-completo do zero! 🏆