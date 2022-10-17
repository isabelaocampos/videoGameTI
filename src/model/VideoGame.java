package model;

import java.util.EnumMap;

public class VideoGame{

    public static final int TOTAL_PLAYERS = 20;
    public static final int TOTAL_OF_LEVELS = 10;
    public static final int TOTAL_OF_ENEMIES = 25;
    public static final int TOTAL_OF_TREASURES = 50;
    public static final int TOTAL_SCORES = 20;

    private int resolutionX;
    private int resolutionY;
    private Player[] players;
    private static Enemy[] enemies;
    private Level[] levels;
    private Treasure[] treasures;

    private Player player;
    private Enemy enemy;
    private Treasure treasure;

    public VideoGame(){
        resolutionX = 1280;
        resolutionY = 720;
        players = new Player[TOTAL_PLAYERS];
        enemies = new Enemy[TOTAL_OF_ENEMIES];
        treasures = new Treasure[TOTAL_OF_TREASURES];

        for(int i = 0; i < TOTAL_OF_LEVELS; i++){
            levels[i] = new Level(i + 1,(i + 1)*20);
        }
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

    //
    public String createPlayer(String playerNickName, String playerName){
        String msj = "Sorry, we have completed the 20 players.";
        boolean isEmpty = false;
        Player newPlayer = new Player(playerNickName, playerName, 0, 0, null);
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

    //
    public String assignEnemyToLevel(int levelId, String enemyName, int typeOfEnemy, int ifBeatenScore, int ifWinnerScore){
        String msj = "Sorry, something unexpected happened. Please try again";
        Enemy newEnemy = new Enemy(enemyName, ifBeatenScore, ifWinnerScore, typeOfEnemy,levels[levelId-1],resolutionX,resolutionY);
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

    //
    public String assignTreasureToLevel(int levelId, String treasureName, int scoreForPlayer, String imageURL){
        String msj = "Sorry, something unexpected happened. Please try again";
        Treasure newTreasure = new Treasure(treasureName, scoreForPlayer, imageURL, levels[levelId-1]);
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

    //
    public String changePlayerLevel(String playerNickName){
        String msj = "Sorry, an error happened. Try again";

        for(int i = 0; i < TOTAL_PLAYERS; i++){
            if(players[i] != null && players[i].getNickName().equalsIgnoreCase(playerNickName)){

                if(players[i].getPlayerScore()< players[i].getLevel().getScoreToPassLevel()){
                    msj = "Sorry the score the player has is not enough to pass level, try again";

                }else if(players[i].getLevel().getLevelId()== 10){ 
                    msj ="The player has reached the maximum level available";

                }else{
    
                    players[i].setLevel(levels[players[i].getLevel().getLevelId()]);
                    msj +="\n Leveled up: " +players[i].getLevel().getLevelId() + "\n";
                }
            }
        }
        return msj;
    }

    /**
     * modifyPlayerScore: This method modifies the score of a player, it cannot change the score to a less than the one that has in the 
     * moment, it has to be greater than it.
     * @param playerNickName: String: This parameter is the identifier of the player that is going to have their score modify.
     * @param newPlayerScore: int: This parameter is the new score that the player is going to have.
     * @return: msj:
     */

     //
    public String modifyPlayerScore(String playerNickName, int newPlayerScore){
        String msj ="Sorry we couldn't change the score, try again";

        for(int i = 0; i<TOTAL_PLAYERS; i++){
            if(players[i] != null && players[i].getNickName().equalsIgnoreCase(playerNickName)){

                if(players[i].getPlayerScore()>= newPlayerScore){
                    msj = "Sorry, you can only change the score with a greater socre than the actual one";

                }else{
                    players[i].setPlayerScore(newPlayerScore);}
                    msj = "Score changed successfully";
                }
            }
        
        return msj;
    }

    /**
     * sameEnemyInLevel: String: This method list all the enemies of the same type that are in all levels.
     * @param enemyType: String: This parameter is the type of enemy that the user wants to know.
     * @return: msj; String: A list with the levels where the type of enemy is.
     */
    public String sameEnemyInGame(int enemyType){
        String msj ="Enemies found: ";
        int counter = 0;
        for(int i = 0; i < TOTAL_OF_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getTypeOfEnemy() == enemyType){
                counter ++;
            }
        }
        if(counter == 0){
            msj="Sorry we couldn't find any enemies";
        }else{
            msj += counter;
        }
        return msj;
    }
        
    public String sameTreasureInGame(String treasureName){
        String msj = "Treasures found: ";
        int counter = 0;
        for(int i = 0; i < TOTAL_OF_TREASURES; i++){
            if(treasures[i] != null && treasures[i].getTreasureName().equalsIgnoreCase(treasureName)){
                counter ++;
            }
        }
        if(counter == 0 ){
            msj ="Sorry we couldn't any treasures";
        }else{
            msj += counter;
        }
        return msj;
    }

    /**
     * printLevels: String: This method list all the levels that the game has, with their information.
     * @return: msj: String: A list of the levels with their information.
     */
    public String printLevels(){
        String msj = "";
        for(int i = 0; i < TOTAL_OF_LEVELS; i++){
            if(levels[i] != null){
                msj += "Level " + levels[i].getLevelId() + "Score to pass level: " + levels[i].getScoreToPassLevel();
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

    public String topFivePlayers(){
        String msj = "";

        return msj;
    }

    public String allEnemies(int type){
        String msj ="Enemigos encontrados: ";
        int counter = 0;
        for(int i = 0; i < TOTAL_OF_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getTypeOfEnemy() == type){
                counter ++;
            }
        }
        if(counter == 0){
            msj="No existen enemigos";
        }else{
            msj += counter;
        }
        return msj;
    }

    public String mostReapeatedTreasure(){
        String msj = "Treasure found: ";
        int counter = 0;
        int maxAmountTreasure = 0;
        String maxNameTreasure = null;
        for(int i = 0; i< TOTAL_OF_TREASURES; i++){

            for(int j = 0; j < TOTAL_OF_TREASURES; j++){
                if(treasures[i]!=null && treasures[j]!= null && treasures[i].getTreasureName().equalsIgnoreCase(treasures[j].getTreasureName())){
                    counter ++;
                }
            
            }
            if(counter > maxAmountTreasure ){
                maxAmountTreasure =counter;
                maxNameTreasure = treasures[i].getTreasureName();
            }
        }
        msj += maxAmountTreasure;

        return msj;

    }

    public String listEnemies(int level){
        String msj ="Enemies: ";

        for(int i = 0; i < TOTAL_OF_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getLevel().getLevelId()==level){
                msj += enemies[i].getEnemyName() + ", ";
            }
        }

        return msj;
    }

    public String listTreasure(int level){
        String msj ="Treasures: ";

        for(int i = 0; i < TOTAL_OF_TREASURES; i++){
            if(treasures[i] != null && treasures[i].getLevel().getLevelId()==level){
                msj += treasures[i].getTreasureName() + ", ";
            }
        }

        return msj;
    }



    //////////////////////////////////////////////////

    public void addChangedPlayerToLevel(Player toAdd, int levelId){
        String msj = "Player cannot be added to level";
        int pos = searchLevelById(levelId); 
        if(pos != -1){
            msj = levels[pos].addPlayerWithObject(toAdd);
        }
    }

    public int searchLevelById(int levelId){
        int pos = -1;
        boolean isFound = false;
        for(int i = 0; i < TOTAL_OF_ENEMIES && !isFound; i++){
            if(levels[i].getLevelId() == (levelId)){
                pos = i;
                isFound = true;
            }
        }
        return pos;

    }

    //
    public Player searchPlayerByNickName(String nickName){
		Player foundPlayer = null;
		for(int i=0; i < TOTAL_PLAYERS && foundPlayer == null; i++){
			if(players[i] !=null && players[i].getNickName().equalsIgnoreCase(nickName)){
				foundPlayer = players[i];
			}
		}
		return foundPlayer;
	}
    
    public Enemy searchEnemyByName(String enemyName){
		Enemy foundPlayer = null;
		for(int i=0; i < TOTAL_PLAYERS && foundPlayer == null; i++){
			if(enemies[i] !=null && enemies[i].getEnemyName().equalsIgnoreCase(enemyName)){
				foundPlayer = enemies[i];
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

    public String emptySpacePlayers(){
        String msj ="available position";
        if(players[0] == null){
            msj = "0 players";
        }else if(players[TOTAL_PLAYERS-1] != null){
            msj = "reached limit";
        }
        return msj;
    } 

    public String emptySpaceEnemies(){
        String msj ="available position";
        if(enemies[0] == null){
            msj = "0 enemies";
        }else if(enemies[TOTAL_OF_ENEMIES-1] != null){
            msj = "reached limit";
        }
        return msj;
    }

    public String emptySpaceTreasures(){
        String msj ="available position";
        if(treasures[0]==null){
            msj = "0 treasures";
        }else if(treasures[TOTAL_OF_TREASURES-1] != null){
            msj = "reached limit";
        }
        return msj;
    }

}

