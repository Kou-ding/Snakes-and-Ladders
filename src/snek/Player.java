package snek;

public class Player{
    private int playerId;
    private String name;
    private int score;
    private int position;
    private Board currentBoard;

    public int getPlayerId(){return playerId;}
    public String getName(){return name;}
    public int getScore(){return score;}
    public int getPosition(){return position;}
    public Board getCurrentBoard(){return currentBoard;}

    public void setPlayerId(int playerId){this.playerId=playerId;}
    public void setName(String name){this.name=name;}
    public void setScore(int score){this.score=score;}
    public void setPosition(int position){this.position=position;}
    public void setCurrentBoard(Board currentBoard){this.currentBoard=currentBoard;}

    public Player(int playerId,String name,int position,int score,Board currentBoard){
        setPlayerId(playerId);
        setName(name);
        setScore(score);
        setPosition(position);
        setCurrentBoard(currentBoard);
    }
    
    public void move(int dice,Player currentPlayer){
        currentPlayer.position=currentPlayer.position+dice;
        System.out.println("You rolled: "+dice);
    }

    public void printPlayerInfo(){
        String playerInfo=new String("Player position: "+getPosition()+"\n"+"Player score: "+(getScore()+getPosition())+"\n");
        System.out.println(playerInfo);
    }
    
    public int finalScoreCalc(){
        int finalScore=getScore()+getPosition();
        return finalScore;
    }
}