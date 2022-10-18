package model;

public class Treasure {

    public static final int SIZE_OF_TREASURES = 50;
    
    private String name;
    private String imageURL;
    private int scoreForPlayer;
    private double randomPixelPosition;
    private Level level;
    private int amountPerLevel;


    public Treasure(String name, int scoreForPlayer, String imageURL, Level level, int amountPerLevel){
        this.name = name;
        this.imageURL = imageURL;
        this.scoreForPlayer = scoreForPlayer;
        this.level = level;
        this.amountPerLevel = amountPerLevel;

    }

    public String getTreasureName(){
		return name; 
	}

    public void setName(String name){
      this.name = name; 
	}

    public String getImageURL(){
		return imageURL; 
	}

  public void setImageURL(String imageURL){
		this.imageURL = imageURL; 
    }

  public int getScoreForPlayer(){
    return scoreForPlayer; 
    } 

  public void setLevel(Level level){
    this.level = level;
  }

  public Level getLevel(){
     return level;
  }
  
  public int getAmountPerLevel(){
    return amountPerLevel;
  }

  public void setAmountPerLevel(int amountPerLevel){
    this.amountPerLevel = amountPerLevel;
  }
	}

