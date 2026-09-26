import java.util.Scanner;
import java.util.Random;

public class SafariAdventure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int totalPoints = 0;
        int targetPoints = 100;
        boolean survived = true; // Tracks if the player is still alive
        
        System.out.println("-----------------");
        System.out.println("");

        System.out.println("Welcome to the 5-Day Safari Adventure!");
        System.out.println("Goal: Survive 5 days and collect at least " + targetPoints + " points.\n");
        
        // 1. for Loop — Daily Exploration (5 days)
        for (int day = 1; day <= 5; day++) {
            System.out.println("=================================");
            System.out.println("--- DAY " + day + " of 5 ---");
            System.out.println("Current Total Points: " + totalPoints);
            System.out.println("=================================");
            
            String area = "";
            
            // 2. do...while Loop — Choose Area to Explore, input validation
            do {
                System.out.print("Choose an area to explore (Jungle, River, Desert, Mountains): ");
                area = sc.nextLine().trim();
                
                if (!area.equalsIgnoreCase("Jungle") && 
                    !area.equalsIgnoreCase("River") && 
                    !area.equalsIgnoreCase("Desert") && 
                    !area.equalsIgnoreCase("Mountains")) {
                    System.out.println("Invalid choice! Please type Jungle, River, Desert, or Mountains.");
                }
            } while (!area.equalsIgnoreCase("Jungle") && 
                     !area.equalsIgnoreCase("River") && 
                     !area.equalsIgnoreCase("Desert") && 
                     !area.equalsIgnoreCase("Mountains"));
            
            System.out.println("Exploring the " + area + " today...\n");
            
            int eventsCount = 0;
            int dailyPoints = 0;
            boolean escapedDanger = false;
            
            // 3. while Loop — Simulate up to 3 events in the chosen area
            while (eventsCount < 3 && !escapedDanger) {
                eventsCount++;
                int eventType = random.nextInt(4); // Randomizes between 0, 1, 2, or 3
                
                // 4. continue — Harmless Event, can continue (eventType == 0)
                if (eventType == 0) {
                    System.out.println("Event " + eventsCount + ": Harmless bird sighting. Nothing much happens.");
                    continue;
                }
                
                // 5. break — Escape Danger (eventType == 3)
                if (eventType == 3) {
                    
                    // Individual species in each area for the 'danger' part
                    String animal = "";
                    if (area.equalsIgnoreCase("Jungle")) {
                        animal = "panther";
                    } else if (area.equalsIgnoreCase("River")) {
                        animal = "crocodile";
                    } else if (area.equalsIgnoreCase("Desert")) {
                        animal = "horned viper";
                    } else { // Mountains
                        animal = "cougar";
                    }
                    System.out.println("Event " + eventsCount + ": DANGER! A " + animal + " blocks your path!");
                    System.out.print("Type 'run' to escape: ");
                    String action = sc.nextLine().trim();
                    
                    if (action.equalsIgnoreCase("run")) {
                        System.out.println("You safely escape back to camp, ending today's exploration early!\n");
                        escapedDanger = true;
                        break; // Break out of the event while loop since escaped danger
                    } else {
                        
                            System.out.println("CRITICAL FAILURE! The predator attacked you. You did not survive the encounter!");
                            survived = false; // Game Over for the player
                            break; // Break out of the event while loop
                        }
            
                } else if (eventType == 1) {
                    System.out.println("Event " + eventsCount + ": You discovered a rare medicinal plant! (+20 points)");
                    totalPoints += 20;
                    dailyPoints += 20;
                } else if (eventType == 2) {
                    System.out.println("Event " + eventsCount + ": You found a hidden water spring and supplies! (+15 points)");
                    totalPoints += 15;
                    dailyPoints += 15;
                }
            }
            
            // If the player did not survive the day's events, break out of the 5-day FOR loop immediately
            if (!survived) {
                break;
            }
            
            System.out.println("End of Day " + day + " Summary: You gained " + dailyPoints + " points today.\n");
        }
        
        // End of Game Summary
        System.out.println("=================================");
        System.out.println("       SAFARI ADVENTURE OVER     ");
        System.out.println("=================================");
        System.out.println("You collected " + totalPoints + " points.");
        
        // Check if the player had survived encounters beforehand, if not, continue and calculate if the goal was met.
        if (!survived) {
            System.out.println("Result: GAME OVER! You did not survive the safari. Try again...");
        } else if (totalPoints >= targetPoints) {
            System.out.println("Result: SUCCESS! You survived and collected enough resources to complete the safari!");
        } else {
            System.out.println("Result: FAILED! You survived, but you did not reach the " + targetPoints + " point threshold.");
        }
        
        sc.close();
    }
}