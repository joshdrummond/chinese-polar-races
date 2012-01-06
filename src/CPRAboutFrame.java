/*
    Chinese Polar Races v2.02
    Joshua Drummond

    The About Screen
*/

import java.awt.*;
import java.awt.event.*;

public class CPRAboutFrame
    extends Frame
{
    private TextArea ta;

    public CPRAboutFrame()
    {
        super("About Screen");
        this.setBackground(Color.black);
        this.addWindowListener(new CPRWindowAdapter(this));
        ta = new TextArea(15,50);
        ta.setFont(new Font("SansSerif",Font.BOLD,14));
        ta.setEditable(false);
        ta.setBackground(Color.black);
        ta.setForeground(Color.white);
        String s = "Chinese Polar Races v2.6\n" +
                   "(c) 1999-2000 Josh Drummond (Han2 Guo2 An1)\n\n" +
                   "\n\nPurpose:\n\n" +
                   "Learn Mandarin with audio, characters and Pinyin\n" +
                   "in a fun environment in this flashcard type game.\n" +
                   "Choose appropriate Lesson and Difficulty and then:\n" +
                   " - To learn vocabulary choose Play and either Pinyin\n" +
                   "to English or English to Pinyin multiple choice.\n" +
                   " - To learn character recognition choose Play and\n" +
                   "either Character to English or Character to Pinyin\n" +
                   "multiple choice.\n" +
                   " - To learn listening recognition choose Play and\n" +
                   "either Audio to English or Audio to Pinyin\n" +
                   "multiple choice.\n" +
                   " - To memorize Pinyin tone marks and add challenge\n" +
                   "choose Play and either English/Character/Audio\n" +
                   "to Pinyin fill in the blank.\n" +
                   " - To memorize Character writing, choose Practice\n" +
                   "and turn Display Character off.  Click on Random\n" +
                   "and try to write the character. Then turn Display\n" +
                   "Character back on and see if you got it correct.\n" +
                   "\n\n"+
                   "Story:\n\n"+
                   "You are the heroic Radman racing PolarBears in the\n" +
                   "Great Arctic.  Whoever knows the most Chinese wins\n" +
                   "the race as both your accuracy and total race\n" +
                   "results are " +
                   "continually calculated.\n\n\n"+
                   "Acknowledgements:\n\n"+
                   "The words used are separated by Lessons in sync\n" +
                   "with "+
                   "that of the Practical Chinese Reader used in\n" +
                   "first year Chinese classes "+
                   "at UCI.\nHope its helpful =)\n\n";
        ta.append(s);
        setSize(420,400);
        setLayout(new GridLayout(1,1));
        add(ta);
        center();
        setResizable(false);
        setVisible(true);
    }

    private void center()
    {
      // Locate center and place frame there.
      Dimension dimScreenSize = getToolkit().getScreenSize();
      Dimension dimDialogSize = getSize();
      setLocation((dimScreenSize.width - dimDialogSize.width) / 2,
         (dimScreenSize.height - dimDialogSize.height) / 2);
    }
}
