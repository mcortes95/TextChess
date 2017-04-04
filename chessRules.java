import java.util.Scanner;
public class chessRules{
  private gameboard game;
  private int count;
  private boolean continueG;
  private int p1win;
  private int p2win;
  private int draw;
  private Scanner input;

  public chessRules(){
    gameboard game=new gameboard(8,8);
    this.game=game;
  }
  public void displayScore(){
    System.out.println("Player 1: "+p1win+"\nPlayer 2: "+p2win+"\nDraw: "+draw);
  }
  public void play(){
    this.game.clearBoard();
    for(int x=1;x<this.game.getGameboardLength()+1;x++){
      this.game.setCharacter("G"+x,"2P");
      this.game.setCharacter("B"+x,"1P");
      if(x==1||x==8){
        this.game.setCharacter("A"+x,"1R");
        this.game.setCharacter("H"+x,"2R");
      }
      if(x==2||x==7){
        this.game.setCharacter("A"+x,"1k");
        this.game.setCharacter("H"+x,"2k");
      }
      if(x==3||x==6){
        this.game.setCharacter("A"+x,"1B");
        this.game.setCharacter("H"+x,"2B");
      }
      if(x==4){
        this.game.setCharacter("A"+x,"1Q");
        this.game.setCharacter("H"+x,"2K");
      }
      if(x==5){
        this.game.setCharacter("A"+x,"1K");
        this.game.setCharacter("H"+x,"2Q");
      }
    }
    this.game.printBoard();
    continueG=true;
    while(continueG){
      checkForTurn();
    }
  }
  public void setCount(int count){
    this.count=count;
  }
  public void checkForTurn(){
    if(this.count%2==0){
      turn1();
    }
    else if(this.count%2!=0){
      turn2();
    }
    this.game.printBoard();
  }
  public void turn1(){
    boolean legalMove=false;
    Scanner input=new Scanner(System.in);
    while(!legalMove){
      System.out.print("Player 1,enter piece: ");
      String select=input.nextLine();
      System.out.print("now destination: ");
      String destination=input.nextLine();
      legalMove=checkMove(this.game.getCharacter(select),select ,destination);
        if(!legalMove){
          System.out.println("Illegal move, try again.");
        }
        else{
          this.game.moveCharacter(select,destination);
          this.count++;
        }
    }
    if(checkWin("2")){
      continueG=false;
      this.p1win++;
    }
  }
  public void turn2(){
    boolean legalMove=false;
    Scanner input=new Scanner(System.in);
    while(!legalMove){
      System.out.print("Player 2, enter piece: ");
      String select=input.nextLine();
      System.out.print("now destination: ");
      String destination=input.nextLine();
      legalMove=checkMove(this.game.getCharacter(select), select, destination);
        if(!legalMove){
          System.out.println("Illegal move, try again.");
        }
        else{
          this.game.moveCharacter(select,destination);
          this.count++;
        }
    }
    if(checkWin("1")){
      continueG=false;
      this.p2win++;
    }
  }
  public boolean checkMove(String piece,String start,String destination){//removed char player argument, info can be derived from first characted "piece" string
  //piece is the chess piece the player intends to move, start is where that piece is located, and destination is where they intend to move it to
    System.out.println(piece);
    if(piece.charAt(0)=='1'){//if it's player one making the move
      //if player one selects pawn
      if(piece.charAt(1)=='P'){
        System.out.println("pawn selected");
        if(start.charAt(0)==destination.charAt(0)-1&&start.charAt(1)==destination.charAt(1)&&(this.game.getCharacter(destination)=="##"||this.game.getCharacter(destination)=="  ")){
          return true;
        }
        else if(start.charAt(0)=='B'&&start.charAt(0)==destination.charAt(0)-2){
          return true;
        }
        else if(start.charAt(0)==destination.charAt(0)-1&&(start.charAt(1)==destination.charAt(1)-1||start.charAt(1)==destination.charAt(1)+1)&&this.game.getCharacter(destination).charAt(0)=='2'){
          return true;
        }
      }
      //if player selects rook
      else if(piece.charAt(1)=='R'){
        if((start.charAt(0)==destination.charAt(0)||start.charAt(1)==destination.charAt(1))&&this.game.getCharacter(destination).charAt(0)!='1'){//checks that the piece is moving in a straight line
          if(start.charAt(1)==destination.charAt(1)){//if the piece is moving vertically
            if(start.charAt(0)<destination.charAt(0)){//if piece moves up
              for(char x=start.charAt(0);x<destination.charAt(0);x++){
                if(x==start.charAt(0)){
                  x++;
                }
                if(this.game.getCharacter(x+Character.toString(start.charAt(1)))!="  "&&this.game.getCharacter(x+Character.toString(start.charAt(1)))!="##"){
                  System.out.println(x+Character.toString(start.charAt(1))+" is occupied");
                  return false;
                }
              }
              return true;
            }
            else if(start.charAt(0)>destination.charAt(0)){//if piece moves down
              System.out.println("start is greater than end");
              for(char x=start.charAt(0);x>destination.charAt(0);x--){
                if(x==start.charAt(0)){
                  x--;
                }
                if(this.game.getCharacter(x+Character.toString(start.charAt(1)))!="  "&&this.game.getCharacter(x+Character.toString(start.charAt(1)))!="##"){
                  System.out.println(x+Character.toString(start.charAt(1))+" is occupied");
                  return false;
                }
              }
              return true;
            }
          }
          else{//if piece is moving horizontally
            if(start.charAt(1)<destination.charAt(1)){//if moving right
              for(char x=start.charAt(1);x<destination.charAt(1);x++){
                if(x==start.charAt(1)){
                  x++;
                }
                System.out.println(x+Character.toString(start.charAt(0))+x);
                if(this.game.getCharacter(Character.toString(start.charAt(0))+x)!="  "&&this.game.getCharacter(Character.toString(start.charAt(0))+x)!="##"){
                  System.out.println(Character.toString(start.charAt(0))+x+" is occupied");
                  return false;
                }
              }
              return true;
            }
            else if(start.charAt(1)>destination.charAt(1)){//if moving left
              for(char x=start.charAt(1);x>destination.charAt(1);x--){
                if(x==start.charAt(1)){
                  x--;
                }
                System.out.println(x+Character.toString(start.charAt(0))+x);
                if(this.game.getCharacter(Character.toString(start.charAt(0))+x)!="  "&&this.game.getCharacter(Character.toString(start.charAt(0))+x)!="##"){
                  System.out.println(Character.toString(start.charAt(0))+x+" is occupied");
                  return false;
                }
              }
              return true;
            }
          }
        }
        return false;
      }
      else if(piece.charAt(1)=='k'){//if player selects knight
        if((Math.abs(start.charAt(0)-destination.charAt(0))==2&&Math.abs(start.charAt(1)-destination.charAt(1))==1)||(Math.abs(start.charAt(0)-destination.charAt(0))==1&&Math.abs(start.charAt(1)-destination.charAt(1))==2)){
          return true;
        }
      }
      else if(piece.charAt(1)=='B'){//if player selects bishop
        if(Math.abs(start.charAt(0)-destination.charAt(0))==Math.abs(start.charAt(1)-destination.charAt(1))){
          //remember to finish the piece that checks if it's movement path is blocked
          return true;
        }
      }
      else if(piece.charAt(1)=='Q'){//if player selects queen
        if(Math.abs(start.charAt(0)-destination.charAt(0))==Math.abs(start.charAt(1)-destination.charAt(1))){
          return true;
      }
      else if(piece.charAt(1)=='K'){//if player selects king
        if(Math.abs(start.charAt(0)-destination.charAt(0))==1||Math.abs(start.charAt(1)-destination.charAt(1))==1){
          return true;
        }
      }
    }
    else if(piece.charAt(0)=='2'){//if it's player two making the move
      System.out.println("player two");
      if(piece.charAt(1)=='P'){//if player two selects pawn
        System.out.println("pawn selected");
        if(start.charAt(0)==destination.charAt(0)+1&&start.charAt(1)==destination.charAt(1)&&(this.game.getCharacter(destination)=="##"||this.game.getCharacter(destination)=="  ")){
          System.out.println("forward 1");
          return true;
        }
        else if(start.charAt(0)=='G'&&start.charAt(0)==destination.charAt(0)+2){
          System.out.println("forward 2");
          return true;
        }
        else
          return false;
      }
      else if(piece.charAt(1)=='R'){//rook
        if(start.charAt(0)==destination.charAt(0)||start.charAt(1)==destination.charAt(1)&&this.game.getCharacter(destination).charAt(0)!='2'){
          return true;
        }
      }
      else if(piece.charAt(1)=='k'){//knight
        if((Math.abs(start.charAt(0)-destination.charAt(0))==2&&Math.abs(start.charAt(1)-destination.charAt(1))==1)||(Math.abs(start.charAt(0)-destination.charAt(0))==1&&Math.abs(start.charAt(1)-destination.charAt(1))==2)){
          return true;
        }
      }
      else if(piece.charAt(1)=='B'){//bishop
        if(Math.abs(start.charAt(0)-destination.charAt(0))==Math.abs(start.charAt(1)-destination.charAt(1))){
          //remember to finish the piece that checks if it's movement path is blocked
          return true;
        }
      }
      else if(piece.charAt(1)=='Q'){//queen
        if(Math.abs(start.charAt(0)-destination.charAt(0))==Math.abs(start.charAt(1)-destination.charAt(1))){
          return true;
        }
      }
      else if(piece.charAt(1)=='K'){//king
        if(Math.abs(start.charAt(0)-destination.charAt(0))==1||Math.abs(start.charAt(1)-destination.charAt(1))==1){
          return true;
        }
      }
    }
    return false;//supposed to return false, set it to true for dev purposes

  }
  public boolean checkWin(String player){
    return !game.checkPiece(player+"K");
  }
  /*
  public boolean movePawn(String start, String end){
  }
  public boolean moveRook(String start, String end){
  }
  public boolean moveKnight(String start, String end){
  }
  public boolean moveBishop(String start, String end){
  }
  public boolean moveQueen(String start, String end){
  }
  public boolean moveKing(String start, String end){
  }
  */
}
