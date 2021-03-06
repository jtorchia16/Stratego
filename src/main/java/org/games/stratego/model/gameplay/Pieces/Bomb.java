package org.games.stratego.model.gameplay.Pieces;

import org.games.stratego.model.gameplay.FightResult;
import org.games.stratego.model.gameplay.Player;

public class Bomb extends Piece{

    private String name = "bomb";
    private boolean canMove = false;
    private int rank = 0;

    public Bomb(Player owner)
    {
        this.owner = owner;
    }

    @Override
    public FightResult fight(Piece piece)
    {
        if (isDead) throw new IllegalStateException("This piece is dead.");

        if (piece.getOwner()==null)
        {
            throw new IllegalStateException("Attacker has no rank.");
        }

        if (piece.isDead())
        {
            throw new IllegalStateException("Attacker is alredy dead");
        }

        if (piece.getOwner()==null)
        {
            throw new IllegalStateException("Attacker has no owner");
        }

        if (piece.getOwner() == this.owner)
        {
            return FightResult.IllegalMove;
        }

        if (piece.getType().equals("minor") && piece.getRank() == 3)
        {
            return FightResult.AttackerVictory;
        }

        return FightResult.DefenderVictory;
    }
}
