/*
    Chinese Polar Races
    Josh Drummond
    Fall of '99
*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CPR
    extends Applet
{
    private Button btnPlay;
    private Button btnReview;
    private Button btnAbout;
    private CPRTitleCanvas canTitle;
    private CPRImageCanvas canGraphic;

    public static CPRVocab words;
    public static Applet app;

    public void init()
    {
       System.out.println("-------------------------------------------------");
       System.out.println("Starting Chinese Polar Races...");
       System.out.println("Version number: 1.7");
       System.out.println("Version date: 11/17/1999");
       System.out.println("(c)1999 Josh Drummond");
       System.out.println("-------------------------------------------------");

       this.app = this;
       canTitle = new CPRTitleCanvas("Chinese Polar Races!", new Font("TimesRoman", 
          Font.BOLD, 48), Color.white);
          
       canGraphic = new CPRImageCanvas(getImage(getDocumentBase(), "back1.jpg"), 350, 350);

       btnPlay = new Button("   Play   ");
       btnPlay.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent e)
          {
             doPlay();
          }
       });

       btnReview = new Button(" Review ");
       btnReview.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent e)
          {
             doReview();
          }
       });

       btnAbout = new Button("  About  ");
       btnAbout.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent e)
          {
             doAbout();
          }
       });

       drawScreen();
     }


     private void drawScreen()
     {
       this.setBackground(Color.black);
       this.setLayout(new BorderLayout());
       btnPlay.setBackground(Color.white);
       btnPlay.setFont(new Font("Serif", Font.BOLD, 18));
       btnReview.setBackground(Color.white);
       btnReview.setFont(new Font("Serif", Font.BOLD, 18));
       btnAbout.setBackground(Color.white);
       btnAbout.setFont(new Font("Serif", Font.BOLD, 18));

       Panel panBot = new Panel();
       panBot.add(btnPlay);
       panBot.add(btnReview);
       panBot.add(btnAbout);

       this.add(canTitle, "North");
       this.add(canGraphic, "Center");
       this.add(panBot, "South");

     }

     private void doPlay()
     {
        new CPRGameFrame();
     }

     private void doAbout()
     {
        new CPRAboutFrame();
     }

     private void doReview()
     {
        new CPRReviewFrame();
     }
}
