import greenfoot.GreenfootSound;

/**
 * Write a description of class SoundManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundManager  
{
    private static GreenfootSound hitSoundPaddle;
    private static GreenfootSound hitSoundCeiling;
    private static GreenfootSound hitSoundWalls;
    private static GreenfootSound hitSoundFloor;
    private static GreenfootSound defaultSound;

    static {
        try{
            hitSoundPaddle = new GreenfootSound("hit.wav"); 
            hitSoundCeiling = new GreenfootSound("hit.wav"); 
            hitSoundWalls = new GreenfootSound("hit.wav"); 
            hitSoundFloor = new GreenfootSound("hit.wav"); 
            defaultSound = new GreenfootSound("hit.wav"); 
        }catch(Exception e){
            System.out.print(e);
        }
    }
    
    public static void playHitPaddle(){
        hitSoundPaddle.play();
    }
    
    public static void playHitCeiling(){
        hitSoundCeiling.play();
    }
    
    public static void playHitWalls(){
        hitSoundWalls.play();
    }
    public static void playHitFloor(){
        hitSoundFloor.play();
    }
    
    public static void playDefaultSong(){
        defaultSound.play();
    }

}
