import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet_2 extends Actor
{
    /**
     * Act - do whatever the Bullet_2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int z=1;
    public void act()
    {
        move(5);
            while (z==1){
                turn(110);
                z=z-1;
            }
        Actor crab;
        crab=getOneObjectAtOffset(0,0,Crab.class);
        if (crab!=null){
            World world;
            world=getWorld();
            world.removeObject(crab);
        }
    }
}
