package model;

public class Player {
    public static final int SIZE_OF_PLAYERS= 20;
    private String nickName;
    private String name;
    private int playerScore; 
    private Level level;

    private Player player;


    public Player(String nickName, String name, Level level){
        this.nickName = nickName;
        this.name = name;
        playerScore = 10;
        this.level = level;

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

    public void setPlayerScore(int playerScore){
        this.playerScore = playerScore;
    }

    public void setLevel(Level level){
        this.level = level;
    }

    public Level getLevel(){
        return level;
    }

    
}
