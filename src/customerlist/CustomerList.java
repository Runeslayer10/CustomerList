/*
 * Blake Hadaway
 * October 22. 2018
 * This program asks the user to input a number of customers to enter into a business
 * list of there info.
 */

package customerlist;
import java.io.*;
import javax.swing.*;
/**
 *
 * @author blhad3491
 */
public class CustomerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //variables section
        String name, address, city, province, postal, myLine, amount;
        int numCust = 0;
        boolean noError = true;
        boolean isError = true;
        
        //checking if there is any info in customerList.txt
        PrintWriter fileOut = new PrintWriter(new FileWriter("customersList.txt", true));
        
        // allows me to writing to customerList.txt
        BufferedReader readFile = new BufferedReader(new FileReader("customersList.txt"));
        
        //this outputs what is on the file to the text box
        while ((myLine = readFile.readLine()) != null){
            System.out.println(myLine);
        }
        
        // while there is no error, the user can input the number of customers
        while (noError){
        amount = JOptionPane.showInputDialog("How many customers would you like to enter?");
        
        // try and catch to catch unacceptable inputs from user
        try{
            numCust = Integer.parseInt(amount);
            noError = false;
        
        // catching if user doesn't enter a integer value for number of customers
            }catch(NumberFormatException nfe){
                System.out.println("Please Enter a integer for the number of customers"
                + " you'd like to add.");
                System.out.println(nfe);
            }
        }

        //for loop for how many customers to enter into the text file
        for (int i = 0; i < numCust ; i++){
            name = JOptionPane.showInputDialog("Please enter the customers full name.");
        
        address = JOptionPane.showInputDialog("Please enter the customers address.");
        
        city = JOptionPane.showInputDialog("Please enter the city the customer lives in.");
        
        province = JOptionPane.showInputDialog("Please enter the province the customer lives in.");
        
        postal = JOptionPane.showInputDialog("Please enter the customers postal code."
                + " (NO SPACES)");
        
        //while there is an error, this will keep running till the usering inputs 
        //an acceptable postal code
        while (isError){
        
            //checking each character to fit postal code form
            if (Character.isLetter(postal.charAt(0)) && Character.isDigit(postal.charAt(1)) &&
                Character.isLetter(postal.charAt(2)) && Character.isDigit(postal.charAt(3)) &&
                Character.isLetter(postal.charAt(4)) && Character.isDigit(postal.charAt(5))){
            JOptionPane.showMessageDialog(null,"This is a valid postal code, Thank your for"
                    + " inputing the customers");
            isError = false;
            
            //this is if the user doesn/t input in postal code form
            }else{
            postal = JOptionPane.showInputDialog("This is not a vaild postal code, please try again."
                    + " (Remember no spaces!!)");
        }
        }
        
        //this is writing into the file
        fileOut.println("\n" + name + "\n" + address + "\n" + city + "\n" +
                province + "\n" + postal);
        
        // makes the list look better
        fileOut.println("------------------------------------");
        }
        
        //closes the file
        fileOut.close();   
    }
}
