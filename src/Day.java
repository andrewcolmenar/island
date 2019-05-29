import java.util.Scanner;

public class Day {
    public int time;
    
    
    
    public void cycle(){
        Inventory inv = new Inventory();
        Scanner in = new Scanner(System.in);
        
        time = 18;
        inv.hunger += 5;
        inv.sanity-= 5;
        inv.stamina = 100;
        inv.fire -= 8;
        if (inv.fire < 0){
            inv.fire = 0;
        }
        if (inv.fire > 0){
            System.out.println("The fire is stoked for " + inv.fire + " more hours...");
            inv.sanity++;
        } else {
            System.out.println("The fire is out.");
            inv.health--;
        }
        System.out.println("Wood = " + inv.wood);
        System.out.println("Health = " + inv.health);
        System.out.println("Stamina = " + inv.stamina);
        System.out.println("Sanity = " + inv.sanity);
        System.out.println("Food = " + inv.food);
        if (inv.Axe){
            System.out.println("You have an Axe");
        }
        if (inv.Spear){
            System.out.println("You have a Spear");
        }
        if(inv.hunger >= 50){
            System.out.println("You are hungry.");
        }
        if (inv.hunger >= 100){
            System.out.println("You are very hungry");
            inv.sanity -= 5;
        }
        if (inv.hunger >= 150){
            System.out.println("You are starving");
            inv.sanity -= 25;
        }
        if (inv.hunger >= 200){
            System.out.println("You have starved");
            inv.isDead = true;
        }
        System.out.println("Sun sets in 18 hours");
        
        //Cycle Start
        
        while (time > 0 && (!inv.isDead)){
            System.out.println();
            System.out.println("Enter the number corresponding to what action you want to take");
            System.out.println("Rest = 1 | Woodchopping = 2 | Hunting = 3 | Eating = 4 | Crafting = 5| Stoke the Fire = 6 | End the Day = 7");
            int answer = in.nextInt();
            System.out.println();
            
            //Rest
            if (answer == 1){
                System.out.println("How many hours would you like to rest?");
                int restTime = in.nextInt();
                if(restTime <= time){
                    time = time - restTime;
                    inv.stamina = inv.stamina + (restTime * 5);
                    inv.sanity = inv.sanity + (restTime * 2);
                    inv.hunger += restTime;
                    inv.fire -= restTime;
                } else {
                    restTime = time;
                    time = time - restTime;
                    inv.stamina = inv.stamina + (restTime * 5);
                    inv.sanity = inv.sanity + (restTime * 2);           
                    inv.hunger += restTime;
                    inv.fire -= restTime;
                }
                if (inv.fire < 0){
                    inv.fire = 0;
                }
                System.out.println();
                if (inv.fire > 0){
                    System.out.println("The fire is stoked for " + inv.fire + " more hours...");
                    inv.sanity++;
                } else {
                    System.out.println("The fire is out.");
                }
                
                System.out.println("Wood = " + inv.wood);
                System.out.println("Health = " + inv.health);
                System.out.println("Stamina = " + inv.stamina);
                System.out.println("Sanity = " + inv.sanity);
                System.out.println("Food = " + inv.food);
                if(inv.hunger >= 25){
                    System.out.println("You are hungry.");
                }
                if (inv.hunger >= 75){
                    System.out.println("You are very hungry");
                    inv.sanity -= 5;
                }
                if (inv.hunger >= 150){
                    System.out.println("You are starving");
                    inv.sanity -= 25;
                }
                if (inv.hunger >= 200){
                    System.out.println("You have starved");
                    inv.isDead = true;
                }
                System.out.println("Hours left in the day = " + time);
                System.out.println();
            }
            
            //Woodchopping
            if (answer == 2){
                int hoursChopping = 0;
                boolean passedOut = false;
                System.out.println("How many hours would you like to lumber?");
                int lumberTime = in.nextInt();
                if (lumberTime > time){
                    lumberTime = time;
                }
                for(int chopping = 0; chopping < lumberTime; chopping++){
                    if (inv.Axe){
                        inv.wood += 2;
                        System.out.println("Wood + 2");
                        double axeBreak = Math.random();
                        if (axeBreak <= 0.02){
                            System.out.println("Your axe broke!");
                            inv.Axe = false;
                        }
                    } else {
                        inv.wood++;
                        System.out.println("Wood + 1");
                        }
                    inv.stamina = inv.stamina - 15;
                    hoursChopping++;
                    inv.hunger += 3;
                    if (inv.stamina <= 0){
                        chopping = lumberTime;
                        passedOut = true;
                        inv.sanity -= 1;
                        inv.stamina = 0;
                    }
                    time--;
                    inv.fire--;
                }
                if (inv.fire < 0){
                    inv.fire = 0;
                }
                System.out.println();
                if (inv.fire > 0){
                    System.out.println("The fire is stoked for " + inv.fire + " more hours...");
                    inv.sanity++;
                } else {
                    System.out.println("The fire is out.");
                }
                System.out.println("Wood = " + inv.wood);
                System.out.println("Health = " + inv.health);
                System.out.println("Stamina = " + inv.stamina);
                System.out.println("Sanity = " + inv.sanity);
                System.out.println("Food = " + inv.food);
                System.out.println("Hours left in the day = " + time);
                if(inv.hunger >= 25){
                    System.out.println("You are hungry.");
                }
                if (inv.hunger >= 75){
                    System.out.println("You are very hungry");
                    inv.sanity -= 5;
                }
                if (inv.hunger >= 150){
                    System.out.println("You are starving");
                    inv.sanity -= 25;
                }
                if (inv.hunger >= 200){
                    System.out.println("You have starved");
                    inv.isDead = true;
                }
                if(passedOut){
                    System.out.println("You passed out after " + hoursChopping + " hours.");
                }
                System.out.println();
            }
            
            //Hunting
            if (answer == 3){
                System.out.println("How many hours would you like to Hunt?");
                int huntingTime = in.nextInt();
                if (huntingTime > time){
                    huntingTime = time;
                }
                int rabbit = 0;
                int deer = 0;
                int boar = 0;
                int moose = 0;
                int hunted = 0;
                boolean hangover = false;
                        
                        
                //has spear
                if (inv.Spear){
                    for (int hunting = 0; hunting < huntingTime; hunting++){
                        double getgot = Math.random();
                        double spearBreak = Math.random();
                        if (getgot <= 0.049){
                            System.out.println("You were attacked by a wild boar!");
                            inv.health-= 5;
                        }
                        if (getgot <= 0.5 && getgot >= 0.05){
                            System.out.println("You got: Nothing!");
                        }
                        if (getgot <= 0.75 && getgot >= 0.51){
                            System.out.println("You got a rabbit!");
                            rabbit++;
                            inv.food += 5;
                        }
                        if (getgot <= 0.87 && getgot >= 0.76){
                            System.out.println("You got a deer!");
                            deer++;
                            inv.food += 20;
                        }
                        if (getgot <= 0.99 && getgot >= 0.88){
                            System.out.println("You got a boar!");
                            boar++;
                            inv.food += 25;
                        }
                        if (getgot >= 0.991){
                            System.out.println("!!!!! You got a moose !!!!!");
                            moose++;
                            inv.food += 100;
                            inv.sanity += 20;
                        }
                        if (spearBreak <= 0.2){
                            inv.Spear = false;
                            System.out.println("Your spear broke!");
                        }
                        time--;
                        inv.fire--;
                        inv.stamina -= 15;
                        hunted++;
                        if (inv.stamina <= 0){
                        hunting = huntingTime;
                        hangover = true;
                        inv.sanity -= 1;
                        inv.stamina = 0;
                        }
                        
                    }
                    System.out.println();
                    System.out.println("You caught " + rabbit + " rabbits!");
                    System.out.println("You caught " + deer + " deer!");
                    System.out.println("You caught " + boar + " boars!");
                    System.out.println("You caught " + moose + " moose!");
                    System.out.println();
                } 
                else //no spear
                {
                    for (int hunting = 0; hunting < huntingTime; hunting++){
                        double getgot = Math.random();
                        double spearBreak = Math.random();
                        if (getgot <= 0.1){
                            System.out.println("You were attacked by a wild boar!");
                            inv.health-= 5;
                        }
                        if (getgot <= 0.70 && getgot >= 0.11){
                            System.out.println("You got: Nothing!");
                        }
                        if (getgot <= 0.90 && getgot >= 0.71){
                            System.out.println("You got a rabbit!");
                            rabbit++;
                            inv.food += 5;
                        }
                        if (getgot <= 0.95 && getgot >= 0.91){
                            System.out.println("You got a deer!");
                            deer++;
                            inv.food += 20;
                        }
                        if (getgot <= 1 && getgot >= 0.96){
                            System.out.println("You got a boar!");
                            boar++;
                            inv.food += 25;
                        }
                        inv.fire--;
                        time--;
                        inv.stamina -= 20;
                        hunted++;
                        if (inv.stamina <= 0){
                        hunting = huntingTime;
                        hangover = true;
                        inv.sanity -= 1;
                        inv.stamina = 0;
                        }
                    }
                    System.out.println();
                    System.out.println("You caught " + rabbit + " rabbits!");
                    System.out.println("You caught " + deer + " deer!");
                    System.out.println("You caught " + boar + " boars!");
                    System.out.println();
                } 
                if (inv.fire < 0){
                    inv.fire = 0;
                }
                System.out.println();
                if (inv.fire > 0){
                    System.out.println("The fire is stoked for " + inv.fire + " more hours...");
                    inv.sanity++;
                } else {
                    System.out.println("The fire is out.");
                    inv.health--;
                }
                System.out.println("Wood = " + inv.wood);
                System.out.println("Health = " + inv.health);
                System.out.println("Stamina = " + inv.stamina);
                System.out.println("Sanity = " + inv.sanity);
                System.out.println("Food = " + inv.food);
                System.out.println("Hours left in the day = " + time);
                if(inv.hunger >= 25){
                    System.out.println("You are hungry.");
                }
                if (inv.hunger >= 75){
                    System.out.println("You are very hungry");
                    inv.sanity -= 5;
                }
                if (inv.hunger >= 150){
                    System.out.println("You are starving");
                    inv.sanity -= 25;
                }
                if (inv.hunger >= 200){
                    System.out.println("You have starved");
                    inv.isDead = true;
                }
                if(hangover){
                    System.out.println("You passed out after " + hunted + " hours.");
                }
                System.out.println();
                
            }
            
            //Eating
            if (answer == 4){
                int cookedFood = 0;
                System.out.println("You have " + inv.food + " food");
                System.out.println("Would you like to cook your food? --> 1 for yes | 2 for no");
                int chef = in.nextInt();
                if (chef == 1){
                    System.out.println("25 food is cooked every hour");
                    System.out.println("How many hours would you like to cook your food?");
                    int cooking = in.nextInt();
                    if (cooking > 0){
                        
                    }
                    if (cooking > time){
                        cooking = time;
                    }
                    for (int heating = 0; heating < cooking; heating++){
                        if (inv.food >= 25){
                            if (inv.fire > 0){
                                inv.food -= 25;
                                cookedFood += 50;
                                inv.fire -= 1;
                                time -= 1;
                                inv.hunger += 3;
                                inv.sanity += 1;
                            } else {
                                System.out.println("You ran out of fire.");
                            }
                            
                        } else {
                            System.out.println("You have run out of food to cook.");
                        }
                    }
                }
                int combinedFood = inv.food + cookedFood;
                inv.food = 0;
                cookedFood = 0;
                System.out.println("You ate " + combinedFood + " food");
                System.out.println("You recovered " + combinedFood + " hunger");
                inv.stamina += combinedFood;
                time -= 1;
                inv.hunger -= combinedFood;
                if (inv.fire < 0){
                    inv.fire = 0;
                }
                System.out.println();
                if (inv.fire > 0){
                    System.out.println("The fire is stoked for " + inv.fire + " more hours...");
                    inv.sanity++;
                } else {
                    System.out.println("The fire is out.");
                }
                System.out.println("Wood = " + inv.wood);
                System.out.println("Health = " + inv.health);
                System.out.println("Stamina = " + inv.stamina);
                System.out.println("Sanity = " + inv.sanity);
                System.out.println("Food = " + inv.food);
                System.out.println("Hours left in the day = " + time);
                if(inv.hunger >= 25){
                    System.out.println("You are hungry.");
                }
                if (inv.hunger >= 75){
                    System.out.println("You are very hungry");
                    inv.sanity -= 5;
                }
                if (inv.hunger >= 150){
                    System.out.println("You are starving");
                    inv.sanity -= 25;
                }
                if (inv.hunger >= 200){
                    System.out.println("You have starved");
                    inv.isDead = true;
                }
                System.out.println();
                
                
                
            }
            
            //Crafting
            if (answer == 5){
                if (inv.Axe){
                    System.out.println("You already have an Axe");
                }
                if (inv.Spear){
                    System.out.println("You already have a Spear");
                }
                System.out.println("You have " + inv.wood + " wood");
                System.out.println("It takes 10 wood and 2 hours to craft an Axe or Spear");
                System.out.println("Enter 1 to craft Axe | Enter 2 to craft Spear");
                int crafting = in.nextInt();
                if (crafting == 1){
                    if (!(inv.Axe)){
                        if(inv.wood < 10){
                            System.out.println("Insufficient materials");
                            inv.sanity--;
                        } else {
                            inv.wood -= 10;
                            inv.Axe = true;
                            time -= 2;
                            inv.fire -= 2;
                        }
                        
                    } else {
                        System.out.println("You already have an Axe!");
                    }
                }
                if (crafting == 2){
                    if (!(inv.Spear)){
                        if(inv.wood < 10){
                            System.out.println("Insufficient materials");
                            inv.sanity--;
                        } else {
                            inv.wood -= 10;
                            inv.Spear = true;
                            time -= 2;
                            inv.fire -= 2;
                        }
                        
                    } else {
                        System.out.println("You already have a Spear!");
                    }
                }
        if (inv.fire < 0){
            inv.fire = 0;
        }
        System.out.println();
        if (inv.fire > 0){
            System.out.println("The fire is stoked for " + inv.fire + " more hours...");
            inv.sanity++;
        } else {
            System.out.println("The fire is out.");
        }
        System.out.println("Wood = " + inv.wood);
        System.out.println("Health = " + inv.health);
        System.out.println("Stamina = " + inv.stamina);
        System.out.println("Sanity = " + inv.sanity);
        System.out.println("Food = " + inv.food);
        System.out.println("Hours left in the day = " + time);
        if (inv.Axe){
            System.out.println("You have an Axe");
        }
        if (inv.Spear){
            System.out.println("You have a Spear");
        }
        if(inv.hunger >= 25){
            System.out.println("You are hungry.");
        }
        if (inv.hunger >= 75){
            System.out.println("You are very hungry");
            inv.sanity -= 5;
        }
        if (inv.hunger >= 150){
            System.out.println("You are starving");
            inv.sanity -= 25;
        }
        if (inv.hunger >= 200){
            System.out.println("You have starved");
            inv.isDead = true;
        }
        System.out.println();
            }
            
            //Fire
            if (answer == 6){
                if (inv.fire < 0){
                    inv.fire = 0;
                }
                if (inv.fire > 0){
                    System.out.println("The fire is stoked for " + inv.fire + " more hours...");
                    inv.sanity++;
                } else {
                    System.out.println("The fire is out.");
            }
                System.out.println("You have " + inv.wood + " wood");
                System.out.println("How much wood would you like to add to the fire?");
                int stoking = in.nextInt();
                if (stoking > inv.wood){
                    stoking = inv.wood;
                }
                inv.fire += stoking;
                inv.sanity += stoking;
                inv.wood -= stoking;
                System.out.println();
                if (inv.fire > 0){
                    System.out.println("The fire is stoked for " + inv.fire + " more hours...");
                    inv.sanity++;
                } else {
                    System.out.println("The fire is out.");
                    inv.health--;
                }
                System.out.println("Wood = " + inv.wood);
                System.out.println("Health = " + inv.health);
                System.out.println("Stamina = " + inv.stamina);
                System.out.println("Sanity = " + inv.sanity);
                System.out.println("Food = " + inv.food);
                System.out.println("Hours left in the day = " + time);
                if(inv.hunger >= 25){
                    System.out.println("You are hungry.");
                }
                if (inv.hunger >= 75){
                    System.out.println("You are very hungry");
                    inv.sanity -= 5;
                }
                if (inv.hunger >= 150){
                    System.out.println("You are starving");
                    inv.sanity -= 25;
                }
                if (inv.hunger >= 200){
                    System.out.println("You have starved");
                    inv.isDead = true;
                }
                System.out.println();
                
            }
            
            //End Day
            if (answer == 7){
                time = 0;
            }
            
        }
        
    }
    
    
    
    
    
    public int getTime(){
        return time;
    }
}
