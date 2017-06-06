import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;
import sun.audio.*;
import java.io.*;

public class ChoicePanel extends JPanel 
implements ActionListener 
{
    private Rooms map;

    JButton northButton = new JButton("NORTH");
    JButton southButton = new JButton("SOUTH");
    JButton eastButton = new JButton("EAST");
    JButton westButton = new JButton("WEST");

    // Constructor
    public ChoicePanel(Rooms currentMap)
    {
        map = currentMap;
        setLayout(new GridLayout(0,3));
        add(new JPanel());
        //add(new JButton("NORTH"));
        northButton.setActionCommand("NORTH");
        northButton.addActionListener(this);
        add(northButton);

        add(new JPanel());
        //add(new JButton("WEST"));
        westButton.setActionCommand("WEST");
        westButton.addActionListener(this);
        add(westButton);

        add(new JPanel());
        //add(new JButton("EAST"));
        eastButton.setActionCommand("EAST");
        eastButton.addActionListener(this);
        add(eastButton);

        add(new JPanel());
        //add(new JButton("SOUTH"));
        southButton.setActionCommand("SOUTH");
        southButton.addActionListener(this);
        add(southButton);

        add(new JPanel());
    }

    public void disableButtons() {
        northButton.setEnabled(false);
        southButton.setEnabled(false);
        eastButton.setEnabled(false);
        westButton.setEnabled(false);
    }

    public void enableButtons() {
        northButton.setEnabled(true);
        southButton.setEnabled(true);
        eastButton.setEnabled(true);
        westButton.setEnabled(true);
    }

    // Called when the roll button is clicked
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("NORTH")) {
            map.updateRoom(0, -1);
        }
        if (e.getActionCommand().equals("SOUTH")) {
            map.updateRoom(0, 1);
        }
        if (e.getActionCommand().equals("EAST")) {
            map.updateRoom(1, 0);
        }
        if (e.getActionCommand().equals("WEST")) {
            map.updateRoom(-1, 0);
        }
    }

    public void directionMusic()
    {
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;
        try{
            BGM = new AudioStream(new FileInputStream("direction.wav"));
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);
        }catch(IOException error){
        MGP.start(loop);
        }
    }

}


