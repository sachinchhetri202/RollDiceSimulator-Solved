import java.util.*;


public class DiceRollSimulator{
    
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();

        int die1;
        int die2;
        int howManyRolls;
        

        System.out.println("Welcome to the dice throwing simulator!");
        System.out.print("How many rolls would you like to simulate? ");
        howManyRolls = keyboard.nextInt();
        System.out.println();

        System.out.println("DICE ROLLING SIMULATOR RESULTS");
        System.out.println("Each \"*\" represents 1% of the total number of rolls.");
        System.out.println("Total number of rolls = " + howManyRolls + ".");

        int[] dieStorage = new int[11];

        for (int i = 0; i < howManyRolls; i++){
            die1 = rand.nextInt(6) + 1;
            die2 = rand.nextInt(6) + 1;
            int sum = die1 + die2;
            dieStorage[sum-2]+=1;
        }
        for (int i = 0; i < 11; i++){
            System.out.print((i+2) + ": ");
            for (int j = 0; j < (100 * dieStorage[i] / howManyRolls); j++){
                System.out.print("*");
            }
            System.out.println();   
        }    
            
        System.out.println();
        System.out.println("Thank you for using the dice throwing simulator. Goodbye!"); 
        keyboard.close();

    }
}