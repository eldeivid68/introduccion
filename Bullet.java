import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Bullet extends Actor
{
    int z=1;
    public void act()
    {
        move(5);
            while (z==1){
                turn(90);
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
