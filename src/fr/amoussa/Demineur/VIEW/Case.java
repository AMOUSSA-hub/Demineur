package fr.amoussa.Demineur.VIEW;

import fr.amoussa.Demineur.UTILS.*;

import java.awt.*;

import javax.swing.*;

public class Case extends JButton {

    private int status_tag;
    private int pos_x;
    private int pos_y;

    public Case(int x, int y) {
        this.pos_x = x;
        this.pos_y = y;

        setBackground(Color.gray);
        setPreferredSize(new Dimension(10, 10));

    }

    public void setStatus(int s) {

        this.status_tag = s;
    }

    public void next_Tag() {
        // 0 = case vierge
        if (status_tag == 2) {
            setIcon(null);
            setStatus(0);

        }

        // 1 = mettre ?
        else if (status_tag == 0) {
            setIcon(Icone.interrogation);
            setStatus(1);

        }
        // 2 = mettre ★
        else if (status_tag == 1) {
            setIcon(Icone.star);
            setStatus(2);

        }

    }

    public int getStatus() {

        return this.status_tag;
    }

    public int getGridPosX() {
        return pos_x;
    }

    public int getGridPosY() {
        return pos_y;
    }

    public void devoiler() {

        setBackground(new Color(199, 191, 191));
        setStatus(-1);// -1 signifie que la case est dévoilée grille claire
    }

    public void markNumber(int n) {

        devoiler();

        if (n == 1)
            setIcon(Icone.one);

        if (n == 2)
            setIcon(Icone.two);

        if (n == 3)
            setIcon(Icone.three);

        if (n == 4)
            setIcon(Icone.four);

        if (n == 5)
            setIcon(Icone.five);

        if (n == 6)
            setIcon(Icone.six);

        if (n == 7)
            setIcon(Icone.seven);

        if (n == 8)
            setIcon(Icone.eight);

    }

}
