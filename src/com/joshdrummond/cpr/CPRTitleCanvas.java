package com.joshdrummond.cpr;
import java.awt.*;

public class CPRTitleCanvas
    extends Canvas
    implements Runnable
{
    String banner;		// The text to be displayed
    char bannerChars[];		// The same text as an array of characters
    Thread runner = null;	// The thread that is displaying the text
    boolean threadSuspended;	// True when thread suspended (via mouse click)

    public CPRTitleCanvas(String strTitle, Font fntTitle, Color colTitle) {
	banner = strTitle;
        int bannerLength = banner.length();
	bannerChars =  new char[bannerLength];
        banner.getChars(0, banner.length(), bannerChars, 0);

        threadSuspended = false;

	setSize(15*(bannerLength + 1), 50);
	setForeground(colTitle);
	setFont(fntTitle);
//	new Font("TimesRoman", Font.BOLD, 36));
//	addMouseListener(this);
        this.start();
    }

    public void destroy() {
    }

    public void start() {
        runner = new Thread(this);
        runner.start();
    }

    public synchronized void stop() {
	runner = null;
        if (threadSuspended) {
            threadSuspended = false;
            notify();
        }
    }

    public void run() {
        Thread me = Thread.currentThread();
        while (runner == me) {
            try {
                Thread.sleep(100);
                synchronized(this) {
                    while (threadSuspended) {
                        wait();
                    }
                }
            } catch (InterruptedException e){
            }
            repaint();
        }
    }

    public void paint(Graphics g) {
        for(int i=0, length = banner.length(); i<length; i++) {
            int x = (int) (10*Math.random() + 25*i +50);
            int y = (int) (10*Math.random() + 36);
            g.drawChars(bannerChars, i, 1, x, y);
	}
    }
}
