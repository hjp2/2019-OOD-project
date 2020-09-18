/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import dataPackage.ChartData;
import dataPackage.DetailData;
import guimaker.DataStation;
import static guimaker.DataStation.makingDate;
import static guimaker.TestDrive.client;

/**
 *
 * @author hjp
 */
public class SOILState implements ISelectedCompanyState {



    @Override
    public void changeLabel() {
        DataStation.selectCompany = "SOIL";
    }

    @Override
    public void makeSelectedData() {
        DataStation.makeDate();
        client.callRemoteMethod("SOIL", makingDate);
        
        DetailData.setData();
        ChartData.setData();
    }
    
}

