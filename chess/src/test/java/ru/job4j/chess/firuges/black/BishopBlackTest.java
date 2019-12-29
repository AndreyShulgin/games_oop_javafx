package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void positionBishop() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A5);
        assertThat(bishopBlack.position(), is(Cell.A5));
    }

    @Test
    public void copyBishop() {
        Figure bishopBlack = new BishopBlack(Cell.A5);
        bishopBlack = bishopBlack.copy(Cell.A7);
        assertThat(bishopBlack.position(), is(Cell.A7));
    }

    @Test
    public void wayBishop() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expect));
    }

    @Test
    public void notDiagonalBishop() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream  out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C1, Cell.G6);
        assertThat(out.toString(), is(new StringBuilder()
                .append("Could not way by diagonal from C1 to G6")
                .append(System.lineSeparator())
                .toString()));
        System.setOut(stdout);
    }
}