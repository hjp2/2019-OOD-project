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
public class TestDriver {
    public static void main(String[] args) {
        CompanyList list = new CompanyList();
        list.setState(new GSState());
        list.doOperation();
        
        System.out.println(CompanyChartData.data);
        System.out.println(CompanyDetailData.data);
        
        list.setState(new KAKAOState());
        list.doOperation();
        
        System.out.println(CompanyChartData.data);
        System.out.println(CompanyDetailData.data);
        
        list.setState(new KBState());
        list.doOperation();
        
        
        System.out.println(CompanyChartData.data);
        System.out.println(CompanyDetailData.data);
    }
}
