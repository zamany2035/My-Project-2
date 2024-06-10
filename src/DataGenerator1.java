import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator1 {
    public static void main(String[] args) {
        generateDataFile("data.txt", 100);
        generateDataFile("data.txt", 500);
        generateDataFile("data.txt", 2000);
        generateDataFile("data.txt", 5000);
        generateDataFile("data.txt", 10000);
    }

    public static void generateDataFile(String fileName, int numRecords) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Random random = new Random();
            for (int i = 1; i <= numRecords; i++) {
                writer.write(i + "," +
                        generateRandomName() + "," +
                        random.nextInt(101) + "," +
                        random.nextInt(101) + "," +
                        random.nextInt(101) + "," +
                        random.nextInt(101) + "," +
                        random.nextInt(101) + "," +
                        random.nextInt(101));
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
    public static String generateRandomName() {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Henry", "Ivy", "Jack"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }
}
