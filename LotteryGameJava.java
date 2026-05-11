/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lotterygame.java;

/**
 *
 * @author lenle
 */
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;



public class LotteryGameJava extends JFrame {
    private JCheckBox[] cB = new JCheckBox[31];
    private JButton sB = new JButton("Submit Selection");
    private JLabel rL = new JLabel("Select 6 numbers and click Submit");
    private int sC = 0;

    public LotteryGameJava() {
        setTitle("Lottery Game ;0");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boxPanel = new JPanel(new GridLayout(0, 5));
        for (int i = 0; i <= 30; i++) {
            cB[i] = new JCheckBox(String.valueOf(i));
            cB[i].addActionListener(new CheckBoxListener());
            boxPanel.add(cB[i]);
        }

        add(new JScrollPane(boxPanel), BorderLayout.CENTER);
        add(sB, BorderLayout.SOUTH);
        add(rL, BorderLayout.NORTH);

        sB.addActionListener(new SubmitListener());
        sB.setEnabled(false);

        setVisible(true);
    }

    private class CheckBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sC = 0;
            for (JCheckBox cb : cB) {
                if (cb.isSelected()) sC++;
            }

            if (sC >= 6) {
                sB.setEnabled(true);
                for (JCheckBox cb : cB) {
                    if (!cb.isSelected()) cb.setEnabled(false);
                }
            } else {
                sB.setEnabled(false);
                for (JCheckBox cb : cB) {
                    cb.setEnabled(true);
                }
            }
        }
    }

    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Set<Integer> wN= new HashSet<>();
            while (wN.size() < 6) {
                wN.add((int) (Math.random() * 31));
            }

            ArrayList<Integer> uN = new ArrayList<>();
            for (int i = 0; i <= 30; i++) {
                if (cB[i].isSelected()) {
                    uN.add(i);
                }
            }

            int matches = 0;
            for (int num : uN) {
                if (wNs.contains(num)) {
                    matches++;
                }
            }

            String prize = "0";
            switch (matches) {
                case 3 -> prize = "100";
                case 4 -> prize = "10,000";
                case 5 -> prize = "50,000";
                case 6 -> prize = "1,000,000";
            }

            rL.setText("<html>Wins: $" + prize + "! | Matches: " + matches +
                                "!<br>Winning Nos: " + wN +
                                "<br>Your Nos: " + uN + "</html>");
        } 
       
    } public static void main(String[] args) {
        new LotteryGameJava();
    }     
 }
   
