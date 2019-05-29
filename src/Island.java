
public class Island {

    public static void main(String[] args) {
        double savior = 0;
        Day cycle = new Day();
        for (int i = 0; i < 100; i++){
            cycle.cycle();
            double saved = Math.random();
            if (saved <= savior){
                System.out.println("YOU WERE SAVED!!");
                System.out.println("YOU WERE SAVED!!!");
                System.out.println("YOU WERE SAVED!!!");
            }
            savior += 0.01;
        }
        
        
    }
    
}
