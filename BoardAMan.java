import java.util.Scanner;

class BoardAMan implements Comparable<BoardAMan> {
    int vals[][];
    Integer depth;
    Integer custo;

    BoardAMan(int d){
        vals = new int[4][4];
        depth = d;
    }

    public void read(Scanner in){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                vals[i][j] = in.nextInt();
            }
        }
    }

    public int[] findn(int n){
        int[] res = new int[2];
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                if (vals[i][j] == n){res[0] = i; res[1] = j; return res;}
            }
        }
        return res;
    }

    public void setCusto(BoardAMan f){
        custo = depth+heuristicmanhattan(f);
    }

    public int heuristicmanhattan(BoardAMan f){
        int sum = 0;
        for(int i = 0;i<4;i++){
           for(int j = 0;j<4;j++){
            int temp = vals[i][j];
            if (temp != 0){int[] t = f.findn(temp); sum += Math.abs(i -t[0]) + Math.abs(j-t[1]);}
           }
        }
        return sum;
    }

    public boolean isSolvable(){
        return (findn(0)[0]%2 == 1) == (NumberInversions()%2==0);
    }

    public int NumberInversions(){
        int count = 0;
        for(int i = 0;i<16;i++){
            if (vals[i/4][i%4] != 0){
                for(int j = i+1;j<16;j++){
                    if (vals[i/4][i%4] > vals[j/4][j%4] && vals[j/4][j%4] != 0){
                        count++;
                    } 
                }
            }
        }
        return count;
    }


    public String orderValue(){
        String value = "";
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                value += vals[i][j] + " ";
            }
        }
        return value;
    }
    public String toString(){
        return orderValue();
    }

    public int compareTo(BoardAMan b) {if(custo==b.custo){
        return depth.compareTo(b.depth);}
        return custo.compareTo(b.custo);}

    public boolean InOrder(BoardAMan f){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(vals[i][j] != f.vals[i][j]){return false;}
            }
        }
        return true;
    }

    public boolean canUp()   {return findn(0)[0] != 0;}
    public boolean canDown()  {return findn(0)[0] != 3;}
    public boolean canLeft()  {return findn(0)[1] != 0;}
    public boolean canRight()  {return findn(0)[1] != 3;}

    public BoardAMan moveUp(){
        int[] empty = findn(0);
        int x = empty[0];
        int y = empty[1];
        BoardAMan res = new BoardAMan(this.depth + 1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                res.vals[i][j] = this.vals[i][j];
            }
        }
        res.vals[x][y] = res.vals[x-1][y];
        res.vals[x-1][y] = 0;
        return res;
    }

    public BoardAMan moveDown(){
        int[] empty = findn(0);
        int x = empty[0];
        int y = empty[1];
        BoardAMan res = new BoardAMan(this.depth + 1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                res.vals[i][j] = this.vals[i][j];
            }
        }
        res.vals[x][y] = res.vals[x+1][y];
        res.vals[x+1][y] = 0;
        return res;
    }

    public BoardAMan moveLeft(){
        int[] empty = findn(0);
        int x = empty[0];
        int y = empty[1];
        BoardAMan res = new BoardAMan(this.depth + 1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                res.vals[i][j] = this.vals[i][j];
            }
        }
        res.vals[x][y] = res.vals[x][y-1];
        res.vals[x][y-1] = 0;
        return res;
    }

    public BoardAMan moveRight(){
        int[] empty = findn(0);
        int x = empty[0];
        int y = empty[1];
        BoardAMan res = new BoardAMan(this.depth + 1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                res.vals[i][j] = this.vals[i][j];
            }
        }
        res.vals[x][y] = res.vals[x][y+1];
        res.vals[x][y+1] = 0;
        return res;
    }

    
}