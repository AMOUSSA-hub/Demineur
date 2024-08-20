package fr.amoussa.Demineur.VIEW;

import javax.swing.*;

import fr.amoussa.Demineur.CONTROLLER.Observateur_Selection;

import java.awt.*;

public class Selection extends JFrame {


    public Selection(){
        
        setSize(300,400);
        setLayout(new GridLayout(4,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    JSpinner form_ligne = new JSpinner(new SpinnerNumberModel(4,4,30,1) );
    JSpinner form_colonne = new JSpinner(new SpinnerNumberModel(4,4,30,1) );
    JSpinner form_bombe = new JSpinner(new SpinnerNumberModel(1,1,null,1) );
    JButton val = new JButton("valider");



    val.addActionListener(new Observateur_Selection(form_ligne,form_colonne,form_bombe,this));
    
    add(new JLabel("Lignes : ") );
    add(form_ligne);
    add(new JLabel("Colonnes :"));
    add(form_colonne);
    add(new JLabel("bombes"));
    add(form_bombe);
    add(val,BorderLayout.SOUTH);
    
    pack();
    setLocationRelativeTo(null);
    setVisible(true);


    }
    
}
