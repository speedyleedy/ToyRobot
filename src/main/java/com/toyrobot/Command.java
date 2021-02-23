package com.toyrobot;

public class Command {

    private int x;
    private int y;
    private Direction direction;
    private String left;
    private String right;

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public Command(ChoiceType choice, String arguments) {
        this.choice = choice;
        this.arguments = arguments;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Command(int x, int y, Direction direction, ChoiceType choice) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.choice = choice;
    }

    public static Command parse(String input) {
        //limiting to 2 parts, can't tell if a user will type place 0,0,NORTH or place 0, 0, north
        String[] parts = input.split(" ",2);
        if (parts.length > 0){
           ChoiceType c = ChoiceType.valueOf(parts[0]);
           switch (c){
               case PLACE:
                   //error checking here to make sure parts contains the correct stuff.
                   String[] args = parts[1].split(",");
                   //check that parts has 3 bits, X, Y and Direction
                   int x = Integer.parseInt(args[0].trim());
                   int y = Integer.parseInt(args[1].trim());
                   Direction directional = Direction.valueOf(args[2].trim());
                   Command ret = new Command(x, y, directional, ChoiceType.PLACE);
                   return ret;
               default:
                   return new Command(c,null);

           }

        }
        return null;
    }

    public ChoiceType getChoice() {
        return choice;
    }

    public void setChoice(ChoiceType choice) {
        this.choice = choice;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    private ChoiceType choice;
    private String arguments;

    public enum ChoiceType {
        ERROR,
        QUIT,
        PLACE,
        MOVE,
        REPORT,
        LEFT,
        RIGHT
    }

    public enum Direction{
        NORTH,
        SOUTH,
        EAST,
        WEST
    }



}
