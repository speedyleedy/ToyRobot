package com.toyrobot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * Unit test for simple App.
 */
public class RobotTest
{
    Robot robot = null;

    Surface surface = null;

    @Before
    public void setUp() throws Exception {
        surface = Mockito.mock(Surface.class);
        robot = new Robot(surface);
    }


    @Test
    public void shouldNotPlaceIfBoundsInvalid(){
        Mockito.when(surface.checkBounds(Mockito.anyInt(), Mockito.anyInt())).thenReturn(-1);

        robot.place(1,1, Command.Direction.NORTH);

        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
    }

    @Test
    public void shouldPlaceIfBoundsValid(){
        Mockito.when(surface.checkBounds(Mockito.anyInt(), Mockito.anyInt())).thenReturn(0);
        robot.place(1,1, Command.Direction.NORTH);

        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());

    }

    @Test
    public void shouldTurnLeft(){
        Mockito.when(surface.checkBounds(Mockito.anyInt(), Mockito.anyInt())).thenReturn(0);
        robot.place(1,1, Command.Direction.NORTH);
        robot.turn(Command.ChoiceType.LEFT);

        assertEquals(Command.Direction.WEST, robot.getDirection());

    }

    @Test
    public void shouldTurnRight(){
        Mockito.when(surface.checkBounds(Mockito.anyInt(), Mockito.anyInt())).thenReturn(0);
        robot.place(1,1, Command.Direction.NORTH);
        robot.turn(Command.ChoiceType.RIGHT);

        assertEquals(Command.Direction.EAST, robot.getDirection());

    }


    @Test
    public void shouldMoveInDirectionFacing(){
        robot.place(1,1, Command.Direction.NORTH);
        robot.move();

        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());

    }

    @Test
    public void shouldNotCommitSuicide(){

        Surface surface = new Surface(5,5);
        Robot rob = new Robot(surface);

        rob.place(4,4, Command.Direction.NORTH);
        rob.move();

        assertEquals(4, rob.getY());


    }

}
