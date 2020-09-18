package remote;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadCSV {
    private List<Data> original = new ArrayList<>();
    private String filePath;

    public void getCSV(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            this.filePath = filePath;
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] item = line.split(",");
                Data data = new Data(item[0], Integer.parseInt(item[1]));
                original.add(data);
            }
            original.forEach(it -> {
                System.out.println(String.format("%s %d", it.getField(), it.getValue()));
            });
        } catch (FileNotFoundException ignored) {

        }
    }

    public void updateCSV(String name, int value) {
        original.add(new Data(name, value));
        original.forEach(it -> System.out.println(String.format("%s %d", it.getField(), it.getValue())));
    }

    public void sorting() {
        original.sort((o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return -1;
            } else {
                return 0;
            }
        });
        original.forEach(it -> System.out.println(String.format("%s %d", it.getField(), it.getValue())));
    }

    public void saveFile() {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < original.size(); i++) {
                fileWriter.write(String.format("%s,%d", original.get(i).getField(), original.get(i).getValue()));
                fileWriter.write(System.getProperty("line.separator"));
            }
            fileWriter.close();
            System.out.println("쓰기끝");
        } catch (IOException ignored) {

        }
    }
    public List<Data> getOriginal(){
        return original;
    }

}
