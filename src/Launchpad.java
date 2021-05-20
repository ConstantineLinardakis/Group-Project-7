import java.awt.*;
import javax.swing.JButton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//Main Class
public class Launchpad extends Thread{
  //Declares the JFrame and JButtons as private so the refresh class can use them
  private static Frame frame = new Frame("Launchpad");
  public static Buttons[][] btns = new Buttons[5][5];
  private static int colorCount = 0;
  public static boolean loop = false;

  public Launchpad(){
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++){
        int title = ((j + 1) + (i * 5));
        makeBtn(title,i,j);
      }
    }
  }

  public static void main(String[] args){
    //Orginal Button Location
    //Loops thorugh the buttons, creates them, defines dimentions and sets their original color
    Launchpad l = new Launchpad();
    l.start();
    //Adds the Change Colors button
    ColorButton cButton = new ColorButton();
    Labels labels = new Labels("C");
    LoopButton loopButton = new LoopButton();
    StopButton stopButton = new StopButton();
    frame.add(stopButton);
    frame.add(loopButton);
    frame.add(labels);
    frame.add(cButton);

    frame.setVisible(true);
  }

  public void makeBtn(int title, int i, int j){
    int locX = 20;
    int locY = 120;
    String sTitle = Integer.toString(title);
    btns[i][j] = new Buttons(sTitle);
    btns[i][j].setDimentions(locX + (j * 120),locY + (i * 120));
    btns[i][j].setColors("Gray", "Gray");
    frame.add(btns[i][j]);
  }

  //Method used to refresh the buttons on the screen adn change their colors
  public void refresh(String[][] color){
    int locX = 20;
    int locY = 120;
    //Loops through removing the old button and adding the new ones
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++){
        //Sets the colors of the buttons to the next array in the 2 dimentional array
        btns[i][j].setColors(color[colorCount][j + (i*5)], color[colorCount][j + (i*5)]);
      }
    }
    //Keeps track of which color array is being used
    colorCount++;
    if(colorCount > 10){
      colorCount = 0;
    }
    //Refreshes the frame after changes
    frame.repaint();
  }

  public void run() {
    while(true){
      boolean loop = LoopButton.loop;
      System.out.print("");
      if(StopButton.stop == true){
        int count = 0;
        for(Clip clip : Buttons.list){
          clip.stop();
          clip.flush();
          clip.close();
        }
        Buttons.list.clear();
        LoopButton.loop = false;
        StopButton.stop = false;
      }else{
        StopButton.stop = false;
        for(Clip clip : Buttons.list){
          clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
      }
    }
  }
}
