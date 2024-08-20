package fr.amoussa.Demineur.VIEW;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Compteur extends JPanel {

    private int guess_bomb;
    private JLabel labelCompteur;
    private int nbrBombes;

    public Compteur(int nbrBombes){
        this.guess_bomb = 0;
        this.nbrBombes = nbrBombes;
        labelCompteur  = new JLabel(this.guess_bomb+"/"+nbrBombes+"bombes trouvées");
        add(labelCompteur,BorderLayout.CENTER);
    }


    public void  PlusUn(){
        this.guess_bomb++;
        labelCompteur.setText(this.guess_bomb+"/"+nbrBombes+"bombes trouvées");
        this.repaint();
    }

    public void MoinsUn(){
        this.guess_bomb--;
        labelCompteur.setText(this.guess_bomb+"/"+nbrBombes+"bombes trouvées");
        this.repaint();
    }
    
}
