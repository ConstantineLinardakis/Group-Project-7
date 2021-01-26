import java.awt.*;

//Main Class
public class Launchpad{
  //Declares the JFrame and JButtons as private so the refresh class can use them
  private static Frame frame = new Frame("Launchpad");
  private static Buttons[][] btns = new Buttons[5][5];
  private static int colorCount = 0;
  public static void main(String[] args){
    //Orginal Button Location
    int locX = 20;
    int locY = 120;
    //Loops thorugh the buttons, creates them, defines dimentions and sets their original color
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++){
        String title = i + ":" + j;
        btns[i][j] = new Buttons(title);
        btns[i][j].setDimentions(locX + (j * 120),locY + (i * 120));
        btns[i][j].setColors("Gray", "Gray");
        frame.add(btns[i][j]);
      }
    }
    //Adds the Change Colors button
    ColorButton cButton = new ColorButton();
    Labels labels = new Labels("C");
    frame.add(labels);
    frame.add(cButton);

    frame.setVisible(true);
  }

  //Method used to refresh the buttons on the screen adn change their colors
  public static void refresh(String[][] color){
    int locX = 20;
    int locY = 120;
    //Loops through removing the old button and adding the new ones
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++){
        frame.remove(btns[i][j]);
        String title = i + ":" + j;
        btns[i][j].setDimentions(locX + (j * 120),locY + (i * 120));
        //Sets the colors of the buttons to the next array in the 2 dimentional array
        btns[i][j].setColors(color[colorCount][j + (i*5)], color[colorCount][j + (i*5)]);
        frame.add(btns[i][j]);
      }
    }
    //Keeps track of which color array is being used
    colorCount++;
    if(colorCount > 9){
      colorCount = 0;
    }
    //Refreshes the frame after changes
    frame.repaint();
  }
}

