import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    public static int health;
  
    public HealthBar(int health){
        
        this.health = health;

             
    }
    public void act(){
        health = getHealth();
        if (health >= 3) {
                setImage("heart3.png");
                getImage().scale(70,70);
                // play crack sound
            }
         if (health <= 2) {
                setImage("heart2.png");
                getImage().scale(70,70);
            }
         if (health <= 1) {
                setImage("heart1.png");
                 getImage().scale(70,70);
            }
    }
    public int getHealth(){
        return health;
    }
    public static void dealDamage(int damage){
        health -= damage;
    }
    
}
