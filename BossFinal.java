import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossFinal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossFinal extends Actor
{
    /**
     * Act - do whatever the BossFinal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int direccion = 1;
    private int contador = 0;
    private int amplitud = 50;
    public void act()
    {
        if(getWorld().getObjects(Crab.class).isEmpty())
        {
            return;
        }
        setLocation(getX() + direccion * 3, getY());
        if(getX() < 50)
        {
            direccion = 1;
        
            amplitud = Greenfoot.getRandomNumber(80) + 20;
        }
        
        if(getX() > getWorld().getWidth() - 50)
        {
            direccion = -1;
        
            amplitud = Greenfoot.getRandomNumber(80) + 20;
        }
        contador++;
        int yBase = 120;
        int y = yBase +
                (int)(Math.sin(contador * 0.05) * amplitud);
        setLocation(getX(), y);
    }
}
