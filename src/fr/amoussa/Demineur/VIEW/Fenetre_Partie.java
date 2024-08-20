package fr.amoussa.Demineur.VIEW;

import javax.swing.*;

import fr.amoussa.Demineur.CONTROLLER.GameButtonListener;
import fr.amoussa.Demineur.MODEL.GridModel;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Fenetre_Partie extends JFrame {


    public Fenetre_Partie(int ligne, int colonne, int bombe) {
      

        
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel footer = new JPanel( new FlowLayout());

        JButton save = new JButton("sauvegarder et quitter");
        JButton quit = new JButton("quitter");

        Compteur c = new Compteur(bombe);

        footer.add(save);
        footer.add(quit);

        Grille g = new Grille(ligne, colonne, bombe, this,c);

        g.setMinimumSize(new Dimension(300, 300));
        add(c,BorderLayout.NORTH);
        quit.addActionListener(e -> System.exit(0));
        save.addActionListener(new GameButtonListener(g.getModel()));
        add(g,BorderLayout.CENTER);
        add(footer,BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    
    public Fenetre_Partie(GridModel gm) {
      

        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel footer = new JPanel(new FlowLayout());

        JButton save = new JButton("sauvegarder et quitter");
        JButton quit = new JButton("quitter");

        Compteur c = new Compteur(gm.getBombs());

        footer.add(save);
        footer.add(quit);

        Grille g = new Grille(gm, this,c);

        g.setMinimumSize(new Dimension(300, 300));
        add(c,BorderLayout.NORTH);
        quit.addActionListener(e -> System.exit(0));
        save.addActionListener(new GameButtonListener(g.getModel()));
        add(g,BorderLayout.CENTER);
        add(footer,BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);

    }



    

    private void readObject(ObjectInputStream ois)
            throws IOException, ClassNotFoundException {

        // setLocation(600,200);
        // setSize(500,500);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setLayout(new GridLayout(3,1));

        // JPanel footer = new JPanel();

        // JButton save = new JButton("sauvegarder et quitter");
        // JButton quit = new JButton("quitter");

        // Compteur c = new Compteur(bombe);

        // footer.add(save);
        // footer.add(quit);

        // Grille g = new Grille(ois.readInt(), ois.readInt(), ois.readInt(),this);

        // add(c,BorderLayout.NORTH);
        // quit.addActionListener(new GameButtonListener());
        // save.addActionListener(new GameButtonListener(this));
        // //add(g);
        // add(footer,BorderLayout.SOUTH);

        setVisible(true);

    }


}
