package validatorModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;


public class Menu extends JFrame implements ActionListener {
    JTextField texto;
    JLabel title;

    public void Menu() throws ParseException {
        setTitle("Validator CPF");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0xBD2E5A));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton jButton = new JButton("Validar");
        jButton.setBounds(256, 250, 290, 70);
        jButton.setFont(new Font("Arial", Font.BOLD, 40));
        jButton.setForeground(new Color(0x070606));
        jButton.setBackground(new Color(0xD7CACA));

        add(jButton);

        jButton.addActionListener(this::actionPerformed);

        texto = new JTextField();
        texto.setBounds(150, 100, 500, 90);
        texto.setForeground(new Color(0x070606));
        texto.setBackground(new Color(0xD7CACA));
        texto.setFont(new Font("Arial", Font.ITALIC, 20));

        add(texto);

        title = new JLabel("Digite o CPF");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(new Color(0xFFFFFF));
        title.setBounds(310, 25, 400, 100);

        add(title);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Validator validator = new Validator();
        validator.validaCpf(texto.getText());

        if (validator.validaCpf(texto.getText())) {
            JOptionPane.showMessageDialog(null, "EBA! Esse CPF é válido!", "Resultado da pesquisa:",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "POXA! Esse CPF não é válido!", "Resultado da pesquisa:",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
