import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//JButton Color Button
public class ColorButton extends JButton implements ActionListener{
  //Sets basic features of the button and adds action listener
  public ColorButton(){
    super();
    setName("C");
    setBounds(450,22,80,80);
    setBorder(new RoundedBorder(80));
    setOpaque(false);
    setForeground(Color.CYAN);
    requestFocus();
    addActionListener(this);
  }

  //Actino Listener - Changes the colors of the buttons using arrays of colors
  @Override
  public void actionPerformed(ActionEvent e){
    //Declares arrya of colors and patterns
    String[] rainbow = new String[25];
    String[] red = new String[25];
    String[] orange = new String[25];
    String[] yellow = new String[25];
    String[] green = new String[25];
    String[] blue = new String[25];
    String[] magenta = new String[25];
    String[] pink = new String[25];
    String[] cyan = new String[25];
    String[] gray = new String[25];
    String[] diagRain = new String[25];
    String[][] arrays = {red,orange,yellow,green,blue,magenta,pink,cyan,rainbow,diagRain,gray};
    //Loops through the array and assigns colors
    for(int i = 0; i < 5; i++){
      rainbow[0 + (i * 5)] = "Red";
      rainbow[1 + (i * 5)] = "Orange";
      rainbow[2 + (i * 5)] = "Yellow";
      rainbow[3 + (i * 5)] = "Green";
      rainbow[4 + (i * 5)] = "Blue";
    }

    for(int i = 0; i < 25; i++){
      red[i] = "Red";
      orange[i] = "Orange";
      yellow[i] = "Yellow";
      green[i] = "Green";
      blue[i] = "Blue";
      magenta[i] = "Magenta";
      pink[i] = "Pink";
      cyan[i] = "Cyan";
      gray[i] = "Gray";
    }

    diagRain[0] = "Red";
    diagRain[1] = "Orange";
    diagRain[2] = "Yellow";
    diagRain[3] = "Green";
    diagRain[4] = "Blue";
    diagRain[5] = "Orange";
    diagRain[6] = "Yellow";
    diagRain[7] = "Green";
    diagRain[8] = "Blue";
    diagRain[9] = "Green";
    diagRain[10] = "Yellow";
    diagRain[11] = "Green";
    diagRain[12] = "Blue";
    diagRain[13] = "Green";
    diagRain[14] = "Yellow";
    diagRain[15] = "Green";
    diagRain[16] = "Blue";
    diagRain[17] = "Green";
    diagRain[18] = "Yellow";
    diagRain[19] = "Orange";
    diagRain[20] = "Blue";
    diagRain[21] = "Green";
    diagRain[22] = "Yellow";
    diagRain[23] = "Orange";
    diagRain[24] = "Red";

    //Adds the new colors to the dispplay using the refresh method
    if(e.getSource() == this){
      Launchpad pad = new Launchpad();
      pad.refresh(arrays);
    }
  }
}
