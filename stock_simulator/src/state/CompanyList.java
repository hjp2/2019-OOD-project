/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 *
 * @author hjp
 */
public class CompanyList {
    ISelectedCompanyState state;

    
    public void setState(ISelectedCompanyState state){
        this.state = state;
    }
    
    
    public void doOperation(){
        state.makeSelectedData();
        state.changeLabel();
    }
}
