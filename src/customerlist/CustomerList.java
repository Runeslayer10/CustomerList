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
        
        String name, address, city, province, postal, myLine;
        
        PrintWriter fileOut = new PrintWriter(new FileWriter("customersList.txt", true));
        
        BufferedReader readFile = new BufferedReader(new FileReader("customersList.txt"));
        
        while ((myLine = readFile.readLine()) != null){
            System.out.println(myLine);
        }
        
        name = JOptionPane.showInputDialog("Please enter your full name.");
        
        address = JOptionPane.showInputDialog("Please enter your address.");
        
        city = JOptionPane.showInputDialog("Please enter the city you live in.");
        
        province = JOptionPane.showInputDialog("Please enter the province you live in.");
        
        fileOut.println(name + "\n" + address + "\n" + city + "\n" +
                province + "\n" + "x");
        
        fileOut.close();
        
    }
    
}
