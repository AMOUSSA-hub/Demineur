package fr.amoussa.Demineur.CONTROLLER;
import java.awt.event.*;
import javax.swing.JFrame;
import fr.amoussa.Demineur.VIEW.Selection;

public class ObservateurFinalSelection implements ActionListener {

    private JFrame gameFen;

   public ObservateurFinalSelection(JFrame gF){
    this.gameFen = gF;
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand()=="quitter"){System.exit(0);}
        if(e.getActionCommand()=="rejouer"){
            gameFen.dispose();
            new Selection();
        }
    }
}
