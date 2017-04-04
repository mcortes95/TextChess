import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JButton;
//import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
//import javax.swing.*;

public class ChessGrid extends JFrame {
	//private final JButton b = new JButton();
   private final JButton[][] btnArr = new JButton[8][8];
   
	public ChessGrid(){
		super();
      JLabel label1 = new JLabel("Test");
		setTitle("Chess");
		this.getContentPane();
      this.setLayout(new GridLayout(8,8));
      //this.setColumns(8);
		this.setBounds(150,150,600,550);
		//this.add(makeButton());
		//this.setVisible(true);
      int count=1;
      for(int x=0;x<8;x++){
         for(int y=0;y<8;y++){
            //this.add(btnArr[x][y]=new JButton("XX"));
            this.add(btnArr[x][y]=new JButton(Integer.toString(count)));
            //btnArr[x][y].setBounds(34*(x+x+1),29*(y+y+1),60,40);
            btnArr[x][y].setOpaque(true);
            btnArr[x][y].setBackground(Color.green);
            btnArr[x][y].setBorderPainted(true);
            count++;
            //System.out.println(btnArr[x][y].getLabel());
         }
      }
      this.add(label1);
      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
  	public static void main(String[] args) {
		new ChessGrid();
  }
}
