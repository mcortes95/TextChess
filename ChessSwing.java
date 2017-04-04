import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ChessSwing extends JFrame {

   private JButton[][] btnArr = new JButton[8][8];
	public ChessSwing(){
		super();
		this.getContentPane().setLayout(null);
		this.setBounds(150,150,480,602);
      
      JButton button1=new JButton();
      button1.setLabel("gfdf");
      JPanel p=new JPanel();
      p.setVisible(true);
      this.add(p, BorderLayout.SOUTH);
      p.add(button1);
      
      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      for(int x=0;x<8;x++){
         for(int y=0;y<8;y++){
           if(x%2==0){
             if(y%2==0){
               this.add(btnArr[x][y]=new JButton(new ImageIcon("PawnB.png")));
               btnArr[x][y].setBackground(Color.darkGray);
             }
             else{
               this.add(btnArr[x][y]=new JButton(new ImageIcon("PawnB.png")));
               btnArr[x][y].setBackground(Color.white);
             }
           }
           else{
             if(y%2==0){
               this.add(btnArr[x][y]=new JButton(new ImageIcon("PawnW.png")));
               btnArr[x][y].setBackground(Color.white);
             }
             else{
               this.add(btnArr[x][y]=new JButton(new ImageIcon("PawnW.png")));
               btnArr[x][y].setBackground(Color.darkGray);
             }
           }
           
           /*
           btnArr[x][y].addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                  //setTitle(Integer.toString(btnData[x][y]));
                  setTitle("Getting an error so I'll just leave this here.");
                  //System.out.println(btnArr[1][2].getText());
               }
           });
           */
           btnArr[x][y].setText("Chess Piece.");
           btnArr[x][y].setBounds(30*(x+x),30*(y+y),60,60);
           btnArr[x][y].setOpaque(true);
           btnArr[x][y].setBorderPainted(false);
         }
      }      
      
      this.setPiece(2,2,"RookW.png");
	}
   public void setPiece(int column, int row,String piece){
      //btnArr[column-1][row-1].setText(piece);
      btnArr[column-1][row-1].setIcon(new ImageIcon(piece));
   }
   public void movePiece(String start,String end){

   }
	public static void main(String[] args) {
		new ChessSwing();

  }
}
