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
    private static GreenfootSound startSound;
    private static GreenfootSound boneCrack;
    private static GreenfootSound gameSound;
    private static GreenfootSound gameOverSound;
    

    static {
        try{
            hitSoundPaddle = new GreenfootSound("oof.mp3"); 
            hitSoundWalls = new GreenfootSound("bounce.mp3"); 
            hitSoundFloor = new GreenfootSound("wrong.mp3"); 
            startSound = new GreenfootSound("start_music.mp3"); 
            boneCrack = new GreenfootSound("bone_crack.mp3"); 
            gameSound = new GreenfootSound("theme_music.mp3"); 
            gameOverSound = new GreenfootSound("game_over.mp3"); 
        }catch(Exception e){
            System.out.print(e);
        }
    }
    
    public static void playHitPaddle(){
        hitSoundPaddle.play();
    }
    
    public static void playHitWalls(){
        hitSoundWalls.play();
    }
    public static void playHitFloor(){
        hitSoundFloor.play();
    }
    
    public static void playStartMusic(){
        startSound.play();
    }
    
    public static void playBoneCrack(){
        boneCrack.play();
    }
    
    public static void playThemeMusic(){
        gameSound.playLoop();
        gameSound.setVolume(50);
    }
    
     public static void stopThemeMusic(){
        gameSound.stop();
    }
    
    public static void stopStartMusic(){
        startSound.stop();
    }
    
     public static void playGameOverSound(){
        gameOverSound.play();
    }
    
    

}
