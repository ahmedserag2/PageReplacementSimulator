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
public class LRUAllocator extends PageAllocator{
    
    private int[] ages = new int[noOfFrames];
    public LRUAllocator(int noOfFrames, String refrenceString) {
        super(noOfFrames,refrenceString);
    }
    
    
    private int getIndexOfMaxAge() {
        
        int index = 0, maxValue = 0;

        for (int i = 0; i < ages.length; i++){
                if(ages[i] > maxValue){
                        maxValue = ages[i];
                        index = i;
                }
        }
        return index;
    }
    
    @Override
    public void allocate(){
        
        char[] scenario = new char[noOfFrames];
        //allocationTable
        int currentFrame = 0; 
        int pointer = 0;
        
        for (int j = 0 ; j<noOfFrames ; j++){
            scenario[j] = (char) -1;
            ages[j] =0 ;
        }
        //loop over the whole refrence String
        for(int i = 0; i < referenceLength; i++)
        { 
                for (int j = 0 ; j<noOfFrames ; j++){
                    ages[j]++; //1 1 1 // 1 2 2 // 2 1 3 // 3 2 1 
                    
                }
                if(!match(scenario,noOfFrames,referenceString.charAt(i)))
                {
                    pageFaults++; //1 // 2 // 3
                    pointer = getIndexOfMaxAge(); //0 // 1 // 2
                    
                    scenario[pointer] = referenceString.charAt(i);   
                    ages[pointer] = 0; //ages[0] = 0 // ages[1] = 0 // ages[2] = 0
                }

                else
                {
                    for (int x = 0; x < noOfFrames; x++){
                        if (scenario[x] == referenceString.charAt(i)){
                                ages[x] = 0; // ages[1] = 0 
                        }
                    }
                }
                System.arraycopy(scenario, 0, allocationTable[i], 0, noOfFrames);
        }
    
    }
    
}
