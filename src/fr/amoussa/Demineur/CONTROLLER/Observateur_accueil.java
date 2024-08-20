package fr.amoussa.Demineur.CONTROLLER;

import java.awt.event.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFrame;

import fr.amoussa.Demineur.MODEL.GridModel;
import fr.amoussa.Demineur.VIEW.Fenetre_Partie;
import fr.amoussa.Demineur.VIEW.Selection;

public class Observateur_accueil implements ActionListener {

private JFrame fen_home;

    public Observateur_accueil( JFrame f){
        this.fen_home = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("nouvelle partie")){
            this.fen_home.dispose();
            new Selection();
        }


        if(e.getActionCommand().equals("reprendre une partie")){
           this.fen_home.dispose();
         
            try {
              ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("grille.bin")) ;

            

            GridModel  gm = (GridModel)ois.readObject();
            Fenetre_Partie fp = new Fenetre_Partie(gm);
             ois.close();
           } catch (Exception ex) {
            System.err.println(ex);
           }  

        }


        if(e.getActionCommand().equals("quitter")){
            System.exit(0);
        }



        
        
    }


    
}
