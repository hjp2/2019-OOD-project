package templateMethod;

import javax.swing.JComboBox;

public abstract class MyComboBox {
    
    protected JComboBox<String> myCombo;
    protected final String[] year = { "2018", "2017", "2016", "2015", "2014"};
    protected final String[] month = { "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1" };
    protected final String [] money = {"10000000", "20000000", "30000000", "40000000", "50000000", "60000000", "70000000", "80000000", "90000000", "100000000"};

    public JComboBox getCombo() {
        return myCombo;
    }

    public abstract void makeCombo() ;

    public abstract void doWork() ;

}
