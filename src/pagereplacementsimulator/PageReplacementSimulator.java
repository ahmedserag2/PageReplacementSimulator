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
public class PageReplacementSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int noFrames = 3;
        String refrenceString1 = "1303563";
        String refrenceString2  = "012301401234";
        PageAllocator table1 = new FifoAllocator(noFrames , refrenceString2);
        table1.allocate();
        table1.printTable();
    }
    
}
