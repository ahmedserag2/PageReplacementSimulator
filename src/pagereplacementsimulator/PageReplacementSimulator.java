/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagereplacementsimulator;
import java.util.Scanner;

/**
 *
 * @author ahmed
 */
public class PageReplacementSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner MyInput = new Scanner(System.in);
        Scanner MyInput1 = new Scanner(System.in);
        String Resume = "";
       
        
        do{
            
            System.out.println("Enter your refrence of string");
            String RefString = MyInput1.nextLine();
            System.out.println("\n");
   
            System.out.println("Enter number of frames");
            int Frames = MyInput.nextInt();
            System.out.println("\n");
            
            PageAllocator table1 = new FifoAllocator(Frames , RefString);
            PageAllocator table2 = new LRUAllocator(Frames , RefString);
            PageAllocator table3 = new OptimalAllocator(Frames , RefString);
            
            System.out.println("Algorithm menu");
            PageAllocator.DisplayMenu();
            System.out.println("\n");
            
            System.out.println("Choose which algorithm you want to apply");
            int choice=MyInput.nextInt();
            System.out.println("\n");
            
            switch (choice) {
                case 1:         
                    table1.allocate();
                    table1.printTable();
                    break;
                case 2: 
                    table2.allocate();
                    table2.printTable();
                    break;
                case 3: 
                    table3.allocate();
                    table3.printTable();
                    break;
                default: System.out.println("Invalid choice");
            }

            
            System.out.println("Do you want to make another operation y or n");
            Resume = MyInput1.nextLine();
            System.out.println("\n");

        }while(Resume.equalsIgnoreCase("Y"));
        
    }
    
}
