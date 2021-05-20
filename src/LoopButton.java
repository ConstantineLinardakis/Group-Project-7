import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class LoopButton extends JButton implements ActionListener{
  public static boolean loop = false;
  public LoopButton(){
    super("Loop");
    setBounds(120,10,100,50);
    addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == this){
      if(loop == false){
        loop = true;
      }else{
        loop = false;
      }
    }
  }
}
