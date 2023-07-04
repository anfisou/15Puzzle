import java.util.Scanner;

class BoardAFora implements Comparable<BoardAFora> {
    int vals[][];
    Integer depth;
    Integer custo;

    BoardAFora(int d){
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

    public void setCusto(BoardAFora f){
        custo = depth+heuristicforalugar(f);
    }

    public int heuristicforalugar(BoardAFora f){
        int count = 0;
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                if (vals[i][j]!=0){
                    if(vals[i][j] != f.vals[i][j]){count++;}
                }
            }
        }
        return count;
    }

    public boolean isSolvable(){
        return (findEmpty()[0]%2 == 1) == (NumberInversions()%2==0);
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

    public int compareTo(BoardAFora b) {if(custo==b.custo){
        return depth.compareTo(b.depth);}
        return custo.compareTo(b.custo);}

    public boolean InOrder(BoardAFora f){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(i!=3 || j!=3){
                    if(vals[i][j] != f.vals[i][j]){return false;}
            }
        }
    }
        return true;
    }

    public int[] findEmpty(){
        int[] res = new int[2];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(vals[i][j] == 0) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public boolean canUp()  {return findEmpty()[0] != 0;}
    public boolean canDown()  {return findEmpty()[0] != 3;}
    public boolean canLeft()  {return findEmpty()[1] != 0;}
    public boolean canRight()  {return findEmpty()[1] != 3;}

    public BoardAFora moveUp(){
        int[] empty = findEmpty();
        int x = empty[0];
        int y = empty[1];
        BoardAFora res = new BoardAFora(this.depth + 1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                res.vals[i][j] = this.vals[i][j];
            }
        }
        res.vals[x][y] = res.vals[x-1][y];
        res.vals[x-1][y] = 0;
        return res;
    }

    public BoardAFora moveDown(){
        int[] empty = findEmpty();
        int x = empty[0];
        int y = empty[1];
        BoardAFora res = new BoardAFora(this.depth + 1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                res.vals[i][j] = this.vals[i][j];
            }
        }
        res.vals[x][y] = res.vals[x+1][y];
        res.vals[x+1][y] = 0;
        return res;
    }

    public BoardAFora moveLeft(){
        int[] empty = findEmpty();
        int x = empty[0];
        int y = empty[1];
        BoardAFora res = new BoardAFora(this.depth + 1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                res.vals[i][j] = this.vals[i][j];
            }
        }
        res.vals[x][y] = res.vals[x][y-1];
        res.vals[x][y-1] = 0;
        return res;
    }

    public BoardAFora moveRight(){
        int[] empty = findEmpty();
        int x = empty[0];
        int y = empty[1];
        BoardAFora res = new BoardAFora(this.depth + 1);

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