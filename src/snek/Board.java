package snek;

import java.util.Random;

public class Board{
    public Snake[] snakes;
    public Ladder[] ladders;
    public Present[] presents;

    private int N, M; //diastaseis tou tamplo
    private int snakesCount;
    private int laddersCount;
    private int presentsCount;

    public int getN(){return N;}
    public int getM(){return M;}
    public int getSnakesCount(){return snakesCount;}
    public int getLaddersCount(){return laddersCount;}
    public int getPresentsCount(){return presentsCount;}

    public void setN(int N){this.N=N;}
    public void setM(int M){this.M=M;}
    public void setSnakesCount(int snakesCount){this.snakesCount=snakesCount;}
    public void setLaddersCount(int laddersCount){this.laddersCount=laddersCount;}
    public void setPresentsCount(int presentsCount){this.presentsCount=presentsCount;}

    public Board(int N, int M, int snakesCount, int laddersCount, int presentsCount){
        setN(N);
        setM(M);
        setSnakesCount(snakesCount);
        setLaddersCount(laddersCount);
        setPresentsCount(presentsCount);
        this.snakes=new Snake[snakesCount]; //pinakas me fidia
        this.ladders=new Ladder[laddersCount]; //pinakas me skales
        this.presents=new Present[presentsCount]; // pinakas me dwra
    }

    
    
    public void createElementBoard(){
        Random random=new Random();
        random.setSeed((long)System.currentTimeMillis());

        for(int i=0;i<snakesCount;i++){
            int low=random.nextInt(N*M+1);
            int high=random.nextInt(N*M+1);
            while(low>=high){
                low=random.nextInt(N*M+1);
                high=random.nextInt(N*M+1);
            }
            snakes[i]=new Snake(i,high,low);
        }
        for(int i=0;i<laddersCount;i++){
            int low=random.nextInt(N*M+1);
            int high=random.nextInt(N*M+1);
            while(low>=high){
                low=random.nextInt(N*M+1);
                high=random.nextInt(N*M+1);
            }
            ladders[i]=new Ladder(i,high,low,false);
        }
        for(int i=0;i<presentsCount;i++){
            presents[i]=new Present(i,random.nextInt(N*M),(int)Math.pow(-1,random.nextInt(2))*(random.nextInt(50)+1));
        }
    }
    public void createBoard(){
        for(int i=N*M,newLine=0;i>=0;i--){
            if(newLine%10==0){
                System.out.print("\n");
                newLine++;
            }
            else{
                newLine++;
            }
            System.out.print(i+" ");
            for(int j=0;j<snakesCount;j++){
                if(snakes[j].getHeadId()==i){
                    System.out.print("SH"+snakes[j].getSnakeId()+" ");
                }
                if(snakes[j].getTailId()==i){
                    System.out.print("ST"+snakes[j].getSnakeId()+" ");
                }
            }
            for(int j=0;j<laddersCount;j++){
                if(ladders[j].getTopSquareId()==i){
                    System.out.print("LT"+ladders[j].getLadderId()+" ");
                }
                if(ladders[j].getBottomSquareId()==i){
                    System.out.print("LB"+ladders[j].getLadderId()+" ");
                }
            }
            for(int j=0;j<presentsCount;j++){
                if(presents[j].getPresentSquareId()==i){
                    System.out.print("PR"+presents[j].getPresentId()+" Points: "+presents[j].getPoints());
                }
            }
            System.out.print("|");
        }    
    }   
}
