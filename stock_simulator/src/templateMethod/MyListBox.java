package templateMethod;


import javax.swing.JList;

public abstract class MyListBox {
    
    protected JList myList;
    protected String [] needData123123 = {"GS", "KAKAO", "KB금융", "KCC", "KT", "LG전자", 
        "NAVER", "SKT", "SK하이닉스", "SOIL", "삼성전자", "셀트리온", "신한은행", "이마트", "현대자동차"};
    protected int x;
    protected int y;

    public JList getListBox() {
        return myList;
    }

    public final void makeList() {
        getData();
        
        setMyListLocation(x, y);
        setMyListSize();
        doWork();
    }
    
    private void setMyListLocation(int x, int y){
        myList.setLocation(x,y);
    }
    
    private void setMyListSize(){
        myList.setSize(300,200);
    }
    
    
    protected abstract void doWork() ;

    protected abstract void getData() ;

}
