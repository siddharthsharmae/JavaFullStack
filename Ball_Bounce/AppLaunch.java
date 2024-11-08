package com.Siddharth.Upload.JavaFullStack.Ball_Bounce;

import javax.swing.*;
import java.awt.*;

class AppFrame extends JFrame{
    AppFrame(){
        setTitle("Bounce Ball");
        setSize(1000,700);
        setFocusable(true);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        AppPanel appPanel = new AppPanel(100,Color.RED);
        add(appPanel);
        setVisible(true);
    }
}

class AppPanel extends JPanel{
    private final int diameter;
    private final Color color;
    int xAxis = 0,yAxis = 0;
    AppPanel(int diameter, Color color){
        this.diameter = diameter;
        this.color = color;
        setPreferredSize(new Dimension(1000, 700));
        StartAnimation();
        setBackground(Color.cyan);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smooth edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the color and draw the oval for the ball
        g2d.setColor(color);
        g2d.fillOval(xAxis, yAxis, diameter, diameter);
    }

    Boolean down = false, right = false;
    float boost = 0.1f;
    float adddx = 10;
    float adddy = 10;
    private void StartAnimation(){
        Timer timer = new Timer(8,(abcd)->{
            ballmove();
            repaint();
        });
        timer.start();
    }

    private void ballmove(){
        adddx+=boost;
        xAxis+=adddx;
        if(xAxis>= getWidth()-diameter || xAxis <= 0){
            adddx*=-1;
        }
        adddy+=boost;
        yAxis+=adddy;
        if(yAxis>=getHeight()-diameter || yAxis<=0){
            adddy*=-1;
        }
    }
}


public class AppLaunch {
    public static void main(String[] args) {
        AppFrame aframe = new AppFrame();
    }
}
