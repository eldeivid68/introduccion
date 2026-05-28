import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class out here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class out extends Actor
{
    /**
     * Act - do whatever the out wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Actor bullet;
        Actor bullet_2;
        Actor bullet_3;
        bullet=getOneObjectAtOffset(0,0,Bullet.class);
        bullet_2=getOneObjectAtOffset(0,0,Bullet_2.class);
        bullet_3=getOneObjectAtOffset(0,0,Bullet_3.class);
        if (bullet!=null){
            World world;
            world=getWorld();
            world.removeObject(bullet);
        }
        if (bullet_2!=null){
            World world;
            world=getWorld();
            world.removeObject(bullet_2);
        }
        if (bullet_3!=null){
            World world;
            world=getWorld();
            world.removeObject(bullet_3);
        }
    }
}
