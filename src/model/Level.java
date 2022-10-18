package model;

public class Level {


    private int levelId;
    private int scoreToPassLevel;

    public Level(int levelId, int scoreToPassLevel){
        this.levelId = levelId;
        this.scoreToPassLevel = scoreToPassLevel; 

    }

    public int getLevelId(){
        return levelId;
    }

    public int getScoreToPassLevel(){
        return scoreToPassLevel;
    }

    
}
