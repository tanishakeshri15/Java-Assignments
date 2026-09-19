import java.util.Scanner;

public class Problem4_MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {

        // Check if the phone number has exactly 10 digits
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Check that every character is a digit
        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Get the last 4 digits
        String lastFourDigits = phone.substring(6);

        // Create masked number using StringBuilder
        StringBuilder maskedNumber = new StringBuilder("XXXXXX");

        maskedNumber.insert(6, "-");
        maskedNumber.append(lastFourDigits);

        return maskedNumber.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.println(maskPhoneNumber(phone));

        sc.close();
    }
}