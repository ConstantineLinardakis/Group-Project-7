import javax.swing.*;
import java.awt.*;

//Labels for the action and menu buttons
public class Labels extends JLabel{
  public Labels(String text){
    super(text);
    setBounds(474,23,80,80);
    setOpaque(false);
    setForeground(Color.CYAN);
    Font font = new Font("Arial", Font.BOLD, 40);
    setFont(font);
  }
}
