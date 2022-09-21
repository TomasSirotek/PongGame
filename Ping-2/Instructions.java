import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instruction class that takes String instructions,int fontSize,Color background,Color outline as parameters
 *
 */
public class Instructions extends Actor
{
    private String instructions;
    private int fontSize;
    private Color background;
    private Color outline;

    public Instructions(String instructions,int fontSize,Color background,Color outline){
        {
            this.instructions = instructions;
            this.fontSize = fontSize;
            this.background = background;
            this.outline = outline;
            setImage();
        }
    }
    
    private void setImage(){
       setImage(new GreenfootImage(instructions, 25, Color.ORANGE, Color.BLACK));
    }
    
}
