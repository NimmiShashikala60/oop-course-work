package service;

public class HumanPlayer extends Player{
    public HumanPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {
        //if(board.existLeagalMoves()){
            if ( board.isLeagalMove(col)==true) {//ture
                board.updateMove(col,Piece.BLUE);
                board.getBoardUI().update(col,true);
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
}
