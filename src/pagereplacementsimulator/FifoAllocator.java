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
public class FifoAllocator extends PageAllocator{
    
    public FifoAllocator(int noOfFrames, String refrenceString) {
        super(noOfFrames,refrenceString);
        
    }
    
    @Override
    public void allocate(){
        
        char[] scenario = new char[noOfFrames];
        //allocationTable
        int currentFrame = 0;        
        //loop over the whole refrence String
        for(int i = 0; i < referenceLength; i++)
        {
            
            //if there is no match indicate a page miss 
            if(!match(scenario,noOfFrames,referenceString.charAt(i)))
            {
                //replace using fifo
                scenario[currentFrame] = referenceString.charAt(i); 
                
                //increment
                //make sure we dont go out of bounds 
                currentFrame++;
                currentFrame = currentFrame % noOfFrames;
                
                //indicating a miss
                pageFaults++;

            }
               
            System.arraycopy(scenario, 0, allocationTable[i], 0, noOfFrames); 
        }
        
    }
    
}
