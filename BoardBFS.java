import java.util.Scanner;

class BoardBFS implements Comparable<BoardBFS> {
    int vals[][];
    int depth;

    BoardBFS(int d){
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

    public int heuristicforalugar(){
        int count = 0;
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                if (i == 3 && j == 3){if(vals[i][j]!=0){count++;}}
                else if(vals[i][j] != i*4 + j +1){count++;}
            }
        }
        return count;
    }

    public int heuristicmanhattan(){
        int sum = 0;
        for(int i = 0;i<4;i++){
           for(int j = 0;j<4;j++){
            int temp = vals[i][j];
            if (temp == 0){sum+=Math.abs(i-3)+Math.abs(j-3);}
            else{sum += Math.abs(i -(temp-1)/4) + Math.abs(j-((temp-1)%4));}
           }
        }
        return sum;
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

    public int compareTo(BoardBFS b) {return orderValue().compareTo(b.orderValue());}

    public boolean InOrder(BoardBFS f){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(vals[i][j] != f.vals[i][j]){return false;}
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

    public BoardBFS moveUp(){
        int[] empty = findEmpty();
        int x = empty[0];
        int y = empty[1];
        BoardBFS res = new BoardBFS(this.depth + 1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                res.vals[i][j] = this.vals[i][j];
            }
        }
        res.vals[x][y] = res.vals[x-1][y];
        res.vals[x-1][y] = 0;

        return res;
    }

    public BoardBFS moveDown(){
        int[] empty = findEmpty();
        int x = empty[0];
        int y = empty[1];
        BoardBFS res = new BoardBFS(this.depth + 1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                res.vals[i][j] = this.vals[i][j];
            }
        }
        res.vals[x][y] = res.vals[x+1][y];
        res.vals[x+1][y] = 0;

        return res;
    }

    public BoardBFS moveLeft(){
        int[] empty = findEmpty();
        int x = empty[0];
        int y = empty[1];
        BoardBFS res = new BoardBFS(this.depth + 1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                res.vals[i][j] = this.vals[i][j];
            }
        }
        res.vals[x][y] = res.vals[x][y-1];
        res.vals[x][y-1] = 0;

        return res;
    }

    public BoardBFS moveRight(){
        int[] empty = findEmpty();
        int x = empty[0];
        int y = empty[1];
        BoardBFS res = new BoardBFS(this.depth + 1);

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