import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sample extends JFrame {
	//private final JButton b = new JButton();
   private final JButton[][] btnArr = new JButton[5][5];

	public Sample(){
		super();
		this.setTitle("Chess");
		this.getContentPane().setLayout(null);
		this.setBounds(100, 100, 400, 400);
		//this.add(makeButton());
		//this.setVisible(true);
      for(int x=0;x<5;x++){
         for(int y=0;y<5;y++){
            this.add(btnArr[x][y]=new JButton("XX"));
            //btnArr[x][y].setBackground(Color.RED); 
            btnArr[x][y].setBounds(30*(x+x+1),25*(y+y+1),50,40);
            System.out.println(btnArr[x][y].getLabel());
            /*
            btnArr[x][y].addActionListener(new ActionListener(){
		         public void actionPerformed(ActionEvent e) {
			         JOptionPane.showMessageDialog(btnArr[x][y], "Hello World!");
			      }
		      });
            */
         }
      }
      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
   /*
	private JButton makeButton(){
		b.setText("Click me!");
		b.setBounds(40, 40, 30, 30);
		b.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e) {
			   JOptionPane.showMessageDialog(b, "Hello World!");
			}
		});
		return b;
	}
   */
	public static void main(String[] args) {
		new Sample();
  }
}
