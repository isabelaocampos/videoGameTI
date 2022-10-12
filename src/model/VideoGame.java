package model;


public class VideoGame{

    public static final int TOTAL_PLAYERS = 20;
    public static final int TOTAL_OF_LEVELS = 10;
    public static final int TOTAL_OF_ENEMIES = 25;
    public static final int TOTAL_OF_TREASURES = 50;
    public static final int TOTAL_SCORES = 20;

    private Player[] players;
    private Enemy[] enemies;
    private Level[] levels;
    private Treasure[] treasures;

    private Level level;
    private Player player;
    private Enemy enemy;
    private Treasure treasure;

    public VideoGame(){
        players = new Player[TOTAL_PLAYERS];
        enemies = new Enemy[TOTAL_OF_ENEMIES];
        treasures = new Treasure[TOTAL_OF_TREASURES];
        levels = new Level[TOTAL_OF_LEVELS];
    }

    public Player getPlayer(){
        return player;

    }

    public Enemy getEnemy(){
        return enemy;
    }

    public Player[] getTotPlayers(){
        return players;
    }

    public Treasure[] getTotalTreasures(){
        return treasures;
    }

    public Level[] getLevels(){
        return levels;
    }

    public String createPlayer(String playerNickName, String playerName){
        String msj = "Sorry, we have completed the 20 players.";
        boolean isEmpty = false;
        Player newPlayer = new Player(playerNickName, playerName, 0, 0, msj, msj);
        for(int i=0; i < TOTAL_PLAYERS && !isEmpty; i++){
            if(players[i] == null){
                players[i] = newPlayer;
                isEmpty = true;
                msj = "Player added successfully";
            }
        }
        
        return msj;
    }

    public String assignEnemyToLevel(String levelId, String enemyName, String typeOfEnemy, int ifBeatenScore, int ifWinnerScore){
        String msj = "Sorry, something unexpected happened. Please try again";
        Enemy newEnemy = new Enemy(enemyName, ifBeatenScore, ifWinnerScore, typeOfEnemy);
        int posLevel = searchLevelById(levelId);
        if (posLevel != -1){
            msj = levels[posLevel].addEnemyToLevel(newEnemy);
        }
        return msj;
    }

    public String assignTreasureToLevel(String levelId, String treasureName, int scoreForPlayer, String imageURL, int amountPerLevel){
        String msj = "Sorry, something unexpected happened. Please try again";
        Treasure newTreasure = new Treasure(treasureName, scoreForPlayer, imageURL, amountPerLevel);
        int posLevel = searchLevelById(levelId);
        if (posLevel != -1){
            msj = levels[posLevel].addTreasureToLevel(newTreasure);
        }
        return msj;
    }


        
    public String changePlayerLevel(String playerNickName, String levelToGo){
        String msj = "An error has happen. Try again";
        Player toChange = searchPlayerByNickName(playerNickName);
        int levelToLeave = -1;
        if(toChange != null){
            levelToLeave = playerLocation(playerNickName);
        }
        if(levelToLeave != -1){
            levels[levelToLeave].deletePlayer(playerNickName);
            addChangedPlayerToLevel(toChange, levelToGo);
            msj = "PLayer has been successfully changed";
        }

        return msj;
    }

    public String modifyPlayerScore(String playerNickName, String newPlayerScore){
        String msj = "";
        Player toChangeScore = searchPlayerByNickName(playerNickName);
        return msj;
    }

    public static String SameEnemyInLevel(String levelId, String enemyName){
        String msj = "";
        
        
        return msj;
    }

    public String printLevels(){
        String msj = "";
        for(int i = 0; i < TOTAL_OF_LEVELS; i++){
            if(levels[i] != null){
                msj += "Level " + levels[i].getLevelId();
            }   
        }
        return msj; 
    }

    public String printPlayers(){
        String msj = "";
        for(int i = 0; i < TOTAL_OF_LEVELS; i++){
            if(players[i] != null){
                msj += "Level " + players[i].getNickName();
            }   
        }
        return msj; 
    }

    //public String topFivePlayers(){
        
    //6}

    //////////////////////////////////////////////////

    public void addChangedPlayerToLevel(Player toAdd, String levelId){
        String msj = "Player cannot be added to level";
        int pos = searchLevelById(levelId); 
        if(pos != -1){
            msj = levels[pos].addPlayerWithObject(toAdd);
        }
    }

    public int searchLevelById(String levelId){
    int pos = -1;
    boolean isFound = false;
    for(int i = 0; i < TOTAL_OF_ENEMIES && !isFound; i++){
        if(levels[i].getLevelId().equalsIgnoreCase(levelId)){
            pos = i;
            isFound = true;
        }
    }
    return pos;
}

    public Player searchPlayerByNickName(String nickName){
		Player foundPlayer = null;
		for(int i=0; i < TOTAL_PLAYERS && foundPlayer ==null; i++){
			if(players[i] !=null && players[i].getNickName().equalsIgnoreCase(nickName)){
				foundPlayer = players[i];
			}
		}
		return foundPlayer;
	}

    public int playerLocation(String nickNameToFind){

		int levelIndex = -1;
		for(int i=0; i< TOTAL_OF_LEVELS && levelIndex == -1; i++){
			if(levels[i] != null && levels[i].searchPlayerNickName(nickNameToFind)!=-1){
				levelIndex=i;
			}
		}
		return levelIndex;

	}

    public boolean notTheSameNickName(String nickName){
        Player foundNickName = null;
        boolean nickNameNotAble = false;
        for(int i=0; i < TOTAL_PLAYERS && foundNickName ==null; i++){
			if(players[i] !=null && players[i].getNickName().equalsIgnoreCase(nickName)){
				foundNickName = players[i];
                nickNameNotAble = true;
			}
		}
        return nickNameNotAble;
    }

}

