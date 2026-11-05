package utill;

public class ValidationUtil {
    public static boolean isValidName(String text) {
        return text != null &&
                text.trim().matches("[a-zA-ZəƏıİöÖüÜşŞğĞçÇ]{3,20}");
    }

    public static boolean isValidAge(int age) {
        return age >= 18 && age <= 70;
    }

    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    public static boolean isValidFin(String fin) {
        return fin != null && fin.matches("[A-Z0-9]{7}");
    }

    public static boolean isValidNumber(String number) {
        return number != null && number.matches("^(050|051|055|070|077|010|099)\\d{7}$");
    }
    public static boolean isValidEmail(String email) {
        return email != null &&
                email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}
