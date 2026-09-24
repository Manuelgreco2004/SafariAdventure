import java.util.Scanner;

public class SafariGame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-----------------");
        System.out.println("");
        System.out.println("Welcome to Safari Adventure!");
        System.out.println("");
        

    
        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day + ":");
            System.out.println("");
            
    
            boolean keep_asking = true;

            //Step 2: Do-While Loop

            do{
            System.out.print("Where would you like to explore? (Jungle, River, Desert, Mountains): ");
            String area = sc.nextLine();

            if (area.equals("Jungle")){
                keep_asking = false;
                System.out.println("You chose: " + area);

            }

            else if (area.equals("River")){
                keep_asking = false;
                System.out.println("You chose: " + area);
            }
            
            else if (area.equals("Desert")){
                keep_asking = false;
                System.out.println("You chose: " + area);
            }

            else if (area.equals("Mountains")){
                keep_asking = false;
                System.out.println("You chose: " + area);
            }

            


            else{
                System.out.println("Invalid area, please try again");
                keep_asking = true;
            }


        } while (keep_asking);
        }

        
        
        sc.close();
        System.out.println("Safari complete!");
    }
}
