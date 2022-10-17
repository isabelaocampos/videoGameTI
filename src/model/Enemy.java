package model;
import java.util.Random;

public class Enemy{
    public static final int SIZE_OF_ENEMIES = 25;

    private String name; 
    private int ifBeatenScore;
    private int ifWinnerScore;
    private double randomPixelPosition;
    private TypeEnemy typeOfEnemy;
    private Level level;
    private int posX;
    private int posY;

    public Enemy(String name, int ifBeatenScore, int ifWinnerScore, int typeOfEnemy, Level level, int resolutionX, int resolutionY){
        this.name = name;
        this.ifBeatenScore = ifBeatenScore;
        this.ifWinnerScore = ifWinnerScore;  
        this.level = level;
        Random random = new Random();
        posX = random.nextInt(resolutionX);
        posY = random.nextInt(resolutionY);

        switch(typeOfEnemy){
            case 1:
                this.typeOfEnemy = TypeEnemy.OGRE;
                break;

            case 2:
                this.typeOfEnemy = TypeEnemy.ABSTRACT;
                break;

            case 3:
                this.typeOfEnemy = TypeEnemy.BOSS;
                break;

            case 4:
                this.typeOfEnemy = TypeEnemy.MAGICIAN;
                break;         
        }
    }

    public String getEnemyName(){
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

    public int getTypeOfEnemy(){
        switch(typeOfEnemy){
            case OGRE:
                return 1;

            case ABSTRACT:
                return 2;
            case BOSS: 
                return 3;
            case MAGICIAN:
                return 4;
            default:
                return 0;
        }
        
    }

    public String addEnemy(Enemy newEnemy) {
        return null;
    }

    public void setTypeEnemy(){
    
    }

    public void setLevel(Level level){
        this.level = level;
    }

    public Level getLevel(){
        return level;
    }
}