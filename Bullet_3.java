import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet_3 extends Actor
{
    /**
     * Act - do whatever the Bullet_3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int z=1;
    public void act()
    {
        move(5);
            while (z==1){
                turn(70);
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
