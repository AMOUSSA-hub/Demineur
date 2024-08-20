package fr.amoussa.Demineur.UTILS;
import javax.swing.*;
import java.awt.Image;


public class Icone {


 static ClassLoader loader = Thread.currentThread().getContextClassLoader();

 
//  //MODE ARCHIVE
//    //AUTRES
//     public static Icon bomb  = new ImageIcon(new ImageIcon(loader.getResource("bomb.png")).getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
//     public static Icon interrogation  = new ImageIcon(new ImageIcon(loader.getResource("interrogation.png")).getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
//     public static Icon star  = new ImageIcon(new ImageIcon(loader.getResource("etoile.png")).getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
//      //NOMBRE
//      public static Icon one =new ImageIcon(new ImageIcon(loader.getResource("un.png")).getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
//      public static Icon two =new ImageIcon(new ImageIcon(loader.getResource("deux.png")).getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
//      public static Icon three =new ImageIcon(new ImageIcon(loader.getResource("trois.png")).getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
//      public static Icon four =new ImageIcon(new ImageIcon(loader.getResource("quatre.png")).getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
//      public static Icon five  =new ImageIcon(new ImageIcon(loader.getResource("cinq.png")).getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
//      public static Icon six =new ImageIcon(new ImageIcon(loader.getResource("six.png")).getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
//      public static Icon seven =new ImageIcon(new ImageIcon(loader.getResource("sept.png")).getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
//      public static Icon eight =new ImageIcon(new ImageIcon(loader.getResource("huit.png")).getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));

//MODE NORMAL 
  //AUTRES
    public final  static String background_home ="res/home_good.png";
    public static String background_select ="res/wow_home.png"; 
    public static String logo_home ="res/logo_demineur.png";
    public static Icon bomb =  new ImageIcon(new ImageIcon("res/bomb.png").getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));

    public static Icon interrogation  = new ImageIcon(new ImageIcon("res/interrogation.png").getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
    public static Icon star = new ImageIcon(new ImageIcon("res/etoile.png").getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));

     //NOMBRE
     public static Icon one =  new ImageIcon(new ImageIcon("res/un.png").getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
     public static Icon two =  new ImageIcon(new ImageIcon("res/deux.png").getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
     public static Icon three =  new ImageIcon(new ImageIcon("res/trois.png").getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
     public static Icon four =  new ImageIcon(new ImageIcon("res/quatre.png").getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT)); 
     public static Icon five =  new ImageIcon(new ImageIcon("res/cinq.png").getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
     public static Icon six =  new ImageIcon(new ImageIcon("res/six.png").getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
     public static Icon seven =  new ImageIcon(new ImageIcon("res/sept.png").getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
     public static Icon eight =  new ImageIcon(new ImageIcon("res/huit.png").getImage().getScaledInstance(20 , 20, Image.SCALE_DEFAULT));
    }
