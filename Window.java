package com.company;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame {

    Graphics g;
    int n = 15;

    public static void main(String[] args) { //по умолчанию создаются невидимые окна
        new Window();
    }


    public Window() {
        super();
        this.setVisible(true); //через this к этому классу обращаемся
        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);//завершить программу
        this.setBounds(200, 50, 800, 600);
        this.setResizable(true);
        this.setLayout(null);// вывод компонентов, по умолчанию - заполнение всего окна, null-вывод строго по координатам
        this.setTitle("График");


        g = this.getGraphics();

       /* JPanel p = new JPanel();
        //p.setSize(this.getSize());
        //  p.setBounds(this.getBounds());
        p.setBounds(130, 0, this.getWidth(), this.getHeight());
        p.setVisible(true);
        p.setBackground(Color.GREY);
        this.add(p);*/

        Button b1 = new Button();
        b1.setLabel("Отобразить");
        b1.setBounds(10, 10, 100, 20);
        b1.setBackground(Color.PINK);
        this.add(b1);


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX());
                System.out.println(e.getY());
                double xCart = (e.getX() - getWidth() / 2) / 15;
                double yCart = (getHeight() / 2 - e.getY()) / 15;
                g.drawString(" (" + xCart + "," + yCart + ")", e.getX(), e.getY());
                g.fillOval(e.getX(), e.getY(), 3, 3);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        b1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
                g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);

                int count = 0;

                for (int i = getWidth() / 2; i < getWidth(); i++) {
                    g.fillOval(i, getHeight() / 2, 2, 2);
                    g.drawString(count + "", i, getHeight() / 2);
                    count++;
                    i += n;
                }

                count = 1;
                for (int i = getWidth() / 2 - n; i > 0; i--) {
                    g.fillOval(i, getHeight() / 2, 2, 2);
                    g.drawString("-" + count + "", i, getHeight() / 2);
                    count++;
                    i -= n;
                }

                count = 1;
                for (int i = getHeight() / 2 - n; i > 0; i--) {
                    g.fillOval(getWidth() / 2, i, 2, 2);
                    g.drawString(count + "", getWidth() / 2, i);
                    count++;
                    i -= n;
                }

                count = 1;
                for (int i = getHeight() / 2 + n; i < getHeight(); i++) {
                    g.fillOval(getWidth() / 2, i, 2, 2);
                    g.drawString("-" + count + "", getWidth() / 2, i);
                    count++;
                    i += n;
                }


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


    }
}
