/*
    Chinese Polar Races v1.0
    Joshua Drummond

    A file which just contains all of the words
    used in the game in different languages
    in array format.
*/

public class CPRVocab
    extends Object
{
    private String[][] word;
    public static final int MAX_WORD = 229;
    public static final int MAX_LESSON = 18;
    private int intLesson = 0;
    private int intMaxLesson = 0;

    public CPRVocab(int intLesson)
    {
       word = new String[MAX_WORD][2];
       this.intLesson = intLesson;
       intMaxLesson = convertMaxLesson(this.intLesson);

       for (int i = 0; i < MAX_WORD; i++)
          word[i] = new String[2];
       
       loadWords();
    }



    public void loadWords()
    {
        word[0][0] = new String("you");
        word[0][1] = new String("ni3");
        word[1][0] = new String("good, well");
        word[1][1] = new String("hao3");
        word[2][0] = new String("(interrogative particle)");
        word[2][1] = new String("ma");
        word[3][0] = new String("I, me");
        word[3][1] = new String("wo3");
        word[4][0] = new String("very");
        word[4][1] = new String("hen3");
        word[5][0] = new String("(modal particle)");
        word[5][1] = new String("ne");
        word[6][0] = new String("also, too");
        word[6][1] = new String("ye3");
        word[7][0] = new String("busy");
        word[7][1] = new String("mang2");
        word[8][0] = new String("not, no");
        word[8][1] = new String("bu4");
        word[9][0] = new String("elder brother");
        word[9][1] = new String("ge1ge");
        word[10][0] = new String("he, him");
        word[10][1] = new String("ta1");
        word[11][0] = new String("younger brother");
        word[11][1] = new String("di4di");
        word[12][0] = new String("they, them");
        word[12][1] = new String("ta1men");
        word[13][0] = new String("all");
        word[13][1] = new String("dou1");
        word[14][0] = new String("this");
        word[14][1] = new String("zhe4");
        word[15][0] = new String("to be");
        word[15][1] = new String("shi4");
        word[16][0] = new String("friend");
        word[16][1] = new String("peng2you");
        word[17][0] = new String("father");
        word[17][1] = new String("ba4ba");
        word[18][0] = new String("mother");
        word[18][1] = new String("ma1ma");
        word[19][0] = new String("you (plural)");
        word[19][1] = new String("ni3men");
        word[20][0] = new String("doctor");
        word[20][1] = new String("dai4fu");
        word[21][0] = new String("(structural particle)");
        word[21][1] = new String("de");
        word[22][0] = new String("vehicle");
        word[22][1] = new String("che1");
        word[23][0] = new String("that");
        word[23][1] = new String("na4");
        word[24][0] = new String("she, her");
        word[24][1] = new String("ta1");
        word[25][0] = new String("book");
        word[25][1] = new String("shu1");
        word[26][0] = new String("which");
        word[26][1] = new String("na3");
        word[27][0] = new String("country");
        word[27][1] = new String("guo2");
        word[28][0] = new String("person");
        word[28][1] = new String("ren2");
        word[29][0] = new String("who");
        word[29][1] = new String("shei2");
        word[30][0] = new String("we, us");
        word[30][1] = new String("wo3men");
        word[31][0] = new String("teacher");
        word[31][1] = new String("lao3shi1");
        word[32][0] = new String("Chinese (language)");
        word[32][1] = new String("Han4yu3");
        word[33][0] = new String("what");
        word[33][1] = new String("shen2me");
        word[34][0] = new String("map");
        word[34][1] = new String("di4tu2");
        word[35][0] = new String("to see, to read, to watch");
        word[35][1] = new String("kan4");
        word[36][0] = new String("please");
        word[36][1] = new String("qing3");
        word[37][0] = new String("to drink");
        word[37][1] = new String("he1");
        word[38][0] = new String("tea");
        word[38][1] = new String("cha2");
        word[39][0] = new String("you (formal)");
        word[39][1] = new String("nin2");
        word[40][0] = new String("to enter, to come in");
        word[40][1] = new String("jin4");
        word[41][0] = new String("to welcome");
        word[41][1] = new String("huan1ying2");
        word[42][0] = new String("to thank");
        word[42][1] = new String("xie4xie");
        word[43][0] = new String("polite, courteous");
        word[43][1] = new String("ke4qi");
        word[44][0] = new String("to smoke");
        word[44][1] = new String("xi1 yan1");
        word[45][0] = new String("May I ask your name?");
        word[45][1] = new String("gui4 xing4");
        word[46][0] = new String("May I ask... ?");
        word[46][1] = new String("qing3wen4");
        word[47][0] = new String("expensive");
        word[47][1] = new String("gui4");
        word[48][0] = new String("a student who studies abroad");
        word[48][1] = new String("liu2xue2sheng1");
        word[49][0] = new String("(one's) surname is ...");
        word[49][1] = new String("xing4");
        word[50][0] = new String("to call, to be called");
        word[50][1] = new String("jiao4");
        word[51][0] = new String("foreign language");
        word[51][1] = new String("wai4yu3");
        word[52][0] = new String("college, institute");
        word[52][1] = new String("xue2yuan4");
        word[53][0] = new String("student");
        word[53][1] = new String("xue2sheng");
        word[54][0] = new String("to study, to learn");
        word[54][1] = new String("xue2xi2");
        word[55][0] = new String("to be at (a place), in, at");
        word[55][1] = new String("zai4");
        word[56][0] = new String("to sit, to take a seat");
        word[56][1] = new String("zuo4");
        word[57][0] = new String("where");
        word[57][1] = new String("nar3");
        word[58][0] = new String("dormitory");
        word[58][1] = new String("su4she4");
        word[59][0] = new String("to live");
        word[59][1] = new String("zhu4");
        word[60][0] = new String("how many, how much");
        word[60][1] = new String("duo1shao");
        word[61][0] = new String("number");
        word[61][1] = new String("hao4");
        word[62][0] = new String("four");
        word[62][1] = new String("si4");
        word[63][0] = new String("(measure word) storey, floor");
        word[63][1] = new String("ceng2");
        word[64][0] = new String("two");
        word[64][1] = new String("er2");
        word[65][0] = new String("three");
        word[65][1] = new String("san1");
        word[66][0] = new String("zero");
        word[66][1] = new String("ling2");
        word[67][0] = new String("one");
        word[67][1] = new String("yi1");
        word[68][0] = new String("five");
        word[68][1] = new String("wu3");
        word[69][0] = new String("to ask");
        word[69][1] = new String("wen4");
        word[70][0] = new String("here");
        word[70][1] = new String("zher4");
        word[71][0] = new String("there");
        word[71][1] = new String("nar4");
        word[72][0] = new String("to return");
        word[72][1] = new String("huan2");
        word[73][0] = new String("pictorial");
        word[73][1] = new String("hua3bao3");
        word[74][0] = new String("dictionary");
        word[74][1] = new String("ci2dian3");
        word[75][0] = new String("now, nowadays");
        word[75][1] = new String("xian4zai4");
        word[76][0] = new String("to use, to make use of");
        word[76][1] = new String("yong4");
        word[77][0] = new String("a little while");
        word[77][1] = new String("yi2xiar4");
        word[78][0] = new String("to say good-bye");
        word[78][1] = new String("zai4jian4");
        word[79][0] = new String("six");
        word[79][1] = new String("liu4");
        word[80][0] = new String("seven");
        word[80][1] = new String("qi1");
        word[81][0] = new String("eight");
        word[81][1] = new String("ba1");
        word[82][0] = new String("nine");
        word[82][1] = new String("jiu3");
        word[83][0] = new String("ten");
        word[83][1] = new String("shi2");
        word[84][0] = new String("female");
        word[84][1] = new String("nu3");
        word[85][0] = new String("Mr., sir, gentleman");
        word[85][1] = new String("xian1sheng");
        word[86][0] = new String("to be familiar with, to recognize");
        word[86][1] = new String("ren4shi");
        word[87][0] = new String("English");
        word[87][1] = new String("Ying1yu3");
        word[88][0] = new String("French");
        word[88][1] = new String("Fa3yu3");
        word[89][0] = new String("often");
        word[89][1] = new String("chang2");
        word[90][0] = new String("to go");
        word[90][1] = new String("qu4");
        word[91][0] = new String("they, them");
        word[91][1] = new String("ta1men");
        word[92][0] = new String("name");
        word[92][1] = new String("ming2zi");
        word[93][0] = new String("(interjection) hello");
        word[93][1] = new String("wei4");
        word[94][0] = new String("(interjection) oh");
        word[94][1] = new String("a4");
        word[95][0] = new String("shop");
        word[95][1] = new String("shang1dian4");
        word[96][0] = new String("to buy");
        word[96][1] = new String("mai3");
        word[97][0] = new String("pen");
        word[97][1] = new String("bi3");
        word[98][0] = new String("paper");
        word[98][1] = new String("zhi3");
        word[99][0] = new String("to come");
        word[99][1] = new String("lai2");
        word[100][0] = new String("to introduce");
        word[100][1] = new String("jie4shao4");
        word[101][0] = new String("male");
        word[101][1] = new String("nan2");
        word[102][0] = new String("right, correct");
        word[102][1] = new String("dui4");
        word[103][0] = new String("(modal particle)");
        word[103][1] = new String("le");
        word[104][0] = new String("and, with");
        word[104][1] = new String("he2");
        word[105][0] = new String("to speak, to say");
        word[105][1] = new String("shuo1");
        word[106][0] = new String("Gubo");
        word[106][1] = new String("Gu3bo1");
        word[107][0] = new String("China");
        word[107][1] = new String("Zhong1guo2");
        word[108][0] = new String("Palanka");
        word[108][1] = new String("Pa4lan2ka3");
        word[109][0] = new String("Ding Yun");
        word[109][1] = new String("Ding1 Yun2");
        word[110][0] = new String("Britain");
        word[110][1] = new String("Ying1guo2");
        word[111][0] = new String("France");
        word[111][1] = new String("Fa3guo2");
        word[112][0] = new String("note-book, exercise-book");
        word[112][1] = new String("ben3zi");
        word[113][0] = new String("post office");
        word[113][1] = new String("you2ju2");
        word[114][0] = new String("stamp");
        word[114][1] = new String("you2piao4");
        word[115][0] = new String("professor");
        word[115][1] = new String("jiao4shou4");
        word[116][0] = new String("to do");
        word[116][1] = new String("zuo4");
        word[117][0] = new String("to work, work");
        word[117][1] = new String("gong1zuo4");
        word[118][0] = new String("to want, to think, to miss");
        word[118][1] = new String("xiang3");
        word[119][0] = new String("family, home, house");
        word[119][1] = new String("jia1");
        word[120][0] = new String("to have, there be");
        word[120][1] = new String("you3");
        word[121][0] = new String("not, no");
        word[121][1] = new String("mei2");
        word[122][0] = new String("younger sister");
        word[122][1] = new String("mei4mei");
        word[123][0] = new String("elder sister");
        word[123][1] = new String("jie3jie");
        word[124][0] = new String("bank");
        word[124][1] = new String("yin2hang2");
        word[125][0] = new String("husband / wife");
        word[125][1] = new String("ai4ren");
        word[126][0] = new String("bookstore");
        word[126][1] = new String("shu1dian4");
        word[127][0] = new String("child");
        word[127][1] = new String("hai2zi");
        word[128][0] = new String("to, for, to give");
        word[128][1] = new String("gei3");
        word[129][0] = new String("to write");
        word[129][1] = new String("xie3");
        word[130][0] = new String("letter");
        word[130][1] = new String("xin4");
        word[131][0] = new String("to tell");
        word[131][1] = new String("gao4su");
        word[132][0] = new String("office worker, staff member");
        word[132][1] = new String("zhi2yuan2");
        word[133][0] = new String("engineer");
        word[133][1] = new String("gong1cheng2shi1");
        word[134][0] = new String("manager, director");
        word[134][1] = new String("jing1li3");
        word[135][0] = new String("company");
        word[135][1] = new String("gong1si2");
        word[136][0] = new String("Chinese (language)");
        word[136][1] = new String("Zhong1wen2");
        word[137][0] = new String("department");
        word[137][1] = new String("xi4");
        word[138][0] = new String("(measure word)");
        word[138][1] = new String("ge4");
        word[139][0] = new String("how many, how much, several");
        word[139][1] = new String("ji3");
        word[140][0] = new String("to teach");
        word[140][1] = new String("jiao1");
        word[141][0] = new String("grammar");
        word[141][1] = new String("yu3fa3");
        word[142][0] = new String("Chinese character");
        word[142][1] = new String("Han4zi4");
        word[143][0] = new String("character");
        word[143][1] = new String("zi4");
        word[144][0] = new String("else, in addition, still");
        word[144][1] = new String("hai2");
        word[145][0] = new String("spoken language");
        word[145][1] = new String("kou3yu3");
        word[146][0] = new String("I don't really deserve it, you flatter me");
        word[146][1] = new String("bu4 gan3dang1");
        word[147][0] = new String("each other, mutually");
        word[147][1] = new String("hu4xiang1");
        word[148][0] = new String("new");
        word[148][1] = new String("xin1");
        word[149][0] = new String("reading-room");
        word[149][1] = new String("yue4lan3shi4");
        word[150][0] = new String("magazine");
        word[150][1] = new String("za2zhi4");
        word[151][0] = new String("newspaper");
        word[151][1] = new String("bao4");
        word[152][0] = new String("(measure word)");
        word[152][1] = new String("ben3");
        word[153][0] = new String("library");
        word[153][1] = new String("tu2shu1guan3");
        word[154][0] = new String("there");
        word[154][1] = new String("nar4");
        word[155][0] = new String("Wang");
        word[155][1] = new String("Wang2");
        word[156][0] = new String("class, squad");
        word[156][1] = new String("ban1");
        word[157][0] = new String("classroom");
        word[157][1] = new String("jiao4shi4");
        word[158][0] = new String("laboratory");
        word[158][1] = new String("shi2yan4shi4");
        word[159][0] = new String("to borrow, to lend");
        word[159][1] = new String("jie4");
        word[160][0] = new String("new word");
        word[160][1] = new String("sheng1ci2");
        word[161][0] = new String("(measure word)");
        word[161][1] = new String("tiao2");
        word[162][0] = new String("skirt");
        word[162][1] = new String("qun2zi");
        word[163][0] = new String("two");
        word[163][1] = new String("liang3");
        word[164][0] = new String("(measure word), piece");
        word[164][1] = new String("zhang1");
        word[165][0] = new String("ticket");
        word[165][1] = new String("piao4");
        word[166][0] = new String("Beijing opera");
        word[166][1] = new String("jing1ju4");
        word[167][0] = new String("evening");
        word[167][1] = new String("wan3shang");
        word[168][0] = new String("too, too much");
        word[168][1] = new String("tai4");
        word[169][0] = new String("from");
        word[169][1] = new String("cong2");
        word[170][0] = new String("to look for, to call on (a person)");
        word[170][1] = new String("zhao3");
        word[171][0] = new String("here");
        word[171][1] = new String("zher4");
        word[172][0] = new String("old");
        word[172][1] = new String("jiu4");
        word[173][0] = new String("to put on, to wear");
        word[173][1] = new String("chuan1");
        word[174][0] = new String("(measure word)");
        word[174][1] = new String("jian4");
        word[175][0] = new String("shirt, blouse");
        word[175][1] = new String("chen4shan1");
        word[176][0] = new String("green");
        word[176][1] = new String("lu4");
        word[177][0] = new String("big, large");
        word[177][1] = new String("da4");
        word[178][0] = new String("white");
        word[178][1] = new String("bai2");
        word[179][0] = new String("blue");
        word[179][1] = new String("lan2");
        word[180][0] = new String("upper outer garment, jacket");
        word[180][1] = new String("shang4yi1");
        word[181][0] = new String("trousers");
        word[181][1] = new String("ku4zi");
        word[182][0] = new String("overcoat, topcoat");
        word[182][1] = new String("da4yi1");
        word[183][0] = new String("black, dark");
        word[183][1] = new String("hei1");
        word[184][0] = new String("theatre");
        word[184][1] = new String("ju4chang3");
        word[185][0] = new String("seat");
        word[185][1] = new String("zuo4wei4");
        word[186][0] = new String("(measure word), o'clock");
        word[186][1] = new String("dian3");
        word[187][0] = new String("dining-hall");
        word[187][1] = new String("shi2tang2");
        word[188][0] = new String("to lack, to be short of");
        word[188][1] = new String("cha4");
        word[189][0] = new String("(measure word), minute");
        word[189][1] = new String("fen1");
        word[190][0] = new String("(measure word), quarter (of an hour)");
        word[190][1] = new String("ke4");
        word[191][0] = new String("to attend (a class), to teach (in a class)");
        word[191][1] = new String("shang4");
        word[192][0] = new String("class, lesson");
        word[192][1] = new String("ke4");
        word[193][0] = new String("class if over or dismissed");
        word[193][1] = new String("xia4");
        word[194][0] = new String("later on, in the future");
        word[194][1] = new String("yi3hou4");
        word[195][0] = new String("business, thing");
        word[195][1] = new String("shir4");
        word[196][0] = new String("to return, to go back to");
        word[196][1] = new String("hui2");
        word[197][0] = new String("with, to follow, to accompany");
        word[197][1] = new String("gen1");
        word[198][0] = new String("together");
        word[198][1] = new String("yi4qi3");
        word[199][0] = new String("film, movie");
        word[199][1] = new String("dian4ying3");
        word[200][0] = new String("cafe");
        word[200][1] = new String("ka1fei1guan3");
        word[201][0] = new String("coffee");
        word[201][1] = new String("ka1fei1");
        word[202][0] = new String("half");
        word[202][1] = new String("ban4");
        word[203][0] = new String("(modal particle)");
        word[203][1] = new String("a");
        word[204][0] = new String("to wait");
        word[204][1] = new String("deng3");
        word[205][0] = new String("to depart, to walk");
        word[205][1] = new String("zou3");
        word[206][0] = new String("to go to work, to start working");
        word[206][1] = new String("shang4 ban1");
        word[207][0] = new String("to come or go off to work");
        word[207][1] = new String("xia4 ban1");
        word[208][0] = new String("cinema");
        word[208][1] = new String("dian4ying3yuan4");
        word[209][0] = new String("watch");
        word[209][1] = new String("biao3");
        word[210][0] = new String("clock");
        word[210][1] = new String("zhong1");
        word[211][0] = new String("before, in the past, ago");
        word[211][1] = new String("yi3qian2");
        word[212][0] = new String("day");
        word[212][1] = new String("tian1");
        word[213][0] = new String("every, each");
        word[213][1] = new String("mei3");
        word[214][0] = new String("to get up (from bed)");
        word[214][1] = new String("qi3 chuang2");
        word[215][0] = new String("to get up, to rise");
        word[215][1] = new String("qi3");
        word[216][0] = new String("bed");
        word[216][1] = new String("chuang2");
        word[217][0] = new String("morning");
        word[217][1] = new String("shang4wu3");
        word[218][0] = new String("to eat");
        word[218][1] = new String("chi1");
        word[219][0] = new String("meal, cooked rice, food");
        word[219][1] = new String("fan4");
        word[220][0] = new String("many, much, a lot of");
        word[220][1] = new String("duo1");
        word[221][0] = new String("afternoon");
        word[221][1] = new String("xia4wu3");
        word[222][0] = new String("to rest, to take a rest");
        word[222][1] = new String("xiu1xi");
        word[223][0] = new String("sometimes");
        word[223][1] = new String("you3 shi2hou");
        word[224][0] = new String("time");
        word[224][1] = new String("shi2hou");
        word[225][0] = new String("question, problem");
        word[225][1] = new String("wen4ti2");
        word[226][0] = new String("to go to bed, to sleep");
        word[226][1] = new String("shui4 jiao4");
        word[227][0] = new String("friends");
        word[227][1] = new String("peng2youmen");
        word[228][0] = new String("Beijing");
        word[228][1] = new String("Bei3jing1");
    }


    public String getEnglish(int num)
    {
        return word[num][0];
    }
    
    public String getForeign(int num)
    {
        return word[num][1];
    }

    public static int getMax()
    {
        return MAX_WORD;
    }

    public int getLessonMax()
    {
       return intMaxLesson;
    }

    public void setLesson(int intLesson)
    {
       intMaxLesson = convertMaxLesson(intLesson);
    }

    public int getLesson()
    {
       return this.intLesson;
    }

    public static int convertMaxLesson(int intLesson)
    {
       switch (intLesson)
       {
          case 1 : return 1;
          case 2 : return 6;
          case 3 : return 13;
          case 4 : return 19;
          case 5 : return 25;
          case 6 : return 32;
          case 7 : return 35;
          case 8 : return 44;
          case 9 : return 54;
          case 10 : return 71;
          case 11 : return 83;
          case 12 : return 91;
          case 13 : return 115;
          case 14 : return 135;
          case 15 : return 160;
          case 16 : return 185;
          case 17 : return 211;
          case 18 : return 228;
          default : return -1;
       }
    }

}
