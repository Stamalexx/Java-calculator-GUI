import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,20,20));
    private JPanel centerPanel = new JPanel(new FlowLayout());
    private JPanel eastPanel = new JPanel(new GridLayout(5,1,5,10));
    private JButton[] numberButtons = new JButton[10];
    private JLabel show_number = new JLabel("0");
    private JButton plusButton = new JButton("+");
    private JButton minusButton = new JButton("-");
    private JButton divisionButton = new JButton("/");
    private JButton multiplicationButton = new JButton("*");
    private JButton equalButton = new JButton("=");
    private ArrayList<Integer> intigerlist = new ArrayList<>();
    private ArrayList<String> stringlist = new ArrayList<>();
    private String toShow = "";
    private String currentInput = "";



    public GUI(){

        ButtonListener listener = new ButtonListener();
        plusButton.addActionListener(listener);
        minusButton.addActionListener(listener);
        divisionButton.addActionListener(listener);
        multiplicationButton.addActionListener(listener);
        equalButton.addActionListener(listener);
        //creates buttons from 0 to 9
        for (int i = 0; i<10; i++){

            numberButtons[i] = new JButton(String.valueOf(i));

        }

        //adds the buttons and set dimensions of the buttons
        for (JButton button: numberButtons){
            button.setPreferredSize(new Dimension(50, 50));
            button.addActionListener(listener);
            centerPanel.add(button);
        }
        show_number.setFont(new Font("Arial",Font.PLAIN, 24));
//        show_number.setPreferredSize(new Dimension(200,50));
        //add panels
        northPanel.add(show_number);
//add buttons
        eastPanel.add(plusButton);
        eastPanel.add(minusButton);
        eastPanel.add(divisionButton);
        eastPanel.add(multiplicationButton);
        eastPanel.add(equalButton);


        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(eastPanel,BorderLayout.EAST);



        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setSize(250,350);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    private void resetShow(){
        toShow = "";
        show_number.setText("0");
    }
    private Boolean checkStatement(ActionEvent event,JButton button){
        if (event.getSource().equals(button)){
            resetShow();
            return true;}
        else
            return false;

    }
    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for (JButton button : numberButtons) {
                if (e.getSource().equals(button)) {
                    currentInput += button.getText();  // build the number as string
                    toShow += button.getText();
                    show_number.setText(toShow);
                    return;
                }
            }

            if (checkStatement(e, plusButton)) {
                intigerlist.add(Integer.parseInt(currentInput));
                stringlist.add("+");
                toShow += " + ";
                show_number.setText(toShow);
                currentInput = "";  // reset for next number
            } else if (checkStatement(e, minusButton)) {
                intigerlist.add(Integer.parseInt(currentInput));
                stringlist.add("-");
                toShow += " - ";
                show_number.setText(toShow);
                currentInput = "";
            } else if (checkStatement(e, divisionButton)) {
                intigerlist.add(Integer.parseInt(currentInput));
                stringlist.add("/");
                toShow += " / ";
                show_number.setText(toShow);
                currentInput = "";
            } else if (checkStatement(e, multiplicationButton)) {
                intigerlist.add(Integer.parseInt(currentInput));
                stringlist.add("*");
                toShow += " * ";
                show_number.setText(toShow);
                currentInput = "";
            } else if (checkStatement(e, equalButton)) {
                // Add last entered number
                if (!currentInput.equals("")) {
                    intigerlist.add(Integer.parseInt(currentInput));
                }

                // Perform calculation
                int result = intigerlist.get(0);
                for (int i = 0; i < stringlist.size(); i++) {
                    String op = stringlist.get(i);
                    int next = intigerlist.get(i + 1);
                    switch (op) {
                        case "+" -> result += next;
                        case "-" -> result -= next;
                        case "*" -> result *= next;
                        case "/" -> result /= next;
                    }
                }

                show_number.setText(String.valueOf(result));

                // Reset state
                intigerlist.clear();
                stringlist.clear();
                currentInput = "";
                toShow = String.valueOf(result);
            }
        }

    }




}
