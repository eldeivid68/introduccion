import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Victoria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Victoria extends Actor
{
    /**
     * Act - do whatever the Victoria wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Victoria(int score)
    {
        GreenfootImage img = new GreenfootImage(
            "VICTORIA\n\nScore Final: " + score + "\n\nGracias por jugar",
            40,
            Color.GREEN,
            new Color(0,0,0,0)
        );

        setImage(img);
    }
}
