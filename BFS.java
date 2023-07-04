import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.Queue;

class BFS{
    public static void run(){
        Scanner in = new Scanner(System.in);
        BoardBFS game = new BoardBFS(0);
        game.read(in);
        BoardBFS fin = new BoardBFS(0);
        fin.read(in);
        if (game.isSolvable()!= fin.isSolvable()){System.out.println("Not solvable");}
        else{Queue<BoardBFS> fila = new LinkedList<BoardBFS>();
            Set<String> set = new TreeSet<String>();
            fila.add(game);
            set.add(game.orderValue());
            int visited=0;
            long max = 0;
            BoardBFS actual = fila.peek();
            while(!fila.isEmpty()){
                if (fila.size()>max){max=fila.size();}
                actual = fila.peek();
                visited++;
                if(actual.InOrder(fin)){break;}
                if(actual.canUp()){
                    BoardBFS up = actual.moveUp();
                    if(!set.contains(up.orderValue())){
                        fila.add(up);set.add(up.orderValue());}}
                if(actual.canDown()){
                    BoardBFS down = actual.moveDown();
                    if(!set.contains(down.orderValue())){
                        fila.add(down);set.add(down.orderValue());}}
                if(actual.canLeft()){
                    BoardBFS left = actual.moveLeft();
                    if(!set.contains(left.orderValue())){
                        fila.add(left);set.add(left.orderValue());}}
                if(actual.canRight()){
                    BoardBFS right = actual.moveRight();
                    if(!set.contains(right.orderValue())){
                        fila.add(right);set.add(right.orderValue());}}
                fila.remove();
            }
            if(fila.isEmpty()){System.out.println("Solucao nao encontrada");}
            else{
                System.out.println(visited + " caso(s) vistos");
                System.out.println("Profundidade da solucao: " +actual.depth );
                System.out.println("Numero maximo de estados em memoria: " + (max+set.size()));
            }}
    }
}