package fr.amoussa.Demineur.MODEL;

import java.io.Serializable;
import java.util.*;



import fr.amoussa.Demineur.UTILS.Icone;
import fr.amoussa.Demineur.VIEW.*;

public class GridModel implements Serializable{
    private int[][]  tab_partie ;
    private int nbr_bombe;
    private Grille g;
    private int nbr_ligne;
    private int nbr_colonne;
    private  boolean first_cliquee = false;
    
    public GridModel(int colonne,int ligne,int b,Grille G){

        this.tab_partie = new int[ligne][colonne];
        this.nbr_bombe = b;
        this.g = G;
        this.nbr_ligne = ligne;
        this.nbr_colonne = colonne;

        
        for(int y= 0; y <= ligne-1; y++){
            for(int x=0; x <= colonne-1; x++){
                tab_partie[y][x]=-1;

            }

        }
        

    }

    public void placerBombe(int pos_safe_X, int pos_safe_Y){

        int bombe_a_placer = nbr_bombe;
        Random rdm = new Random();

        while(bombe_a_placer > 0 ){

            int tirage_X = rdm.nextInt(g.getColumn()-1);
            int tirage_Y = rdm.nextInt(g.getLine()-1);
            

            if(!checkBomb(tirage_X, tirage_Y) && tirage_X != pos_safe_X && tirage_Y!= pos_safe_Y ){
                tab_partie[tirage_Y][tirage_X] = 1;
                bombe_a_placer--;
               // g.getCase(tirage_X,tirage_Y).setIcon(Icone.bomb); MODE TRICHE


            }

        }


    }

     public int getEntourage (int x , int y){
        int bomb_close = 0;

        List<Case> safeCase = new ArrayList<>();

    //vérification de la case en haut-gauche.
     if( x-1>= 0 && x-1<= nbr_colonne-1 && y-1>= 0 && y-1<= nbr_ligne-1 ){
        if(g.getCase(x-1, y-1).getStatus() == 0){
            if(checkBomb(x-1,y-1) ){
                bomb_close++;
            }
            else{
            safeCase.add(g.getCase(x-1, y-1));
            }
        }
     }

     //vérification de la case en haut.
     if(x>= 0 &&x<= nbr_colonne-1 && y-1>= 0 && y-1<= nbr_ligne-1){
        if(g.getCase(x, y-1).getStatus() == 0){
        if(checkBomb(x,y-1)){
            bomb_close++;
        }
        else{
          safeCase.add(g.getCase(x, y-1));
         }
        }
    }
        
    //vérification de la case en haut-droite.
    if(x+1>= 0 &&x+1<= nbr_colonne-1 && y-1>= 0 &&y-1<= nbr_ligne-1){
        if(g.getCase(x+1, y-1).getStatus() == 0){
        if(checkBomb(x+1,y-1)){
            bomb_close++;
        }
        else{
          safeCase.add(g.getCase(x+1, y-1));
         }
        }
    }

    //vérification de la case à droite.
    if(x+1>= 0 &&x+1<= nbr_colonne-1 && y>= 0 &&y<= nbr_ligne-1){
        if(g.getCase(x+1, y).getStatus() == 0){
            if(checkBomb(x+1,y)){
                bomb_close++;
            }
            else{
            safeCase.add(g.getCase(x+1, y));
            }
        }
    }

   //vérification de la case à gauche.
   if(x-1>= 0 &&x-1<= nbr_colonne-1 && y>= 0 &&y<= nbr_ligne-1){
    if(g.getCase(x-1, y).getStatus() == 0){
            if(checkBomb(x-1,y)){
                bomb_close++;
            }
            else{
            safeCase.add(g.getCase(x-1, y));
            }
        }
}

    //vérification de la case en bas-gauche.
    if(x-1>= 0 &&x-1<= nbr_colonne-1 && y+1>= 0 &&y+1<= nbr_ligne-1){
        if(g.getCase(x-1, y+1).getStatus() == 0){
            if(checkBomb(x-1,y+1)){
                bomb_close++;
            }
            else{
            safeCase.add(g.getCase(x-1, y+1));
            }
        }
    }
     
    //vérification de la case en bas.
    if(x>= 0 &&x<= nbr_colonne-1 && y+1>= 0 &&y+1<= nbr_ligne-1){
        if(g.getCase(x, y+1).getStatus() == 0){
            if(checkBomb(x,y+1)){
                bomb_close++;
            }
            else{
            safeCase.add(g.getCase(x, y+1));
            }
        }
    }
    
    //vérification de la case en bas-droite.
    if(x+1>= 0 &&x+1<= nbr_colonne-1 && y+1>= 0 &&y+1<= nbr_ligne-1){
        if(g.getCase(x+1, y+1).getStatus() == 0){
            if(checkBomb(x+1,y+1)){
                bomb_close++;
            }
            else{
            safeCase.add(g.getCase(x+1, y+1));
            }
        }
    }

    Case currenCase = g.getCase(x, y); 
         if(bomb_close == 0){
             unHideCase(x, y);

             for(Case c : safeCase){
                getEntourage(c.getGridPosX(), c.getGridPosY());
             }
         }
         else{
            unHideCase(x, y);
             currenCase.markNumber(bomb_close);
         }
        
         return bomb_close;
     }

     //renvoie true s'il ya une bombe et false si il n'y en a pas
    public boolean checkBomb(int posX, int posY){
        
        if(tab_partie[posY][posX] == 1){
            return true;
        }

        else{
            return false;
        }

    }

    public boolean checkVictory(){


    for(int x = 0; x<= nbr_colonne-1 ; x++){
        for(int y = 0; y<= nbr_ligne-1 ; y++){
            if( tab_partie[y][x]== -1){
                return false;
            }       
        }
    }
    return true;

    }

    public void unHideCase( int pos_x , int pos_y){
        tab_partie[pos_y][pos_x]= 0;

         g.getCase(pos_x, pos_y).devoiler();
    }

    public void getstartedGame(){
        first_cliquee = true;
    }

    public boolean  isStartedGame(){
        return first_cliquee;
    }

    public int[][] getTab(){
        return tab_partie;
    }

    public int getRows() {
        return nbr_ligne;
    }

    public int getCols() {
        return nbr_colonne;
    }

    public int getBombs() {
        return nbr_bombe;
    }

    public void setView(Grille g) {
        this.g = g;
    }

    public void UnHideBomb(){
        this.g.UnHideBomb();
    }

}
