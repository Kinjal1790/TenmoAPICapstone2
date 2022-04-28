package com.techelevator.tenmo;

import com.techelevator.tenmo.model.*;
import com.techelevator.tenmo.services.*;
import org.apiguardian.api.API;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final UserService userService = new UserService(API_BASE_URL);
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private final AccountService accountService = new AccountService(API_BASE_URL);
    private final TransferService transferService = new TransferService(API_BASE_URL);
    private final Account account = new Account();
    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
        accountService.setAuthToken(currentUser.getToken());
        userService.setAuthToken(currentUser.getToken());
        transferService.setAuthToken(currentUser.getToken());

    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                viewCurrentBalance();
            } else if (menuSelection == 2) {
                viewTransferHistory();
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();
            } else if (menuSelection == 5) {
                requestBucks();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

	private void viewCurrentBalance() {
		// TODO Auto-generated method stub

        System.out.println("Your current account balance is: " + account.getBalance());

	}

	private void viewTransferHistory() {
		// TODO Auto-generated method stub
		
	}

	private void viewPendingRequests() {
		// TODO Auto-generated method stub
		
	}

	private void sendBucks() {
		// TODO Auto-generated method stub
        while(true) {
            List<User> users = userService.getAllUser();
            consoleService.displayLisOfUsers(users);
            String userIdOfSelectedUser = consoleService.getIdOfSelectedUser();

            User selectedUser = consoleService.getUser(users, userIdOfSelectedUser);
            if(selectedUser.getId() != currentUser.getUser().getId()) {
                viewCurrentBalance();
                BigDecimal amountToTransfer = consoleService.promptForAmount();

                if (amountToTransfer.equals(account.getBalance())) {
                    Transfer transfer = new Transfer(currentUser.getUser().getId(), selectedUser.getId(), amountToTransfer);
                    transferService.initiateTransfer(transfer);
                } else {
                    consoleService.displayNotEnoughBalance();
                }
            }
            else{
                consoleService.displayNotAbleToSendMoneyToSelf();
            }

        }
	}

	private void requestBucks() {
		// TODO Auto-generated method stub
		
	}

}
