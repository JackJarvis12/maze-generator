import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 330);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel widthLabel = new JLabel("width : ");
        widthLabel.setBounds(50, 20, 200, 30);
        JTextArea widthInput = new JTextArea("1000");
        widthInput.setBounds(50, 50, 200, 30);
        JLabel heightLabel = new JLabel("height : ");
        heightLabel.setBounds(50, 80, 200, 30);
        JTextArea heightInput = new JTextArea("1000");
        heightInput.setBounds(50, 110, 200, 30);
        JLabel wLabel = new JLabel("cell width : ");
        wLabel.setBounds(50, 140, 200, 30);
        JTextArea wInput = new JTextArea("20");
        wInput.setBounds(50, 170, 200, 30);

        JLabel solutionLabel = new JLabel("show solution");
        solutionLabel.setBounds(50, 200, 100, 30);
        JCheckBox solutionInput = new JCheckBox();
        solutionInput.setBounds(150, 200, 30, 30);
        solutionInput.setSelected(true);

        JButton generate = new JButton("generate");
        generate.setBounds(50, 235, 200, 30);

        frame.add(widthLabel);
        frame.add(widthInput);
        frame.add(heightLabel);
        frame.add(heightInput);
        frame.add(wLabel);
        frame.add(wInput);
        frame.add(solutionLabel);
        frame.add(solutionInput);
        frame.add(generate);

        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();

                int width = Integer.parseInt(widthInput.getText());
                int height = Integer.parseInt(heightInput.getText());
                int pixels = Integer.parseInt(wInput.getText());
                Boolean solutions = solutionInput.isSelected();

                new Generator("Maze Generator", width, height, pixels, solutions);
            }
        });
    }
}
