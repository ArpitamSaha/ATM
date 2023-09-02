import java.util.HashMap;
import java.util.Scanner;

public class atm {
    static Scanner sc = new Scanner(System.in);

    static HashMap<String, Integer> hm = new HashMap<>();

    public static void Registration() {
        System.out.println("Enter your account number:");
        String accountNumber = sc.next();
        System.out.println("Enter PIN:");
        int pin = sc.nextInt();

        if (hm.containsKey(accountNumber)) {
            System.out.println("Account Already exist !");
            Verification(accountNumber, pin);
        } else {
            hm.put(accountNumber, pin);
            System.out.println("Your account has been succesfully registered.");
        }
    }

    public static boolean Verification(String accountNumber, int pin) {
        boolean verified = true;
        if (hm.get(accountNumber) != pin) {
            verified = false;
            return verified;
        }
        return verified;
    }

    public static void main(String[] args) {

        System.out.println("What you want to do ?");
        System.out.println("1.New Registration");
        System.out.println("2.Existing user");
        int option = sc.nextInt();

        if (option == 1) {
            Registration();
        } else {
            System.out.println("Enter your account number:");
            String accountNumber = sc.next();
            System.out.println("Enter PIN:");
            int pin = sc.nextInt();
            boolean verification = Verification(accountNumber, pin);

            if (verification == false) {
                System.out.println("Invalid Credentials");
                System.exit(0);
            }
        }
        while (true) {
            System.out.println("----------Automated Teller Machine----------");
            System.out.println("1.Cash Withdraw");
            System.out.println("2.Check Balance");
            System.out.println("3.Deposit Money");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }

    }
}
