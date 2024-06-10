package algorithms.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

 class DataReader {

    public static LinkedList<StudentRecord> readDataFromFile(String fileName) {
        LinkedList<StudentRecord> records = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                StudentRecord record = new StudentRecord();
                record.id = Integer.parseInt(data[0]);
                record.name = data[1];
                record.mathCA = Integer.parseInt(data[2]);
                record.mathExam = Integer.parseInt(data[3]);
                record.physicsCA = Integer.parseInt(data[4]);
                record.physicsExam = Integer.parseInt(data[5]);
                record.logicCA = Integer.parseInt(data[6]);
                record.logicExam = Integer.parseInt(data[7]);
                records.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
