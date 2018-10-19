/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        
        String name, address, city, province, postal, myLine, amount;
        int num;
        
        
        PrintWriter fileOut = new PrintWriter(new FileWriter("customersList.txt", true));
        
        BufferedReader readFile = new BufferedReader(new FileReader("customersList.txt"));
        
        while ((myLine = readFile.readLine()) != null){
            System.out.println(myLine);
        }
        
        boolean error = true;
        
        
        amount = JOptionPane.showInputDialog("How many customers would you like to enter?");
          
        num = Integer.parseInt(amount);
        
        
        for (int i = 0; i <= num ; i++){
            name = JOptionPane.showInputDialog("Please enter your full name.");
        
        address = JOptionPane.showInputDialog("Please enter your address.");
        
        city = JOptionPane.showInputDialog("Please enter the city you live in.");
        
        province = JOptionPane.showInputDialog("Please enter the province you live in.");
        
        postal = JOptionPane.showInputDialog("Please enter your postal code.");
        
        if (Character.isLetter(postal.charAt(0)) && Character.isDigit(postal.charAt(1)) &&
                Character.isLetter(postal.charAt(2)) && Character.isDigit(postal.charAt(3)) &&
                Character.isLetter(postal.charAt(4)) && Character.isDigit(postal.charAt(5))){
            JOptionPane.showMessageDialog(null,"This is a valid postal code, Thank your for"
                    + " inputing the customers");
            error = false;
    }else{
            postal = JOptionPane.showInputDialog("Please enter a valid postal code.");
        }
        
        fileOut.println("\n" + name + "\n" + address + "\n" + city + "\n" +
                province + "\n" + postal);
        
        fileOut.println("------------------------------------");
        }
        
        fileOut.close();
        
        
    }
    
}
