# English Version

This project was developed for the subject 'Artificial Intelligence' by the students [André Sousa](https://github.com/anfisou) and [Paulo Silva](https://github.com/Panda-Hacks) and implements the [15 Puzzle](https://en.wikipedia.org/wiki/15_puzzle) using different search algorithms.You can choose between the BFS, the DFS, the Iterative DFS,the  Greedy and the A* algorithms.In case you chose the Greedy or A* algorithms you have 2 options of heuristics to use: the number of misplaced pieces ('misplaced') or the Manhattan distance from each piece to their final position ('Manhattan').

In order to execute the game you need to compile all the .java files using:

```javac *.java```

To run the code you only need to execute one of the following commands:

- ```java Game15 BFS < config.txt```
- ```java Game15 DFS < config.txt```
- ```java Game15 IDFS < config.txt```
- ```java Game15 Greedy-misplacedFS < config.txt```
- ```java Game15 Greedy-Manhattan < config.txt```
- ```java Game15 A*-misplaced < config.txt```
- ```java Game15 A*-Manhattan < config.txt```

The ```config.txt``` file should contain a inicial configuration on the first line and a final configuration on the second line, theese are the configurations in wich the game starts and the one we prentend to obtain at the end (in the default version of the game this is ```1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0```). The blank space is represented by a ```0``` and the values are read horizontally from left to rigth and top to bottom, for example:

```
1 2 3 4 5 6 7 8 9 10 11 12 0 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0
```

# Versão Portuguesa

Este projeto foi desevolvido no âmbito da unidade curricular 'Inteligência Artificial' pelos alunos [André Sousa](https://github.com/anfisou) e [Paulo Silva](https://github.com/Panda-Hacks) e implementa o [Jogo dos 15](https://pt.wikipedia.org/wiki/O_jogo_do_15) utilizando diferentes algoritmos de pesquisa. Foram desenvolvidos os algoritmos BFS, DFS, Iterative DFS, Greedy e A*. Para os algoritmls Greedy e A* podem ser utilizadas duas heurísticas: o número de peças fora do lugar ('misplaced') ou a distância Manhattan de cada peça ao seu lugar ('Manhattan').

Para poder executar o código é necessário compilar todos os ficheiros .java usando o comando:

```javac *.java```

Agora apenas precisamos de executar o código recorrendo a uma das instruções:

- ```java Game15 BFS < config.txt```
- ```java Game15 DFS < config.txt```
- ```java Game15 IDFS < config.txt```
- ```java Game15 Greedy-misplacedFS < config.txt```
- ```java Game15 Greedy-Manhattan < config.txt```
- ```java Game15 A*-misplaced < config.txt```
- ```java Game15 A*-Manhattan < config.txt```

O ficheiro ```config.txt``` deve conter a configuração inicial na primeira linha e final na segunda linha, ou seja, a configuração em que o jogo começa e a configuração que pretendemos obter (no caso normal do jogo, esta é ```1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0```) em que o espaço vazio é representado pelo ```0``` e os valores são lidos horizontalmente da direira para a esquerda e de cima para baixo, como por exemplo:

```
1 2 3 4 5 6 7 8 9 10 11 12 0 13 14 15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0
```
