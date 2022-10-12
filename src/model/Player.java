package model;

public class Player {
    public static final int SIZE_OF_PLAYERS = 20;

    private String nickName;
    private String name;
    private int initialScore;
    private int amountOfLives; 
    private String currentLevel;
    private String scoreToPassCurrentLevel;

    private String[] nicknames = new String[SIZE_OF_PLAYERS]; 

    public Player(String nnickName, String nname, int iinitialScore, int aamountOfLives, String ccurrentLevel, String sscoreToPassCurrentLevel){
        nickName = nnickName;
        name = nname;
        initialScore = iinitialScore;
        amountOfLives = aamountOfLives;
        currentLevel = ccurrentLevel;
        scoreToPassCurrentLevel = sscoreToPassCurrentLevel;
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

    public void setNickName(String nnickName){
        nickName = nnickName;
    }

    public int setInitialScore(int iinitialScore){
        initialScore = 10;
        return initialScore;
    }

    public int setAmountOfLives(){
        amountOfLives = 5;
        return amountOfLives;
    }

    public String setCurrentLevel(){
        currentLevel = "1";
        return currentLevel;
    }

    public String getScoreToPassCurrentLevel(){
        return scoreToPassCurrentLevel;
    }

    
}
