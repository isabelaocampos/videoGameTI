package model;

public class Level {
    
    public static final int SIZE_OF_ENEMIES = 25;
    public static final int SIZE_OF_TREASURES = 50;
    public static final int SIZE_OF_PLAYERS_PER_LEVEL = 5;

    private int levelId;
    private int scoreToPassLevel;

    public Enemy[] enemies;
    public Treasure[] treasures;
    public Player[] players;


    public Level(int levelId, int scoreToPassLevel){
        this.levelId = levelId;
        this.scoreToPassLevel = scoreToPassLevel; 
        enemies = new Enemy[SIZE_OF_ENEMIES];
        treasures = new Treasure[SIZE_OF_TREASURES];
        players = new Player[SIZE_OF_PLAYERS_PER_LEVEL];
    }

    public int getLevelId(){
        return levelId;
    }

    public void setLevelId(int levelId){
        this.levelId = levelId;

    }

    public int getScoreToPassLevel(){
        return scoreToPassLevel;
    }

    public String addEnemyToLevel(Enemy enemy){
        String msj ="You already created all 25 enemies";
        boolean isEmpty = false;
        for (int i = 0; i < SIZE_OF_ENEMIES && !isEmpty; i++){
            if(enemies[i] == null){
                enemies[i] = enemy;
                isEmpty = true;
                msj = "Enemy added successfully"; 
            }
        }
        return msj;
    }

    public String addTreasureToLevel(Treasure treasure){
        String msj = "You already created all 50 treasures";
        boolean isEmpty = false;
        for (int i = 0; i < SIZE_OF_TREASURES && !isEmpty; i++){
            if(treasures[i] == null){
                treasures[i] = treasure; 
                isEmpty = true;
                msj = "Treasure added successfully";
            }
        }

        return msj;
    }

    public String addPlayerWithObject(Player player){
        String msj = "Maximum capacity reached"; 
		boolean isEmpty = false; 
		for(int i = 0; i <SIZE_OF_PLAYERS_PER_LEVEL && !isEmpty; i++){
			if(players[i] == null){
				players[i] = player; 
				isEmpty = true; 
				msj = "Player added successfully"; 
			}
		}

		return msj;    
    }


    public int searchPlayerNickName(String playerNickName){
        int pos = -1;
        boolean isFound = false;
        for(int i = 0; i < SIZE_OF_PLAYERS_PER_LEVEL && !isFound; i++){
            if(players[i] !=null && players[i].getNickName().equals(playerNickName)){
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }

    public String deletePlayer(String playerNickName){
		String msj = "The player you want to delete cannot be found"; 
		int pos = searchPlayerNickName(playerNickName); 
		if(pos != -1){
			players[pos] = null; 
			msj = "The person has been eliminated"; 
		}
		return msj; 
	}

    
}
