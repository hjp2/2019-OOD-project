package remote;


public class Main {
    public static void main(String[] args) {
        
        
        ReadCSV readCSV = new ReadCSV();
        readCSV.getCSV("C:\\csv\\랭킹.csv");
        System.out.println();
        
        readCSV.updateCSV("test",5000000);
        System.out.println();
        
        readCSV.sorting();
        System.out.println();
        
        readCSV.saveFile();
        
        
        
    }
}
