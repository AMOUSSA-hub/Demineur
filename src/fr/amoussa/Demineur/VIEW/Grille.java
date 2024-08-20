package fr.amoussa.Demineur.VIEW;

import javax.swing.*;

import fr.amoussa.Demineur.CONTROLLER.Observateur_case;
import fr.amoussa.Demineur.MODEL.GridModel;
import fr.amoussa.Demineur.UTILS.Icone;

import java.awt.*;

public class Grille extends JPanel {

    private int ligne;
    private int colonne;
    private Case[][] allCases;
    private GridModel model;
   
    public Grille(int ligne, int colonne, int bombe, JFrame f, Compteur c) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.model = new GridModel(colonne, ligne, bombe, this);
        

        this.allCases = new Case[ligne][colonne];

        setLayout(new GridLayout(ligne, colonne));

        for (int y = 0; y <= ligne - 1; y++) {
            for (int x = 0; x <= colonne - 1; x++) {
                Case ca = new Case(x, y);
                allCases[y][x] = ca;
                ca.addMouseListener(new Observateur_case(ca, model, f,c));
                add(ca);
            }
        }

    }

    public Grille(GridModel gm, JFrame f, Compteur c) {
        this.ligne = gm.getRows();
        this.colonne = gm.getCols();
        this.model = gm;
        model.setView(this);

        this.allCases = new Case[ligne][colonne];

        setLayout(new GridLayout(ligne, colonne));

        for (int y = 0; y <= ligne - 1; y++) {
            for (int x = 0; x <= colonne - 1; x++) {
                Case ca = new Case(x, y);
                allCases[y][x] = ca;

                ca.addMouseListener(new Observateur_case(ca, model, f,c));
                add(ca);
            }
        }

        for (int y = 0; y <= ligne - 1; y++) {
            for (int x = 0; x <= colonne - 1; x++) {
                if (gm.getTab()[y][x] == 0) {
                    model.getEntourage(x, y);
                }

            }
        }

    }

    public GridModel getModel() {
        return model;
    }

    public Case getCase(int pos_x, int pos_y) {
        return allCases[pos_y][pos_x];
    }

    public int getLine() {
        return ligne;
    }

    public int getColumn() {
        return colonne;
    }

    public void UnHideBomb(){

        for (int y = 0; y <= ligne - 1; y++) {
            for (int x = 0; x <= colonne - 1; x++) {
                if (this.model.getTab()[y][x] == 1) {
                    getCase(x, y).setIcon(Icone.bomb);
                }

            }
        }

    }

}
