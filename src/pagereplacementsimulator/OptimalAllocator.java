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
public class OptimalAllocator extends PageAllocator
{
    private int[] priorities;
    public OptimalAllocator(int noOfFrames, String referenceString){
        super(noOfFrames, referenceString);
        priorities = new int[noOfFrames];
    }
    
    
    //the frame with least priority is the frame which wont be used or wont be used farthest in
    //and returns the index of the least priority
    public int prioritize(int currentIndex, char [] scenario){
        //count
        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < noOfFrames; i++){
            
            priorities[i] = search(referenceString,
                                currentIndex,referenceLength,scenario[i]);
            //either the page isnt used (least priority)
            if(priorities[i] == -1){
                maxIndex = i;
                break;
            
            }
            //else lowest priority is the maximum index
            else if (max < priorities[i]){            
                maxIndex = i; 
                max = priorities[i];
            }
           // System.out.println(scenario[i] + " has a priority of " + priorities[i]);
         
        }
        return maxIndex;
    }
    
    
    @Override
    public void allocate(){
        
        char [] scenario = new char[noOfFrames];
        
        pageFaults = noOfFrames;
        for(int x = 0;x < noOfFrames; x++)
        {
            scenario[x]= referenceString.charAt(x);
            System.arraycopy(scenario, 0, allocationTable[x], 0, noOfFrames); 

        }
        
        //loop over the whole refrence String
        for(int i = noOfFrames; i < referenceLength; i++)
        {
            
            //if there is no match indicate a page miss 
            if(!match(scenario,noOfFrames,referenceString.charAt(i)))
            {
                //get the frame wih lowest priority and replace it
                int pointer = prioritize(i , scenario);

                //replace the one with least priority
                scenario[pointer] = referenceString.charAt(i); 
                
                
                
                //indicating a miss
                pageFaults++;

            }
           
           for (int x = 0; x < noOfFrames; x++){
               // System.out.print(priorities[x] + " ");   
                priorities[x] = 0; // ages[1] = 0 

            }
           // System.out.println("");
               
            System.arraycopy(scenario, 0, allocationTable[i], 0, noOfFrames); 
        }
        
    }
    
    
    
    
}
