package memento;

import java.util.ArrayList;
import java.util.List;

public class Originator {
   
    private int state;
    private int state1;
    private int state2;
   
    
   
    public void YsetState(int state){
      this.state = state;
      
   }

   public int YgetState(){
      return state;
     
   }
   public YearMemento YsaveStateToMemento(){
      return new YearMemento(state);
     
   }
   
   public void YgetStateFromMemento(YearMemento state){
      this.state = state.YgetState();
      
      
   }
   
   
  
   ////////////////////////////////////////////////////////
   
     public void MosetState(int state1){
      this.state1 = state1;
      
   }

   public int MogetState(){
      return state1;
     
   }

   public MonthMemento MosaveStateToMemento(){
      return new MonthMemento(state1);
     
   }

   public void MogetStateFromMemento(MonthMemento month){
      state1 = month.MogetState();
      
      
   }
   
   
   ////////////////////////////////////////////////////////
    public void MsetState(int state2){
      this.state2 = state2;
   }

   public int MgetState(){
      return state2;
   }

   public MoneyMemento MsaveStateToMemento(){
      return new MoneyMemento(state2);
   }

   public void MgetStateFromMemento(MoneyMemento money){
      state2 = money.MgetState();
   
   }
 

}
////////////////////////////////////////////////

