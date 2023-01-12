import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 05.12.2022
 * @author 
 */

public class FehlerInterface extends JFrame {
  // Anfang Attribute
  private JNumberField jNumberField1 = new JNumberField();
  private JLabel lFehlercodeInterpreter = new JLabel();
  private JButton bAuslesen = new JButton();
  private JLabel lFehlercodeeingeben = new JLabel();
  private JLabel jLabel1 = new JLabel();

  // Ende Attribute
  
  public FehlerInterface() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 629; 
    int frameHeight = 352;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("FehlerInterface");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jNumberField1.setBounds(224, 96, 179, 56);
    jNumberField1.setText("");
    cp.add(jNumberField1);
    lFehlercodeInterpreter.setBounds(184, 16, 264, 56);
    lFehlercodeInterpreter.setText("Fehlercode Interpreter");
    lFehlercodeInterpreter.setHorizontalAlignment(SwingConstants.CENTER);
    lFehlercodeInterpreter.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(lFehlercodeInterpreter);
    bAuslesen.setBounds(256, 168, 115, 40);
    bAuslesen.setText("Auslesen");
    bAuslesen.setMargin(new Insets(2, 2, 2, 2));
    bAuslesen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bAuslesen_ActionPerformed(evt);
      }
    });
    cp.add(bAuslesen);
    lFehlercodeeingeben.setBounds(40, 96, 171, 48);
    lFehlercodeeingeben.setText("Fehlercode eingeben:");
    lFehlercodeeingeben.setFont(new Font("Dialog", Font.BOLD, 16));
    lFehlercodeeingeben.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(lFehlercodeeingeben);
    jLabel1.setBounds(24, 224, 576, 52);
    jLabel1.setText("");
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLabel1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public FehlerInterface
  
  // Anfang Methoden
  
  public void bAuslesen_ActionPerformed(ActionEvent evt)
  {
    jLabel1.setText(auslesen());
  } // end of bAuslesen_ActionPerformed
  
  public String intToHex()
  {   
    return Integer.toHexString(jNumberField1.getInt()); 
  }
   
  public String auslesen()
  {
    String zeile = "";
    String fehlercode;
    String fehlerbeschreibung = "Unbekannter Fehler";

    try {
        FileReader fileread = new FileReader("fehlerKurz.txt");
        BufferedReader input = new BufferedReader(fileread);
        for(int i = 0;i<20; i++) // 20 Zeilen werden durchlaufen
        {
          zeile = input.readLine(); 
          fehlercode = zeile.substring(0,2);
          if (fehlercode.equals(intToHex()))
          {
              fehlerbeschreibung = zeile.substring(4);
          }        
        }
    }
    catch(Exception e)
    {}
    
    return fehlerbeschreibung;
  }
  // Ende Methoden
} // end of class FehlerInterface

