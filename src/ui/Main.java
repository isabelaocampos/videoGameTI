package ui;

import java.util.Scanner;
import model.VideoGame;

public class Main {
    
    private Scanner reader;
    private VideoGame videoGame;

    public Main(){
        reader = new Scanner(System.in);
        videoGame = new VideoGame();

    }

    public VideoGame getVideoGame(){
        return videoGame;
    }

    public Scanner getReader(){
        return reader;
    }

    public static void main(String[] args){

        Main main = new Main();

        int option = 0;

            do{
                option = main.getOptionShowMenu();
                main.executeOption(option);
            }while(option != 0);

            main.getReader().close();
    }

    /**
    getOptionShowMenu: This method has all the options that the user can choose. The user selects the option by writing the number of the list.
	* @return option: int: this parameter reads the option entered by the user. 
	*/
    public int getOptionShowMenu(){
        int option = 0;
        System.out.println("<<<<< Welcome to this videogame >>>>>");
        System.out.println(
            "1. Create player \n" +
            "2. Add enemy to level \n" +
            "3. Add treasure to level \n" +
            //"4. Modify the score of a player \n" +
            "5. Change player of level \n" + 
            //"6. Treasures and Enemies in a level - List \n" +
            //"7. Amount of a treasure in all levels \n" +
            //"8. Amount of a enemies in all levels \n" +
            //"9. Most repeated treasure in the game \n" +
            //"10. Enemy that gives more score and where is located \n" +
            //"11. Consonants found in the names of all enemies \n" +
            //"12. Top 5 players \n" +
            "0. Exit");
        option = reader.nextInt();

        return option;
    }

    public void executeOption(int option){

        String playerName, playerNickName, msj, enemyName, imageURL, treasureName= "";
        int ifBeatenScore, ifWinnerScore, amountPerLevel,scoreForPlayer, newScorePlayer = 0;
        int scoreToPassLevel, typeOfEnemy, levelId, levelToGo = 0;
        switch(option){
            

            case 1: 
            
            System.out.println("You are now creating a new player");
            if(videoGame.emptySpacePlayers().equals("reached limit")){
                System.out.println(videoGame.emptySpacePlayers());
                
            }else{
                reader.nextLine();
                System.out.println("Write the nickname of the player, this will be their identifier: ");
                playerNickName = reader.next();
                if(videoGame.searchPlayerByNickName(playerNickName) != null){
                    
                    System.out.println("Sorry this nickname is already taken, please try again");

                }else{

                    System.out.println("Write the name of the player: ");
                    playerName = reader.next();
                    msj = videoGame.createPlayer(playerName, playerNickName);
                    System.out.println(msj);
                }
            
            }
            break;

            case 2:
            
            System.out.println("You are now adding a new enemy to a level");
            if(videoGame.emptySpaceEnemies().equals("reached limit")){
                System.out.println(videoGame.emptySpaceEnemies());
            }else{
                reader.nextLine();
                System.out.println("Write the name of the enemy: ");
                enemyName = reader.next();
                if(videoGame.searchEnemyByName(enemyName) != null){
                    System.out.println("Sorry this enemy  already exist, try again");
                }else{
                    System.out.print("Write the type of enemy: \n"+
                    "\n 1. Ogre"+
                    "\n 2. Abstract"+
                    "\n 3. Boss"+
                    "\n 4. Magician");

                    typeOfEnemy = reader.nextInt();
                    System.out.println("Write the score that the player get's if it beats the enemy: ");
                    ifBeatenScore = reader.nextInt();
                    System.out.println("Write the score that the player will lose if he can't beat the enemy: ");
                    ifWinnerScore = reader.nextInt();
                    System.out.println(videoGame.printLevels());
                    System.out.println("Write the level you want the enemy to be: ");
                    levelId = reader.nextInt();
                    if(levelId > 10 || levelId < 1){
                        System.out.println("Invalid level, try again");
                    }else{
                        System.out.println(videoGame.assignEnemyToLevel(levelId, enemyName, typeOfEnemy, ifBeatenScore, ifWinnerScore));
                    }

                }
            }
            
            break; 

            case 3: 

            System.out.println("You are now adding a new treasure to a level");
            if(videoGame.emptySpaceTreasures().equals("reached limit")){
                System.out.println(videoGame.emptySpaceTreasures());
            }else{
                reader.nextLine();
                System.out.println("Write the name of the treasure: ");
                treasureName= reader.next();
                System.out.println("Enter the image URL of the enemy: ");
                imageURL = reader.next();
                System.out.println("Write the score the player get's if it finds the treasure: ");
                scoreForPlayer= reader.nextInt();
                System.out.println(videoGame.printLevels());
                System.out.println("Write the level you want the treasure to be: ");
                levelId = reader.nextInt();
                if(levelId > 10 || levelId < 1){
                    System.out.println("Invalid level, try again");
                }
                System.out.println(videoGame.assignTreasureToLevel(levelId, treasureName, scoreForPlayer, imageURL));
            }
            
            break;

            case 4:

            System.out.println("You are about to modify the score of a player");
            if(videoGame.emptySpacePlayers().equals("0 players")){
                System.out.println(videoGame.emptySpacePlayers());
            
            }else{
                reader.nextLine();
                System.out.println("Write the id of the player you want to modify their score: ");
                playerNickName = reader.next();
                if(videoGame.searchPlayerByNickName(playerNickName) == null){
                        
                    System.out.println("Sorry, we couldn't find this player. Try again");

                }else{
                    System.out.println("Write the new score of the player, remember is has to be greater or the same score that is has: ");
                    newScorePlayer = reader.nextInt();
                    System.out.println(videoGame.modifyPlayerScore(playerNickName,reader.nextInt()));
                }
            }

            break;
            
            case 5:

            System.out.println("You are now changing a player to a different level");
            if(videoGame.emptySpacePlayers().equals("No hay jugadores ")){
                System.out.println(videoGame.emptySpacePlayers());
            }else{
                reader.nextLine();
                System.out.println("Write the nickname of the player: ");
                playerNickName = reader.next();
                if(videoGame.searchPlayerByNickName(playerNickName) == null){
                        
                    System.out.println("Error, nickName no existe");

                }else{
                    System.out.println(videoGame.changePlayerLevel(playerNickName));
                }
            }

            break;

            case 6:
            System.out.println("You are about to be inform of the treasures and enemies of a certain level");
            if(videoGame.emptySpaceTreasures().equals("0 treasures")){
                System.out.println(videoGame.emptySpaceTreasures());
            }else if(videoGame.emptySpaceEnemies().equals("0 enemies")){
                System.out.println(videoGame.emptySpaceEnemies());
            }else{
                System.out.println("Write the level you want: ");
                levelId = reader.nextInt();
                System.out.println(videoGame.listTreasure(levelId));
                System.out.println(videoGame.listEnemies(levelId));
            }
            break;
            
            case 7:
            if(videoGame.emptySpaceTreasures().equals("0 treasures")){
                System.out.println(videoGame.emptySpaceTreasures());
            }else{
                System.out.println("Por favor dime el nombre del tesoro que deseas consultar");
                reader.nextLine();
                System.out.println(videoGame.listTreasureInAllGame(reader.nextLine()));
            }
            break;

            case 8:
            if(videoGame.emptySpaceEnemies().equals("No hay Enemigos ")){
                System.out.println(videoGame.emptySpaceEnemies());
            }else{

                System.out.print("\nQue enemigo deseas consultar"+
                "\n1.Ogro"+
                "\n2.Abstracto"+
                "\n3.Jefe"+
                "\n4.Magico"+
                "\nOpcion: ");
                int type = reader.nextInt();
                if(type > 4 || type < 1){
                    System.out.println("Opcion invalida");
                }else{
                    System.out.println(videoGame.amountEnemiesType(type));
                }
            }
            break;
            
            case 9:
            if(videoGame.emptySpaceTreasures().equals("No hay tesoros")){
                System.out.println(videoGame.emptySpaceTreasures());
            }else{
                System.out.println(videoGame.countTreasuresName());
            }
            break;

            case 10:
            break;

            case 11:
            break;

            case 12:
            break;

            default:
            break;

            case 0:
            break;
        }
    }

    public int validateIntegerOption(){
        int option = 0; 

        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            // clear reader. 
            reader.nextLine(); 
            option = -1; 
        }

        return option; 
    }
}
