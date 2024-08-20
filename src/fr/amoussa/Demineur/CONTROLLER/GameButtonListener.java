package fr.amoussa.Demineur.CONTROLLER;

import java.awt.event.*;
import java.io.*;

import fr.amoussa.Demineur.MODEL.GridModel;
import fr.amoussa.Demineur.VIEW.Fenetre_Partie;

public class GameButtonListener implements ActionListener {
   private GridModel gm;

   public GameButtonListener(GridModel gm) {
      this.gm = gm;
   }

   @Override
   public void actionPerformed(ActionEvent e) {

      if (e.getActionCommand() == "sauvegarder et quitter") {

         try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("grille.bin"));
            oos.writeObject(this.gm);
            oos.close();

         } catch (Exception ex) {
            System.err.println(ex);
         }
         System.exit(0);
      }
   }

}
