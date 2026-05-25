import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Crab extends Actor
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        move(4);
        turn(3);
        if (Greenfoot.isKeyDown("left")) {  turn(-8); }
        if (Greenfoot.isKeyDown("right")) { turn(4); }
        Actor worm = getOneObjectAtOffset(0, 0, Worm.class);
        if (worm != null) { 
            getWorld().removeObject(worm);
            Greenfoot.playSound("eating.wav");
        }
    }    
}

//Hola este es un cambio