/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagereplacementsimulator;

/**
 *
 * @author ahmed
 */
public class PageAllocator 
{
    protected int noOfFrames;
    protected int pageFaults;
    protected String referenceString;
    protected int referenceLength;
    protected char allocationTable[][];
    
    
    public PageAllocator(int noOfFrames, String referenceString) {
        this.noOfFrames = noOfFrames;
        this.referenceString = referenceString;
        this.pageFaults = 0;
        referenceLength = referenceString.length();
        allocationTable = new char[referenceLength][noOfFrames];
    }
    public static boolean match(char arr[],int size, char key)
    {
        for(char x : arr)
            if(x == key)
                return true;
        
        return false;
    }
    public void allocate(){
        
        
        
    }
    
    public void printTable()
    {
        //iterate over the table
        System.out.println("reference String: "  + referenceString);
        for(int i = 0;i < referenceLength;i++){
            System.out.print(i+ " :");
            for(int j = 0;j < noOfFrames; j++)
                System.out.print(allocationTable[i][j] + " ");
        System.out.println("");
        
        }
        
        System.out.println("number of page faults "+ pageFaults);
    }
}
