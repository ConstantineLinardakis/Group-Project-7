import javax.swing.*;
import java.awt.*;

//JFrame Class
public class Frame extends JFrame{
  //Creates and defines the dimentions and features of the JFrame
  public Frame(String title){
    super(title);
    setSize(625,740);
    setLocation(200,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);
    getContentPane().setBackground(Color.BLACK);
  }
}
