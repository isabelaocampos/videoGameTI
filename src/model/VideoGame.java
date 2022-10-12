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

    private Player player;
    private Enemy enemy;
    private Treasure treasure;

    public VideoGame(){
        levels = new Level[TOTAL_OF_LEVELS];
        levels[0] = new Level("1", 20, 0, 0);
        levels[1] = new Level("2", 40, 0, 0);
        levels[2] = new Level("3", 80, 0, 0);
        levels[3] = new Level("4", 160, 0, 0);
        levels[4] = new Level("5", 320, 0, 0);
        levels[5] = new Level("6", 640, 0, 0);
        levels[6] = new Level("7", 1280, 0, 0);
        levels[7] = new Level("8", 2560, 0, 0);
        levels[8] = new Level("9", 5120, 0, 0);
        levels[9] = new Level("10", 10240, 0, 0);
        players = new Player[TOTAL_PLAYERS];
        enemies = new Enemy[TOTAL_OF_ENEMIES];
        treasures = new Treasure[TOTAL_OF_TREASURES];
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

    /**
    createPlayer: This method creates a new player in the game, with their information (nickname as an identifier and the name of 
    the player)
    * @param playerNickName: String: this parameter is the nickname of the player that is getting added, it will be the identifier.
	* @param playerName: String: this parameter is the name of the player that is getting added.
	* @return msj: String: There are two options as result, the first that assures that the user has been added and the second one is a message that
    notifies that the player cannot be added because the array of players is full.
	*/
    public String createPlayer(String playerNickName, String playerName){
        String msj = "Sorry, we have completed the 20 players.";
        boolean isEmpty = false;
        Player newPlayer = new Player(playerNickName, playerName, 0, 0, msj);
        for(int i=0; i < TOTAL_PLAYERS && !isEmpty; i++){
            if(players[i] == null){
                players[i] = newPlayer;
                isEmpty = true;
                msj = "Player added successfully";
            }
        }
        
        return msj;
    }

    /**
    assignEnemyToLevel: This method creates and adds an enemy to a level chosen by the user.
    * @param levelId: String: This parameter is the identifier of the level that the enemy is going to be assign to.
	* @param enemyName: String: This parameter is the name of the enemy that is getting added.
    * @param typeOfEnemy: String: This parameter is the type of enemy that it can be, there are four options (Ogre, Abstract, Boss and Magician).
    * @param ifBeatenScore: int: This parameter is the score that the player get's if it beats the enemy.
    * @param ifWinnerScore: int: This parameter is the score that the player loses if the enemy beats it.
	* @return msj: String: There are two options as result, the first that assures that the enemy has been added and the second one is a message that
    notifies that something unexpected happened.
	*/
    public String assignEnemyToLevel(String levelId, String enemyName, String typeOfEnemy, int ifBeatenScore, int ifWinnerScore){
        String msj = "Sorry, something unexpected happened. Please try again";
        Enemy newEnemy = new Enemy(enemyName, ifBeatenScore, ifWinnerScore, typeOfEnemy);
        int posLevel = searchLevelById(levelId);
        if (posLevel != -1){
            msj = levels[posLevel].addEnemyToLevel(newEnemy);
        }
        return msj;
    }
    /**
     * assignTreasureToLevel: This method creates and adds treasures to a level chosen by the user.
     * @param levelId: String: This parameter is the identifier of the level that the enemy is going to be assign to.
     * @param treasureName: String: This parameter is the name of the treasure.
     * @param scoreForPlayer: int: This parameter is the score that the player get's when it finds the treasure.
     * @param imageURL: String: This parameter is the URL of the image of the treasure, how this one looks.
     * @param amountPerLevel: int: This parameter is the amount of treasure that are in the level.
     * @return msj: String: There are two options as result, the first that assures that the treasure has been added and the second one 
     * is a message that notifies that something unexpected happened.
     */
    public String assignTreasureToLevel(String levelId, String treasureName, int scoreForPlayer, String imageURL, int amountPerLevel){
        String msj = "Sorry, something unexpected happened. Please try again";
        Treasure newTreasure = new Treasure(treasureName, scoreForPlayer, imageURL, amountPerLevel);
        int posLevel = searchLevelById(levelId);
        if (posLevel != -1){
            msj = levels[posLevel].addTreasureToLevel(newTreasure);
        }
        return msj;
    }


    /**
     * changePlayerLevel: This method changes a player from a level to another, the player has to have the score to pass the level, if it 
     * doesn't haved it cannot change it.
     * @param playerNickName: String: This parameter is the identifier of the player that is going to change levels.
     * @param levelToGo: String: This parameter is the level that the player is going to.
     * @return: msj: String: There are two options as result, the first that assures that the player has changed levels and the second one 
     * is a message that notifies that an error happened.
     */    
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

    /**
     * modifyPlayerScore: This method modifies the score of a player, it cannot change the score to a less than the one that has in the 
     * moment, it has to be greater than it.
     * @param playerNickName: String: This parameter is the identifier of the player that is going to have their score modify.
     * @param newPlayerScore: int: This parameter is the new score that the player is going to have.
     * @return: msj: String:
     */
    public String modifyPlayerScore(String playerNickName, int newPlayerScore){
        String msj = "";
        Player toChangeScore = searchPlayerByNickName(playerNickName);
        boolean isFound = false;
        for(int i = 0; i < TOTAL_PLAYERS && !isFound; i++){
            //if(players[i].getPlayerScore().(playerNickName)){

            //}
    }
        
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

    public Player searchScore(String nickName){
        Player foundScore = null;

        for(int i = 0; i < TOTAL_PLAYERS && foundScore == null; i++){
			if(players[i] != null && players[i].getPlayerScore().equals(nickName)){
				foundScore = players[i];
			}
		}
        return foundScore;
    }

}

