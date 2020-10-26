/**
 *
 * @author Esther Cortez
 * @since 10/20/2020
 * @version 1.0
 */

package vipclients;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class VIPClients {

    public static PrintStream ps;
   
    public static void main(String[] args) throws FileNotFoundException, Exception {
        ps = new PrintStream ("results.txt"); // sending all output to a file named results
        String [] fileNames = {"week1.txt", "week2.txt", "week3.txt",
                "week4.txt", "week5.txt", "week6.txt", "week7.txt", "week8.txt", 
                "week9.txt", "week10.txt", "week11.txt", "week12.txt"};
        int columns = 5;
        int rows = 2400;
        int row=0;
        
        String [][] myList = new String [rows][columns]; //creates a string with 5 columns, 2400 rows
        String fileName = fileNames[0];
        
        for (int i = 0; i < fileNames.length ; i++){
            String myFile = fileNames[i];
            Scanner sc = new Scanner (new File(myFile));
            
            row = populateArray(myList, row, myFile);
            
        }
        
        sortArray(myList,rows);
        
    }

    
       public static int populateArray(String [][] myList, int row, String fileName)throws Exception{ 
            
            File myFile = new File (fileName);
            Scanner sc = new Scanner (myFile);//takes in the csv file
            String line = "";
            
            while(sc.hasNextLine()){   
                line = sc.nextLine();
                String[] values = line.split(",(?=([^\"]|\"[^\"]*\")*$)");
                /*gets rid of unecessary quotes etc 
                */
                
                for(int i = 0; i < 5; i++){
                
                    myList[row][i] = values[i];                    
                    //ps.print(myList[row][i] + " "); //prints out to csv file to another file
                    System.out.println(myList[row][i] + " ");
                    
                }
                row = row+1;
            }
            
            return row;
        }    
            //return myList; //method returns the csv file but in an organized array
        
       
       public static String [][] sortArray(String [][] array, int count)throws Exception{
        int i, j;
        
        String [][]temp = new String [1][2];
        boolean switched = true;
        
        for(i=0; i< count-1; i++){
            switched = false;
            
            for(j=0; j< count-i-1; j++){
                if(array[j][1].compareToIgnoreCase(array[j+1][1])>0){
                    switched = true;
                
                    temp[0][0] = array[j][0];
                    temp[0][1] = array[j][1];
                    
                    array[j][0] = array [j+1][0];
                    array[j][1] = array [j+1][1];
                    
                    array[j+1][0] = temp[0][0];
                    array[j+1][1] = temp[0][1];
                }
            }
        }
        
        return array;
    }
       
       
       
       
       
    }    
    
    

