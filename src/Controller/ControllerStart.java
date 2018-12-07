/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import View.ViewMenuEvent;
import View.ViewStart;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author Faisal Ridwan
 */
public class ControllerStart implements ActionListener {
    private ViewStart view;
    
    public ControllerStart() {
        view = new ViewStart();
        view.addActionListener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnLogin())){
            view.dispose();
            new ControllerLogIn();
        }else if(source.equals(view.getBtnSignup())){
            view.dispose();
            new ControllerSignIn();
        }
    }
}
