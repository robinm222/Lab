import  java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.green;
import static java.awt.Color.red;

public class calu extends Applet implements ActionListener {

    TextField t1=new TextField();
    TextField t2=new TextField();
    TextField t3=new TextField();
    Button b1=new Button("Add");
    public calu(){
        Label l1=new Label("Enter the first number:");
        Label l2=new Label("Enter the Second number:");
        Label l3=new Label("Result:");

        //setLayout(new GridLayout(3,0) );
        setBackground(Color.cyan);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(l3);
        add(t3);

        t2.addActionListener(this);
        b1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //  t3.setText("Hello");
        String s1=t1.getText();
        Double num1=Double.parseDouble(s1);
        Double num2=Double.parseDouble(t2.getText());
        Double s=num1+num2;
        if (e.getSource()==b1){
            this.setBackground(red);
            t3.setBackground(green);
            t3.setText(String.valueOf(s));
        }

    }
}
