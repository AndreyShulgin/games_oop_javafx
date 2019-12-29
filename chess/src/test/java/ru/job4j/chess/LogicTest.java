package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void canMove() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        boolean rst = logic.move(bishopBlack.position(), Cell.G5);
        assertThat(rst, is(true));
    }

    @Test
    public void dontCanMove() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        BishopBlack bishopBlack2 = new BishopBlack(Cell.E3);
        logic.add(bishopBlack);
        logic.add(bishopBlack2);
        boolean rst = logic.move(bishopBlack.position(), Cell.G5);
        assertThat(rst, is(false));
    }

}