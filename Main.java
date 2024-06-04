public class Main {

  public class MaxElement {
    public static double maxElement(double[] A) {
        double maxval = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > maxval) {
                maxval = A[i];
            }
        }
        return maxval;
    }

    public static void main(String[] args) {
        double[] A = {1.2, 3.4, 5.6, 7.8};
        System.out.println("Maximum element: " + maxElement(A));
    }
}

public class UniqueElements {
  public static boolean uniqueElements(double[] A) {
      for (int i = 0; i < A.length - 1; i++) {
          for (int j = i + 1; j < A.length; j++) {
              if (A[i] == A[j]) {
                  return false;
              }
          }
      }
      return true;
  }

  public static void main(String[] args) {
      double[] A = {1.2, 3.4, 5.6, 1.2};
      System.out.println("Elements are unique: " + uniqueElements(A));
  }
}

public class MatrixMultiplication {
  public static double[][] matrixMultiplication(double[][] A, double[][] B) {
      int n = A.length;
      double[][] C = new double[n][n];
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              C[i][j] = 0.0;
              for (int k = 0; k < n; k++) {
                  C[i][j] += A[i][k] * B[k][j];
              }
          }
      }
      return C;
  }

  public static void main(String[] args) {
      double[][] A = {{1, 2}, {3, 4}};
      double[][] B = {{5, 6}, {7, 8}};
      double[][] C = matrixMultiplication(A, B);
      for (double[] row : C) {
          for (double val : row) {
              System.out.print(val + " ");
          }
          System.out.println();
      }
  }
}

public class GaussianElimination {
  public static void gaussianElimination(double[][] A) {
      int n = A.length;
      for (int i = 0; i < n - 1; i++) {
          for (int j = i + 1; j < n; j++) {
              double factor = A[j][i] / A[i][i];
              for (int k = i; k <= n; k++) {
                  A[j][k] -= factor * A[i][k];
              }
          }
      }
  }

  public static void main(String[] args) {
      double[][] A = {{2, 1, -1, 8}, {-3, -1, 2, -11}, {-2, 1, 2, -3}};
      gaussianElimination(A);
      for (double[] row : A) {
          for (double val : row) {
              System.out.print(val + " ");
          }
          System.out.println();
      }
  }
}

 
}
