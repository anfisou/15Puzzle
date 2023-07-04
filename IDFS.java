import java.util.Stack;
import java.util.Scanner;

public class IDFS {
    public static void run(){
        Scanner in = new Scanner(System.in);
        BoardDFS game = new BoardDFS(0);
        game.read(in);
        BoardDFS fin = new BoardDFS(0);
        fin.read(in);
        boolean solutionfound = false;
        Stack<BoardDFS> stack = new Stack<BoardDFS>();
        if (game.isSolvable()!= fin.isSolvable()){System.out.println("Not solvable");}
        else{
            int visited = 0;
            long max = 0;
            BoardDFS actual = new BoardDFS(0);
            for(int p = 0;p>-1;p++){
            game.visited = false;
            stack = new Stack<BoardDFS>();
            stack.push(game);
            visited = 0;
            max = 0;
            actual = stack.peek();
            while(!stack.empty()){
                if (stack.size()>max){max = stack.size();}
                actual = stack.peek();
                if (actual.InOrder(fin)){solutionfound = true;break;}
                if (actual.visited || actual.depth == p){stack.pop();}
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
                            stack.add(left);}}
                    if(actual.canDown()){
                        BoardDFS down = actual.moveDown();
                        if(!stack.contains(down)){
                            stack.add(down);}}
                    if(actual.canRight()){
                        BoardDFS right = actual.moveRight();
                        if(!stack.contains(right)){
                            stack.add(right);}}}
            }
            if(solutionfound){break;}
            }
                System.out.println(visited + " caso(s) visitados");
                System.out.println("Profundidade da solucao: " +actual.depth );
                System.out.println("Numero maximo de estados em memoria: " + max);
            }
        
    }
}
