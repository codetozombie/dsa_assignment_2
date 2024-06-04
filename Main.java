public class Main {

  public static void main(String[] args) {
    System.out.println("Hello World");

    int[] A = {1,2,2,3,3,4,4,4};
    int max = findMax(A); // Call the findMax function

    System.out.println("The maximum element is: " + max);
    boolean unique = UniqueElements(A);
    System.out.println(unique);
  }

  public static int findMax(int[] arr) {
    if (arr.length == 0) {
      throw new IllegalArgumentException("Array cannot be empty");
    }
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
    }
    return max;
  }
  public static boolean UniqueElements(int[] A) {
    for (int i = 0; i < A.length - 1; i++) {
        for (int j = i + 1; j < A.length; j++) {
            if (A[i] == A[j]) {
                return false;
            }
        }
    }
    return true;
}


 
}
