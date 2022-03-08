package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame{
    JLabel pol1Text = new JLabel("Polynomial 1");
    JLabel pol2Text = new JLabel("Polynomial 2");
    JLabel resultText = new JLabel("Result:");
    JTextField pol1 = new JTextField("1*x^3-2x^2-4x^1-1x^0");
    JTextField pol2 = new JTextField("2x^2-2x^1-1x^0");
    JTextArea result = new JTextArea("Result");
    JButton mul = new JButton("*");
    JButton div = new JButton("/");
    JButton add = new JButton("+");
    JButton sub = new JButton("-");
    JButton integrate = new JButton("Integrate");
    JButton derivative = new JButton("Derivative");

    Controller c = new Controller();

    public View(){
        setSize(300,500);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        addComponents();

        setVisible(true);
    }

    private void addComponents(){
        addpol1TextLabel();
        addpol2TextLabel();

        addPol1TField();
        addPol2TField();

        addResult();
        addButtons();
        addResultText();
    }

    private void addpol1TextLabel(){
        pol1Text.setBounds(35,0,150,150);
        add(pol1Text);
        pol1Text.setVisible(true);
    }

    private void addPol1TField(){
        pol1.setBounds(35, 100,200,20);
        add(pol1);
        pol1.setVisible(true);
    }

    private void addPol2TField(){
        pol2.setBounds(35, 200,200,20);
        add(pol2);
        pol2.setVisible(true);
    }

    private void addpol2TextLabel(){
        pol2Text.setBounds(35,100,200,150);
        add(pol2Text);
        pol2Text.setVisible(true);
    }
    
    private void addResult(){
        result.setBounds(35, 300,200,40);
        add(result);
        result.setVisible(true);
    }

    private void addResultText(){
        resultText.setBounds(35,270,200,20);
        add(resultText);
        resultText.setVisible(true);
    }

    private void addButtons(){
        mul.setBounds(35,350,50,30);
        div.setBounds(85,350,50,30);
        add.setBounds(135,350,50,30);
        sub.setBounds(185,350,50,30);
        integrate.setBounds(35,380,100,30);
        derivative.setBounds(135,380,100,30);
        add(mul);
        add(div);
        add(add);
        add(sub);
        add(integrate);
        add(derivative);
        mul.addActionListener(new MulListener());
        div.addActionListener(new DivListener());
        add.addActionListener(new AddListener());
        sub.addActionListener(new SubListener());
        integrate.addActionListener(new IntegralListener());
        derivative.addActionListener(new DerivativeListener());
        mul.setVisible(true);
        div.setVisible(true);
        add.setVisible(true);
        sub.setVisible(true);
        integrate.setVisible(true);
        derivative.setVisible(true);
    }
    private class MulListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String res = c.getMultiplication(pol1.getText(),pol2.getText());
            result.setText(res);
        }
    }
    private class DivListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String res = c.getDivision(pol1.getText(),pol2.getText());
            result.setText(res);
        }
    }
    private class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String res = c.getAddition(pol1.getText(),pol2.getText());
            result.setText(res);
        }
    }

    private class SubListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String res = c.getSubtraction(pol1.getText(),pol2.getText());
            result.setText(res);
        }
    }

    private class DerivativeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String res = c.getDerivative(pol1.getText());
            result.setText(res);
        }
    }

    private class IntegralListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String res = c.getIntegral(pol1.getText());
            result.setText(res);
        }
    }
}


