import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main{


    public static int device1(int x) {
        int speed1 = 3 * x;
        return speed1;
    }

    public static double device2(int y){
        double speed2 = y / 1.6;
        return speed2;
    }

    public static int device3(int x){
        int rpm = x * 90;
        return rpm;
    }
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("Number of Acceleration position needs to be taken");
        int x = in.nextInt();

        // Objective is to observe the data of vehicle's behaviour in different Acceleration pedal position

        File output = new File("output.txt");
        output.delete();

        System.out.println("Accl" + "    " + "Speed(s1)" + "    " + "Speed(s2)" + "             " + "RPM");

            for(int i=1;i<=x;i++) {
            Random rand = new Random();
            int accrange = 100;
            int acc = rand.nextInt(accrange);
            //Device:1 - Measures Vehicle Speed (S1) - (km/hr)
            int s1 = device1(acc);
            //Device:2 - Measures Vehicle Speed (S2) - (miles/hr)
            double s2 = device2(s1);
            //Device:3 - Measures Engine RPM (R) - (rpm)
            int R = device3(acc);
            System.out.println(acc + "%" + "    " + s1 + "(km/hr)" + "    " + s2 + "(miles/hr)" + "    " + R + "(rpm)");

            try {
                // Create the file to write to
                PrintWriter fileOut = new PrintWriter(new FileWriter("output.txt ", true));

                if (i<2){
                    fileOut.println("Accl" + "    " + "Speed(s1)" + "    " + "Speed(s2)" + "             " + "RPM");
                }
                fileOut.println(acc + "%" + "    " + s1 + "(km/hr)" + "    " + s2 + "(miles/hr)" + "    " + R + "(rpm)");

                fileOut.close();

            } catch (IOException e) {
                System.out.println("File not found");
            }
        }
        File file = new File(
                "C://Users//sbalasubramanian//JAVA//EATON//output.txt");
            int count = 0;
        BufferedReader br
                = new BufferedReader(new FileReader(file));

               String st;

        while ((st = br.readLine()) != null)

            count++;
        System.out.println("number of counts");
        System.out.println(count-1);
    }
    }