package ch17.e;

// 기존의 정렬 클래스처럼 동일한 방법으로 사용하려면
// Sorter를 상속 받아 같은 타입으로 묶여야 한다.
// 그래서 Sorter를 상속 받았다.
//
public class MergeSort extends Sorter {
  
  // Sorter에서 상속 받은 메서드가 추상 메서드이기 때문에
  // 이 서브 클래스는 반드시 구현해야 한다.
  
  @Override
  public void sort(int[] values) {
    sort(values, 0, values.length-1);
  }
  void merge(int arr[], int l, int m, int r) 
  { 
    int n1 = m - l + 1; 
    int n2 = r - m; 

    int L[] = new int [n1]; 
    int R[] = new int [n2]; 

    for (int i=0; i<n1; ++i) 
      L[i] = arr[l + i]; 
    for (int j=0; j<n2; ++j) 
      R[j] = arr[m + 1+ j]; 

    int i = 0, j = 0; 

    int k = l; 
    while (i < n1 && j < n2) 
    { 
      if (L[i] <= R[j]) 
      { 
        arr[k] = L[i]; 
        i++; 
      } 
      else
      { 
        arr[k] = R[j]; 
        j++; 
      } 
      k++; 
    } 

    while (i < n1) 
    { 
      arr[k] = L[i]; 
      i++; 
      k++; 
    } 

    while (j < n2) 
    { 
      arr[k] = R[j]; 
      j++; 
      k++; 
    } 
  } 

  void sort(int arr[], int l, int r) 
  { 
    if (l < r) 
    { 
      int m = (l+r)/2; 
      sort(arr, l, m); 
      sort(arr , m+1, r); 
      merge(arr, l, m, r); 
    } 
  } 
}
