import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===============================");
            System.out.println(" PAN & Aadhaar Validation");
            System.out.println("===============================");
            System.out.println("1.Validate PAN");
            System.out.println("2.Validate Aadhaar");
            System.out.println("3.Validate Both");
            System.out.println("4.View Saved Records");
            System.out.println("5.Exit");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    validatePAN();
                    break;

                case 2:
                    validateAadhaar();
                    break;

                case 3:
                    validateBoth();
                    break;

                case 4:
                    viewRecords();
                    break;

                case 5:
                    System.out.println("Thank You...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        }while(choice!=5);

    }

    static void validatePAN(){

        System.out.print("Enter PAN : ");
        String pan=sc.nextLine().toUpperCase();

        if(Validator.validatePAN(pan))
            System.out.println("PAN is VALID");
        else
            System.out.println("PAN is INVALID");

    }

    static void validateAadhaar(){

        System.out.print("Enter Aadhaar : ");
        String aadhaar=sc.nextLine();

        if(Validator.validateAadhaar(aadhaar))
            System.out.println("Aadhaar is VALID");
        else
            System.out.println("Aadhaar is INVALID");

    }

    static void validateBoth(){

        System.out.print("Enter PAN : ");
        String pan=sc.nextLine().toUpperCase();

        System.out.print("Enter Aadhaar : ");
        String aadhaar=sc.nextLine();

        String panStatus=Validator.validatePAN(pan)?"VALID":"INVALID";
        String aadhaarStatus=Validator.validateAadhaar(aadhaar)?"VALID":"INVALID";

        System.out.println("\n========= RESULT =========");
        System.out.println("PAN Status : "+panStatus);
        System.out.println("Aadhaar Status : "+aadhaarStatus);

        Record r=new Record(pan,aadhaar,panStatus,aadhaarStatus);

        try{

            FileWriter fw=new FileWriter("records.txt",true);
            fw.write(r.toString()+"\n");
            fw.close();

            System.out.println("Record Saved Successfully");

        }catch(Exception e){

            System.out.println(e);

        }

    }

    static void viewRecords(){

        try{

            BufferedReader br=new BufferedReader(new FileReader("records.txt"));

            String line;

            while((line=br.readLine())!=null){

                System.out.println(line);

            }

            br.close();

        }catch(Exception e){

            System.out.println("No Records Found");

        }

    }

}