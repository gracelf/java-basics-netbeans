

package designPattern.strategy;

/**
 *
 */
class Ryu extends Fighter
{
    //constructor
    public Ryu(KickBehavior kickBehavior, JumpBehavior jumpBehavior)
    {
        super(kickBehavior,jumpBehavior);
    }
    public void display()
    {
        System.out.println("Ryu");
    }
}
