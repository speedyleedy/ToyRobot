package com.toyrobot;

public class Game {
    GameInput input = new GameInput();
    public void mainLoop(){
        while (true){
            System.out.print("Enter input: ");
            Command c = input.getInput();
            if (Command.ChoiceType.QUIT == c.getChoice()){
                return;
            }
        }


    }
}
