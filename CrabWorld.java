import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Crab crab = new Crab();
        addObject(crab,310,245);
        Worm worm = new Worm();
        addObject(worm,392,174);
        Worm worm2 = new Worm();
        addObject(worm2,64,64);
        Worm worm3 = new Worm();
        addObject(worm3,56,192);
        Worm worm4 = new Worm();
        addObject(worm4,98,379);
        Worm worm5 = new Worm();
        addObject(worm5,253,466);
        Worm worm6 = new Worm();
        addObject(worm6,358,463);
        Worm worm7 = new Worm();
        addObject(worm7,453,438);
        Worm worm8 = new Worm();
        addObject(worm8,486,400);
        Worm worm9 = new Worm();
        addObject(worm9,228,340);
        worm9.setLocation(180,268);
        Worm worm10 = new Worm();
        addObject(worm10,180,268);
        Worm worm11 = new Worm();
        addObject(worm11,188,131);
        Worm worm12 = new Worm();
        addObject(worm12,228,98);
    }
}
