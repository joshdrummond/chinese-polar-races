/*
    Chinese Polar Races
    Joshua Drummond

    The Review Screen
*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CPRReviewFrame
    extends Frame
{
    private CPRImageCanvas pix;
  //  private Panel panCenter;
    private Label lblNumber;
    private Label lblEnglish;
    private Label lblForeign;
//    private Label lblLanguage;
    private TextField tfNumber;
    private Label lblEnglishHead;
    private Label lblForeignHead;
    private Label lblLesson;
    private Label lblPenColor;
    private Label lblPenSize;
    private Label lblRange;
    private Choice chLesson;
    private Choice chPenColor;
    private Choice chPenSize;
    private Checkbox cbxShowCharacter;
    private Checkbox cbxShowEnglish;
    private Checkbox cbxShowPinyin;
    private CheckboxGroup cbgRange;
    private Checkbox cbxCumulative;
    private Checkbox cbxCurrentOnly;
//    private Choice chLanguage;
    private Button btnPrev;
    private Button btnNext;
    private Button btnRandom;
    private Button btnSound;
    private Button btnClear;
//    private Button btnClose;
    private static int cmdPrev = 0;
    private static int cmdNext = 1;
    private static int cmdRandom = 2;
    private static int cmdSound = 3;
    private static int cmdClose = 4;
    private static int cmdClear = 5;
    private int currentNum;
  //  private Panel p1, p2, p3, p4, p5, p6;
    private Random random;
    private CPRVocab words;
    private CPRDrawingCanvas canvas;
    private GridBagLayout gbl;
    private Panel panButtons;
    private int intMinWord, intMaxWord;
   // private String strSeparator;

    public CPRReviewFrame()
    {
        super("Practice Screen");
       // this.setSize(600,440);
  //      center();
        addWindowListener(new CPRWindowAdapter(this));
        gbl = new GridBagLayout();
        panButtons = new Panel();
        //setLayout(new BorderLayout(5,5));
        setLayout(gbl);
        words = new CPRVocab(CPRVocab.MAX_LESSON); //getMax()); //SPANISH);
        /*panCenter = new Panel();
        panCenter.setLayout(new GridLayout(5,1,5,5));
        */
        setBackground(Color.black); 
        random = new Random();
       /* chLanguage = new Choice();
        chLanguage.addItemListener(new ItemListener()
        {
           public void itemStateChanged(ItemEvent e)
           {
              doChoiceChange();
           }
        });
        //chLanguage.setFont(new Font("Serif", Font.BOLD, 14));
        //initChoice();
        */
        //pix = new CPRImageCanvas(CPR.app.getImage(CPR.app.getDocumentBase(), "blank.gif"), 100, 100);
        pix = new CPRImageCanvas(CPRResourceLoader.getImage("/blank.gif", this), 500, 100);
        btnClear = new Button("     Clear     ");
        btnClear.setBackground(Color.white);
        btnClear.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnClear.addActionListener(new MyButtonListener(cmdClear));
        btnPrev = new Button(" <- Previous ");
        btnPrev.setBackground(Color.white);
        btnPrev.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnPrev.addActionListener(new MyButtonListener(cmdPrev));
        btnNext = new Button("   Next ->   ");
        btnNext.setBackground(Color.white);
        btnNext.addActionListener(new MyButtonListener(cmdNext));
        btnNext.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnRandom = new Button("   Random   ");
        btnRandom.setBackground(Color.white);
        btnRandom.addActionListener(new MyButtonListener(cmdRandom));
        btnRandom.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnSound = new Button("   Listen   ");
        btnSound.setBackground(Color.white);
        btnSound.addActionListener(new MyButtonListener(cmdSound));
        btnSound.setFont(new Font("SansSerif", Font.BOLD, 14));
        /*btnClose = new Button("   Close   ");
        btnClose.setBackground(Color.white);
        btnClose.addActionListener(new MyButtonListener(cmdClose)); */
        lblEnglishHead = new Label("English : ",Label.RIGHT);
        lblEnglishHead.setForeground(Color.white);
        lblEnglishHead.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblForeignHead = new Label("Pinyin : ",Label.RIGHT);
        lblForeignHead.setForeground(Color.white);
        lblForeignHead.setFont(new Font("SansSerif", Font.BOLD, 14));
    //    lblLanguage = new Label("Language : ",Label.RIGHT);
     //   lblLanguage.setForeground(Color.white);
      //  lblLanguage.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblNumber = new Label("Word #");
        lblNumber.setForeground(Color.white);
        lblNumber.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblLesson = new Label("Lesson:", Label.RIGHT);
        lblLesson.setForeground(Color.white);
        lblLesson.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblRange = new Label("Range:", Label.RIGHT);
        lblRange.setForeground(Color.white);
        lblRange.setFont(new Font("SansSerif", Font.BOLD, 14));
        cbxShowCharacter = new Checkbox("Display Character", true);
        cbxShowCharacter.setForeground(Color.white);
        cbxShowCharacter.addItemListener(new ItemListener()
        {
           public void itemStateChanged(ItemEvent e)
           {
              doCheckboxChange();
           }
        });
        cbxShowEnglish = new Checkbox("Display English", true);
        cbxShowEnglish.setForeground(Color.white);
        cbxShowEnglish.addItemListener(new ItemListener()
        {
           public void itemStateChanged(ItemEvent e)
           {
              doCheckboxChange();
           }
        });
        cbxShowPinyin = new Checkbox("Display Pinyin", true);
        cbxShowPinyin.setForeground(Color.white);
        cbxShowPinyin.addItemListener(new ItemListener()
        {
           public void itemStateChanged(ItemEvent e)
           {
              doCheckboxChange();
           }
        });
        
        cbgRange = new CheckboxGroup();
        cbxCumulative = new Checkbox("Cumulative to Lesson", cbgRange, true);
        cbxCumulative.setForeground(Color.white);
        cbxCumulative.addItemListener(new ItemListener()
        {
           public void itemStateChanged(ItemEvent e)
           {
              doLessonChange();
           }
        });
        cbxCurrentOnly = new Checkbox("Current Lesson Only", cbgRange, false);
        cbxCurrentOnly.setForeground(Color.white);
        cbxCurrentOnly.addItemListener(new ItemListener()
        {
           public void itemStateChanged(ItemEvent e)
           {
              doLessonChange();
           }
        });


        chLesson = new Choice();
        chLesson.setFont(new Font("SansSerif", Font.BOLD, 14));
        chLesson.setBackground(Color.white);
        //for (int i = 0; i < CPRVocab.MAX_LESSON; i++)
        //   chLesson.addItem(""+(i+1));
        // pcr
        for (int i = 0; i < 30; i++)
           chLesson.addItem(""+(i+1));
        // lic
        chLesson.addItem("L-2");
        chLesson.addItem("L-3");
        chLesson.addItem("L-6");
        chLesson.addItem("L-7");
        chLesson.addItem("L-8");
        chLesson.addItem("L-12");
        chLesson.addItem("L-18");
        chLesson.addItem("L-20");
        chLesson.addItem("L-21");
        chLesson.addItemListener(new ItemListener()
        {
           public void itemStateChanged(ItemEvent e)
           {
              doLessonChange();
           }
        });
        chLesson.select(chLesson.getItemCount() - 1);

        lblEnglish = new Label();
        lblEnglish.setFont(new Font("Serif",Font.BOLD,14));
        lblEnglish.setForeground(Color.white);
        //English.setEditable(false);
        lblForeign = new Label();
        lblForeign.setFont(new Font("Serif",Font.BOLD,14));
        lblForeign.setForeground(Color.white);
        tfNumber = new TextField(10);
        tfNumber.setFont(new Font("Serif", Font.BOLD, 14));
        tfNumber.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               doHitEnter();
            }
        });
        tfNumber.setForeground(Color.white);
        /*p1 = new Panel();
        //p1.setLayout(new GridLayout(1,2));
        p1.setLayout(new BorderLayout()); //GridLayout(1,2));
        p1.add(lblEnglishHead, "West");
        p1.add(lblEnglish, "Center");
        p2 = new Panel();
        p2.setLayout(new BorderLayout()); //GridLayout(1,2));
        //p2.setLayout(new GridLayout(1,2));
        p2.add(lblForeignHead, "West");
        p2.add(lblForeign, "Center");
        p3 = new Panel();
        p3.add(lblNumber);
        p3.add(tfNumber);
        p4 = new Panel();
        p4.add(btnPrev);
        p4.add(btnNext);
        p4.add(btnRandom);
        p4.add(btnSound);
        p5 = new Panel();
     //   p5.setLayout(new GridLayout(1,0,5,5));
        p5.add(lblLesson);
        p5.add(chLesson);
        p5.add(new Label("            "));
        p5.add(cbxShowCharacter);
       // p5.setLayout(new GridLayout(1,1));
        this.add(pix,"North");
        panCenter.add(p1); panCenter.add(p2); panCenter.add(p3); panCenter.add(p5);
        panCenter.add(p4);
        this.add(panCenter,"Center");
//        this.setLocation(100,100);
//pack();
        //this.setSize(500,375);
        */
        currentNum = 0;
        intMinWord = 0;
        intMaxWord = words.getMax() - 1;
        tfNumber.setText(""+currentNum);
        lblEnglish.setText(words.getEnglish(currentNum));
        lblForeign.setText(words.getForeign(currentNum));
        //pix.setImage(CPR.app.getImage(CPR.app.getDocumentBase(), "cpr"+currentNum+".gif"));
        panButtons.add(btnPrev);
        panButtons.add(btnNext);
        panButtons.add(btnRandom);
        panButtons.add(btnSound);
        pix.setImage(CPRResourceLoader.getImage("/cpr"+currentNum+".gif", this));
        canvas = new CPRDrawingCanvas(Color.black, 
           Color.white, 500, 100);
        //this.add(canvas, "South");
        //strSeparator = System.getProperty("file.separator");

        drawScreen();
        setSize(550,580);
        center();
        setResizable(false);
        setVisible(true);
    }

    private void drawScreen()
    {
       addComponent(gbl, pix, this, 0, 0, 6, 2, 5, 5, 5, 5, GridBagConstraints.CENTER, false);
       addComponent(gbl, lblEnglishHead, this, 0, 2, 1, 1, 5, 5, 5, 5, GridBagConstraints.EAST, true);
       addComponent(gbl, lblEnglish, this, 1, 2, 5, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, lblForeignHead, this, 0, 3, 1, 1, 5, 5, 5, 5, GridBagConstraints.EAST, true);
       addComponent(gbl, lblForeign, this, 1, 3, 5, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, canvas, this, 0, 4, 6, 2, 5, 5, 5, 5, GridBagConstraints.CENTER, false);
       addComponent(gbl, lblNumber, this, 1, 6, 1, 1, 5, 5, 5, 5, GridBagConstraints.EAST, true);
       addComponent(gbl, tfNumber, this, 2, 6, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, btnClear, this, 4, 6, 2, 1, 5, 5, 5, 5, GridBagConstraints.CENTER, false);
       addComponent(gbl, cbxShowCharacter, this, 1, 7, 2, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, cbxShowEnglish, this, 1, 8, 2, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, cbxShowPinyin, this, 1, 9, 2, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, lblLesson, this, 3, 7, 1, 1, 5, 5, 5, 5, GridBagConstraints.EAST, true);
       addComponent(gbl, lblRange, this, 3, 8, 1, 1, 5, 5, 5, 5, GridBagConstraints.EAST, true);
       addComponent(gbl, chLesson, this, 4, 7, 2, 1, 5, 5, 5, 5, GridBagConstraints.WEST, false);
       addComponent(gbl, cbxCumulative, this, 4, 8, 2, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, cbxCurrentOnly, this, 4, 9, 2, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, new Label(" "), this, 1, 10, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, panButtons, this, 0, 11, 6, 1, 5, 5, 5, 5, GridBagConstraints.CENTER, true);
    }

/*
    private void initChoice()
    {
       chLanguage.addItem("Spanish");
       chLanguage.addItem("Korean");
       chLanguage.addItem("Japanese");
       chLanguage.addItem("Chinese");
       chLanguage.addItem("French");
       chLanguage.addItem("German");
    }
*/
/*
    private void doChoiceChange()
    {
       String strLanguage = chLanguage.getSelectedItem();
       if (strLanguage.equals("Spanish"))
          words.loadSpanishWords();
       else if (strLanguage.equals("Korean"))
          words.loadKoreanWords();
       else if (strLanguage.equals("Japanese"))
          words.loadJapaneseWords();
       else if (strLanguage.equals("Chinese"))
          words.loadChineseWords();
       else if (strLanguage.equals("French"))
          words.loadFrenchWords();
       else if (strLanguage.equals("German"))
          words.loadGermanWords();

       if (!words.isPix())
          pix.setImage(CPR.app.getImage(CPR.app.getDocumentBase(), "blank.jpg"));

       doHitEnter();

    }
*/
        private void doHitEnter()
        {
          int temp = currentNum;
          try
          {
            currentNum = (Integer.valueOf(tfNumber.getText())).intValue();
            //if (currentNum >= 0 && currentNum <= words.getLessonMax())
            if (currentNum >= intMinWord && currentNum <= intMaxWord)
            {
                tfNumber.setText(""+currentNum);
                if (cbxShowEnglish.getState())
                   lblEnglish.setText(words.getEnglish(currentNum));

                if (cbxShowPinyin.getState())
                   lblForeign.setText(words.getForeign(currentNum));

                if (cbxShowCharacter.getState())
                    pix.setImage(CPRResourceLoader.getImage("/cpr"+currentNum+".gif", this));
                    
                repaint();
            }
            else
            {
                currentNum = temp;
                tfNumber.setText(""+currentNum);
            }
          }
          catch (NumberFormatException exp) 
          { 
            currentNum = temp;
            tfNumber.setText(""+currentNum);
          }
        }


       private void doCheckboxChange()
       {
           if (cbxShowCharacter.getState())
               // Show character
               //pix.setImage(CPR.app.getImage(CPR.app.getDocumentBase(), "cpr"+currentNum+".gif"));
               pix.setImage(CPRResourceLoader.getImage("/cpr"+currentNum+".gif", this));
           else
               // Don't show character
               //pix.setImage(CPR.app.getImage(CPR.app.getDocumentBase(), "blank.gif"));
               pix.setImage(CPRResourceLoader.getImage("/blank.gif", this));

           if (cbxShowEnglish.getState())
              lblEnglish.setText(words.getEnglish(currentNum));
           else
              lblEnglish.setText("");

           if (cbxShowPinyin.getState())
              lblForeign.setText(words.getForeign(currentNum));
           else
              lblForeign.setText("");

           repaint();
       }

       private void doLessonChange()
       {
      //     int intLesson = (Integer.valueOf(chLesson.getSelectedItem())).intValue();
           int intLesson = (chLesson.getSelectedIndex() + 1);
           words.setLesson(intLesson);
           intMaxWord = words.convertMaxLesson(intLesson);
           if (cbxCumulative.getState())
           {
              // cumulative, start at 0
              intMinWord = 0;
           }
           else
           {
              // this lesson only, cut off minimum!
              if (intLesson == 1)
                 intMinWord = 0;
              else
                 intMinWord = words.convertMaxLesson(intLesson-1) + 1;
           }

           if (currentNum < intMinWord || currentNum > intMaxWord)
           {
              // redraw with possible new number
              currentNum = intMinWord;
              tfNumber.setText(""+currentNum);
              if (cbxShowEnglish.getState())
                 lblEnglish.setText(words.getEnglish(currentNum));

              if (cbxShowPinyin.getState())
                 lblForeign.setText(words.getForeign(currentNum));

              if (cbxShowCharacter.getState())
                 pix.setImage(CPRResourceLoader.getImage("/cpr"+currentNum+".gif", this));
                   
              repaint();
           }
       }

    private class MyButtonListener
        implements ActionListener
    {
        private int cmd;

        public MyButtonListener(int cmd)
        {
           this.cmd = cmd;
        }

        public void actionPerformed(ActionEvent e)
        {
           doHitButton(cmd);
        }
    }


    private void doHitButton(int cmd)
    {
            if (cmd == cmdClose)
            {
                setVisible(false);
                dispose();
            }
            else if (cmd == cmdPrev)
            {
                currentNum--;
                if (currentNum < intMinWord)
                    currentNum = intMaxWord;
                tfNumber.setText(""+currentNum);
                if (cbxShowEnglish.getState())
                    lblEnglish.setText(words.getEnglish(currentNum));
                if (cbxShowPinyin.getState())
                    lblForeign.setText(words.getForeign(currentNum));
                if (cbxShowCharacter.getState())
                   pix.setImage(CPRResourceLoader.getImage("/cpr"+currentNum+".gif", this));
                repaint();
            }
            else if (cmd == cmdNext)
            {
                currentNum++;
                if (currentNum > intMaxWord)
                    currentNum = intMinWord;
                tfNumber.setText(""+currentNum);
                if (cbxShowEnglish.getState())
                    lblEnglish.setText(words.getEnglish(currentNum));
                if (cbxShowPinyin.getState())
                    lblForeign.setText(words.getForeign(currentNum));
                if (cbxShowCharacter.getState())
                   pix.setImage(CPRResourceLoader.getImage("/cpr"+currentNum+".gif", this));
                repaint();
            }
            else if (cmd == cmdRandom)
            {
                currentNum = ((int)(random.nextFloat() * (intMaxWord-intMinWord+1))) + intMinWord;
                tfNumber.setText(""+currentNum);
                if (cbxShowEnglish.getState())
                   lblEnglish.setText(words.getEnglish(currentNum));
                if (cbxShowPinyin.getState())
                   lblForeign.setText(words.getForeign(currentNum));
                if (cbxShowCharacter.getState())
                   pix.setImage(CPRResourceLoader.getImage("/cpr"+currentNum+".gif", this));
                repaint();
            }
            else if (cmd == cmdSound)
            {
      //      String strTemp = 
      //          CPR.app.getDocumentBase()+ "audio" + strSeparator + "cpr"+currentNum+".au";
       //         System.out.println(strTemp);
          //      AudioClip sound = CPR.app.getAudioClip(CPR.app.getDocumentBase(), "cpr"+currentNum+".au");
                AudioClip sound = CPR.app.getAudioClip(CPR.app.getDocumentBase(), "audio//cpr"+currentNum+".au");
                sound.play();
            }
            else if (cmd == cmdClear)
            {
                // repaint the CPRDrawingCanvas
                canvas.repaint();
            }
      }

   private void addComponent(GridBagLayout gridb,
                         Component comp,
                         Container parent,
                         int x, int y, int width, int height,
                         int left, int right, int top, int bottom, 
                         int align, boolean isFill)
   {
      GridBagConstraints con = new GridBagConstraints();
    
      con.gridx=x;
      con.gridy=y;
      con.gridwidth=width;
      con.gridheight=height;
      con.insets.left=left;
      con.insets.right=right;
      con.insets.top=top;
      con.insets.bottom=bottom;
      con.anchor=align;
      if (isFill)
        con.fill = GridBagConstraints.BOTH;
       else
        con.fill = GridBagConstraints.NONE;
      gridb.setConstraints(comp, con);
      parent.add(comp);

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
