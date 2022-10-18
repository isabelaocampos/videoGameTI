package model;


public class VideoGame{

    public static final int TOTAL_PLAYERS = 20;
    public static final int TOTAL_OF_LEVELS = 10;
    public static final int TOTAL_OF_ENEMIES = 25;
    public static final int TOTAL_OF_TREASURES = 50;

    private int resolutionX;
    private int resolutionY;
    private Player[] players;
    private Enemy[] enemies;
    private Level[] levels;
    private Treasure[] treasures;

    

    public VideoGame(){
        resolutionX = 1280;
        resolutionY = 720;
        levels = new Level[TOTAL_OF_LEVELS];
        players = new Player[TOTAL_PLAYERS];
        enemies = new Enemy[TOTAL_OF_ENEMIES];
        treasures = new Treasure[TOTAL_OF_TREASURES];

        for(int i = 0; i < TOTAL_OF_LEVELS; i++){
            levels[i] = new Level(i + 1,(i + 1)*20);
        }
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
        for(int i=0; i < TOTAL_PLAYERS && !isEmpty; i++){
            if(players[i] == null){
                players[i] = new Player(playerNickName, playerName, levels[0]);
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
        boolean isEmpty = false;
        for(int i = 0; i < TOTAL_OF_ENEMIES && !isEmpty; i++){
        if (enemies[i] == null){
            enemies[i] = new Enemy(enemyName, ifBeatenScore, ifWinnerScore, typeOfEnemy,levels[levelId-1],resolutionX,resolutionY);
            msj = "Enemy added successfully";
        }
        
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
    public String assignTreasureToLevel(int levelId, String treasureName, int scoreForPlayer, String imageURL, int amountPerLevel){
        String msj = "Sorry, something unexpected happened. Please try again";
        boolean isEmpty = false;
        for(int i = 0; i < TOTAL_OF_TREASURES && !isEmpty; i++){
            if(treasures[i] == null){
                treasures[i] =  new Treasure(treasureName, scoreForPlayer, imageURL, levels[levelId-1], amountPerLevel);
                isEmpty = true;
                msj = "Treasure added successfully";
            }
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
    
    /**
     * sameTreasureInGame: String: This method list all the treasures in the game.
     * @param treasureName: String: This parameter is the name of the treasure to search for.
     * @return: msj: String: The return message is a list with the treasures.
     */
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
     * topFivePlayers: String: This method displays the top five players in order of highest score to lowest.
     * @return: msj: String: a message with the top 5 five players.
     */
    public String topFivePlayers(){
		int top1 = 0;
		int top2 = 0;
		int top3 = 0;
		int top4 = 0;
		int top5 = 0;
		String name1 = " ";
		String name2 = " ";
		String name3 = " ";
		String name4 = " ";
		String name5 = " ";
		String msj = ""; 

		for(int i = 0; i<TOTAL_PLAYERS; i++){

			if(players[i] != null && players[i].getPlayerScore() > top1){
				
				top5 = top4;
				top4= top3;
				top3= top2;
				top2 = top1;
				top1 = players[i].getPlayerScore();
				name5 = name4;
				name4 = name3;
				name3 = name2;
				name2= name1; 
				name1 = players[i].getNickName(); 
				
			} else if(players[i] != null && players[i].getPlayerScore() > top2){
				
				top5 = top4;
				top4= top3;
				top3= top2;
				top2 = players[i].getPlayerScore(); 
				name5 = name4;
				name4 = name3;
				name3 = name2;
				name2= players[i].getNickName();

			}else if( players[i] != null && players[i].getPlayerScore() > top3){

				top5 = top4;
				top4= top3;
				top3= players[i].getPlayerScore(); 
				name5 = name4;
				name4 = name3;
				name3 = players[i].getNickName();

			} else if(players[i] != null && players[i].getPlayerScore() > top4){

				top5 = top4;
				top4= players[i].getPlayerScore(); 
				name5 = name4;
				name4 = players[i].getNickName();

			}else if(players[i] != null && players[i].getPlayerScore() > top5){

				top5 = players[i].getPlayerScore();
				name5 = players[i].getNickName(); 
		
			}

			msj = "Podium: Top 5 Players \n" +
					"1."+ name1 + ": " + top1 + "\n"+
					"2."+ name2 + ": " + top2 + "\n"+
					"3."+ name3 + ": " + top3 + "\n"+
					"4."+ name4 + ": " + top4 + "\n"+
					"5."+ name5 + ": " + top5 + "\n"; 

		}

		return msj; 
	}
    
    /**
     * mostReapeatedTreasure: String: This method displays the most repeated treasure in the game.
     * @return: msj: String: A message of the treasure most repeated.
     */
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

    /**
     * listEnemies: String: This method list all the enemies in a level.
     * @param level: int: This paramenter is the level the user consults, levels go from 1 to 10.
     * @return: msj: String: a return message with the enemies separated by a comma.
     */
    public String listEnemies(int level){
        String msj ="Enemies: ";

        for(int i = 0; i < TOTAL_OF_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getLevel().getLevelId()==level){
                msj += enemies[i].getEnemyName() + ", ";
            }
        }

        return msj;
    }

    /**
     * listTreasure: String: This method list all the treasures in a level.
     * @param level: int: This paramenter is the level the user consults, levels go from 1 to 10.
     * @return: msj: String: a return message with the treasures separated by a comma.
     */
    public String listTreasure(int level){
        String msj ="Treasures: ";

        for(int i = 0; i < TOTAL_OF_TREASURES; i++){
            if(treasures[i] != null && treasures[i].getLevel().getLevelId()==level){
                msj += treasures[i].getTreasureName() + ", ";
            }
        }

        return msj;
    }

    /**
     * listTreasureInGame: String: This method shows the amount of a treasure found in all levels.
     * @param nameTreasure: String: This parameter is the name of the treasure that the user wants to consult.
     * @return: msj: String: It can show a message with the treasures or a message that the treasure is not found.
     */
    public String listTreasureInGame(String nameTreasure){
        String msj = "Treasures found: ";
        int counter = 0;
        for(int i = 0; i < TOTAL_OF_TREASURES; i++){
            if(treasures[i] != null && treasures[i].getTreasureName().equalsIgnoreCase(nameTreasure)){
                counter ++;
            }
        }
        if(counter == 0 ){
            msj ="We couldn't found a treasure with this name, try again";
        }else{
            msj += counter;
        }
        return msj;
    }

    /**
     * consonantsEnemies: String: This method separates the consonants of the names of the enemies and then displays
     * the amount.
     * @return: msj: String: A message that says the number of consonants in the enemies name.
     */
    public String consonantsEnemies(){
		String msj = ""; 
		int amount=0;
		char [] consonants={'q','w','r','t','y','p','s','d','f','g','h','j','k','l','z','x',
		                       'c','v','b','n','m'};

		for(int i=0; i<TOTAL_OF_ENEMIES;i++){
		    if(enemies[i]!=null){
		        for(int j=0; j<enemies[i].getEnemyName().length();j++){
		           for(int s=0;s<consonants.length;s++){
		              if(enemies[i].getEnemyName().charAt(j)==consonants[s]){
		               amount++; 
		               }
		            }
		         }
		    }

		      msj = "This is the amount of consonants in the enemies names "  + amount; 
		}
		   return msj;
    }

    /**
     * enemyWithMaxScore: String: This method search for the enemy with the maximum score in the game.
     * @return: msj: String: A message with the name of the enemy with the highest score, and the level where is located.
     */
    public String enemyWithMaxScore(){
        String msj = "";
        int max = 0;
        int level = 0;
        String maxEnemyName = "";

        for(int j = 0; j< TOTAL_OF_ENEMIES; j ++){
            if(enemies[j] != null){
                if(enemies[j].getifBeatenScore() > max){
                    max= enemies[j].getifBeatenScore();
                    maxEnemyName = enemies[j].getEnemyName();
                }
            }
        }
        msj = ("The enemy with the highest score is " + maxEnemyName + ", the score it gives is " + max + " and is in the level " + level);
        return msj;
    }

    /**
     * searchPlayerByNickName: String: This method search for a player with their nickname.
     * @param nickName: String: This parameter is the id of the user, the nickname that the method uses to
     * find the user.
     * @return: player: Player: Return the position of the player in the array.
     */
    public Player searchPlayerByNickName(String nickName){
        Player player = null;
        for(int i = 0; i < TOTAL_PLAYERS; i++){
            if(players[i] != null && players[i].getNickName().equalsIgnoreCase(nickName)){
               player = players[i];
            }            
        }
        return player;
    }

    /**
     * searchEnemyByName: String: This method search for an enemy with their name.
     * @param enemyName: String: This parameter is the name of the enemy the user is searching for.
     * @return: foundPlayer: Enemy: Return the position of the enemy in the array.
     */
    public Enemy searchEnemyByName(String enemyName){
		Enemy foundPlayer = null;
		for(int i=0; i < TOTAL_PLAYERS && foundPlayer == null; i++){
			if(enemies[i] !=null && enemies[i].getEnemyName().equalsIgnoreCase(enemyName)){
				foundPlayer = enemies[i];
			}
		}
		return foundPlayer;
	}

    /**
     * emptySpacePlayers: String: This method search in the array to see if there is an empty 
     * space, if is full or if is empty.
     * @return: msj: String: It depends of the array but there are 3 types of return the "available
     * position", the "0 players", "reached limit".
     */
    public String emptySpacePlayers(){
        String msj ="available position";
        if(players[0] == null){
            msj = "0 players";
        }else if(players[TOTAL_PLAYERS-1] != null){
            msj = "reached limit";
        }
        return msj;
    } 

    /**
     * emptySpaceEnemies: String: This method search in the array to see if there is an empty 
     * space, if is full or if is empty.
     * @return: msj: String: It depends of the array but there are 3 types of return the "available
     * position", the "0 enemies", "reached limit".
     */
    public String emptySpaceEnemies(){
        String msj ="available position";
        if(enemies[0] == null){
            msj = "0 enemies";
        }else if(enemies[TOTAL_OF_ENEMIES-1] != null){
            msj = "reached limit";
        }
        return msj;
    }

    /**
     * emptySpaceTreasures: String: This method search in the array to see if there is an empty 
     * space, if is full or if is empty.
     * @return: msj: String: It depends of the array but there are 3 types of return the "available
     * position", the "0 treasures", "reached limit".
     */
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

