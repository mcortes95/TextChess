
public class gameboard{
  private String[][] board;

   public gameboard(int row,int column){
      String[][] board=new String[row][column];
      this.board=board;
      clearBoard();
   }
   public void clearBoard(){
     char charSet=65;
     char letter=65;
     int number=1;
      for(int x=this.board.length-1;x>=0;x--){
         for(int y=0;y<this.board.length;y++){
           if(x%2==0){
             if(y%2==0){
               this.board[x][y]="##";
             }
             else{
               this.board[x][y]="  ";
             }
           }
           else{
             if(y%2==0){
               this.board[x][y]="  ";
             }
             else{
               this.board[x][y]="##";
             }
           }
         }
         letter++;
         number=1;
      }
   }
   public void printBoard(){
     char row=(char)(64+this.board.length);
     int collumn2=1;
      for(int x=this.board.length-1;x>=0;x--){
         if(x%2==0){
           System.out.print("#");
         }
         else{
           System.out.print(" ");
         }
         for(int y=0;y<this.board.length;y++){
            System.out.print(board[x][y]);
            if(y<this.board.length-1){
              if(x%2==0){
                if(y%2==0){
                  System.out.print("#| ");
                }
                else{
                  System.out.print(" |#");
                }
              }
              else{
                if(y%2==0){
                  System.out.print(" |#");
                }
                else{
                    System.out.print("#| ");
                }
              }
            }
         }
         if(getGameboardLength()%2==0){
           if(row%2==0){
             System.out.print("# "+row);
           }
           else{
             System.out.print("  "+row);
           }
         }
         else if(getGameboardLength()%2==1){
           if(row%2==0){
             System.out.print("  "+row);
           }
           else{
             System.out.print("# "+row);
           }
         }
         row--;
         System.out.print("\n");
         if(x>0){
            for(int z=0;z<this.board.length*5-1;z++){
               System.out.print("-");
            }
         }
         while(x==0&&collumn2<this.board.length+1){
           if(collumn2==1){
             System.out.print("\n");
           }
           System.out.print(" "+collumn2+"   ");
           collumn2++;
         }
         System.out.print("\n");
      }
      System.out.print("\n");
  }
  public void setCharacter(String coor,String piece){
    this.board[coor.charAt(0)-65][Integer.parseInt(coor.substring(1))-1]=piece;
  }

  public void moveCharacter(String a,String b){//removed boolean return type. not sure why I put that there??
    this.board[b.charAt(0)-65][Integer.parseInt(b.substring(1))-1]=this.board[a.charAt(0)-65][Integer.parseInt(a.substring(1))-1];
    //this.board[a.charAt(0)-65][Integer.parseInt(a.substring(1))-1]="  ";
    if((int)(a.charAt(0)-65)%2==0){
      if((int)(Integer.parseInt(a.substring(1))-1)%2==0){
        this.board[a.charAt(0)-65][Integer.parseInt(a.substring(1))-1]="##";
      }
      else{
        this.board[a.charAt(0)-65][Integer.parseInt(a.substring(1))-1]="  ";
      }
    }
    else{
      if((int)(Integer.parseInt(a.substring(1))-1)%2==0){
        this.board[a.charAt(0)-65][Integer.parseInt(a.substring(1))-1]="  ";
      }
      else{
        this.board[a.charAt(0)-65][Integer.parseInt(a.substring(1))-1]="##";
      }
    }
  }
  public String getCharacter(String pos){
    return this.board[pos.charAt(0)-65][Integer.parseInt(pos.substring(1))-1];
  }
  public boolean checkPiece(String piece){
    for(int x=this.board.length-1;x>=0;x--){
       for(int y=0;y<this.board.length;y++){
         //System.out.print(this.board[x][y].substring(0,2));
         //System.out.print(" "+piece+"\n");
         if(this.board[x][y].substring(0,2).equals(piece)){
           return true;
         }
       }
    }
    return false;
  }
  public int getGameboardLength(){
    return this.board.length;
  }
}
