import java.util.Stack;
import java.util.Scanner;

public class DFS {
    public static void run(){
        Scanner in = new Scanner(System.in);
        BoardDFS game = new BoardDFS(0);
        game.read(in);
        BoardDFS fin = new BoardDFS(0);
        fin.read(in);
        if (game.isSolvable()!= fin.isSolvable()){System.out.println("Not solvable");}
        else{Stack<BoardDFS> stack = new Stack<BoardDFS>();
            stack.push(game);
            int visited = 0;
            long max = 0;
            BoardDFS actual = stack.peek();
            //int limit=20;
            while(!stack.empty()){
                if (stack.size()>max){max = stack.size();}
                actual = stack.peek();
                if (actual.InOrder(fin)){break;}
                if (actual.visited /*|| actual.depth==limit*/){stack.pop();}
                else{
                    visited++;
                    actual.visited = true;
                    if(actual.canUp()){
                        BoardDFS up = actual.moveUp();
                        if(!stack.contains(up)){
                            stack.push(up);}}
                    if(actual.canLeft()){
                        BoardDFS left = actual.moveLeft();
                        if(!stack.contains(left)){
                            stack.push(left);}}
                    if(actual.canDown()){
                        BoardDFS down = actual.moveDown();
                        if(!stack.contains(down)){
                            stack.push(down);}}
                    if(actual.canRight()){
                        BoardDFS right = actual.moveRight();
                        if(!stack.contains(right)){
                            stack.push(right);}}}
            }
            if(stack.empty()){System.out.println("Solucao nao encontrada");}
            else{
                System.out.println(visited + " caso(s) visitados");
                System.out.println("Profundidade da solucao: " +actual.depth );
                System.out.println("Numero maximo de estados em memoria: " + max);
            }
        }
    }
}