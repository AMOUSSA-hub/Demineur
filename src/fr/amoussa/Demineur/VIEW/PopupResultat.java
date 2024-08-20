package fr.amoussa.Demineur.VIEW;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fr.amoussa.Demineur.CONTROLLER.ObservateurFinalSelection;

public class PopupResultat extends JDialog {

    public PopupResultat(int res, JFrame owner){



        
        super(owner,true);


         File file = new File("grille.bin");

        if(file.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
        String finalSentence;
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        if(res==1) { finalSentence = "Vous avez gagné !";}
        else{ finalSentence = "Vous avez perdu !";} 

        JLabel text = new JLabel(finalSentence);
        text.setHorizontalAlignment(JLabel.CENTER);
         add(text);
        JPanel panBouton =  new JPanel(new FlowLayout());
        panBouton.setBackground(new Color(185,181,181));
        JButton reset = new JButton("rejouer");
        JButton quit = new JButton("quitter");
        

        panBouton.add(reset);
        panBouton.add(quit);

        add(panBouton, BorderLayout.SOUTH);
        quit.addActionListener(new ObservateurFinalSelection(owner));
        reset.addActionListener(new ObservateurFinalSelection(owner));
        this.setSize(new Dimension(200,140));
        setLocationRelativeTo(owner);
        setVisible(true); 
    }
}
