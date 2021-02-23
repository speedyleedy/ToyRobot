package com.toyrobot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GameInput {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public Command getInput() {

        try{
            while (true){

                String input = reader.readLine().toUpperCase();

                Command ret = Command.parse(input);

                if (ret != null){
                    return ret;
                }

            }
        }
        catch (Exception e){
            return new Command(Command.ChoiceType.ERROR, null);
        }

    }
}
