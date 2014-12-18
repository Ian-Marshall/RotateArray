package com.gmail.uk.ianmarshall.odesk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateArray
{
  /**
   * Rotates the elements in the given array by the given distance.
   * <br/>
   * This method is the technical test's required "function".
   * @param nRotationDistance
   *   The distance by which the array supplied is to be rotated.
   * @param aiValues
   *   An <code>int</code> array of integers which is to be rotated.
   *   If this is <code>null</code> then <code>null</code> will be returned.
   *   If this is empty then an empty array will be returned.
   * @return
   * A copy of the given array rotated by the given distance.
   */
  public static int[] rotateArray(int[] aiValues, int nRotationDistance)
  {
    int[] aiResult = null;

    if (aiValues != null)
    {
      aiResult = new int[aiValues.length];

      if (aiValues.length > 0)
      {
        List<Integer> liValues = new ArrayList<>(aiValues.length);
        for (int i = 0; i < aiValues.length; i++)
          liValues.add(Integer.valueOf(aiValues[i]));

        Collections.rotate(liValues, nRotationDistance);

        for (int i = 0; i < liValues.size(); i++)
          aiResult[i] = liValues.get(i).intValue();
      }
    }

    return aiResult;
  }

  public static void main(String[] args)
  {
    List<Integer> liArgs = parseParameters(args);

    // Extract the rotation distance
    int nRotationDistance = liArgs.get(0).intValue();
    liArgs.remove(0);

    // Extract the integer array from the remaining list elements
    int[] aiValues = new int[liArgs.size()];
    for (int i = 0; i < liArgs.size(); i++)
      aiValues[i] = liArgs.get(i).intValue();

    // Do the rotation using the public method
    int[] aiRotated = rotateArray(aiValues, nRotationDistance);

    System.out.println(String.format("Rotation distance = %d.",
     nRotationDistance));

    System.out.println(String.format("Input array   = %s.",
     Arrays.toString(aiValues)));

    System.out.println(String.format("Rotated array = %s.",
     Arrays.toString(aiRotated)));
  }

  /**
   * Extract integers from the parameter and return them as an (ordered) list.
   * The 1st parameter is the array rotation value.
   * The remaining parameters make up the integer array to be rotated.
   * @param args
   *   A string array containing an ordered list of integers.
   * @return
   *   An (ordered) list of integers.
   */
  private static List<Integer> parseParameters(String[] args)
  {
    ArrayList<Integer> liResult = new ArrayList<Integer>(args.length);

    if (args.length < 2)
    {
      System.err.format("Usage: I need at least 2 parameters:"
       + "%n 1:    an integer,"
       + " which is the number of positions the array is to be rotated."
       + "%n 2...: at least one integer,"
       + " which numbers represent the array to be rotated.%n");
      System.exit(1);
    }

    for (String s: args)
    {
      try
      {
        int n = Integer.parseInt(s);
        liResult.add(Integer.valueOf(n));    // I know: we could use auto boxing
      }
      catch (NumberFormatException e)
      {
        System.err.println("Error: All parameters must be integer.");
        throw e;
      }
    }

    return liResult;
  }
}
