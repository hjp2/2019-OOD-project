package memento;

import java.util.ArrayList;
import java.util.List;

/**
 *fg
 * @author 정현
 */
public class CareTaker {
   private List<YearMemento>  yearlist = new ArrayList<YearMemento>();
   private List<MonthMemento> monthlist = new ArrayList<MonthMemento>();
    private List<MoneyMemento> moneylist = new ArrayList<MoneyMemento>();
     
   
   

   public void Yadd(YearMemento state){
      yearlist.add(0,state);
   }

   public YearMemento Yget(int index){
      return yearlist.get(index);
   }
   
    public void Moadd(MonthMemento state1){
      monthlist.add(0,state1);
   }

   public MonthMemento Moget(int index){
      return monthlist.get(index);
   }
   
   public void Madd(MoneyMemento state2){
      moneylist.add(0,state2);
   }

   public MoneyMemento Mget(int index){
      return moneylist.get(index);
   }
    
   
 
}