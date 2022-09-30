package service;
import java.util.Random;

public class AiPlayer extends Player{
    public AiPlayer(Board board) {
        super(board);
    }

    Random random=new Random();

    @Override
    public void movePiece(int col) {

        if(board.existLeagalMoves()) {
            boolean tOrF;

            do {//ture
                col = random.nextInt(6);
                tOrF = board.isLeagalMove(col);
            } while (tOrF != true);
            //int row=minimax(0,false);


//            int depth=board.emptyRow();
//             col=minimax(depth,false);



            board.updateMove(col, Piece.GREEN);
            //board.updateMove(col,row, Piece.GREEN);
            board.getBoardUI().update(col, false);
            board.findWinner();
            Winner winner=board.findWinner();
            if (!winner.getWinningPiece().equals(Piece.EMPTY)) {
                board.getBoardUI().notifyWinner(winner);
            }else {
                if (board.existLeagalMoves() == false) {//existLeagkMove eken check karla blanwa eka emty thanak hari thianwda kital ehem thank naththam false return karanwa
                    board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                }
            }
        }
    }





    public int minimax(int depth,boolean maximizingPlayer){
        if (depth==0/*CREATION_NUMBER*/ || depth==5) {//danna
            return 3;

        }
        int maxEval,minEval,heuristicVal;
        if ( maximizingPlayer) {
            maxEval=(int)Double.NEGATIVE_INFINITY;
            for (int i=0 ; i < board.NUM_OF_COLS; i++) {
                heuristicVal=minimax(depth+1,false);
                maxEval=max(heuristicVal,maxEval);
            }
            return maxEval;
        }else{
            minEval=(int)Double.POSITIVE_INFINITY;
            for (int i = 0; i < board.NUM_OF_COLS; i++) {
                heuristicVal=minimax(depth+1,true);
                maxEval=min(heuristicVal,minEval);
            }
            return minEval;
        }
    }
    public int min(int heuristicVal, int minEval){
        if (heuristicVal < minEval) {
            return heuristicVal;
        }else {
            return minEval;
        }
    }
    public int max(int heuristicVal, int maxEval){
        if (heuristicVal > maxEval) {
            return heuristicVal;
        }else {
            return maxEval;
        }
    }
}
