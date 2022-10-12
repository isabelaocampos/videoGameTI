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

        String playerName, playerNickName, msj, levelId, enemyName, imageURL, typeOfEnemy, treasureName, levelToGo= "";
        int ifBeatenScore, ifWinnerScore, amountPerLevel,scoreForPlayer, newScorePlayer, scoreToPassLevel = 0;
        switch(option){
            

            case 1: 
            System.out.println("You are now creating a new player");
            System.out.println("Write the name of the player: ");
            playerName = reader.next();
            System.out.println("Write the nickname of the player, this will be their identifier: ");
            playerNickName = reader.next();
            

            //preguntar
            boolean nickNameNotAble = videoGame.notTheSameNickName(playerNickName);
            if(nickNameNotAble == true){
                System.out.println("Sorry this nickname is already taken, please try again");
            }
            else{
                msj = videoGame.createPlayer(playerName, playerNickName);
                System.out.println(msj);
            }    
            break;

            case 2:
            System.out.println("You are now adding a new enemy to a level, we have 10 levels");
            System.out.println(videoGame.printLevels());
            System.out.println("Write the level you want the enemy to be: ");
            levelId = reader.next(); 
            System.out.println("Enter the type of Enemy that you are adding (Ogre, Abstract, Boss or Magician):");
            typeOfEnemy = reader.next();
            System.out.println("Write the name of the enemy: ");
            enemyName = reader.next();
            System.out.println("Write the score that the player get's if it beats the enemy: ");
            ifBeatenScore = reader.nextInt();
            System.out.println("Write the score that the player will lose if he can't beat the enemy: ");
            ifWinnerScore = reader.nextInt();
            System.out.println("Enter the image URL of the enemy: ");
            imageURL = reader.next();
            
            System.out.println(videoGame.assignEnemyToLevel(levelId, enemyName, typeOfEnemy, ifBeatenScore, ifWinnerScore));
            break; 

            case 3: 
            System.out.println("You are now adding a new treasure to a level, we have 10 levels");
            System.out.println("Write the level you want the treasure to be: ");
            levelId = reader.next(); 
            System.out.println("Enter how many of this treasure is going to be in this level:");
            amountPerLevel = reader.nextInt();
            System.out.println("Write the name of the treasure: ");
            treasureName= reader.next();
            System.out.println("Write the score the player get's if it finds the treasure: ");
            scoreForPlayer= reader.nextInt();
            System.out.println("Enter the image URL of the enemy: ");
            imageURL = reader.next();
            
            System.out.println(videoGame.assignTreasureToLevel(levelId, treasureName, scoreForPlayer, imageURL, amountPerLevel));
            break;

            case 4:
            System.out.println("You are about to modify the score of a player");
            System.out.println("Write the id of the player you want to modify their score: ");
            playerNickName = reader.next();
            System.out.println("Write the new score of the player, remember is has to be greater or the same score that is has: ");
            newScorePlayer = reader.nextInt();
            break;
            
            case 5:
            System.out.println("You are now changing a player to a different level");
            System.out.println("Write the nickname of the player: ");
            playerNickName = reader.next();
            System.out.println("Write the level you want the player to go: ");
            levelToGo = reader.next();

            System.out.println(videoGame.changePlayerLevel(playerNickName, levelToGo));

            break;

            case 6:
            break;

            case 7:
            break;
            
            case 8:
            break;

            case 9:
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
