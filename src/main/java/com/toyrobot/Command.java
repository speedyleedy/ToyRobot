package com.toyrobot;

public class Command {

    private int x;
    private int y;
    private ChoiceType direction;

    public Command(ChoiceType choice, String arguments) {
        this.choice = choice;
        this.arguments = arguments;
    }

    public Command(int x, int y, ChoiceType direction, ChoiceType choice) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.choice = choice;
    }

    public static Command parse(String input) {
        String[] parts = input.split(" ");
        if (parts.length >0){
           ChoiceType c = ChoiceType.valueOf(parts[0]);
           switch (c){
               case PLACE:
                   //error checking here to make sure parts contains the correct stuff.
                   String[] args = parts[1].split(",");
                   //check that parts has 3 bits, X, Y and Direction
                   int x = Integer.parseInt(args[0]);
                   int y = Integer.parseInt(args[1]);
                   ChoiceType directional = ChoiceType.valueOf(args[2]);
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
        NORTH,
        SOUTH,
        EAST,
        WEST,
        REPORT,
        LEFT,
        RIGHT
    }



}
