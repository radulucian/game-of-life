package com.gameoflife;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Game {
    public static void main(String[] args) {
        
    	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Grid grid = new Grid();
                JFrame window = new JFrame();
                
                window.setSize(840, 560);
                window.add(grid);
                window.setVisible(true);
                
                grid.fillCell(0, 1);
                grid.fillCell(79, 0);
                grid.fillCell(0, 49);
                grid.fillCell(79, 49);
                grid.fillCell(39, 24);
            }
        });
    }
}
