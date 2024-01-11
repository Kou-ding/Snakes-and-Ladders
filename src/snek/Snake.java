package snek;

public class Snake{
    private int snakeId;
    private int headId;
    private int tailId;
    
    public int getSnakeId(){return snakeId;}
    public int getHeadId(){return headId;}
    public int getTailId(){return tailId;}
    
    public void setSnakeId(int snakeId){this.snakeId=snakeId;}
    public void setHeadId(int headId){this.headId=headId;}
    public void setTailId(int tailId){this.tailId=tailId;}
    
    public Snake(int snakeId, int headId, int tailId){
        setSnakeId(snakeId);
        setHeadId(headId);
        setTailId(tailId);
    }
}