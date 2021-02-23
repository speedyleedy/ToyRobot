package com.toyrobot;

public class Game {
    GameInput input = new GameInput();
    private Robot robot;
    private Surface surface;

    public void mainLoop(){

        surface = new Surface(5,5);
        robot = new Robot(surface);

        System.out.println("Place your robot on the table them move it around. To place : " +
                "\n type [PLACE X,Y,DIRECTION], where x & y are a grid of 5 * 5 and Direction is a [NORTH], [SOUTH], [EAST] or [WEST] " +
                "\n type [MOVE] to move 1 space in a direction" +
                "\n type [LEFT] or [RIGHT] to turn your robot left or right" +
                "\n type [QUIT] when you've finished.");
        while (true){
            System.out.print("Enter input: ");
            Command c = input.getInput();
            if (Command.ChoiceType.QUIT == c.getChoice()){
                return;
            }

            if (Command.ChoiceType.PLACE == c.getChoice()){
                robot.place(c.getX(), c.getY(), c.getDirection());
            }

            if (Command.ChoiceType.REPORT == c.getChoice()){
                robot.report();
            }

            if (Command.ChoiceType.MOVE == c.getChoice()){
                robot.move();
            }

            if (Command.ChoiceType.LEFT == c.getChoice() || Command.ChoiceType.RIGHT == c.getChoice()){
                robot.turn(c.getChoice());
            }

            if (Command.ChoiceType.ERROR == c.getChoice()){
                System.out.println("Invalid Commands. For Placement, try [PLACE X,Y,DIRECTION]");
                System.out.println("Other valid commands are: MOVE, LEFT, RIGHT, REPORT, QUIT");
            }


        }


    }
}
