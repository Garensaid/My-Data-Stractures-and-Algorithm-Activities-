import java.util.Scanner;

public class StudentScores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //store 5 student score
        int[] scores = new int[5];
            System.out.println("1. Add Score");
            System.out.println("2. Delete Score");
            System.out.println("3. View All Scores");
            System.out.println("4. Exit");
                        int score = sc.nextInt();
                        scores[count] = score;
                        count++;
            System.out.print("Enter your choice: ");
            //To select the number of choice.
            int choice = sc.nextInt();
            //declare switch case to random select of numbers.
            switch (choice) {
				//Here is to add scores.
                case 1:
                    if (count < scores.length) {
                        System.out.print("Enter student score: ");
                        System.out.println("Score added.");
                    }
                    break;
                    //Here is to delete scores from given input of user
                case 2:
                    if (count > 0) {
                        System.out.print("Enter the index of the score to delete (1 to " + count + "): ");
                        int index = sc.nextInt();
                        if (index > 0 && index <= count) {
                            for (int i = index - 1; i < count - 1; i++) {
        //I used count, to count the number of scores.
        int count = 0;
        boolean exit = false;

         //Here, I used while loop without exiting the program.
        while (!exit) {
            System.out.println("--- Student Scores ---\n");
                                scores[i] = scores[i + 1];
                            }
                            count--;
                            System.out.println("Score deleted.");
                        } else {
                            System.out.println("Invalid index.");
                      }
                    } else {
					         System.out.println("No scores to delete.");
					            }
					   break;
					   //Here is to view all the score from give input
					   case 3:
					         System.out.print("Scores: ");
					          if (count == 0) {
					              System.out.println("No scores available.");
					          } else {
					              for (int i = 0; i < count; i++) {
					                 System.out.print(scores[i] + " ");
					                  }
					                  System.out.println();
					                  }
					    break;
					    //Here is you want to exit the program.
					   case 4:
				       exit = true;
				       //The program will exit when the user gives wrong number.
					      System.out.println("Exit program.");
					   break;
					   default:
					   //If invalid choice, user have a chance to select the valid choice.
					      System.out.println("Invalid choice. Try Again.");
					   }
			     }
		 }
 }



