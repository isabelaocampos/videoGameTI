package model;

public class Player {
    public static final int SIZE_OF_PLAYERS = 20;

    private String nickName;
    private String name;
    private int playerScore;
    private int amountOfLives; 
    private String currentLevel;


    private String[] nicknames = new String[SIZE_OF_PLAYERS]; 

    public Player(String nickName, String name, int playerScore, int amountOfLives, String currentLevel){
        this.nickName = nickName;
        this.name = name;
        this.playerScore = playerScore;
        this.amountOfLives = amountOfLives;
        this.currentLevel = currentLevel;
    }

    public String[] getNickNames(){
        return nicknames;
    }

    public String getName(){
        return name;
    }

    public String getNickName(){
        return nickName;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public int getPlayerScore(){
        return playerScore;
    }

    public int setPlayerScore(int playerScore){
        this.playerScore = 10;
        return this.playerScore;
    }

    public int setAmountOfLives(){
        amountOfLives = 5;
        return amountOfLives;
    }

    public String setCurrentLevel(){
        currentLevel = "1";
        return currentLevel;
    }


    
}
