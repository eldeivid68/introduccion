import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    public void act()
    {
        if(getWorld().getObjects(Crab.class).isEmpty())
        {
            return;
        }
        
        move(4);
        if (getX()-25<= 5 || getX()+25>= getWorld().getWidth()-5){
            turn(180);
        }
        Actor bullet;
        bullet=new Bullet(90, 5);
        Actor bullet_2;
        bullet_2=new Bullet_2(110, 5);
        Actor bullet_3;
        bullet_3=new Bullet_3(70, 5);
        World world;
        world=getWorld();
        int random=Greenfoot.getRandomNumber(400);
        if (random<10){
            world.addObject(bullet,getX(),getY());
            world.addObject(bullet_2,getX(),getY());
            world.addObject(bullet_3,getX(),getY());
            if (Greenfoot.getRandomNumber(10)==1){
                turn(180);
            }
        }
        else if(random<20){
            world.addObject(bullet_2,getX(),getY());
            world.addObject(bullet_3,getX(),getY());
            if (Greenfoot.getRandomNumber(10)==1){
                turn(180);
            }
        }
        else if(random<30){
            world.addObject(bullet,getX(),getY());
            if (Greenfoot.getRandomNumber(10)==1){
                turn(180);
            }
        }
        Actor crab;
        crab=getOneObjectAtOffset(0,0,Crab.class);
        if (crab!=null){
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
    }
}
