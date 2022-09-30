package service;

public class BoardImpl implements Board{
    private Piece[][] pieces=new Piece[NUM_OF_ROWS][NUM_OF_COLS];


    /////////////////////////////////BoardUI//////////////////////////////////

    private BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI=boardUI;
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            for (int j = 0; j < NUM_OF_COLS; j++) {
                pieces[i][j]=Piece.EMPTY;
            }
        }
    }

    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
       for (int i = 0; i < NUM_OF_ROWS; i++) {
           if (pieces[i][col].equals(Piece.EMPTY)) {
               return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isLeagalMove(int col) {
        if(findNextAvailableSpot(col)!=-1){
            return true;
        }
        return false;
    }

    @Override
    public boolean existLeagalMoves() {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            for (int j = 0; j < NUM_OF_COLS; j++) {
                if (pieces[i][j].equals(Piece.EMPTY)) {
                    return true;

                }
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        int row=findNextAvailableSpot(col);
        pieces[row][col]=move;
    }






//    public int emptyRow(){
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 6; j++) {
//                if ( pieces[i][j].equals(Piece.EMPTY) ) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }


    @Override
    public void updateMove(int col, int row, Piece move) {
//        int tempRow=row;
//        row=findNextAvailableSpot(col);
//        if (tempRow == row) {
//            pieces[row][col]=move;
//        }

    }

    @Override
    public Winner findWinner() {//return type eka void nemei Winner
        Piece p[]=new Piece[6];
        String x;


        for(int i=0;i<5;i++){
            for(int j=0;j<6;j++){
                p[j]=pieces[i][j];
            }
            for(int k=0;k<3;k++){

                x=p[k]+""+p[k+1]+""+p[k+2]+""+p[k+3];
                if(x.equals("GREENGREENGREENGREEN")){
                    Winner winner=new Winner(Piece.GREEN,k,i,k+3,i);
                    return winner;
                }else if(x.equals("BLUEBLUEBLUEBLUE")){
                    Winner winner=new Winner(Piece.BLUE,k,i,k+3,i);
                    return winner;
                }
            }
        }

        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                p[j]=pieces[j][i];
            }
            for(int k=0;k<2;k++){

                x=p[k]+""+p[k+1]+""+p[k+2]+""+p[k+3];
                if(x.equals("GREENGREENGREENGREEN")){
                    Winner winner=new Winner(Piece.GREEN,i,k,i,k+3);
                    return winner;
                }else if(x.equals("BLUEBLUEBLUEBLUE")){
                    Winner winner=new Winner(Piece.BLUE,i,k,i,k+3);
                    return winner;
                }
            }

        }
        return  new Winner(Piece.EMPTY,-1,-1,-1,-1);
    }

}
