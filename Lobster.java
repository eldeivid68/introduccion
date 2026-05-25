import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//hola que tal, este es mi comentario -Tunchez
/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(2);
        if (Greenfoot.getRandomNumber(100) < 10) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if (isAtEdge()) {
            turn(180);
        }
        Actor crab = getOneObjectAtOffset(0, 0, Crab.class);
        if (crab != null) {
            getWorld().removeObject(crab);
        }// Add your action code here.
    }
}
