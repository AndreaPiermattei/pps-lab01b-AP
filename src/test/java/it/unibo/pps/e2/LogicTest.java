package it.unibo.pps.e2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    final int SIZE = 5;
    private Logics logicToTest;

    @Test
    public void testIfChessPiecesAreSetCorrectly() {
        logicToTest = new LogicsImpl(SIZE);
        Pair<Integer,Integer> knighPosition = null;
        Pair<Integer,Integer> pawnPosition = null;
        for(int x=0; x<SIZE; x++){
            for(int y=0; y<SIZE; y++){
                if(logicToTest.hasKnight(x,y)){knighPosition=new Pair<>(x,y);}
                if(logicToTest.hasPawn(x,y)){pawnPosition=new Pair<>(x,y);}
            }
        }

        final Pair<Integer,Integer> k = knighPosition;
        final Pair<Integer,Integer> p = pawnPosition;

        assertAll(()->assertNotEquals(null,k),
                ()->assertNotEquals(null,p),
                ()->assertNotEquals(k,p));
    }

    @ParameterizedTest
    @CsvSource({
            "-1,0",
            "5,3",
            "3,5",
            "2,-5",
            "7,7",
            "-1,-1"
    })
    public void checkIncorrectInputForHit(final int xSelected,final int ySelected){
        logicToTest=new LogicsImpl(SIZE);
        assertThrows(IndexOutOfBoundsException.class,()->logicToTest.hit(xSelected,ySelected));
    }

    @ParameterizedTest
    @CsvSource({
            "0,1,0,1,true,true",
            "1,0,1,0,true,true",
            "3,0,3,0,true,true",
            "4,1,4,1,true,true",
            "0,3,0,3,true,true",
            "1,4,1,4,true,true",
            "4,3,4,3,true,true",
            "3,4,3,4,true,true",
            //above: cases of success hit
            "3,4,0,0,false,true",
            //above: cases of failed hit but correct movement
            "0,0,0,0,false,false",
            "1,1,1,1,false,false",
            "3,3,3,3,false,false",
            "4,4,4,4,false,false",
            "2,4,2,4,false,false",
            "4,2,4,2,false,false",
            "2,0,2,0,false,false",
            "0,2,0,2,false,false",
            //above: cases of incorrect movement inside the board
            //TODO: put every possible scenario from starting position of knight (2,2)
    })
    public void checkBehaviourOfHit(final int xSelected,final int ySelected,final int xPawn,final int yPawn, final boolean expectedHitResult,final boolean expectedMovementResult){
        logicToTest=new LogicsImpl(SIZE,2,2,xPawn,yPawn);
        boolean hitResult = logicToTest.hit(xSelected,ySelected);
        assertAll(()->assertEquals(expectedHitResult,hitResult),
                ()->assertEquals(expectedMovementResult,logicToTest.hasKnight(xSelected,ySelected)));
    }

}
