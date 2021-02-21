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

}
