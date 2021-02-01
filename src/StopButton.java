import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class StopButton extends JButton implements ActionListener{
  public static boolean stop = false;
  public StopButton(){
    super("Stop");
    setBounds(10,10,100,50);
    addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == this){
      if(stop == true){
        stop = false;
      }else{
        stop = true;
      }
      super.repaint();

    }
  }
}
