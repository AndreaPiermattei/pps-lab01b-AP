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
            "0,1,true",
            "1,0,true",
            "3,0,true",
            "4,1,true",
            "0,3,true",
            "1,4,true",
            "4,3,true",
            "3,4,true",
            "0,0,false",
            "1,1,false",
            "3,3,false",
            "4,4,false",
            "2,4,false",
            "4,2,false",
            "2,0,false",
            "0,2,false",//TODO: put every possible scenario
    })
    public void checkHitWithPawn(final int xPawn,final int yPawn, final boolean expectedResult){

        logicToTest=new LogicsImpl(SIZE,2,2,xPawn,yPawn);
        assertEquals(expectedResult,logicToTest.hit(xPawn,yPawn));
    }

}
