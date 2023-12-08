import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swing {
    public static void main(String[] args) {
       JFrame f = new JFrame("SIMPLE CALCULATOR");            //frame
       JPanel p = new JPanel();      //panel
       JTextField textField=new JTextField();

        //buttons 0-9
       JButton b0 = new JButton("0");            
       JButton b1 = new JButton("1");  
       JButton b2 = new JButton("2");  
       JButton b3 = new JButton("3");  
       JButton b4 = new JButton("4");
       JButton b5 = new JButton("5");  
       JButton b6 = new JButton("6");  
       JButton b7 = new JButton("7");  
       JButton b8 = new JButton("8");  
       JButton b9 = new JButton("9"); 


       //buttons of arithmetic operations
       JButton buttonplus = new JButton("+");
       JButton buttonminus = new JButton("-");
       JButton buttonmultiply = new JButton("*");
       JButton buttondivide = new JButton("/");
       JButton buttonEquals = new JButton("=");

       //button for clear
       JButton Clear = new JButton("C");
       Clear.addActionListener(e -> textField.setText("")); //to clear the textfield
        // action of buttons with digits
       ActionListener digitListener=e-> {
            String digit = ((JButton) e.getSource()).getText();
            textField.setText(textField.getText() + digit);

       };
       b1.setBounds(10,230,80,50);
       b2.setBounds(110,230,80,50);
       b3.setBounds(210,230,80,50);
       b4.setBounds(10,290,80,50);
       b5.setBounds(110,290,80,50);
       b6.setBounds(210,290,80,50);
       b7.setBounds(10,350,80,50);
       b8.setBounds(110,350,80,50);
       b9.setBounds(210,350,80,50);
       b0.setBounds(10,410,80,50);

       buttonplus.setBounds(310,230,80,50);
       buttonminus.setBounds(310,290,80,50);
       buttondivide.setBounds(310,410,80,50);
       buttonmultiply.setBounds(310,350,80,50);
       buttonEquals.setBounds(210,410,80,50);
       Clear.setBounds(110,410,80,50);
       textField.setBounds(10,10,380,50);
        //add actionlisteners to digit buttons
        b0.addActionListener(digitListener);
        b1.addActionListener(digitListener);
        b2.addActionListener(digitListener);
        b3.addActionListener(digitListener);
        b4.addActionListener(digitListener);
        b5.addActionListener(digitListener);
        b6.addActionListener(digitListener);
        b7.addActionListener(digitListener);
        b8.addActionListener(digitListener);
        b9.addActionListener(digitListener);
       //actionlisteners for opertaions
        ActionListener operationListener=e->{
            String operation =((JButton) e.getSource()).getText();
            textField.setText(textField.getText()+ " " + operation + " ");
        };

        //add actionlisteners to operations
        buttonplus.addActionListener(operationListener);
        buttonminus.addActionListener(operationListener);
        buttonmultiply.addActionListener(operationListener);
        buttondivide.addActionListener(operationListener); 

        //actionlisteners for equal 
        buttonEquals.addActionListener (e ->{
            String expression =textField.getText();

            try{
                //evaluate the expression
                String result = evaluateExpression(expression);
                textField.setText(result);
            }
            catch (ArithmeticException| NumberFormatException ex){
                textField.setText("Error");
            }
        });

        // Add components to panel
        f.add(textField);
        f.setLayout(null);
        f.setVisible(true);
        //p.add(textField);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(buttondivide);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(buttonmultiply);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(buttonminus);
        f.add(b0);
        f.add(buttonEquals);
        f.add(buttonplus);
        f.add(Clear); // Add the clear button
        
        f.add(p);
        f.setSize(400,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
    }

        private static String evaluateExpression(String expression){
            String[]tokens = expression.split(" ");
            if (tokens.length!=3){
                throw new IllegalArgumentException("Invalid");
            }

            double num1 = Double.parseDouble(tokens[0]);
            double num2 = Double.parseDouble(tokens[2]);

            String operator = tokens[1];
            
            switch(operator) {
                case("+"):
                return String.valueOf(num1 + num2);

                case("-"):
                return String.valueOf(num1 - num2);

                case("*"):
                return String.valueOf(num1 * num2);

                case("/"):
                if (num2==0){
                    throw new ArithmeticException("Cannot divide by 0");
                }
                return String.valueOf(num1 / num2);

                default:
                    throw new IllegalArgumentException("Invalid operator");

            }
        }

        
       
    }

