/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colorlist;

/**
 *
 * @author Admin
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListColor extends JFrame {

    private static final int WID = 600;
    private static final int HEI = 500;
    JLabel lb;
    JPanel panel;
    JList listColor;

    public ListColor(String title) throws HeadlessException {
        super(title);
        lb = new JLabel();
        lb.setText("Chon Mau Kieu List.");
        lb.setFont(new Font("Arial", Font.BOLD, 15));
        lb.setBounds(50, 80, 150, 30);
        add(lb);

        panel = new JPanel();
        panel.setBounds(250, 80, 300, 300);
        panel.setBackground(Color.WHITE);
        add(panel);

        DefaultListModel<String> list = new DefaultListModel<>();
        list.addElement("Do");
        list.addElement("Hong");
        list.addElement("Cam");
        list.addElement("Vang");
        list.addElement("Den");
        list.addElement("Xanh La");
        
        listColor = new JList(list);
        listColor.setBounds(50, 150, 150, 120);
        add(listColor);

        listColor.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (listColor.getSelectedValue().equals("Do")) {
                    panel.setBackground(Color.red);
                }
                if (listColor.getSelectedValue().equals("Hong")) {
                    panel.setBackground(Color.pink);
                }
                if (listColor.getSelectedValue().equals("Cam")) {
                    panel.setBackground(Color.orange);
                }
                if (listColor.getSelectedValue().equals("Vang")) {
                    panel.setBackground(Color.yellow);
                }
                if (listColor.getSelectedValue().equals("Den")) {
                    panel.setBackground(Color.black);
                }
                if (listColor.getSelectedValue().equals("Xanh La")) {
                    panel.setBackground(Color.GREEN);
                }
            }

        });

        setLayout(null);
        setVisible(true);
        setSize(WID, HEI);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
