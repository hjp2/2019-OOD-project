package remote;

import java.io.Serializable;

public class Data implements Serializable {
    private String field; // 앞의 필드명
    private int value; // 값
    public Data(String field,int value){
        this.field=field;
        this.value=value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public synchronized int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
