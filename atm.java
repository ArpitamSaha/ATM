import java.util.HashMap;
import java.util.Scanner;

public class atm {
    static Scanner sc = new Scanner(System.in);

    static HashMap<String, Integer> accCred = new HashMap<>();
    static HashMap<String, Double> accBal = new HashMap<>();

    public static void Registration(String accountNumber, int pin) {

        if (accCred.containsKey(accountNumber)) {
            System.out.println("Account Already exist !");
            Verification(accountNumber, pin);
        } else {
            accCred.put(accountNumber, pin);
            System.out.println("Your account has been succesfully registered.");
        }
    }

    public static boolean Verification(String accountNumber, int pin) {
        boolean verified = true;
        if (accCred.get(accountNumber) != pin) {
            verified = false;
            return verified;
        }
        return verified;
    }

    public static void Deposit(String accountNumber) {
        System.out.println("Enter the balance you want to deposit.");
        double deposit = sc.nextDouble();
        if (accBal.get(accountNumber) == null) {
            accBal.put(accountNumber, deposit);
        } else {
            double Balance = accBal.get(accountNumber);
            accBal.put(accountNumber, (Balance + deposit));
        }
        System.out.println(deposit + " has been successfully deposited in your bank account");
    }

    public static void checkBal(String accountNumber) {
        System.out.println("Your account balance is " + accBal.get(accountNumber));
        if (accBal.get(accountNumber) == null) {
            System.out.println("Do you want to deposit ? YES = 1 | NO = 0");
            int option = sc.nextInt();

            if (option == 1)
                Deposit(accountNumber);
            return;
        }
    }

    public static void main(String[] args) {

        System.out.println("What you want to do ?");
        System.out.println("1.New Registration");
        System.out.println("2.Existing user");
        int option = sc.nextInt();

        System.out.println("Enter your account number:");
        String accountNumber = sc.next();
        System.out.println("Enter PIN:");
        int pin = sc.nextInt();

        if (option == 1) {
            Registration(accountNumber, pin);
        } else {
            boolean verification = Verification(accountNumber, pin);

            if (verification == false) {
                System.out.println("Invalid Credentials");
                System.exit(0);
            }
        }
        while (true) {
            System.out.println("----------Automated Teller Machine----------");
            System.out.println("1.Deposit Money");
            System.out.println("2.Cash Withdraw");
            System.out.println("3.Check Balance");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Deposit(accountNumber);
                    break;
                case 2:

                    break;
                case 3:
                    checkBal(accountNumber);
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }

    }
}
