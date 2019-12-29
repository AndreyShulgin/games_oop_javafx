package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws IllegalStateException {
        try {
            if (!isDiagonal(source, dest)) {
                throw new IllegalStateException();
            }
        } catch (IllegalStateException e) {
            System.out.println(String.format("Could not way by diagonal from %s to %s", source, dest));
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(((index +1) * deltaX) + source.x, ((index + 1) * deltaY) + source.y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
