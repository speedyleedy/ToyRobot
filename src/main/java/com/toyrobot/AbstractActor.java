package com.toyrobot;

public abstract class AbstractActor {
    private int x;
    private int y;
    protected Command.Direction direction;
    private AbstractStage stage;

    public AbstractActor(AbstractStage stage) {
        this.stage = stage;
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

    /*The first valid command to the robot is a PLACE command, after that, any
    sequence of commands may be issued, in any order, including another PLACE
    command. The application should discard all commands in the sequence until
    a valid PLACE command has been executed.*/
    private boolean placed = false;

    public void place(int x, int y, Command.Direction direction) {
    /*PLACE will put the toy robot on the table in position X,Y and facing NORTH,
    SOUTH, EAST or WEST.*/

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

    public void turn(Command.ChoiceType choice){
        /*LEFT and RIGHT will rotate the robot 90 degrees in the specified direction
        without changing the position of the robot.*/

        if (!placed){
            return;
        }


        if (choice == Command.ChoiceType.RIGHT){
            if (direction == Command.Direction.NORTH){
                setDirection(Command.Direction.EAST);
            } else if (direction == Command.Direction.EAST){
                setDirection(Command.Direction.SOUTH);
            } else if (direction == Command.Direction.SOUTH){
                setDirection(Command.Direction.WEST);
            } else if (direction == Command.Direction.WEST){
                setDirection(Command.Direction.NORTH);
            }
        }

        if (choice == Command.ChoiceType.LEFT){
            if (direction == Command.Direction.NORTH){
                setDirection(Command.Direction.WEST);
            } else if (direction == Command.Direction.EAST){
                setDirection(Command.Direction.NORTH);
            } else if (direction == Command.Direction.SOUTH){
                setDirection(Command.Direction.EAST);
            } else if (direction == Command.Direction.WEST){
                setDirection(Command.Direction.SOUTH);
            }
        }

    }



    public void report(){
        System.out.println("REPORT -  " + x + " " + y + " " + direction);
    }

}
