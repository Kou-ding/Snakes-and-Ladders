package snek;

public class Present{
    private int presentId;
    private int presentSquareId;
    private int points;

    public int getPresentId(){return presentId;}
    public int getPresentSquareId(){return presentSquareId;}
    public int getPoints(){return points;}

    public void setPresentId(int presentId){this.presentId=presentId;}
    public void setPresentSquareId(int presentSquareId){this.presentSquareId=presentSquareId;}
    public void setPoints(int points){this.points=points;}

    public Present(int presentId, int presentSquareId, int points){
        setPresentId(presentId);
        setPresentSquareId(presentSquareId);
        setPoints(points);
    }
}