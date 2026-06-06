import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Bullet extends Actor
{
    private int angulo;
    private int velocidad;

    public Bullet(int anguloInicial, int velocidadInicial)
    {
        angulo = anguloInicial;
        velocidad = velocidadInicial;
        setRotation(angulo);
    }
    
    public void act()
    {
        move(velocidad);
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
        if(getY() > 550)           
        {
            World world;
            world=getWorld();
            ((CrabWorld)world).sumarScore();
            getWorld().removeObject(this);
            return;
        }
        if(getY() < 10)           
        {
            World world;
            world=getWorld();
            ((CrabWorld)world).sumarScore();
            getWorld().removeObject(this);
            return;
        }
        if(getX() > 550)           
        {
            World world;
            world=getWorld();
            ((CrabWorld)world).sumarScore();
            getWorld().removeObject(this);
            return;
        }
        if(getX() < 10)           
        {
            World world;
            world=getWorld();
            ((CrabWorld)world).sumarScore();
            getWorld().removeObject(this);
            return;
        }
    }
}
