public class chessTest{
  public static void main(String[] args){
    
    gameboard board1=new gameboard(3,3);
    gameboard board2=new gameboard(6,6);
    board1.setCharacter("C3","XX");
    board1.printBoard();
    board2.printBoard();
    System.out.println(board1.getCharacter("C3"));
    
    /*
    System.out.print(ex.getCharacter("B2"));
    */
    //chessRules game=new chessRules();
    //game.play();
  }
}
