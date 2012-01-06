/*
    Chinese Polar Races v1.xx
    Joshua Drummond

    The Main Game Screen
*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Vector;

public class CPRGameFrame
    extends Frame
{

   // *** Buttons
   private Button btnOptionOkay;
   private Button btnOptionCancel;
   private Button btnNewLevelOkay;
   private Button btn1, btn2, btn3, btn4, btn5;
   private Button btnQuestion;

   // *** Checkboxes
   private CheckboxGroup cbgOption;
   private Checkbox cbTrans1;
   private Checkbox cbTrans2;
   private Checkbox cbTrans3;
   private Checkbox cbTrans4;
   private Checkbox cbTrans5;
   private Checkbox cbTrans6;

   private CheckboxGroup cbgInput;
   private Checkbox cbInput1;
   private Checkbox cbInput2;

   private CheckboxGroup cbgRange;
   private Checkbox cbRangeCumulative;
   private Checkbox cbRangeCurrentOnly;

   // *** Choice box
   private Choice chDifficulty;
   private Choice chLesson;

   // *** commands for events
   private final int cmdOptionOkay = 0;
   private final int cmdOptionCancel = 1;
//   private final int cmdSound = 2;
   private final int cmdLesson = 3;
   private final int cmdNewLevelOkay = 4;
   private final int cmdPlaySound = 5;
   private final int cmdBut1 = 6;
   private final int cmdBut2 = 7;
   private final int cmdBut3 = 8;
   private final int cmdBut4 = 9;
   private final int cmdBut5 = 10;
   private final int cmdTrans = 11;
   private final int cmdFillBlank = 12;

   // *** Labels
   private Label lblOptions;
   private Label lblDifficulty;
   private Label lblLesson;
   private Label lblMethod;
   private Label lblQuestion;
   private Label lblStats;
   private Label lblLevel;
   private Label lblRound;
   private Label lblScore;
   private Label lblInput;
   private Label lblFillBlank;
   private Label lblOldAnswer;
   private Label lblRange;

   // TextFields
   private TextField tfFillBlank;

   // *** ints
   private int intDifficulty;
   private int intMethod;
   private int intLevel;
   private int intRadmanHealth;
   private int intEnemyHealth;
   private int intCorrect;
   private int intTotal;
   private int intTotalWins;
   private int intTotalLosses;
   private int intRace;
   private int intAnswer;
   private int intWord;
   private int intWait;
   private int intDamageWrong;
   private int intDamageGoodHit;
   private int intDamageBadHit;
   private int intRadmanFrame;
   private int intPolarBearFrame;

   // *** booleans
   private boolean isSound;
   private boolean isViolence;
   private boolean isShowThread;
   private boolean isMultipleChoice;
   private boolean isLastCorrect;
   private boolean isCumulative;

   // *** doubles
   private double dblAccuracy;

   // *** Strings
   //private String strSeparator;

   // *** Other
   private GridBagLayout gbl;
   private CPRVocab words;
   private CPRImageCanvas canQuestion;
   private CPRAnimationCanvas canAnimation;
   private Random random;
   private Panel panLeft, panRight;
   private AudioClip sound;
   private MyThread thread;
   private RunningThread runThread;
   private Image imgBackground;
   private Image imgPolarBear1;
   private Image imgPolarBear2;
   private Image imgRadman1;
   private Image imgRadman2;
   private MediaTracker tracker;

   public CPRGameFrame()
   {
      // setup the frame
      super("Chinese Polar Races!");
      addWindowListener(new MyWindowListener());
      gbl = new GridBagLayout();
      setLayout(gbl);


      // *** Initiliaze all variables
      btnOptionOkay = new Button("   Okay   ");
      btnOptionOkay.addActionListener(new MyActionListener(cmdOptionOkay));
      btnOptionOkay.setBackground(Color.white);
      btnOptionOkay.setForeground(Color.black);
      btnOptionOkay.setFont(new Font("SansSerif", Font.BOLD, 14));

      btnNewLevelOkay = new Button("   Okay   ");
      btnNewLevelOkay.addActionListener(new MyActionListener(cmdNewLevelOkay));
      btnNewLevelOkay.setBackground(Color.white);
      btnNewLevelOkay.setForeground(Color.black);
      btnNewLevelOkay.setFont(new Font("SansSerif", Font.BOLD, 14));

      btnOptionCancel = new Button(" Cancel ");
      btnOptionCancel.addActionListener(new MyActionListener(cmdOptionCancel));
      btnOptionCancel.setBackground(Color.white);
      btnOptionCancel.setForeground(Color.black);
      btnOptionCancel.setFont(new Font("SansSerif", Font.BOLD, 14));

      lblOptions = new Label(" O P T I O N S ", Label.CENTER);
      lblOptions.setBackground(Color.black);
      lblOptions.setForeground(Color.white);
      lblOptions.setFont(new Font("SansSerif", Font.BOLD, 36));

      lblLevel = new Label(" L E V E L  X", Label.CENTER);
      lblLevel.setBackground(Color.black);
      lblLevel.setForeground(Color.white);
      lblLevel.setFont(new Font("SansSerif", Font.BOLD, 36));


      lblDifficulty = new Label("Difficulty:", Label.RIGHT);
      lblDifficulty.setBackground(Color.black);
      lblDifficulty.setForeground(Color.white);
      lblDifficulty.setFont(new Font("SansSerif", Font.BOLD, 14));

      lblLesson = new Label("Lesson:", Label.RIGHT);
      lblLesson.setBackground(Color.black);
      lblLesson.setForeground(Color.white);
      lblLesson.setFont(new Font("SansSerif", Font.BOLD, 14));

      lblMethod = new Label("Quiz Method:", Label.RIGHT);
      lblMethod.setBackground(Color.black);
      lblMethod.setForeground(Color.white);
      lblMethod.setFont(new Font("SansSerif", Font.BOLD, 14));

      lblRange = new Label("Quiz Range:", Label.RIGHT);
      lblRange.setBackground(Color.black);
      lblRange.setForeground(Color.white);
      lblRange.setFont(new Font("SansSerif", Font.BOLD, 14));

      lblInput = new Label("Input Method:", Label.RIGHT);
      lblInput.setBackground(Color.black);
      lblInput.setForeground(Color.white);
      lblInput.setFont(new Font("SansSerif", Font.BOLD, 14));

      cbgRange = new CheckboxGroup();

      cbRangeCumulative = new Checkbox("Cumulative to Lesson", true, cbgRange);
      cbRangeCumulative.setBackground(Color.black);
      cbRangeCumulative.setForeground(Color.white);
      cbRangeCumulative.setFont(new Font("Serif", Font.BOLD, 12));

      cbRangeCurrentOnly = new Checkbox("Current Lesson Only", false, cbgRange);
      cbRangeCurrentOnly.setBackground(Color.black);
      cbRangeCurrentOnly.setForeground(Color.white);
      cbRangeCurrentOnly.setFont(new Font("Serif", Font.BOLD, 12));

      cbgOption = new CheckboxGroup();

      cbTrans1 = new Checkbox("English -> Pinyin", false, cbgOption);
      cbTrans1.setBackground(Color.black);
      cbTrans1.setForeground(Color.white);
      cbTrans1.setFont(new Font("Serif", Font.BOLD, 12));
      cbTrans1.addItemListener(new MyItemListener(cmdTrans));

      cbTrans2 = new Checkbox("Pinyin -> English", true, cbgOption);
      cbTrans2.setBackground(Color.black);
      cbTrans2.setForeground(Color.white);
      cbTrans2.setFont(new Font("Serif", Font.BOLD, 12));
      cbTrans2.addItemListener(new MyItemListener(cmdTrans));

      cbTrans3 = new Checkbox("Audio -> English", false, cbgOption);
      cbTrans3.setBackground(Color.black);
      cbTrans3.setForeground(Color.white);
      cbTrans3.setFont(new Font("Serif", Font.BOLD, 12));
      cbTrans3.addItemListener(new MyItemListener(cmdTrans));

      cbTrans4 = new Checkbox("Audio -> Pinyin", false, cbgOption);
      cbTrans4.setBackground(Color.black);
      cbTrans4.setForeground(Color.white);
      cbTrans4.setFont(new Font("Serif", Font.BOLD, 12));
      cbTrans4.addItemListener(new MyItemListener(cmdTrans));

      cbTrans5 = new Checkbox("Character -> English", false, cbgOption);
      cbTrans5.setBackground(Color.black);
      cbTrans5.setForeground(Color.white);
      cbTrans5.setFont(new Font("Serif", Font.BOLD, 12));
      cbTrans5.addItemListener(new MyItemListener(cmdTrans));

      cbTrans6 = new Checkbox("Character -> Pinyin", false, cbgOption);
      cbTrans6.setBackground(Color.black);
      cbTrans6.setForeground(Color.white);
      cbTrans6.setFont(new Font("Serif", Font.BOLD, 12));
      cbTrans6.addItemListener(new MyItemListener(cmdTrans));

      cbgInput = new CheckboxGroup();

      cbInput1 = new Checkbox("Multiple Choice", true, cbgInput);
      cbInput1.setBackground(Color.black);
      cbInput1.setForeground(Color.white);
      cbInput1.setFont(new Font("Serif", Font.BOLD, 12));

      cbInput2 = new Checkbox("Fill in the Blank", false, cbgInput);
      cbInput2.setBackground(Color.black);
      cbInput2.setForeground(Color.white);
      cbInput2.setFont(new Font("Serif", Font.BOLD, 12));
      cbInput2.setEnabled(false);

      chDifficulty = new Choice();
      chDifficulty.setFont(new Font("Serif", Font.BOLD, 14));
      chDifficulty.setBackground(Color.white);
      chDifficulty.add("Too Easy!");
      chDifficulty.add("Intermediate");
      chDifficulty.add("...killer...");

      chLesson = new Choice();
      chLesson.setFont(new Font("Serif", Font.BOLD, 14));
      chLesson.setBackground(Color.white);
      // pcr
      for (int i = 0; i < 30; i++)
         chLesson.addItem("PCR-"+(i+1));
      // lic
      chLesson.addItem("LIC-2");
      chLesson.addItem("LIC-3");
      chLesson.addItem("LIC-6");
      chLesson.addItem("LIC-7");
      chLesson.addItem("LIC-8");
      chLesson.addItem("LIC-12");
      chLesson.addItem("LIC-18");
      chLesson.addItem("LIC-20");
      chLesson.addItem("LIC-21");
      chLesson.addItem("LIC-22");
      chLesson.addItem("LIC-23");
      chLesson.addItem("LIC-26");
      chLesson.addItem("LIC-27");
      chLesson.addItem("LIC-29");
      chLesson.addItem("LIC-30");
      chLesson.addItemListener(new MyItemListener(cmdLesson));

      lblRound = new Label("Round", Label.CENTER);
      lblRound.setBackground(Color.black);
      lblRound.setForeground(Color.white);
      lblRound.setFont(new Font("SansSerif", Font.BOLD+Font.ITALIC, 36));

      lblScore = new Label("Score", Label.CENTER);
      lblScore.setBackground(Color.black);
      lblScore.setForeground(Color.white);
      lblScore.setFont(new Font("SansSerif", Font.BOLD, 18));

      lblQuestion = new Label("", Label.LEFT);
      lblQuestion.setBackground(Color.black);
      lblQuestion.setForeground(Color.white);
      lblQuestion.setFont(new Font("SansSerif", Font.BOLD, 14));

      lblFillBlank = new Label("Answer:", Label.LEFT);
      lblFillBlank.setBackground(Color.black);
      lblFillBlank.setForeground(Color.white);
      lblFillBlank.setFont(new Font("SansSerif", Font.BOLD, 14));

      lblOldAnswer = new Label("", Label.CENTER);
      lblOldAnswer.setBackground(Color.black);
      lblOldAnswer.setForeground(Color.white);
      lblOldAnswer.setFont(new Font("SansSerif", Font.PLAIN, 12));

      btnQuestion = new Button(" Listen to Audio ");
      btnQuestion.addActionListener(new MyActionListener(cmdPlaySound));
      btnQuestion.setBackground(Color.white);
      btnQuestion.setForeground(Color.black);
      btnQuestion.setFont(new Font("SansSerif", Font.BOLD, 14));

      btn1 = new Button(" John Lennon ");
      btn1.addActionListener(new MyActionListener(cmdBut1));
      btn1.setBackground(Color.white);
      btn1.setForeground(Color.black);
      btn1.setFont(new Font("SansSerif", Font.BOLD, 14));

      btn2 = new Button(" Paul McCartney ");
      btn2.addActionListener(new MyActionListener(cmdBut2));
      btn2.setBackground(Color.white);
      btn2.setForeground(Color.black);
      btn2.setFont(new Font("SansSerif", Font.BOLD, 14));

      btn3 = new Button(" George Harrison ");
      btn3.addActionListener(new MyActionListener(cmdBut3));
      btn3.setBackground(Color.white);
      btn3.setForeground(Color.black);
      btn3.setFont(new Font("SansSerif", Font.BOLD, 14));

      btn4 = new Button(" Ringo Starr ");
      btn4.addActionListener(new MyActionListener(cmdBut4));
      btn4.setBackground(Color.white);
      btn4.setForeground(Color.black);
      btn4.setFont(new Font("SansSerif", Font.BOLD, 14));

      btn5 = new Button("Yoko Ono");
      btn5.addActionListener(new MyActionListener(cmdBut5));
      btn5.setBackground(Color.white);
      btn5.setForeground(Color.black);
      btn5.setFont(new Font("SansSerif", Font.BOLD, 14));

      //canQuestion = new CPRImageCanvas(CPR.app.getImage(CPR.app.getDocumentBase(), "cpr1.gif"), 350, 350);
      canQuestion = new CPRImageCanvas(
         CPRResourceLoader.getImage("/cpr1.gif", this),
         350, 350);

      lblStats = new Label("Accuracy = 0/0 100%", Label.CENTER);
      lblStats.setBackground(Color.black);
      lblStats.setForeground(Color.white);
      lblStats.setFont(new Font("SansSerif", Font.PLAIN, 12));

      tfFillBlank = new TextField(20);
      tfFillBlank.setFont(new Font("SansSerif", Font.BOLD, 18));
      tfFillBlank.setBackground(Color.black);
      tfFillBlank.setForeground(Color.white);
      tfFillBlank.addActionListener(new MyActionListener(cmdFillBlank));

      //tracker = new MediaTracker(CPR.app);
      //imgBackground = CPR.app.getImage(CPR.app.getDocumentBase(), "back2.jpg");
      imgBackground = CPRResourceLoader.getImage("/back2.jpg", this);
      //tracker.addImage(imgBackground, 0);
      //imgPolarBear1 = CPR.app.getImage(CPR.app.getDocumentBase(), "polar1.gif");
      imgPolarBear1 = CPRResourceLoader.getImage("/polar1.gif", this);
      //tracker.addImage(imgPolarBear1, 1);
      //imgPolarBear2 = CPR.app.getImage(CPR.app.getDocumentBase(), "polar2.gif");
      imgPolarBear2 = CPRResourceLoader.getImage("/polar2.gif", this);
      //tracker.addImage(imgPolarBear2, 2);
      imgRadman1 = CPRResourceLoader.getImage("/radman1.gif", this);
      //tracker.addImage(imgRadman1, 3);
      imgRadman2 = CPRResourceLoader.getImage("/radman2.gif", this);
      //tracker.addImage(imgRadman2, 4);
/*
      try
      {
         tracker.waitForAll();
      }
      catch (InterruptedException e)
      {
         System.out.println("Loading Images Interrupted!");
      }
*/

      random = new Random();
      isShowThread = false;
      //strSeparator = System.getProperty("file.separator");
      thread = new MyThread();
      thread.start();
      runThread = new RunningThread();
      canAnimation = new CPRAnimationCanvas();
      intCorrect = 0;
      intTotal = 0;
      intLevel = 1;
      //intRound = 1;
      //intRoundWin = 0;
      intTotalWins = 0;
      intTotalLosses = 0;
      intPolarBearFrame = 0;
      intRadmanFrame = 0;
      intRace = 1;
      intRadmanHealth = 100;
      intEnemyHealth = 100;
      panLeft = new Panel();
      panRight = new Panel();
  
      setResizable(false);
      // *** Load options screen
      drawOptions();
    }

    private void makeGamePanels()
    {
      panLeft.setLayout(new GridLayout(1,1));
      panLeft.add(canAnimation);

 //     Panel panButtons = new Panel();
 //     panButtons.setLayout(new GridLayout(0,1,5,5));

      panRight.setLayout(new GridLayout(0,1,5,5));

      Panel pantop = new Panel();
      pantop.setLayout(new GridLayout(0,1,5,5));
      
 //     pantop.add(lblRound);

      Panel panHead = new Panel();
      panHead.setLayout(new GridLayout(0,1));
      panHead.add(lblRound);
      panHead.add(lblScore);

      pantop.add(panHead);



//      Panel panCenter = new Panel();

    //  panRight.add(new Label(" "));
      if ((intMethod == 1) || (intMethod == 2))
         pantop.add(lblQuestion);
      else if ((intMethod == 3) || (intMethod == 4))
      {
         Panel panTemp = new Panel();
         panTemp.add(btnQuestion);
         pantop.add(panTemp);
      }
      else
         pantop.add(canQuestion);

//      panRight.add(panCenter, "Center");
   //   panRight.add(new Label(" "));
   Panel panbot = new Panel();
   panbot.setLayout(new GridLayout(0,1,5,5));

   if (isMultipleChoice)
   {
      panbot.add(btn1);
      panbot.add(btn2);
      panbot.add(btn3);
      panbot.add(btn4);
      panbot.add(btn5);
      Panel panTemp = new Panel();
      panTemp.setLayout(new GridLayout(2, 1));
      panTemp.add(lblOldAnswer);
      panTemp.add(lblStats);
      //panbot.add(lblStats);
      panbot.add(panTemp);
    }
    else
    {
      panbot.add(new Label(" "));
      panbot.add(lblFillBlank);
      panbot.add(tfFillBlank);
      panbot.add(new Label(" "));
      Panel panTemp = new Panel();
      panTemp.setLayout(new GridLayout(2, 1));
      panTemp.add(lblOldAnswer);
      panTemp.add(lblStats);
      panbot.add(new Label(" "));
      panbot.add(panTemp);
    }

    panRight.add(pantop);
    panRight.add(panbot);
  //    panRight.add(panButtons, "South");
    }


    private void drawOptions()
    {
       setBackground(Color.black);
       addComponent(gbl, lblOptions, this, 1, 1, 3, 1, 5, 5, 5, 5, GridBagConstraints.CENTER, false);
       addComponent(gbl, new Label(" "), this, 1, 2, 5, 1, 5, 5, 5, 5, GridBagConstraints.EAST, false);
       addComponent(gbl, lblLesson, this, 1, 3, 1, 1, 5, 5, 5, 5, GridBagConstraints.EAST, false);
       addComponent(gbl, chLesson, this, 2, 3, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
//       addComponent(gbl, cbSound, this, 4, 3, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, false);
       addComponent(gbl, lblDifficulty, this, 1, 4, 1, 1, 5, 5, 5, 5, GridBagConstraints.EAST, false);
       addComponent(gbl, chDifficulty, this, 2, 4, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, cbRangeCurrentOnly, this, 3, 4, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
//       addComponent(gbl, cbViolence, this, 4, 4, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, false);
       addComponent(gbl, lblRange, this, 1, 5, 1, 1, 5, 5, 5, 5, GridBagConstraints.EAST, false);
       addComponent(gbl, cbRangeCumulative, this, 2, 5, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, cbRangeCurrentOnly, this, 3, 5, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, true);
       addComponent(gbl, lblMethod, this, 1, 6, 1, 1, 5, 5, 5, 5, GridBagConstraints.EAST, false);
       addComponent(gbl, cbTrans2, this, 2, 6, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, false);
       addComponent(gbl, cbTrans3, this, 2, 7, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, false);
       addComponent(gbl, cbTrans5, this, 2, 8, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, false);
       addComponent(gbl, cbTrans1, this, 3, 6, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, false);
       addComponent(gbl, cbTrans4, this, 3, 7, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, false);
       addComponent(gbl, cbTrans6, this, 3, 8, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, false);
       addComponent(gbl, lblInput, this, 1, 9, 1, 1, 5, 5, 5, 5, GridBagConstraints.EAST, false);
       addComponent(gbl, cbInput1, this, 2, 9, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, false);
       addComponent(gbl, cbInput2, this, 3, 9, 1, 1, 5, 5, 5, 5, GridBagConstraints.WEST, false);
       addComponent(gbl, new Label(" "), this, 1, 10, 1, 1, 0, 0, 0, 0, GridBagConstraints.EAST, true);
       Panel p = new Panel();
       p.add(btnOptionOkay);
       p.add(btnOptionCancel);
       addComponent(gbl, p, this, 1, 11, 3, 1, 5, 5, 5, 5, GridBagConstraints.EAST, true);
    //   addComponent(gbl, btnOptionCancel, this, 3, 8, 1, 1, 5, 5, 5, 5, GridBagConstraints.EAST, true);

       pack();
       center();
       chLesson.select(chLesson.getItemCount() - 1);
       chDifficulty.select(0);
       setVisible(true);

    }



    private class MyActionListener
       implements ActionListener
    {
       int cmd;

       MyActionListener(int cmd)
       {
          this.cmd = cmd;
       }

       public void actionPerformed(ActionEvent e)
       {
          processEvent(cmd);
       }
    }
    
    private class MyItemListener
       implements ItemListener
    {
       int cmd;

       MyItemListener(int cmd)
       {
          this.cmd = cmd;
       }

       public void itemStateChanged(ItemEvent e)
       {
          processEvent(cmd);
       }
    }


    private void doOptionOkayHit()
    {

       intDifficulty = chDifficulty.getSelectedIndex() + 1;
       if (intDifficulty == 1)
       {
          intWait = 8000;
          intDamageWrong = 5;
          intDamageGoodHit = 30;
          intDamageBadHit = 2;
       }
       else if (intDifficulty == 2)
       {
          intWait = 4000;
          intDamageWrong = 30;
          intDamageGoodHit = 20;
          intDamageBadHit = 15;
       }
       else if (intDifficulty == 3)
       {
          intWait = 2000;
          intDamageWrong = 60;
          intDamageGoodHit = 10;
          intDamageBadHit = 30;
       }

       //words = new CPRVocab((Integer.valueOf(chLesson.getSelectedItem())).intValue());
       words = new CPRVocab(chLesson.getSelectedIndex() + 1);

       if (cbTrans1.getState())
          intMethod = 1;
       else if (cbTrans2.getState())
          intMethod = 2;
       else if (cbTrans3.getState())
          intMethod = 3;
       else if (cbTrans4.getState())
          intMethod = 4;
       else if (cbTrans5.getState())
          intMethod = 5;
       else if (cbTrans6.getState())
          intMethod = 6;

       isMultipleChoice = cbInput1.getState();
       isCumulative = cbRangeCumulative.getState();
       intLevel = 1;
       makeGamePanels();
       drawGame(); //NewLevel();
    }

    private void doOptionCancelHit()
    {
       setVisible(false);
       dispose();
    }

    public void processEvent(int intCommand)
    {
       switch(intCommand)
       {
          case cmdFillBlank:
             doFillBlankEnter();
             break;
          case cmdTrans:
             doTransChange();
             break;
          case cmdOptionOkay:
             doOptionOkayHit();
             break;
          case cmdOptionCancel:
             doOptionCancelHit();
             break;
          case cmdLesson:
            // doLanguageChange();
             break;
          case cmdNewLevelOkay:
    //         doNewLevelOkayHit();
             break;
          case cmdPlaySound:
             doPlaySound();
             break;
          case cmdBut1:
             doCheckAnswer(1);
             break;
          case cmdBut2:
             doCheckAnswer(2);
             break;
          case cmdBut3:
             doCheckAnswer(3);
             break;
          case cmdBut4:
             doCheckAnswer(4);
             break;
          case cmdBut5:
             doCheckAnswer(5);
             break;
          default:
             System.out.println("default");

        }
     }


     private void doFillBlankEnter()
     {
        if (((tfFillBlank.getText()).trim()).equals(""))
           return;

        if (((words.getForeign(intWord)).toLowerCase()).equals(((tfFillBlank.getText()).trim()).toLowerCase()))
          doRight();
        else
          doWrong();

        checkState(false);
     }


     private void doTransChange()
     {
         if (cbTrans2.getState() || cbTrans3.getState() || cbTrans5.getState())
         {
            // something to english
            cbInput1.setState(true);
            cbInput2.setEnabled(false);
         }
         else
         {
            // something to pinyin
            if (!cbInput2.isEnabled())
               cbInput2.setEnabled(true);
         }
     }

     private void doCheckAnswer(int intUserAnswer)
     {
         if (intUserAnswer == intAnswer)
            doRight();
          else
            doWrong();

         checkState(false);
     }



     private void doPlaySound()
     {
        sound.play();
     }


     private void drawGame()
     {
        removeAll();
        setSize(750,550);
        center();
        setLayout(new GridLayout(1,2,5,5));
        add(panLeft);
        add(panRight);
        validate();
        intRadmanHealth = 100;
        intEnemyHealth = 100;
        updateButtons();
        isShowThread = true;
     }


    private void doRight()
    {
        intTotal++;
        intCorrect++;
        doHitEnemy(((int)(random.nextFloat() * intDamageGoodHit))+1);
        lblStats.setForeground(Color.green);
        //lblOldAnswer.setForeground(Color.green);
        lblStats.setText("Accuracy = " +intCorrect+"/"+intTotal+" : "+
          ((100*intCorrect/intTotal))+"%");

       // added support to show correct answer if not in multiple choice mode
       if ((intMethod == 1) ||
           (intMethod == 4) ||
           (intMethod == 6))
         lblOldAnswer.setText("Dui4 le! (" + words.getForeign(intWord) + ")");
       else
          lblOldAnswer.setText("Dui4 le! (" + words.getEnglish(intWord) + ")");

        canAnimation.repaint();
    }

    private void checkState(boolean isThread)
    {
        if (!isShowThread)
           return;

        if (intEnemyHealth <= 0)
           doWinRound();
        else if (intRadmanHealth <= 0)
           doLoseRound();
        else if (!isThread)
           updateButtons();
    }
/*
    private void freezeButtons(boolean isFrozen)
    {
        btn1.setEnabled(!isFrozen);
        btn2.setEnabled(!isFrozen);
        btn3.setEnabled(!isFrozen);
        btn4.setEnabled(!isFrozen);
        btn5.setEnabled(!isFrozen);
    }

*/
    private void doWinRound()
    {
       isShowThread = false;
       new DialogEnd(this, "Cool!", "Radman has won this race!!!", true);
       intRadmanHealth = 100;
       intEnemyHealth = 100;

          intTotalWins++;
          intRace++;
          updateButtons();
    }

    private void doLoseRound()
    {
       isShowThread = false;
       new DialogEnd(this, "Loser!", "PolarBear has won this race!!!", true);
       intRadmanHealth = 100;
       intEnemyHealth = 100;

       intTotalLosses++;
       intRace++;
       updateButtons();
    }

    private void doWrong()
    {
        doHitRadman(((int)(intDamageWrong * random.nextFloat()))+1);
        intTotal++;
        lblStats.setForeground(Color.red);
        //lblOldAnswer.setForeground(Color.red);
        lblStats.setText("Accuracy = "+intCorrect+"/"+intTotal+" : " +
           ((100*intCorrect/intTotal))+"%");

       // added support to show correct answer if not in multiple choice mode
       if ((intMethod == 1) ||
           (intMethod == 4) ||
           (intMethod == 6))
          lblOldAnswer.setText("Bu4 dui4... (" + words.getForeign(intWord) + ")");
       else
          lblOldAnswer.setText("Bu4 dui4... (" + words.getEnglish(intWord) + ")");

        canAnimation.repaint();
    }

    private void updateButtons()
    {
       isShowThread = true;
        int fake1, fake2, fake3, fake4, method;
        canAnimation.repaint();
        if (!runThread.isAlive())
           runThread.start();

        lblRound.setText("Race "+intRace);
        lblScore.setText("("+intTotalWins+" Wins / "+intTotalLosses+" Losses)");

/* --moved to doRight() and doWrong() 11.15.99
       // added support to show correct answer if not in multiple choice mode
       if (!isMultipleChoice)
       {
          lblOldAnswer.setText("(" + words.getForeign(intWord) + ")");
       }
*/

//        if ((int)(random.nextFloat() * 4) == 0)
//        {
//            while ((intWord = (int)(random.nextFloat() * intLevel * 20)) >= words.getMax());
//        }
//        else
//        {
        //while ((intWord = ((int)(random.nextFloat() * words.getMax()))) >= words.getMax());
        //{

      // Added support for cumulative/current lesson
      if (isCumulative)
      {
         intWord = (int)(random.nextFloat() * (words.getLessonMax() + 1));
      }
      else
      { // only current lesson
         intWord =  ((int)(random.nextFloat() * (CPRVocab.convertMaxLesson(
           words.getLesson()) - CPRVocab.convertMaxLesson(
           words.getLesson() - 1)))) + (CPRVocab.convertMaxLesson(
           words.getLesson() - 1)) + 1;
      }

//        }

      fake1 = fake2 = fake3 = fake4 = intWord;

      if (isMultipleChoice)
      {
        //fake1 = fake2 = fake3 = fake4 = intWord;
        while (fake1==fake2 || fake1==fake3 || fake1==intWord ||
              fake1==fake4 || fake2==fake4 || fake3==fake4 || fake4==intWord ||
              fake2==fake3 || fake2==intWord || fake3==intWord)
        {
            fake1 = (int)(random.nextFloat() * words.getMax());
            fake2 = (int)(random.nextFloat() * words.getMax());
            fake3 = (int)(random.nextFloat() * words.getMax());
            fake4 = (int)(random.nextFloat() * words.getMax());
        }
        intAnswer = (int)(random.nextFloat() * 5) + 1;
      }

      if (intMethod == 1)
      {
        lblQuestion.setText(words.getEnglish(intWord));

       if (isMultipleChoice)
       {
        if (intAnswer == 1)
        {
           btn2.setLabel(words.getForeign(fake1));
           btn3.setLabel(words.getForeign(fake2));
           btn4.setLabel(words.getForeign(fake3));
           btn5.setLabel(words.getForeign(fake4));
        }
        else if (intAnswer == 2)
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(intWord));
           btn3.setLabel(words.getForeign(fake2));
           btn4.setLabel(words.getForeign(fake3));
           btn5.setLabel(words.getForeign(fake4));
        }
        else if (intAnswer == 3)
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(fake2));
           btn3.setLabel(words.getForeign(intWord));
           btn4.setLabel(words.getForeign(fake3));
           btn5.setLabel(words.getForeign(fake4));
        }
        else if (intAnswer == 4)
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(fake2));
           btn3.setLabel(words.getForeign(fake3));
           btn4.setLabel(words.getForeign(intWord));
           btn5.setLabel(words.getForeign(fake4));
        }
        else
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(fake2));
           btn3.setLabel(words.getForeign(fake3));
           btn4.setLabel(words.getForeign(fake4));
           btn5.setLabel(words.getForeign(intWord));
        }
      }
     }
     else if (intMethod == 2)
     {
        lblQuestion.setText(words.getForeign(intWord));
       if (isMultipleChoice)
       {
        if (intAnswer == 1)
        {
           btn1.setLabel(words.getEnglish(intWord));
           btn2.setLabel(words.getEnglish(fake1));
           btn3.setLabel(words.getEnglish(fake2));
           btn4.setLabel(words.getEnglish(fake3));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else if (intAnswer == 2)
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(intWord));
           btn3.setLabel(words.getEnglish(fake2));
           btn4.setLabel(words.getEnglish(fake3));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else if (intAnswer == 3)
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(fake2));
           btn3.setLabel(words.getEnglish(intWord));
           btn4.setLabel(words.getEnglish(fake3));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else if (intAnswer == 4)
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(fake2));
           btn3.setLabel(words.getEnglish(fake3));
           btn4.setLabel(words.getEnglish(intWord));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(fake2));
           btn3.setLabel(words.getEnglish(fake3));
           btn4.setLabel(words.getEnglish(fake4));
           btn5.setLabel(words.getEnglish(intWord));
        }
      }
     }
     else if (intMethod == 3)
     {
        //sound = CPR.app.getAudioClip(CPR.app.getDocumentBase(), "cpr"+intWord+".au");
        sound = CPR.app.getAudioClip(CPR.app.getDocumentBase(), "audio//cpr"+intWord+".au");
        sound.play();
      if (isMultipleChoice)
      {
        if (intAnswer == 1)
        {
           btn1.setLabel(words.getEnglish(intWord));
           btn2.setLabel(words.getEnglish(fake1));
           btn3.setLabel(words.getEnglish(fake2));
           btn4.setLabel(words.getEnglish(fake3));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else if (intAnswer == 2)
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(intWord));
           btn3.setLabel(words.getEnglish(fake2));
           btn4.setLabel(words.getEnglish(fake3));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else if (intAnswer == 3)
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(fake2));
           btn3.setLabel(words.getEnglish(intWord));
           btn4.setLabel(words.getEnglish(fake3));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else if (intAnswer == 4)
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(fake2));
           btn3.setLabel(words.getEnglish(fake3));
           btn4.setLabel(words.getEnglish(intWord));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(fake2));
           btn3.setLabel(words.getEnglish(fake3));
           btn4.setLabel(words.getEnglish(fake4));
           btn5.setLabel(words.getEnglish(intWord));
        }
       }
      }
      else if (intMethod == 4)
      {
        //sound = CPR.app.getAudioClip(CPR.app.getDocumentBase(), "cpr"+intWord+".au");
        sound = CPR.app.getAudioClip(CPR.app.getDocumentBase(), "audio//cpr"+intWord+".au");
        sound.play();
       if (isMultipleChoice)
       {
        if (intAnswer == 1)
        {
           btn1.setLabel(words.getForeign(intWord));
           btn2.setLabel(words.getForeign(fake1));
           btn3.setLabel(words.getForeign(fake2));
           btn4.setLabel(words.getForeign(fake3));
           btn5.setLabel(words.getForeign(fake4));
        }
        else if (intAnswer == 2)
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(intWord));
           btn3.setLabel(words.getForeign(fake2));
           btn4.setLabel(words.getForeign(fake3));
           btn5.setLabel(words.getForeign(fake4));
        }
        else if (intAnswer == 3)
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(fake2));
           btn3.setLabel(words.getForeign(intWord));
           btn4.setLabel(words.getForeign(fake3));
           btn5.setLabel(words.getForeign(fake4));
        }
        else if (intAnswer == 4)
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(fake2));
           btn3.setLabel(words.getForeign(fake3));
           btn4.setLabel(words.getForeign(intWord));
           btn5.setLabel(words.getForeign(fake4));
        }
        else
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(fake2));
           btn3.setLabel(words.getForeign(fake3));
           btn4.setLabel(words.getForeign(fake4));
           btn5.setLabel(words.getForeign(intWord));
        }
      }
     }
     else if (intMethod == 5)
     {
        //canQuestion.setImage(CPR.app.getImage(CPR.app.getDocumentBase(),"cpr"+intWord+".gif"));
        canQuestion.setImage(CPRResourceLoader.getImage("/cpr"+intWord+".gif", this));
       if (isMultipleChoice)
       {
        if (intAnswer == 1)
        {
           btn1.setLabel(words.getEnglish(intWord));
           btn2.setLabel(words.getEnglish(fake1));
           btn3.setLabel(words.getEnglish(fake2));
           btn4.setLabel(words.getEnglish(fake3));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else if (intAnswer == 2)
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(intWord));
           btn3.setLabel(words.getEnglish(fake2));
           btn4.setLabel(words.getEnglish(fake3));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else if (intAnswer == 3)
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(fake2));
           btn3.setLabel(words.getEnglish(intWord));
           btn4.setLabel(words.getEnglish(fake3));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else if (intAnswer == 4)
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(fake2));
           btn3.setLabel(words.getEnglish(fake3));
           btn4.setLabel(words.getEnglish(intWord));
           btn5.setLabel(words.getEnglish(fake4));
        }
        else
        {
           btn1.setLabel(words.getEnglish(fake1));
           btn2.setLabel(words.getEnglish(fake2));
           btn3.setLabel(words.getEnglish(fake3));
           btn4.setLabel(words.getEnglish(fake4));
           btn5.setLabel(words.getEnglish(intWord));
        }
       }
      }
      else if (intMethod == 6)
      {
        //canQuestion.setImage(CPR.app.getImage(CPR.app.getDocumentBase(),"cpr"+intWord+".gif"));
        canQuestion.setImage(CPRResourceLoader.getImage("/cpr"+intWord+".gif", this));
       if (isMultipleChoice)
       {
        if (intAnswer == 1)
        {
           btn1.setLabel(words.getForeign(intWord));
           btn2.setLabel(words.getForeign(fake1));
           btn3.setLabel(words.getForeign(fake2));
           btn4.setLabel(words.getForeign(fake3));
           btn5.setLabel(words.getForeign(fake4));
        }
        else if (intAnswer == 2)
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(intWord));
           btn3.setLabel(words.getForeign(fake2));
           btn4.setLabel(words.getForeign(fake3));
           btn5.setLabel(words.getForeign(fake4));
        }
        else if (intAnswer == 3)
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(fake2));
           btn3.setLabel(words.getForeign(intWord));
           btn4.setLabel(words.getForeign(fake3));
           btn5.setLabel(words.getForeign(fake4));
        }
        else if (intAnswer == 4)
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(fake2));
           btn3.setLabel(words.getForeign(fake3));
           btn4.setLabel(words.getForeign(intWord));
           btn5.setLabel(words.getForeign(fake4));
        }
        else
        {
           btn1.setLabel(words.getForeign(fake1));
           btn2.setLabel(words.getForeign(fake2));
           btn3.setLabel(words.getForeign(fake3));
           btn4.setLabel(words.getForeign(fake4));
           btn5.setLabel(words.getForeign(intWord));
        }
       }
      }

      if (!isMultipleChoice)
      {
          tfFillBlank.setText("");
          tfFillBlank.requestFocus();
      }
    }


    private class CPRAnimationCanvas
        extends Canvas
    {
        private Image imgOffscreen;

        public CPRAnimationCanvas()
        {
            this.setSize(350,500);
            imgOffscreen = CPR.app.createImage(350, 500);
        }

        public void drawPolarBear(Graphics g, int i)
        {
           switch (i)
           {
              case 0 : if (intRadmanHealth > intEnemyHealth)
                          g.drawImage(imgPolarBear1, 20, 350, CPR.app);
                        else
                          g.drawImage(imgPolarBear1, 150, 350, CPR.app);
                       return;
              case 1 : if (intRadmanHealth > intEnemyHealth)
                          g.drawImage(imgPolarBear2, 20, 350, CPR.app);
                        else
                          g.drawImage(imgPolarBear2, 150, 350, CPR.app);
                       return;
              default : return;
           }
        }

        public void drawRadman(Graphics g, int i)
        {
           switch (i)
           {
              case 0 : if (intRadmanHealth > intEnemyHealth)
                          g.drawImage(imgRadman1, 200, 300, CPR.app);
                        else
                          g.drawImage(imgRadman1, 20, 300, CPR.app);
                       return;
              case 1 : if (intRadmanHealth > intEnemyHealth)
                          g.drawImage(imgRadman2, 200, 300, CPR.app);
                        else
                          g.drawImage(imgRadman2, 20, 300, CPR.app);
                       return;
              default : return;
           }
        }

        public void drawProgress(Graphics g)
        {
            g.setColor(Color.cyan);
//            g.setFont(new Font("Monospaced",Font.BOLD,10));
            g.drawString("Radman",20, 20);
            g.setColor(Color.blue);
            g.fillRect(15, 25, 150, 20);
            g.setColor(Color.cyan);
            g.fillRect(15, 25, (int)((100-intEnemyHealth)*1.5), 20);
          //  g.drawString("Level "+intLevel+" Enemy",175,60);
            g.drawString("PolarBear",185, 20);
            g.setColor(Color.blue);
            g.fillRect(180, 25, 150, 20);
            g.setColor(Color.cyan);
            g.fillRect(180, 25, (int)((100-intRadmanHealth)*1.5), 20);
            // g.drawImage(imgBackground, 10, 60, 330, 425, CPR.app);
            g.drawImage(imgBackground, 10, 60, 330, 425, CPR.app);
        }
/*
        public void updateProgress(Graphics g)
        {
            g.setColor(Color.cyan);
            g.fillRect(15, 25, (int)((100-intEnemyHealth)*1.5), 20);
            g.fillRect(180, 25, (int)((100-intRadmanHealth)*1.5), 20);
        }
*/
        public void paint(Graphics g)
        {
           drawProgress(g);
           drawPolarBear(g, intPolarBearFrame);
           drawRadman(g, intRadmanFrame);
        }

        public void update(Graphics g)
        {
    //    System.out.println("before graphics, yo dude!");
    //    System.out.println(imgOffscreen.getWidth(this)+ " by " + imgOffscreen.getHeight(this));
     //      Graphics og = imgOffscreen.getGraphics();
    //    System.out.println("before t");

           paint(imgOffscreen.getGraphics());
    //    System.out.println("before drawImage");
           g.drawImage(imgOffscreen, 0, 0, CPR.app);
        }
    }


    public void doHitCloseWindow()
    {
        new DialogConfirmQuit(this, "Alert!", true);
    }


    private class MyWindowListener
       implements WindowListener
    {
       MyWindowListener() { }

       public void windowActivated(WindowEvent e) { }
       public void windowClosed(WindowEvent e) { }

       public void windowClosing(WindowEvent e)
       {
          doHitCloseWindow();

       }

       public void windowDeactivated(WindowEvent e) { }
       public void windowDeiconified(WindowEvent e) { }
       public void windowIconified(WindowEvent e) { }
       public void windowOpened(WindowEvent e) { }

    }


    private void doHitRadman(int intQty)
    {
       intRadmanHealth -= intQty;
       if (intRadmanHealth < 0)
           intRadmanHealth = 0;
    }


    private void doHitEnemy(int intQty)
    {
       intEnemyHealth -= intQty;
       if (intEnemyHealth < 0)
           intEnemyHealth = 0;
    }


    private void doAction()
    {
       doHitRadman(((int)(intDamageBadHit * random.nextFloat())) + 1);
       canAnimation.repaint();
       checkState(true);
    }


    private class MyThread
       extends Thread
    {
        public MyThread() { }

        public void run()
        {
           try
           {
              while (true)
              {
                 if (isShowThread)
                    doAction();
                 sleep(2000 + (intDifficulty * 3000));
              }
           }
           catch (InterruptedException e) { }
        }
    }


    private class RunningThread
        extends Thread
    {
        public RunningThread() { }
        
        public void run()
        {
           try
           {
              while (true)
              {
                 intRadmanFrame++;
                 intPolarBearFrame++;
                 if (intRadmanFrame > 1)
                    intRadmanFrame = 0;
                 if (intPolarBearFrame > 1)
                    intPolarBearFrame = 0;

                 canAnimation.repaint();
                // doRunAnimation();
                 sleep(100);
              }
           }
           catch (InterruptedException e) { }
        }
    }


    private class DialogEnd
       extends Dialog
    {

       DialogEnd(Frame frmParent,
                 String strTitle,
                 String strText,
                 boolean isModel)
       {
          super(frmParent, strTitle, isModel);
          //this.setBackground(Color.black);
          Label lblText = new Label(strText, Label.CENTER);
          lblText.setForeground(Color.white);
          //lblText.setBackground(Color.black);
          lblText.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));               
          Button btnOkay = new Button(" Okay ");
          btnOkay.setForeground(Color.white);
          //btnOkay.setBackground(Color.black);
          btnOkay.addActionListener(new ActionListener()
          {
             public void actionPerformed(ActionEvent e)
             {
                doOkay();
             }
          });
          btnOkay.setFont(new Font("SansSerif", Font.BOLD, 14));               

          setLayout(new BorderLayout());
          add(lblText, "Center");
          Panel panBut = new Panel();
          panBut.add(btnOkay);
          add(panBut, "South");
          pack();
          center();
          show();
       }

       private void doOkay()
       {
          this.setVisible(false);
          this.dispose();
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


    private class DialogConfirmQuit
       extends Dialog
    {
       private Label lblQuit;
       private Button btnYes, btnNo;
       private Frame frmParent;

       DialogConfirmQuit(Frame frmParent,
                         String strTitle,
                         boolean isModel)
       {
          super(frmParent, strTitle, isModel);
          this.frmParent = frmParent;
          //this.setBackground(Color.black);
          lblQuit = new Label("Are you sure you want to quit?", Label.CENTER);
          lblQuit.setForeground(Color.white);
          //lblQuit.setBackground(Color.black);
          lblQuit.setFont(new Font("Serif", Font.BOLD, 18));               
          btnYes = new Button(" Yes ");
          btnYes.setForeground(Color.white);
          //btnYes.setBackground(Color.black);
          btnYes.addActionListener(new ActionListener()
          {
             public void actionPerformed(ActionEvent e)
             {
                doConfirmQuitYes();
             }
          });
          btnYes.setFont(new Font("SansSerif", Font.BOLD, 14));               
          btnNo = new Button("  No  ");
          btnNo.setForeground(Color.white);
          //btnNo.setBackground(Color.black);
          btnNo.addActionListener(new ActionListener()
          {
             public void actionPerformed(ActionEvent e)
             {
                doConfirmQuitNo();
             }
          });
          btnNo.setFont(new Font("SansSerif", Font.BOLD, 14));               

          setLayout(new BorderLayout());
          add(lblQuit, "Center");
          Panel panBut = new Panel();
          panBut.add(btnYes);
          panBut.add(btnNo);
          add(panBut, "South");
          pack();
          center();
          show();
       }

       private void doConfirmQuitYes()
       {
          thread.stop();
          thread = null;
          this.setVisible(false);
          this.dispose();
          frmParent.setVisible(false);
          frmParent.dispose();
       }

       private void doConfirmQuitNo()
       {
          this.setVisible(false);
          this.dispose();
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

   }//end makeBut 

    private void center()
    {
      // Locate center and place frame there.
      Dimension dimScreenSize = getToolkit().getScreenSize();
      Dimension dimDialogSize = getSize();
      setLocation((dimScreenSize.width - dimDialogSize.width) / 2,
         (dimScreenSize.height - dimDialogSize.height) / 2);
    }
 }
