package model;


public class Enemy{
    public static final int SIZE_OF_ENEMIES = 25;

    private String name; 
    private int ifBeatenScore;
    private int ifWinnerScore;
    private double randomPixelPosition;
    private String typeOfEnemy;

    public Enemy(String nname, int iifBeatenScore, int iifWinnerScore, String ttypeOfEnemy){
        name = nname;
        ifBeatenScore = iifBeatenScore;
        ifWinnerScore = iifWinnerScore;
        typeOfEnemy = ttypeOfEnemy;  
    }

    public String getName(){
        return name;
    }

    public int getifBeatenScore(){
        return ifBeatenScore;
    }

    public int getifWinnerScore(){
        return ifWinnerScore;
    }

    public double getRandomPixelPosition(){
        return randomPixelPosition;
    }

    public String getTypeOfEnemy(){
        return typeOfEnemy;
    }

    public String addEnemy(Enemy newEnemy) {
        return null;
    }

}