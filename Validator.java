public class Validator {

    public static boolean validatePAN(String pan) {
        return pan.matches("^[A-Z]{5}[0-9]{4}[A-Z]$");
    }

    public static boolean validateAadhaar(String aadhaar) {
        return aadhaar.matches("^[2-9][0-9]{11}$");
    }

}