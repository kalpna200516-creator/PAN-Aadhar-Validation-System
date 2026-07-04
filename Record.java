public class Record {

    private String pan;
    private String aadhaar;
    private String panStatus;
    private String aadhaarStatus;

    public Record(String pan, String aadhaar, String panStatus, String aadhaarStatus) {
        this.pan = pan;
        this.aadhaar = aadhaar;
        this.panStatus = panStatus;
        this.aadhaarStatus = aadhaarStatus;
    }

    public String toString() {
        return "PAN : " + pan +
                "\nPAN Status : " + panStatus +
                "\nAadhaar : " + aadhaar +
                "\nAadhaar Status : " + aadhaarStatus +
                "\n--------------------------------";
    }
}