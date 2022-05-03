package com.techelevator.tenmo.services;


import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static org.bouncycastle.asn1.x509.X509ObjectIdentifiers.id;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("*********************");
        System.out.println("* Welcome to TEnmo! *");
        System.out.println("*********************");
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("1: View your current balance");
        System.out.println("2: View your past transfers");
        System.out.println("3: View your pending requests");
        System.out.println("4: Send TE bucks");
        System.out.println("5: Request TE bucks");
        System.out.println("0: Exit");
        System.out.println();
    }

    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

    public void displayLisOfUsers(List<User> users) {


        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Users" + "     " + "Name\n" + "ID");
        System.out.println("---------------------------------------");



        users.forEach((user) -> {
            String format = "%d %10s";
            String message = String.format(format, user.getId(), user.getUsername());
            System.out.println(message);
        });

        System.out.println("---------------------------------------");

    }

    public String getIdOfSelectedUser() {
            System.out.println();
            System.out.print("Enter ID of user you are sending to (0 to cancel): ");
            String id = scanner.nextLine().trim().toUpperCase();
            return id;
    }

    public User getUser(List<User> users, String id) {
        User selectedUser = null;
        for (User user : users) {
            if (user.getId().toString().equals(id)) {
                selectedUser = user;
            }
        }
        return selectedUser;
    }

    public BigDecimal promptForAmount() {
        System.out.println("");
        System.out.println("please enter amount: ");
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }

    }

    public void displayNotEnoughBalance(){
        System.out.println("You do not have enough balance in your account to transfer.");
    }

    public void displayNotAbleToSendMoneyToSelf(){
        System.out.println("You can not send money to your self.");
    }

    public void displayMessageInValidAmount(){
        System.out.println("You can not transfer negative or 0 amount.");
    }

    public void displayTransferHistory(List<Transfer> transfers, AuthenticatedUser currentUser) {

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Transfers\n" + "ID           From/To             Amount");
        System.out.println("---------------------------------------");

        for(Transfer transfer : transfers) {
            String message;
            if(transfer.getFromUserId() == currentUser.getUser().getId()) {
                String format = "%-12d To: %-15s $ %.2f";
                 message = String.format(format, transfer.getTransfer_id(), transfer.getUsernameTo(), transfer.getAmount());
            }
            else {
                String format = "%-12d From: %-13s $ %.2f";
                 message = String.format(format, transfer.getTransfer_id(), transfer.getUsernameFrom(), transfer.getAmount());
            }
            System.out.println(message);
        }
    }

    public String getTransferIdOfUser() {
        System.out.println();
        System.out.print("Please enter transfer ID to view details (0 to cancel): ");
        String transferId = scanner.nextLine().trim().toUpperCase();
        return transferId;
    }


    public void displayTransferDetails(Transfer transfer) {
        System.out.println("---------------------------------");
        System.out.println("Transfer Details");
        System.out.println("---------------------------------");
        System.out.println("Id: " + (transfer.getTransfer_id())
                + "\nFrom: " + (transfer.getUsernameFrom())
                + "\nTo: " + (transfer.getUsernameTo())
                + "\nType: " + (transfer.getTransfer_type_desc())
                + "\nStatus: " + (transfer.getTransfer_status_desc())
                + "\nAmount: $" + (transfer.getAmount()));
    }

    public void dipsplayTransferIdNotFound() {
        System.out.println("Transfer ID not found!");
    }

    public void displayAccountBalance(BigDecimal balance) {
        System.out.println("Your current balance is: " + balance);
    }

    public void displayTransferStatus(String transfer_status_desc) {
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("Transfer status: " + transfer_status_desc);
        System.out.println("-----------------------------------");
    }
}
