import snek.Board;
import snek.Player;

import java.util.Scanner;
import java.util.Random;

public class Game{
    private int round;
    private Player[] players; 

    public int getRound(){return round;}
    public Player[] getPlayers(){return players;};

    public void setRound(int round){this.round=round;}
    public void setPlayers(Player[] players){this.players=players;}
    public Game(int round,Player[] players){
        setRound(round);
        setPlayers(players);
    } 
    public  static  void  main(String[] args){
        System.out.println("");
        System.out.println("           /^\\/^\\");
        System.out.println("         _|__|  O|");
        System.out.println(" \\/    /~     \\_/ \\");
        System.out.println("  \\____|__________/ \\");
        System.out.println("        \\_______      \\");
        System.out.println("                 `\\    \\                      \\");
        System.out.println("                  |     |                      \\");
        System.out.println("                 /      /                       \\");
        System.out.println("                /      /                         \\\\");
        System.out.println("               /      /                           \\ \\");
        System.out.println("              /      /           _-~-_             \\  \\");
        System.out.println("            /       /         _-~      ~-_          |  |");
        System.out.println("           (       (       _-~    _--_   ~-_      _/   |");
        System.out.println("           \\       ~-____-~    _-~     ~-_   ~-_-~    /");
        System.out.println("             ~-_           _-~           ~-_       _-~");
        System.out.println("                ~--______-~Snakes And Ladders~-__-~");

        //Initialize Random Object, Board, Players, dice
        Random random=new Random();
        random.setSeed((long)System.currentTimeMillis());

        Board initBoard=new Board(10,10,6,6,6);
        initBoard.createElementBoard();

        Player[] players=new Player[2];
        players[0]=new Player(1,"",0,0,initBoard);
        players[1]=new Player(2,"",0,0,initBoard);
        
        int dice1=0,dice2=0; 

        //get player names
        System.out.println("Enter your names:");
        //Initialize Scanner object to scan names and wait for Enter
        Scanner sc = new Scanner(System.in);
        String username1 = sc.nextLine();
        String username2 = sc.nextLine();

        while(dice1==dice2){
            //prompt player 1 to press enter
            System.out.println(username1+" press Enter to roll the dice:");
            //wait for enter to be pressed
            String waitEnter0 = sc.nextLine();
            
            //roll the dice 
            dice1=random.nextInt(6)+1;
            System.out.println("You rolled: "+dice1);
            //wait for enter to be pressed
            String waitEnter1 = sc.nextLine();

            //prompt player 2 to press enter
            System.out.println(username2+" press Enter to roll the dice:");
            //wait for enter to be pressed
            String waitEnter2 = sc.nextLine();
            
            //roll the dice
            dice2=random.nextInt(6)+1;
            System.out.println("You rolled: "+dice2);
            //wait for enter to be pressed
            String waitEnter3 = sc.nextLine();
        }
        //players[0] always plays first. That's why we need to assign the dice-roll-winner's username to player 1 
        if(dice1>dice2){
            players[0].setName(username1);
            players[1].setName(username2);
        }
        else{
            players[0].setName(username2);
            players[1].setName(username1);
        }
        
        for(int round=0,n=0;round<100;round++){
            //create and display the board each round
            initBoard.createBoard();

            //current player playing counter
            n=round%2;

            //prompt player to press enter
            System.out.println("\n"+players[n].getName()+" ( Position: "+players[n].getPosition()+" ) press Enter to roll the dice:");
            
            //wait for enter to be pressed
            String waitEnter0 = sc.nextLine();
           
            //move player to a certain position according to the dice 
            players[n].move((random.nextInt(6)+1),players[n]); //prints dice

            //wait for enter to be pressed
            String waitEnter1 = sc.nextLine();
            
            //if he steps on a present do this. Presents have higher priority than ladders or snakes 
            //which means that the player will get the present first and then climb a ladder or get eaten by a snake
            for(int i=0;i<initBoard.getPresentsCount();i++){
                if(players[n].getPosition()==initBoard.presents[i].getPresentSquareId()){
                    players[n].setScore(players[n].getScore()+initBoard.presents[i].getPoints());
                    initBoard.presents[i].setPoints(0);
                }
            }

            //if he steps on a ladder do this. Climbing a ladder has higher priority than getting eaten by a snake
            for(int i=0;i<initBoard.getLaddersCount();i++){
                if(players[n].getPosition()==initBoard.ladders[i].getBottomSquareId()){
                    if(initBoard.ladders[i].getBroken()==false){
                        players[n].setPosition(initBoard.ladders[i].getTopSquareId());
                        initBoard.ladders[i].setBroken(true);
                    } 
                }
            }

            //if he steps on a snake do this 
            for(int i=0;i<initBoard.getSnakesCount();i++){
                if(players[n].getPosition()==initBoard.snakes[i].getHeadId()){
                    players[n].setPosition(initBoard.snakes[i].getTailId());
                }
            }

            //print his current position and score
            System.out.println("[ "+players[n].getName()+" ]");
            players[n].printPlayerInfo(); 

            //wait for enter to be pressed
            String waitEnter2 = sc.nextLine();
           
            //break for loop if any of the two players get to the end
            if(players[n].getPosition()>=(initBoard.getN()*initBoard.getM())){
                break;
            }
        }
        //Determine the winner
        if(players[0].finalScoreCalc()>players[1].finalScoreCalc()){
            System.out.println("WINNER: "+players[0].getName());
        }
        else if(players[0].finalScoreCalc()<players[1].finalScoreCalc()){
            System.out.println("WINNER: "+players[1].getName());
        }
        else{
            System.out.println("It's a Draw.");
        } 
        sc.close();
    }
    
}