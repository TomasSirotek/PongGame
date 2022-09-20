import greenfoot.GreenfootSound;

/**
 * Write a description of class SoundManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundManager  
{
    private static GreenfootSound soundEffectHit;
    private static GreenfootSound soundMusic;
    private static GreenfootSound gameOver;
    
    static {
        try{
         soundEffectHit = new GreenfootSound("hit.wav");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.print(e);
        }
    }

    
    public static void playSoundHit(){
        soundEffectHit.play();
    }
}
