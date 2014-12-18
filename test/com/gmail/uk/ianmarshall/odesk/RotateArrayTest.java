package com.gmail.uk.ianmarshall.odesk;

import org.junit.Test;
import static org.junit.Assert.*;

public class RotateArrayTest
{
  public RotateArrayTest()
  {
  }

  /**
   * Test of rotateArray(...) method, of class RotateArray
   */
  @Test
  public void testRotateArray()
  {
    System.out.println("rotateArray");

    int nRotationDistance = 2;
    {
      int[] aiInput = {1, 2, 3, 4, 5, 6};
      int[] aiExpected = {5, 6, 1, 2, 3, 4};
      int[] aiResult = RotateArray.rotateArray(aiInput, nRotationDistance);
      assertArrayEquals(aiExpected, aiResult);
    }

    nRotationDistance = -3;
    {
      int[] aiInput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      int[] aiExpected = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
      int[] aiResult = RotateArray.rotateArray(aiInput, nRotationDistance);
      assertArrayEquals(aiExpected, aiResult);
    }

    System.out.println("The unit tests passed.");
  }

  public static void main(String[] args)
  {
    RotateArrayTest test = new RotateArrayTest();
    test.testRotateArray();
  }
}
