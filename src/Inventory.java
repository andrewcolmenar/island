
public class Inventory {
    public int wood;
    public int health;
    public int stamina;
    public int sanity;
    public int food;
    public int hunger;
    public int fire;
    public boolean Axe;
    public boolean Spear;
    public boolean isDead;
    public boolean insanity;
    
    public Inventory(){
        fire = 0;
        wood = 0;
        health = 101;
        stamina = 105;
        sanity = 105;
        food = 0;
        hunger = 0;
        Axe = false;
        Spear = false;
        isDead = false;
        insanity = false;
    }
    
    public int getFire(){
        return fire;
    }
    public int getWood(){
        return wood;
    }
    public int getHealth(){
        return health;
    }
    public int getStamina(){
        return stamina;
    }
    public int getSanity(){
        return sanity;
    }
    public boolean getAxe(){
        return Axe;
    }
    public boolean getSpear(){
        return Spear;
    }
    public boolean getInsanity(){
        return insanity;
    }
    

}
