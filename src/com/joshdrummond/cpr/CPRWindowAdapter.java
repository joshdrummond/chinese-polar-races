package com.joshdrummond.cpr;
/*
    Joshua Drummond

    The general window adapter for the various frames
*/

import java.awt.*;
import java.awt.event.*;


public class CPRWindowAdapter
        extends WindowAdapter
    {
        private Window f;

        public CPRWindowAdapter(Window f)
        {
            this.f = f;
        }
        
        public void windowClosing(WindowEvent e)
        {
            f.setVisible(false);
            f.dispose();
        }
    }
