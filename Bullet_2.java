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
            ((CrabWorld)world).gameOverr();
            for(Bullet b : world.getObjects(Bullet.class))
            {
                world.removeObject(b);
            }
            for(Bullet_2 b : world.getObjects(Bullet_2.class))
            {
                world.removeObject(b);
            }
            for(Bullet_3 b : world.getObjects(Bullet_3.class))
            {
                world.removeObject(b);
            }
            return;
        }
        if(getY() >= 520)
        {
            World world;
            world=getWorld();
            ((CrabWorld)world).sumarScore();
            getWorld().removeObject(this);
        }
    }
}
