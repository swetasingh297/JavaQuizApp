
package com.mycompany.quizapplication;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class QuizTest extends JFrame implements ActionListener{
    JLabel label;
    JRadioButton radioButtons[]=new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];

    QuizTest(String s){
        super(s);
        label=new JLabel();
        add(label);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            radioButtons[i]=new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        btnNext=new JButton("Next");
        btnResult=new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30,40,450,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,450,20);
        radioButtons[2].setBounds(50,140,450,20);
        radioButtons[3].setBounds(50,170,450,20);
        
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    void setData() {
        radioButtons[4].setSelected(true);
        if (current == 0) {
            label.setText("Q1 : Which is the official language for Android development?");
            radioButtons[0].setText("Java");
            radioButtons[1].setText("Kotlin");
            radioButtons[2].setText("Python");
            radioButtons[3].setText("C++");
        }
        if (current == 1) {
            label.setText("Q2 : Which is not an oop concept?");
            radioButtons[0].setText("Encapsulation");
            radioButtons[1].setText("Inheritance");
            radioButtons[2].setText("Abstraction");
            radioButtons[3].setText("Thread");
        }
        if (current == 2) {
            label.setText("Q3 : What is the size of boolean variable?");
            radioButtons[0].setText("8 bits");
            radioButtons[1].setText("16 bits");
            radioButtons[2].setText("32 bits");
            radioButtons[3].setText("1 bit");
        }
        if (current == 3) {
            label.setText("Q4 : What is default value of long variable?");
            radioButtons[0].setText("0");
            radioButtons[1].setText("0.0");
            radioButtons[2].setText("0L");
            radioButtons[3].setText("null");
        }
        if (current == 4) {
            label.setText("Q5 : What kind of variables class consists of?");
            radioButtons[0].setText("class variable, instance variable");
            radioButtons[1].setText("class variable, local variable");
            radioButtons[2].setText("local variable, instance variable");
            radioButtons[3].setText("none");
        }
        if (current == 5) {
            label.setText("Q6 : Which of the following is thread safe?");
            radioButtons[0].setText("StringBuilder");
            radioButtons[1].setText("StringBuffer");
            radioButtons[2].setText("Both");
            radioButtons[3].setText("None");
        }
        if (current == 6) {
            label.setText("Q7 : What is default value of boolean?");
            radioButtons[0].setText("True");
            radioButtons[1].setText("0");
            radioButtons[2].setText("False");
            radioButtons[3].setText("1");
        }
        if (current == 7) {
            label.setText("Q8 : What is function overloading?");
            radioButtons[0].setText("Methods with same name but different parameters");
            radioButtons[1].setText("Method with same name but different return type");
            radioButtons[2].setText("Method with same name same parameter types");
            radioButtons[3].setText("none of the above");
        }
        if (current == 8) {
            label.setText("Q9 : What is serialization?");
            radioButtons[0].setText("Serialization is the process of writing the state of an object to another object");
            radioButtons[1].setText("Serialization is the process of writing the state of an object to a byte stream");
            radioButtons[2].setText("Both");
            radioButtons[3].setText("none");
        }
        if (current == 9) {
            label.setText("Q10 : Which of the following is true?");
            radioButtons[0].setText("Constructor can be inherited");
            radioButtons[1].setText("Constructor can be final");
            radioButtons[2].setText("Static method can be overrite");
            radioButtons[3].setText("Object class is super class of all the classes");
        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) {
            radioButtons[j].setBounds(50, 80 + i, 500, 20);
        }

    }



 boolean checkAns(){
        if(current==0) {
            return (radioButtons[1].isSelected());
        }
     if(current==1) {
         return (radioButtons[3].isSelected());
     }
     if(current==2) {
         return (radioButtons[1].isSelected());
     }
     if(current==3) {
         return (radioButtons[2].isSelected());
     }
     if(current==4) {
         return (radioButtons[0].isSelected());
     }
     if(current==5) {
         return (radioButtons[1].isSelected());
     }
     if(current==6) {
         return (radioButtons[2].isSelected());
     }
     if(current==7) {
         return (radioButtons[0].isSelected());
     }
     if(current==8) {
         return (radioButtons[1].isSelected());
     }
     if(current==9) {
         return (radioButtons[3].isSelected());
     }
     return false;
    }



    public static void main(String[] args){
      new QuizTest("Simple Quiz app");
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnNext){
            if(checkAns())
                count+=1;
            current++;
            setData();
            if(current==9){
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Result")){
            if(checkAns())
                count+=1;
            current++;
            JOptionPane.showMessageDialog(this,"Correct Answers are "+count);
            System.exit(0);
        }
    }
}
    

