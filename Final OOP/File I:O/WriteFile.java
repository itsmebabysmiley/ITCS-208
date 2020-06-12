import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        PrintWriter w = new PrintWriter(new FileWriter("test.txt"));
        //PrintWriter w = new PrintWriter(new FileWriter("test.txt", true)); // เขียนไฟล์ต่อจากไฟล์เดิม 
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        w.println(text);
        while (text.length() > 0) {
            text = scan.nextLine();
            w.println(text);
        }

        // !!!!!!!!!!!!!Don't forget to close file!!!!!!!!!!!!
        w.close();
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }
}