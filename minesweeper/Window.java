import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;

import javax.swing.*;

public class Window {

  private static void createGUI() {
    JFrame frame = new JFrame("test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel pane = new JPanel();
    frame.add(pane);

    JLabel bg = new JLabel("");
    JLabel label = new JLabel("test");
    label.setBackground(Color.blue);

    label.setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);

    // frame.getContentPane().add(label);
    bg.setPreferredSize(new Dimension(200, 100));
    // label.setPreferredSize(new Dimension(50, 50));
    pane.add(label);
    pane.add(bg);

    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    createGUI();
  }
}
