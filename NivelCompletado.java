import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NivelCompletado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NivelCompletado extends Actor
{
    /**
     * Act - do whatever the NivelCompletado wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public NivelCompletado()
    {
        GreenfootImage img = new GreenfootImage(
            "NIVEL COMPLETADO\n\nAvanzando al jefe final...",
            30,
            Color.GREEN,
            new Color(0,0,0,0)
        );

        setImage(img);
    }
}
