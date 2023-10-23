import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadingWriting {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\mahfu\\Desktop\\cse2142\\name.txt");/** Representing the file only*/
        if (!file.exists()) {
            file.createNewFile();
        }
        /**Writing the text into the above created file using file output stream */
        FileOutputStream fos = new FileOutputStream(file);
        String text = "My name is Mahfuzar Rahman";
        fos.write(text.getBytes());
        fos.flush();
        fos.close();
        /** Reading the text from the file  using FileInputStream */
        FileInputStream fis = new FileInputStream(file);
        int i = fis.read();
        /** when all data will be read from file then read() function return -1*/
        while (i != -1) {
            System.out.print((char) i);
            i = fis.read();
        }
        fis.close();

    }
}
