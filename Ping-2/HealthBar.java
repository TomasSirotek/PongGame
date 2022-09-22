import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthBar extends Actor
{
    public static int health;
  
    public HealthBar(int health){
        this.health = health;       
    }
    public void act(){
        updateImages();
    }
    public int getHealth(){
        return health;
    }
    public static void dealDamage(int damage){
        health -= damage;
    }
    public static void healthUp(int amount){
        health += amount;
    }
    
    private void updateImages(){
        health = getHealth();
        if (health >= 3) {
                setImage("heart3.png");
                getImage().scale(90,90);
            }
         if (health <= 2) {
                setImage("heart2.png");
                getImage().scale(90,90);
            }
         if (health <= 1) {
                setImage("heart1.png");
                 getImage().scale(90,90);
            }
    }
    
}
