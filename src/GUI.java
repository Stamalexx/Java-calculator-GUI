import javax.swing.*;
import java.awt.*;

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


    public GUI(){
        //creates buttons from 0 to 9
        for (int i = 0; i<10; i++){

            numberButtons[i] = new JButton(String.valueOf(i));

        }

        //adds the buttons and set dimensions of the buttons
        for (JButton button: numberButtons){
            button.setPreferredSize(new Dimension(50, 50));
            centerPanel.add(button);
        }
        show_number.setFont(new Font("Arial",Font.PLAIN, 24));
//        show_number.setPreferredSize(new Dimension(200,50));
        //add panels
        northPanel.add(show_number);

        eastPanel.add(plusButton);
        eastPanel.add(minusButton);
        eastPanel.add(divisionButton);
        eastPanel.add(multiplicationButton);


        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(eastPanel,BorderLayout.EAST);

        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setSize(250,350);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }




}
