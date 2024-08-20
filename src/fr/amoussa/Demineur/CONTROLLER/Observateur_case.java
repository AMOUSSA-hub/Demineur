package fr.amoussa.Demineur.CONTROLLER;

import fr.amoussa.Demineur.MODEL.GridModel;
import fr.amoussa.Demineur.VIEW.*;

import java.awt.event.*;
import javax.swing.JFrame;


public class Observateur_case implements MouseListener {

    private Case case_clique;
    private static GridModel model;
    private JFrame gameFen;
    private Compteur count;
    public Observateur_case(Case c, GridModel gm, JFrame f,Compteur count){

        this.case_clique = c;
        model = gm;
        gameFen = f;
        this.count = count;

    }


    @Override
    public void mouseClicked(MouseEvent e) { }

   
   
   
   
   
    @Override
    public void mousePressed(MouseEvent e) {
        
                //Clique gauche
            if (e.getButton() == MouseEvent.BUTTON1){
                

                if(model.isStartedGame()){
                    if(case_clique.getStatus() == 0){   
                        
                        if(!model.checkBomb(case_clique.getGridPosX(), case_clique.getGridPosY())){
                            System.out.println("x:"+case_clique.getGridPosX()+" y:"+case_clique.getGridPosY());
                            model.getEntourage(case_clique.getGridPosX(),case_clique.getGridPosY());
                            
                            if(model.checkVictory()){
                                new PopupResultat(1, gameFen);  
                            }
                        }else{
                            model.UnHideBomb();
                          new PopupResultat(0, gameFen);
                          
                          System.out.println("perdu");
                       
                        }
                    }
                }else{

                    model.placerBombe(case_clique.getGridPosX(),case_clique.getGridPosY());
                    model.getEntourage(case_clique.getGridPosX(),case_clique.getGridPosY());
                    System.out.println("mise en place des bombes");
                    model.getstartedGame();
                     if(model.checkVictory()){
                                new PopupResultat(1, gameFen);  
                            }
                }


            }
                //Clique molette
            if (e.getButton() == MouseEvent.BUTTON2 && model.isStartedGame()){

                case_clique.next_Tag();
                if(case_clique.getStatus() ==1){
                    this.count.PlusUn();
                };
                if(case_clique.getStatus() ==0){
                    this.count.MoinsUn();
                };
          }
                //Clique droit
            if (e.getButton() == MouseEvent.BUTTON3 && model.isStartedGame()){
     
                case_clique.next_Tag();
                if(case_clique.getStatus() ==1){
                    this.count.PlusUn();
                };
                if(case_clique.getStatus() ==0){
                    this.count.MoinsUn();
                };
            }
     }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
