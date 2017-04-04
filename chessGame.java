import java.util.Scanner;
public class chessGame{
  public static void main(String[] args){
    String YN=" ";
    Scanner input=new Scanner(System.in);
    System.out.println("A game of chess.\nKey:\nP = pawn\nR = rook\nk = knight\nB = bishop\nQ = queen\nK = king");
    chessRules game1=new chessRules();
    boolean keepPlaying=true;
    while(keepPlaying){
      game1.play();
      game1.displayScore();
      System.out.println("\nAnother game? Y or N");
      YN = input.nextLine();
      if(YN.contains("Y") || YN.contains("y")){
        keepPlaying = true;
        game1.setCount(0);
      }
      else {
        keepPlaying = false;
      }
    }
    System.out.println("\nThanks for playing!"+ "\n\nFinal Score:");
    game1.displayScore();
  }
}
