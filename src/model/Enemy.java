package model;


public class Enemy{
    public static final int SIZE_OF_ENEMIES = 25;

    private String name; 
    private int ifBeatenScore;
    private int ifWinnerScore;
    private double randomPixelPosition;
    private String typeOfEnemy;

    public Enemy(String name, int ifBeatenScore, int ifWinnerScore, String typeOfEnemy){
        this.name = name;
        this.ifBeatenScore = ifBeatenScore;
        this.ifWinnerScore = ifWinnerScore;
        this.typeOfEnemy = typeOfEnemy;  
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

    public void setTypeEnemy(){
    
    }
}