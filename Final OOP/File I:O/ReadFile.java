import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadFile {

    /**
     * throws to ioexception class
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(/** File name or path */
                ""));
        String s = "";
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }

        reader.close();
    }

    public static void readfile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(/** File name or path */ ""));
            String s = "";
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }

            reader.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static void writefile() {
        try {
            PrintWriter w = new PrintWriter(new FileWriter("test.txt"));
            w.write(/**String */"");
            //!!!!!!!!!!!!!!Don't forget to close file!!!!!!!!!!!!!!!!!
            w.close();
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}