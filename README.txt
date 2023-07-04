Para executar os algoritmos de pesquisa, apenas precisa de garantir que tem alguma versão recente do Java instalada.
Assim apenas precisamos de compilar todos os ficheiros executando a seguinte linha de instuções na shell:

javac AstarFora.java && javac AstarMan.java && javac BFS.java && javac BoardAFora.java && javac BoardAMan.java && javac BoardBFS.java && javac BoardDFS.java && javac BoardGreedyFora.java && javac BoardGreedyMan.java && javac DFS.java && javac Game15.java && javac GreedyFora.java && javac GreedyMan.java && javac IDFS.java

Agora apenas precisamos de executar o código recorrendo à instrução:

java Game15 strategy < config.txt

em que strategy é o nome do algoritmo que queremos usar ( pode ser "BFS", "DFS", "IDFS", "A*-misplaced", "A*-Manhattan", "Greedy-misplaced" ou "Greedy-Manhattan")
e no ficheiro config.txt devem estar a configuração inicial e final, como por exemplo:

1 2 3 4 5 6 7 8 9 10 11 12 0 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0