public class Game15{
    public static void main(String[] args){
        if(args[0].equals("BFS")){BFS.run();}
        else if(args[0].equals("DFS")){DFS.run();}
        else if(args[0].equals("IDFS")){IDFS.run();}
        else if(args[0].equals("A*-misplaced")){AstarFora.run();}
        else if(args[0].equals("A*-Manhattan")){AstarMan.run();}
        else if(args[0].equals("Greedy-misplaced")){GreedyFora.run();}
        else if(args[0].equals("Greedy-Manhattan")){GreedyMan.run();}
    }
}