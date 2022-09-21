import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Screen extends Actor
{
    private int switchStage;
    public Screen(String pictureURL,int switchStage)
    {
        this.setImage(pictureURL);
        this.switchStage = switchStage;
    }
    public void act()
    {
        hasInstructions(switchStage);
    }
    
    private void hasInstructions(int test){
        
        // 0 have options
        // 1 dont 
        switch(test){
            case 0:
                    setBg();
                    
            case 1:
                   break;
        }
        
    }
    
    private void setBg(){
        getImage().scale((int)(getWorld().getWidth()), (int)(getWorld().getHeight()));
        Instructions i = new Instructions("Press <Enter> to start");
        getWorld().addObject(i,500,170);
        i.setLocation(getWorld().getWidth()/2,getWorld().getHeight()/4);
    }
}
