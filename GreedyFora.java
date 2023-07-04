import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.PriorityQueue;


public class GreedyFora{
    public static void run(){
        Scanner in = new Scanner(System.in);
        BoardGreedyFora game = new BoardGreedyFora(0);
        game.read(in);
        BoardGreedyFora fin = new BoardGreedyFora(0);
        fin.read(in);
        if(game.isSolvable()!= fin.isSolvable()) {System.out.println("Not solvable");}
        else{
            game.setCusto(fin);
            PriorityQueue<BoardGreedyFora> fila = new PriorityQueue<BoardGreedyFora>();
            Set<String> set = new TreeSet<String>();
            fila.add(game);
            set.add(game.orderValue());
            long max = 0;
            int visited=0;
            BoardGreedyFora actual = fila.peek();

            while(!fila.isEmpty()){
                if(fila.size()>max){max = fila.size();}
                actual = fila.poll();
                visited++;
                if(actual.InOrder(fin)){break;}
                if(actual.canUp()){
                    BoardGreedyFora up = actual.moveUp();
                    if(!set.contains(up.orderValue())){
                        up.setCusto(fin);fila.add(up);set.add(up.orderValue());}}
                if(actual.canDown()){
                    BoardGreedyFora down = actual.moveDown();
                    if(!set.contains(down.orderValue())){
                        down.setCusto(fin);fila.add(down);set.add(down.orderValue());}}
                if(actual.canLeft()){
                    BoardGreedyFora left = actual.moveLeft();
                    if(!set.contains(left.orderValue())){
                        left.setCusto(fin);fila.add(left);set.add(left.orderValue());}}
                if(actual.canRight()){
                    BoardGreedyFora right = actual.moveRight();
                    if(!set.contains(right.orderValue())){
                        right.setCusto(fin);fila.add(right);set.add(right.orderValue());}}
            }
            
            if(fila.isEmpty()){System.out.println("Solucao nao encontrada");}
            else{
                System.out.println(visited + " caso(s) vistos");
                System.out.println("Profundidade da solucao: " +actual.depth );
                System.out.println("Numero maximo de estados em memoria: " + (max+set.size()));
            }
        }
    }
}
