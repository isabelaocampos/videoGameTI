package model;

public class Treasure {

    public static final int SIZE_OF_TREASURES = 50;
    
    private String name;
    private String imageURL;
    private int scoreForPlayer;
    private double randomPixelPosition;
    private int amountPerLevel;


    public Treasure(String nname, int sscoreForPlayer, String iimageURL, int aamountPerLevel){
        name = nname;
        imageURL = iimageURL;
        scoreForPlayer = sscoreForPlayer;
        amountPerLevel = aamountPerLevel;

    }

    public String getName(){
		return name; 
	}

    public void setName(String nname){
		name = nname; 
	}

    public String getImageURL(){
		return imageURL; 
	}

  public void setImageURL(String iimageURL){
		imageURL = iimageURL; 
    }

    public int getScoreForPlayer(){
     return scoreForPlayer; 
    } 
    
	}

