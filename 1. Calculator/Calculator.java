/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

/**
 *
 * @author Admin
 */
import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;
class Calculator extends JFrame implements ActionListener{
    private JTextField tfResult;

    private double kq = 0;

    private String phep = "=";

    private boolean click = true;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        tfResult = new JTextField("0");
        tfResult.setEditable(false);
        add(tfResult, "North");

        Panel panel = new Panel();
        panel.setLayout(new GridLayout(5, 5));
        String[] arr = {"7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+","^","√x"};
        for (int i = 0; i < arr.length; i++) {
            Button button = new Button(arr[i]);
            panel.add(button);
            button.addActionListener(this);
        }
        add(panel, "Center");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ('0' <= s.charAt(0) && s.charAt(0) <= '9'
                || s.equals(".")) {
            if (click) {
                tfResult.setText(s);
            } else { 
                tfResult.setText(tfResult.getText() + s);
            }

            click = false;
        } else { 
            if (click) {
                if (s.equals("-")) {
                    tfResult.setText(s);
                    click = false;
                } else {
                    phep = s;
                }
            } else { 
                double x = Double.parseDouble(tfResult.getText());
                calculator(x);
                phep = s;
                click = true;
            }
        }
    }

    public void calculator(double n) {
        if (phep.equals("+")) {
            kq += n;
        } else if (phep.equals("-")) {
            kq -= n;
        } else if (phep.equals("*")) {
            kq *= n;
        } else if (phep.equals("/")) {
            kq /= n;
        } else if (phep.equals("^")) {
            kq = Math.pow(kq, n);
        } else if (phep.equals("√x")) {
            kq = Math.sqrt(n);
        } else if (phep.equals("=")) {
            kq = n;
        }

        tfResult.setText(kq + "");
    }
}