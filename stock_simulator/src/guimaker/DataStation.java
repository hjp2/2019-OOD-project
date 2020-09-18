package guimaker;


import static guimaker.TestDrive.client;
import java.util.ArrayList;
import java.util.List;
import memento.CareTaker;
import memento.Originator;
import remote.Data;



/**
 *
 * @author 김현준
 * 모든 데이터를 가지고 관리하는
 * 클래스.
 */
public class DataStation {
    public static int back;
    
    public static Originator originator = new Originator();
    public static CareTaker careTaker = new CareTaker();
    
    public static int haveMoney; // 시작금액
    public static int goalMoney; // 목표금액
    public static int nowMoney; // 현재금액 M
    
    public static String startTime; // 시작시간
    public static String endTime; // 종료시간
    public static int nowTimeY; // 현재 년도 M
    public static int nowTimeM; // 현재 월 M
    public static String makingDate; 
    
    public static String nickName;
    
    public static String selectCompany; // 리스트 선택한 회사
    public static int nowPage = 0; // 현재 페이지
    public static int lastPage;
    public static String chooseV[] = new String[100];
    public static String sellSelectName; // 판매할때 선택할 회사
    public static String selectName; // 리스트에서 선택한 이름
    
    public static String howMuch; // 몇개 주식 살지 고르는 콤보박스 값 저장
    
    public static List<String> stockData = new ArrayList<String>(); // 들어올 주식정보
    
    public static List<String> haveStorkDataArray = new ArrayList<String>(); // 자기가 가지고 있는 주식  M

    public static List<List<String>> getStockDataFromProxy = new ArrayList<List<String>>();
    
    public static List<Data> getRankData = new ArrayList<>();
   
    public static int chk111 = 1;
    
    /**
     * 끝 시간을 정하는 메서드.
     */
    public static void makeEndTime(){
        lastPage = (Integer.parseInt(endTime.split(" ")[0]) - Integer.parseInt(startTime.split(" ")[0])) * 12 + 
                (Integer.parseInt(endTime.split(" ")[1]) - Integer.parseInt(startTime.split(" ")[1]));
    }
    
    /**
     * 년 월을 넣으면 필요한 문자열 만들기.
     */
    public static void makeDate(){
        makingDate = nowTimeY + "." + nowTimeM;
        
        if(nowTimeM < 10){
            makingDate = nowTimeY + ".0" + nowTimeM;
        }
        else{
            makingDate = nowTimeY + "." + nowTimeM;
        }
        
    }
      
    /**
     * 콤보 박스에 넣을 숫자 만드는 메서드.
     */
    public static void makeChooseL(){
        int i = 0;
        for(i = 0 ; i < 100 ; i++){
            chooseV[i] = i+"";
        }
    }
    
    /**
     * 주식을 얼마나 가지고 있는지 계산하는 메소드.
     */
    public static void howmuchHaveMoney(){
        
        client.callRemoteMethod(DataStation.selectCompany, makingDate);
       
        nowMoney = nowMoney - (Integer.parseInt(howMuch) * Integer.parseInt(getStockDataFromProxy.get(getStockDataFromProxy.size()-1).get(1)));
        String addInfo;
        addInfo = selectCompany + " " + howMuch;
        
     haveStorkDataArray.add(addInfo);
        
        
        
    }
    
    public static String[] makeRankListData(){
        if(chk111 == 1)
        {
            client.callRankMethod(nickName, nowMoney);
        }
        chk111++;
        
        String[] listdata = new String[getRankData.size()];
        String addText;
        for(int i = 0 ; i < getRankData.size(); i++){
            addText = "   " + getRankData.get(i).getField() + "  " + getRankData.get(i).getValue();
            listdata[i] = addText;
            System.out.println(listdata[i]);
        }
        
        
        return listdata;
    }
    
    /**
     * 상세 주식 정보를 받아올 메서드.
     */
    public static void getDetailStockData(){
        makeDate();
        client.callRemoteMethod("SKT", makingDate);
        int i;
        String adddd;
        ArrayList<String> test = new ArrayList<>();
        
        test.add("날짜   현재가격   상한가    하한가");
        for (i=0; i< getStockDataFromProxy.size(); i++ ){
            adddd = getStockDataFromProxy.get(i).get(0) + " " + getStockDataFromProxy.get(i).get(1)  + " " + getStockDataFromProxy.get(i).get(2)  + " " + getStockDataFromProxy.get(i).get(3);
            test.add(adddd);
        }
        stockData = test;
        
    }
    
    /**
     * 다음달 버튼을 눌렀을 때 년도와 월을 증가시켜줄 메서드.
     */
    public static void pushNext(){
        
        originator.MsetState(nowMoney);
        careTaker.Madd(originator.MsaveStateToMemento());
        originator.YsetState(nowTimeY);
        careTaker.Yadd(originator.YsaveStateToMemento());
        originator.MosetState(nowTimeM);
        careTaker.Moadd(originator.MosaveStateToMemento());
       
        
        if(nowTimeM < 12){
            nowTimeM += 1;
        }
        else{
            nowTimeY += 1;
            nowTimeM = 1;
        }
        
        
    }
    
    /**
     * 전체적으로 회사별 월간 등락정보 만드는 메서드.
     */
    public static void getCompanyStock(){
        String needTime = nowTimeY + "." + nowTimeM;
    }
    
    public static void pushRollBack(){
        
        
        originator.MgetStateFromMemento(careTaker.Mget(back));
        nowMoney = originator.MgetState();
        originator.YgetStateFromMemento(careTaker.Yget(back));
        nowTimeY = originator.YgetState();
        originator.MogetStateFromMemento(careTaker.Moget(back));
        nowTimeM = originator.MogetState();
        originator.MogetStateFromMemento(careTaker.Moget(back));
        
        haveStorkDataArray.remove(haveStorkDataArray.size()-1);
     
        
        back++;
     
    }
    
    public static void calculateAllHaveStock(){
        
        //haveStorkDataArray 보유주식
                
        //getStockDataFromProxy 받아온 주식정보
        String stockData;
        String companyName;
        int stockPrice;
        String howMuchHave;
        for(int i = 1 ; i < haveStorkDataArray.size(); i++){
            stockData = haveStorkDataArray.get(i);
            companyName = stockData.split(" ")[0];
            howMuchHave = stockData.split(" ")[1];
            System.out.println(stockData);
            client.callRemoteMethod(companyName, makingDate);
            
            nowMoney += Integer.parseInt(howMuchHave) * Integer.parseInt(getStockDataFromProxy.get(getStockDataFromProxy.size()-1).get(1));
        }
        
    }

    
}

// 스마트깃 사용 미숙 클래스 다이어그램 그리