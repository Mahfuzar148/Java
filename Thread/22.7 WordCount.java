import java.io.*;

public class WordCount extends Thread {
    private String filename;
    int countWord = 0;
    String line;

    public WordCount(String fname) {
        filename = fname;
    }

    public void run() {
        try {
            File file = new File(filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(input);

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    // use space delimiter which is \\s+
                    String[] wordList = line.split("\\s+");
                    countWord += wordList.length;
                }
            }
            System.out.println(""+filename + " : " + countWord);
            WordCountRun.totalCount=WordCountRun.totalCount+countWord;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File " + filename + " not found.");
            System.out.println(""+filename + " : " + countWord);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(""+filename + " : " + countWord);
        }
    }
}

public class WordCountRun {
    static int totalCount = 0;

    public static void main(String[] args) {
        WordCount w[] = new WordCount[args.length];
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException();
            } else {
                for (int i = 0; i < args.length; i++) {
                    w[i] = new WordCount(args[i]);
                    w[i].start();
                }

                // Wait for all threads to finish
                for (int i = 0; i < args.length; i++) {
                    w[i].join();
                }

                System.out.println("Combined Count : " + totalCount);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("No args passed in the main function.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
