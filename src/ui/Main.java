package ui;

import java.util.Scanner;
import model.*;

public class Main {
    
    private Scanner reader;
    private VideoGame videoGame;

    public Main(){
        reader = new Scanner(System.in);
        videoGame = new VideoGame();

    }

    public Scanner getReader(){
        return reader;
    }

    public void setReader(Scanner reader){
        this.reader = reader;
    }

    public static void main(String[] args){
        Main main = new Main();

        int option = 0;
            do{
                option = main.getOptionShowMenu();
                main.executeOption(option);

            }while(option != 0);

    }

    public int getOptionShowMenu(){
        int option = 0; 
        printMenu();

        option = validateIntegerOption(); 

        return option; 
}

public void printMenu(){
            System.out.println("<<<<< Welcome to this videogame >>>>>");
            System.out.println(
            "1. Create player \n" +
            "2. Add enemy to level \n" +
            "3. Add treasure to level \n" +
            "4. Modify the score of a player \n" +
            "5. Change player of level \n" + 
            "6. Treasures and Enemies in a level - List \n" +
            "7. Amount of a treasure in all levels \n" +
            "8. Amount of a enemies in all levels \n" +
            "9. Most repeated treasure in the game \n" +
            "10. Enemy that gives more score and where is located \n" +
            "11. Consonants found in the names of all enemies \n" +
            "12. Top 5 players \n" +
            "0. Exit");  
}


    public void executeOption(int option){

        String playerName, playerNickName, msj, enemyName, imageURL, treasureName= "";
        int ifBeatenScore, ifWinnerScore, scoreForPlayer, newScorePlayer = 0;
        int scoreToPassLevel, typeOfEnemyOfEnemy, levelId, levelToGo, amountPerLevel = 0;

        switch(option){
            case 1: 
                if(videoGame.emptySpacePlayers().equals("reached limit")){
                    System.out.println(videoGame.emptySpacePlayers());
                
                    }else{
                        reader.nextLine();
                        System.out.println("You are now creating a new player \n" +  
                        "Write the nickname of the player, this will be their identifier: ");
                        playerNickName = reader.nextLine();
                        if(videoGame.searchPlayerByNickName(playerNickName) != null){
                            System.out.println("Sorry this nickname is already taken, please try again");

                        }else{
                            System.out.println("Write the name of the player: ");
                            playerName = reader.nextLine();
                            msj = videoGame.createPlayer(playerName, playerNickName);
                        System.out.println(msj);
                        }
            
                }

            break;

            case 2:
                if(videoGame.emptySpaceEnemies().equals("reached limit")){
                    System.out.println(videoGame.emptySpaceEnemies());
                }else{
                    reader.nextLine();
                    System.out.println("You are now adding a new enemy to a level");
                    System.out.println("Write the name of the enemy: ");
                    enemyName = reader.nextLine();
                
                    if(videoGame.searchEnemyByName(enemyName) != null){
                        System.out.println("Sorry this enemy  already exist, try again");
                    }else{
                        System.out.print("Write the typeOfEnemy of enemy: \n"+
                        "1. Ogre \n"+
                        "2. Abstract \n"+
                        "3. Boss \n"+
                        "4. Magician \n");

                        typeOfEnemyOfEnemy = reader.nextInt();
                        System.out.println("Write the score that the player get's if it beats the enemy: ");
                        ifBeatenScore = reader.nextInt();
                        System.out.println("Write the score that the player will lose if he can't beat the enemy: ");
                        ifWinnerScore = reader.nextInt();
                        System.out.println("Write the level you want the enemy to be, remember there are only 10 levels: ");
                        levelId = reader.nextInt();
                        if(levelId > 10 || levelId < 1){
                            System.out.println("Invalid level, try again");
                        }else{
                            System.out.println(videoGame.assignEnemyToLevel(levelId, enemyName, typeOfEnemyOfEnemy, ifBeatenScore, ifWinnerScore));
                        }

                    }
                }
            break; 

            case 3: 
                if(videoGame.emptySpaceTreasures().equals("reached limit")){
                    System.out.println(videoGame.emptySpaceTreasures());
                }else{
                    reader.nextLine();
                    System.out.println("You are now adding a new treasure to a level");
                    System.out.println("Write the name of the treasure: ");
                    treasureName= reader.nextLine();
                    System.out.println("Enter the image URL of the enemy: ");
                    imageURL = reader.nextLine();
                    System.out.println("Write the score the player get's if it finds the treasure: ");
                    scoreForPlayer= reader.nextInt();
                    System.out.println("Write the amount of the same treasure in the level");
                    amountPerLevel = reader.nextInt();
                    System.out.println("Write the level you want the treasure to be, remember there are only 10 levels: ");
                    levelId = reader.nextInt();
                if(levelId > 10 || levelId < 1){
                    System.out.println("Invalid level, try again");
                }
                    System.out.println(videoGame.assignTreasureToLevel(levelId, treasureName, scoreForPlayer, imageURL, amountPerLevel));
                }
            break;

            case 4:
                if(videoGame.emptySpacePlayers().equals("0 players")){
                    System.out.println(videoGame.emptySpacePlayers());
            
                }else{
                    reader.nextLine();
                    System.out.println("You are about to modify the score of a player");
                    System.out.println("Write the id of the player you want to modify their score: ");
                    playerNickName = reader.nextLine();
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
            if(videoGame.emptySpacePlayers().equals("No hay jugadores ")){
                System.out.println(videoGame.emptySpacePlayers());
            }else{
                reader.nextLine();
                System.out.println("You are now changing a player to a different level");
                System.out.println("Write the nickname of the player: ");
                playerNickName = reader.nextLine();
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
                System.out.println("You are about to be inform of a treasure found in all the levels");
                System.out.println("Write the name of the treasure: ");
                reader.nextLine();
                System.out.println(videoGame.listTreasureInGame(reader.next()));
            }
            break;

            case 8:
            if(videoGame.emptySpaceEnemies().equals("0 enemies")){
                System.out.println(videoGame.emptySpaceEnemies());
            }else{
                System.out.println("You are about to be inform of a type of enemy found in all the levels");
                System.out.print("\n Write the type of enemy you want to search" +
                "\n 1. Ogre" +
                "\n 2. Abstract" +
                "\n 3. Boss" +
                "\n 4. Magician");

                int typeOfEnemy = reader.nextInt();
                if(typeOfEnemy > 4 || typeOfEnemy < 1){
                    System.out.println("Invalid option");
                }else{
                    System.out.println(videoGame.allEnemies(typeOfEnemy));
                }
            }
            break;
            
            case 9:
            if(videoGame.emptySpaceTreasures().equals("0 treasures")){
                System.out.println(videoGame.emptySpaceTreasures());
            }else{
                System.out.println("You are about to see the treasure that reapeats the most in all levels");
                System.out.println(videoGame.mostReapeatedTreasure());
            }
            break;

            case 10:
                System.out.println("You are about to know the enemy with more score and in which level is located");
                System.out.println(videoGame.enemyWithMaxScore());
            break;

            case 11:
                System.out.println("You are about to know the consonants found in the name of all enemies");
                System.out.println(videoGame.consonantsEnemies());
            break;
                

            case 12:
                System.out.println("You are about to see the top 5 players of the game");
                System.out.println(videoGame.topFivePlayers());
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
            reader.next(); 
            option = -1; 
        }

        return option; 
    }
}
