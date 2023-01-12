import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.math.*;
//import java.util.ResourceBundle;
/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 21.11.2022
 * @author 
 */

public class Interface extends JFrame {
  // Anfang Attribute
  private JLabel titlecard = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JButton bValidieren = new JButton();
  private JLabel gueltigLabel = new JLabel();
  private JLabel landLabel = new JLabel();
  // Ende Attribute
  
  public Interface() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 321;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Interface");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    titlecard.setBounds(36, 13, 198, 52);
    titlecard.setText("IBAN Validierer");
    titlecard.setHorizontalAlignment(SwingConstants.CENTER);
    titlecard.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(titlecard);
    jLabel2.setBounds(8, 84, 118, 36);
    jLabel2.setText("IBAN eingeben:");
    cp.add(jLabel2);
    jTextField1.setBounds(124, 84, 150, 36);
    cp.add(jTextField1);
    bValidieren.setBounds(82, 151, 99, 41);
    bValidieren.setText("Validieren");
    bValidieren.setMargin(new Insets(2, 2, 2, 2));
    bValidieren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bValidieren_ActionPerformed(evt);
      }
    });
    cp.add(bValidieren);
    gueltigLabel.setBounds(84, 202, 110, 20);
    gueltigLabel.setText("text");
    gueltigLabel.setVisible(false);
    cp.add(gueltigLabel);
    landLabel.setBounds(80, 232, 110, 20);
    landLabel.setText("");
    landLabel.setVisible(false);
    cp.add(landLabel);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Interface
  
  // Anfang Methoden
  
  public void bValidieren_ActionPerformed(ActionEvent evt)
  {
    checkLand();
    //checkGueltig();
  }
    
  public void checkLand()
  {
    String eingabe = jTextField1.getText();
    eingabe = eingabe.toUpperCase();
    boolean landValid = true;
    
    switch (eingabe.substring(0, 2))
    {
      case "DE":
        landLabel.setText("Deutschland");
        break;
        
      case "PL":
        landLabel.setText("Polen");
        break;
        
      case "CZ":
        landLabel.setText("Tschechien");
        break;
        
      case "AT":
        landLabel.setText("\u00d6sterreich");
        break;
        
      case "CH":
        landLabel.setText("Schweiz");
        break;
        
      case "FR":
        landLabel.setText("Frankreich");
        break;
          
      case "LU":
        landLabel.setText("Luxemburg");
        break;
          
      case "BE":
        landLabel.setText("Belgien");
        break;
        
      case "NL":
        landLabel.setText("Niederlande");
        break;
        
      case "DK":
        landLabel.setText("D\u00e4nemark");
        break;
        
      default:
        landLabel.setText("Land unbekannt.");
        landValid = false;
    }
    
    if (landValid == true)
    {
          landLabel.setBackground(Color.GREEN);
    }
    else
    {
          landLabel.setBackground(Color.RED);
    } // end of if-else
    
    landLabel.setOpaque(true);
    landLabel.setVisible(true);
    
  }
  
  
  /**
  
  public void checkGueltig()
  {

        String iban = jTextField1.getText();
        String pruefzahl = iban.substring(2,4);
        String bban = iban.substring(4);
        
        int leandercode1 = iban.charAt(0) - 55;
        int leandercode2 = iban.charAt(1) - 55;        
        iban = bban + leandercode1 + leandercode2 + pruefzahl;
        
        BigInteger big1, big2, big3, big4;
        
        big1 = new BigInteger(iban);
        big2 = new BigInteger("97");                
        big3 = new BigInteger("1");
        big4 = big1.remainder(big2);
        
        if (big4.compareTo(big3) == 0) 
        {
          gueltigLabel.setText("IBAN g\u00fcltig");
          gueltigLabel.setVisible(true);
        } // end of if
        else 
        {
          gueltigLabel.setText("IBAN ung\u00fcltig");
          gueltigLabel.setVisible(true);
        } // end of if-else 
  }
  
  */         
}
  

  // Ende Methoden
 // end of class Interface

