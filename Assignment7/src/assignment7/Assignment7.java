/*
course: CSC 310
project: Assignment 7
date: 04/16/2020
author: Katlyn Murphy
purpose: The purpose of this assignment is to write a program in Java that 
maintains an AVL tree for keeping Customer objects (with name, account number, 
and balance as their attributes) in the tree.  The nodes are sorted based on 
customers’ account numbers.  The program shall present the user with a menu that 
allows him or her to search for a specified customer by name, insert a new customer, 
delete an existing customer, or print the entire AVL tree.  The printed tree should 
contain the node level number and nodes’ data.  
 */
package assignment7;
import java.util.Scanner;

public class Assignment7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AVLTree account = new AVLTree(); 
        
        //input variables
        int x = 0;
        String name = "";
        int accountNum = 0;
        double balance = 0.0;

        //provide a simple menu to allow a user to perform the related tasks in course
        while (true && (x != 1 || x != 2 || x != 3 || x != 4 || x != 5)) { //continuously run menu and input validation {
            //print out options to user 
            System.out.println("1. Search for a customer by name: ");
            System.out.println("2. Insert a new customer: ");
            System.out.println("3. Delete an existing customer: ");
            System.out.println("4. Print entire AVL tree: ");          
            System.out.println("5. Exit ");
            System.out.println("====================================");
            System.out.println("Please enter a number (1-5): ");
            x = in.nextInt();
            switch (x) //call each element in menu by users choice
            {
                case 1: //search for a customer by name
                    System.out.println("Please enter the name of the customer you would like to search: ");
                    name = in.next();
                    System.out.println("Please enter the account number of the customer you would like to search: ");
                    accountNum = in.nextInt();
                    System.out.println("Please enter the balance of the customer you would like to search: ");
                    balance = in.nextDouble();
                    account.root = account.find(account.root, name, accountNum, balance);
                    break;
                case 2: //insert a new customer
                    System.out.println("Please enter the name of the customer you would like to add: ");
                    name = in.next();
                    System.out.println("Please enter the account number of the customer you would like to add: ");
                    accountNum = in.nextInt();
                    System.out.println("Please enter the balance of the customer you would like to add: ");
                    balance = in.nextDouble();
                    account.root = account.insert(account.root, name, accountNum, balance);
                    System.out.println();
                    break;
                case 3: //delete an existing customer
                    System.out.println("Please enter the name of the customer you would like to delete: ");
                    name = in.next();
                    System.out.println("Please enter the account number of the customer you would like to delete: ");
                    accountNum = in.nextInt();
                    System.out.println("Please enter the balance of the customer you would like to delete: ");
                    balance = in.nextDouble();
                    account.root = account.deleteNode(account.root, name, accountNum, balance);
                    System.out.println();
                    break;
                case 4: //print entire AVLTree
                    account.printTree(account.root);
                    System.out.println();
                    break;     
                case 5: //exit program
                    System.out.println("Thank you for using my program! "); //exit program
                    System.exit(1);
                    break;
                default: //default 
                    System.out.println("Invalid input, please try again!");
            } //end of switch statement
        } //end of while loop
    } //end of main
} //end of public class