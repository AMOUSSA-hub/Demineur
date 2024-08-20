package fr.amoussa.Demineur.CONTROLLER;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

import fr.amoussa.Demineur.VIEW.Fenetre_Partie;

public class Observateur_Selection implements ActionListener {

    private JSpinner form_ligne;
    private JSpinner form_colonne;
    private JSpinner form_bombe;
    private JFrame fen_selection;

    public Observateur_Selection(JSpinner fl, JSpinner fc, JSpinner fb, JFrame f) {

        this.form_ligne = fl;
        this.form_colonne = fc;
        this.form_bombe = fb;
        this.fen_selection = f;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("valider")) {

            int nbr_ligne = (Integer) form_ligne.getValue();
            int nbr_colonne = (Integer) form_colonne.getValue();
            int nbr_bombe = (Integer) form_bombe.getValue();

            if (nbr_bombe <= nbr_ligne * nbr_colonne - 1) {

                System.out.println("nombre de lignes : " + nbr_ligne + "\n nombre de colonnes : " + nbr_colonne
                        + "\n nombre de bombes :" + nbr_bombe);
                new Fenetre_Partie(nbr_ligne, nbr_colonne, nbr_bombe);
                this.fen_selection.dispose();

            } else {
                JOptionPane.showMessageDialog(fen_selection,
                        "le nombre de bombe est trop élevé (max " + (nbr_ligne * nbr_colonne - 1) + " bombes)");
                throw new IllegalStateException("nombre de bombes invalide.");
            }

        }

    }

}
