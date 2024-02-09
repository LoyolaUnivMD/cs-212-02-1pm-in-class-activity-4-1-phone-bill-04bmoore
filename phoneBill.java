/* Programmers:  Brendan
   Course:  CS212
   Due Date: 02/02/24
   Class Activity 4
   Problem Statement: Calculate the monthly bill for a cell phone data plan
   Data In: The subscription package type, amount of data used
   Data Out: The total cost of the monthly bill
   Credits: None
*/
import java.util.Scanner;
import java.text.DecimalFormat;
class phoneBill {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Phone Bill Activity!");

        //Determine user's package
        System.out.println(" What subscription package do you have? (green,blue,purple) ");
        String package_Type = scan.nextLine().toLowerCase();


        //Check for valid input
        //Calculate cost based on user's package and their data usage
        while(!(package_Type.equals("green") || package_Type.equals("blue") || package_Type.equals("purple"))){
            System.out.println("Your input for package name is invalid");
            System.out.println(" What subscription package do you have? (green,blue,purple) ");
            package_Type = scan.nextLine().toLowerCase();
        }

        //Input for GB usage
        System.out.println("How many Gigabits of data did you use?: ");
        int data = Integer.parseInt(scan.nextLine());

        //Variables initialized for green package
        int data_incl = 2;
        int price_per_GB = 15;
        double price = 49.99;


        //Variables for blue package
        if(package_Type.equals("blue")){
            data_incl = 4;
            price_per_GB = 10;
            price = 70;
        }
        //Purple package price
        else if(package_Type.equals("purple")){
            price = 99.95;
        }

        //Add cost of extra data usage
        if(!(package_Type.equals("purple")) && data >= data_incl){
            double data_price = (data - data_incl) * price_per_GB;
            price += data_price;
        }

        //Coupon for green package
        if(package_Type.equals("green")){
            System.out.println("Do you have a coupon? (yes or no): ");
            String coupon = scan.nextLine().toLowerCase();
            //Error checking input
            while(!(coupon.equals("yes") || coupon.equals("no"))){
                System.out.println("Invalid input. Please enter 'yes' or 'no' ");
                coupon = scan.nextLine().toLowerCase();
            }
            if(coupon.equals("yes") && price >= 75){
                price -= 20;
            }
        }

        //DecimalFormat with $ and two decimal places
        DecimalFormat df = new DecimalFormat("$#.##");

        //Output of monthly bill
        System.out.println("Your monthly bill is " + df.format(price));

    }
}
