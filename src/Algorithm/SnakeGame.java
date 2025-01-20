package Algorithm;

import java.io.IOException;
import java.util.*;

enum Direction {
    UP, DOWN, LEFT, RIGHT
}
class Coordinates {
    private final int x;
    private final int y;
    public Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates getNext(Direction direction, final int height, final int width) {
        switch (direction) {
            case UP:
                return new Coordinates(this.x, (this.y-1 + height) % height);
            case DOWN:
                return new Coordinates(this.x, (this.y+1 + height) % height);
            case LEFT:
                return new Coordinates((this.x - 1 + width) % width, this.y);
            case RIGHT:
                return new Coordinates((this.x + 1 + width) % width, this.y);
            default:
                return this;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Coordinates coordinates = (Coordinates) obj;
        return this.y == coordinates.y && this.x == coordinates.x;
    }

}
public class SnakeGame {
    private final int height;
    private final int width;
    private final boolean walls;
    private Direction currentDirection;
    private final List<Coordinates> snake;
    private boolean gameOver;
    public SnakeGame(final int height, final int width, final boolean walls, final int initialSnakeSize) {
        this.height = height;
        this.width = width;
        this.walls = walls;
        this.currentDirection = Direction.RIGHT;
        this.snake = new ArrayList<>();
        int start = walls ? 1 : 0;
        for(int i=0; i<initialSnakeSize; i++) {
            this.snake.add(new Coordinates(start + i, start));
        }
        this.gameOver = false;
        this.printBoard();
    }

    public void changeDirection(Direction direction) {
        if(
                (direction == Direction.UP && this.currentDirection == Direction.DOWN)
                || (direction == Direction.DOWN && this.currentDirection == Direction.UP)
                || (direction == Direction.LEFT && this.currentDirection == Direction.RIGHT)
                || (direction == Direction.RIGHT && this.currentDirection == Direction.LEFT)
        ) {
            return;
        }
        this.currentDirection = direction;
    }

    public void tic() {
        Coordinates currentHead = this.snake.get(this.snake.size() - 1);
        Coordinates nextHeadPosition = currentHead.getNext(this.currentDirection, this.height, this.width);
        if(this.walls) {
            if(nextHeadPosition.getX() == 0 || nextHeadPosition.getX() == width-1 || nextHeadPosition.getY() == 0 || nextHeadPosition.getY() == height-1) {
                this.gameOver = true;
                throw new Error("Game over, you hit the wall");
            }
        }
        this.snake.remove(this.snake.get(0));
        if(this.snake.contains(nextHeadPosition)) {
            this.gameOver = true;
            throw new Error("Game over, You hit yourself");
        }
        this.snake.add(nextHeadPosition);
        this.printBoard();
    }

    private void printBoard() {
        Coordinates nextHeadPosition = this.snake.get(this.snake.size()-1);
        System.out.println("\n\n\n");
        for(int i=0; i<this.height; i++) {
            for(int j=0; j<this.width; j++) {
                Coordinates currentCoordinate = new Coordinates(j, i);
                if(currentCoordinate.equals(nextHeadPosition)) {
                    System.out.print("@ ");
                } else if(this.snake.contains(currentCoordinate)) {
                    System.out.print("o ");
                } else {
                    if(this.walls && (i==0 || i == this.width - 1 || j==0 || j == this.height - 1)) {
                        System.out.print("X ");
                    } else {
                        System.out.print(". ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        SnakeGame game = new SnakeGame(10, 10, false, 5);
//        new Timer().scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                game.tic();
//            }
//        }, 0, 1000);
        game.changeDirection(Direction.DOWN);
        game.tic();
        game.changeDirection(Direction.LEFT);
        game.tic();
        game.changeDirection(Direction.UP);
        game.tic();

    }
}
