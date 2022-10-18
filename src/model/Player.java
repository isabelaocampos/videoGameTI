package model;

public class Player {

    private String nickName;
    private String name;
    private int playerScore; 
    private Level level;


    public Player(String nickName, String name, Level level){
        this.nickName = nickName;
        this.name = name;
        playerScore = 10;
        this.level = level;

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
