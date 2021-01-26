import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//JButtons Class
public class Buttons extends JButton implements ActionListener{
  private int locX = 0;
  private int locY = 0;

  //Sets the basic features of the buttons and adds an action listener
  public Buttons(String title){
    super(title);
    setBounds(locX,locY,100,100);
    setOpaque(true);
    setBorderPainted(false);
    setBorder(BorderFactory.createLineBorder(Color.WHITE));
    addActionListener(this);
  }

  //Sets the dimentions of the buttons
  public void setDimentions(int x, int y){
    this.locX = x;
    this.locY = y;
    setBounds(locX,locY,100,100);
  }

  //Maps button colors to sting values
  static Map<String, Color> colorMap = Map.ofEntries(Map.entry("WHITE", Color.WHITE), Map.entry("GRAY", Color.GRAY), Map.entry( "BLACK", Color.BLACK), Map.entry( "RED", Color.RED), Map.entry( "ORANGE", Color.ORANGE), Map.entry( "YELLOW", Color.YELLOW), Map.entry( "GREEN", Color.GREEN), Map.entry( "BLUE", Color.BLUE), Map.entry( "MAGENTA", Color.MAGENTA), Map.entry( "PINK", Color.PINK), Map.entry( "CYAN", Color.CYAN));

  //Gets the color from the map and returns it
  static Color getColor(String col){
    return colorMap.get(col.toUpperCase());
  }

  //Sets the color of the button and repaints it
  public void setColors(String colorBack, String colorFront){
    setBackground(getColor(colorBack));
    setForeground(getColor(colorFront));
    repaint();
  }

  //Event Handler / Action Listener
  @Override
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == this){
      System.out.println(this.getText());
    }
  }
}
