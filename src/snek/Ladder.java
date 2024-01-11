package snek;

public class Ladder{
    private int ladderId;
    private int topSquareId;
    private int bottomSquareId;
    private boolean broken;

    public int getLadderId(){return ladderId;}
    public int getTopSquareId(){return topSquareId;}
    public int getBottomSquareId(){return bottomSquareId;}
    public boolean getBroken(){return broken;}

    public void setLadderId(int ladderId){this.ladderId=ladderId;}
    public void setTopSquareId(int topSquareId){this.topSquareId=topSquareId;}
    public void setBottomSquareId(int bottomSquareId){this.bottomSquareId=bottomSquareId;}
    public void setBroken(boolean broken){this.broken=broken;}
    
    public Ladder(int ladderId, int topSquareId, int bottomSquareId, boolean broken){
        setLadderId(ladderId);
        setTopSquareId(topSquareId);
        setBottomSquareId(bottomSquareId);
        setBroken(broken);
    }
}