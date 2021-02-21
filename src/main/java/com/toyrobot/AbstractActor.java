package com.toyrobot;

public abstract class AbstractActor {
    private int x;
    private int y;
    protected Command.Direction direction;
    private AbstractStage stage;

    public AbstractActor(AbstractStage stage) {
        this.stage = stage;
    }

    public void report(){
        System.out.println("REPORT -  " + x + " " + y + " " + direction);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Command.Direction getDirection() {
        return direction;
    }

    public void setDirection(Command.Direction direction) {
        this.direction = direction;
    }

    private boolean placed = false;

    public void place(int x, int y, Command.Direction direction) {

            if(stage.checkBounds(x,y) == 0){
                this.x = x;
                this.y = y;
                this.direction = direction;
                placed = true;
            }

    }
    public void move(){
        // MOVE will move the toy robot one unit forward in the direction it is currently facing.

        if (!placed){
            return;
        }
        int tx = x;
        int ty = y;

        if (Command.Direction.EAST == direction){
            tx += 1;

        } else if (Command.Direction.WEST == direction){
            tx -= 1;
        } else if (Command.Direction.SOUTH == direction){
            ty -=1;
        } else if (Command.Direction.NORTH == direction){
            ty +=1;
        }
        if (stage.checkBounds(tx, ty) == 0){
            x = tx;
            y = ty;
        }

    }


}
