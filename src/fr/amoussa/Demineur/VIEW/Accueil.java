package fr.amoussa.Demineur.VIEW;


import javax.swing.*;

import fr.amoussa.Demineur.CONTROLLER.Observateur_accueil;

import java.awt.*;
import java.io.File;


public class Accueil extends JFrame {


    public Accueil(){
       
        
        setLayout(new GridLayout(3,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton new_game = new JButton("nouvelle partie");

        JButton resume = new JButton("reprendre une partie");
        JButton quit = new JButton("quitter");


        
        File file = new File("grille.bin");

        if(!file.exists())
        {
           resume.setEnabled(false);
        }


        new_game.addActionListener(new Observateur_accueil(this));
        resume.addActionListener(new Observateur_accueil(this));
        quit.addActionListener(new Observateur_accueil(this));


        add(new_game);
        add(resume);
        add(quit);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);




    }
    
}
