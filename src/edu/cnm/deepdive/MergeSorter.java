package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.Random;

public class MergeSorter {

  public void sort(int[] data) {
    sort(data, 0, data.length);
  }

  private void sort(int[] data, int from, int to) {
    if (to - from <= 1) {
      return;
    }
    int midpoint = (from + to) / 2;
    sort(data, from, midpoint); // Sort the left pile.
    sort(data, midpoint, to);
    int[] merged = new int[to - from];
    int leftIndex = from;
    int rightIndex = midpoint;
    int mergedIndex = 0;
    while (leftIndex < midpoint && rightIndex < to) {
      if (data[leftIndex] <= data[rightIndex]) {
        merged[mergedIndex++] = data[leftIndex++];
      } else {
        merged[mergedIndex++] = data[rightIndex++];
      }
    }
    for (int i = leftIndex; i < midpoint; i++) {
      merged[mergedIndex++] = data[i];
    }
    for (int i = rightIndex; i < to; i++) {
      merged[mergedIndex++] = data[i];
    }
    System.arraycopy(merged, 0, data, from, to - from);
  }

  public static void main(String[] args) {
    int SIZE = 1000000;
    Random rng = new Random();
    int[] data = new int[SIZE];

    for (int i = 0; i < data.length; i++) {
      data[i] = rng.nextInt(SIZE);
    }

    MergeSorter sorter = new MergeSorter();

    sorter.sort(data, 0, 100);
    System.out.println(Arrays.toString(data));
  }

}
