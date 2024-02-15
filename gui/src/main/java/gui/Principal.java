package gui;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal extends JFrame {
    private final JTextField jTextField1;
    private final JTextField jTextField2;
    private final JTextArea jTextArea;

    private final transient ClienteEjb cejb = new ClienteEjb();


    public Principal() {


        setTitle("Janela principal");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        jTextField1 = new JTextField(20);
        jTextField2 = new JTextField(20);
        jTextArea = new JTextArea(10, 20);
        JButton somarButton = new JButton("Somar");

        jTextField1.setText("10");
        jTextField2.setText("20");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Campo 1: "));
        inputPanel.add(jTextField1);
        inputPanel.add(new JLabel("Campo 2: "));
        inputPanel.add(jTextField2);

        somarButton.addActionListener(e -> {
            var valora = Integer.parseInt(jTextField1.getText());
            var valorb = Integer.parseInt(jTextField2.getText());
            var result = cejb.somar(valora, valorb);
            jTextArea.setText("Resultado: " + result);
        });

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(jTextArea), BorderLayout.CENTER);
        add(somarButton, BorderLayout.SOUTH);

    }


    public static void main(String args[]) {
        Logger topLogger = java.util.logging.Logger.getLogger("");
        topLogger.setLevel(Level.SEVERE);

        SwingUtilities.invokeLater(() -> {
            var principal = new Principal();
            principal.setVisible(true);
        });
    }
}
