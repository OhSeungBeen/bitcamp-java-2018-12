package ch17.c;

public class QuickSort extends Sorter{
  @Override
  public void sort(int[] values) {
    start(values, 0, values.length-1);
  }
  
  private int partition(int[] arr, int low, int high) 
  { 
      int pivot = arr[high];  
      int i = (low-1); 
      for (int j=low; j<high; j++) 
      {  
          if (arr[j] <= pivot) 
          { 
              i++; 
 
              int temp = arr[i]; 
              arr[i] = arr[j]; 
              arr[j] = temp; 
          } 
      } 

      int temp = arr[i+1]; 
      arr[i+1] = arr[high]; 
      arr[high] = temp; 

      return i+1; 
  } 
  
  private void start(int[] arr, int low, int high) {
    if (low < high) 
    { 

        int pi = partition(arr, low, high); 

        start(arr, low, pi-1); 
        start(arr, pi+1, high); 
    } 
  }
}
