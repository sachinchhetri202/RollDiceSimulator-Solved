import java.util.*;
import java.io.*;

public class Decoder{
    public static void main(String[] args){
        String fileName = "";
        int encryptionKey;
        Scanner keyboard = new Scanner(System.in);
        String translatedFile = "Encrypted.txt"; 
        String decryptedFile = "Decrypted.txt";
        
        
        System.out.print("Please enter the name of the encrypted file: ");
        fileName = keyboard.nextLine();
        System.out.print("Enter encryption key (1-5)? ");
        encryptionKey = keyboard.nextInt();

        // calling out method
        translateFile(fileName, translatedFile, encryptionKey, true);
        System.out.println("File has been encrypted to Encrypted.txt");

        // Flush the buffer
        keyboard.nextLine();

        while(true){
            try{
                System.out.print("Please enter the name of the file (q to quit): ");
                fileName = keyboard.nextLine();

                if (fileName.equalsIgnoreCase("q")){
                    break;
                }

                System.out.print("Enter encryption key (1-5)? ");
                encryptionKey = keyboard.nextInt();

                // Flush the buffer 
                keyboard.nextLine();

                // Calling out method 
                translateFile(fileName, decryptedFile, encryptionKey, false);
                System.out.println("File has been decrypted to Decrypted.txt");
            
                
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input.");
            }
        }    
        keyboard.close();

    }
    // Method to decrypt the file as well as encrypt if the guess was correct 
    public static void translateFile(String fileName, String translatedFile, int encryptionKey, boolean encrypt){
        try{
            File a = new File(translatedFile);
            PrintWriter fileOut = new PrintWriter(new FileWriter(translatedFile));
            a.createNewFile(); // it will create a file in your directory
            File f = new File(fileName);
            Scanner fileIn = new Scanner (f);
            while(fileIn.hasNextLine()){
                String firstLine = fileIn.nextLine();
                for (int i = 0; i < firstLine.length(); i++){
                    char c = firstLine.charAt(i);
                    if (encrypt){
                        c += encryptionKey;
                        fileOut.append(c); // appends each character to newfile
                    }
                    // if decrypt
                    else {     
                        c -= encryptionKey;
                        fileOut.append(c); // appends each character to newfile 
                    }    
                }

                fileOut.append("\n");
            }

            // closing the files 
            fileOut.close();
            fileIn.close();


        }
        catch(FileNotFoundException e){
            System.out.println("Sorry. The file do not exist.");
        }
        catch(IOException e){
            System.out.println("Sorry " + e.getMessage());
        }
    }
}
