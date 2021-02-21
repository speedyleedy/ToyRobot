package com.toyrobot;

public class Surface extends AbstractStage{
    private int width;
    private int height;

    public Surface(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int checkBounds(int x, int y){
        if (x >= 0 && x < width){
            if (y >= 0 && y < height){
                return 0;
            }

        }
        return -1;

    }


}
