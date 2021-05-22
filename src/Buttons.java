import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//JButtons Class
public class Buttons extends JButton implements ActionListener{
  private int locX = 0;
  private int locY = 0;

  public static ArrayList<Clip> list = new ArrayList<Clip>();

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
  static Map<String, Color> colorMap = Map.ofEntries(Map.entry("WHITE", Color.WHITE), Map.entry("GRAY", Color.GRAY), Map.entry( "BLACK", Color.BLACK), Map.entry( "RED", Color.RED), Map.entry( "ORANGE", new Color(255,121,0)), Map.entry( "YELLOW", Color.YELLOW), Map.entry( "GREEN", Color.GREEN), Map.entry( "BLUE", Color.BLUE), Map.entry( "MAGENTA", Color.MAGENTA), Map.entry( "PINK", Color.PINK), Map.entry( "CYAN", Color.CYAN));

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

  public String[] listFilesForFolder(final File folder) {
    String[] f = new String[25];
    int count = 0;
    for(int i = 0; i < 25; i++){
      f[i] = "";
    }
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry);
        } else {
            if(fileEntry.getName().equals(".DS_Store")){

            }else{
              f[count] = fileEntry.getName();
              count++;
            }
        }
    }
    return f;
  }

  public void playSound(String url, boolean loop, boolean stop){
    try{
      System.out.println("1");
      File sound = new File("soundFiles/" + url);
      System.out.println("2");
      Clip clip = AudioSystem.getClip();
      System.out.println("3");
      clip.open(AudioSystem.getAudioInputStream(sound));
      System.out.println("4");
      clip.start();
      System.out.println("5");
      if(loop == true){
        list.add(clip);
        // clip.loop(Clip.LOOP_CONTINUOUSLY);
      }
      if(stop == true){
        stopSound(clip);
      }
    }
    catch(Exception e){
      System.out.println(e);
    }
  }

  public void stopSound(Clip clip){
    if(clip.isActive()){
      clip.stop();
      clip.flush();
      clip.close();
    }
  }

  //Event Handler / Action Listener
  @Override
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == this){
      String sNum = this.getText();
      int num = Integer.parseInt(sNum);
      final File folder = new File("soundFiles");
      String[] names =listFilesForFolder(folder);
      System.out.println(names[num - 1]);
      System.out.println(num);
      boolean fullStop = StopButton.stop;
      playSound(names[num - 1], LoopButton.loop, fullStop);
    }
  }
}
