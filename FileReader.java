import java.util.Scanner;
import java.io.*;
// This program read from file.
public class FileReader
{
   public static void main(String[] args) throws IOException
   {
      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter the file name: ");
      String filename = input.nextLine();
      
      //open the file.
      File file = new File(filename);
      Scanner inputFile = new Scanner(file);
      
      // read lines from the file until no more left.
      while (inputFile.hasNext())
      {
         System.out.println(inputFile.nextLine());
      }  
      //close the file.
      inputFile.close();
   }
   
}