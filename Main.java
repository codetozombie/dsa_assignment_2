import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Select an algorithm to run:");
                System.out.println("1. Maximum Element");
                System.out.println("2. Element Uniqueness");
                System.out.println("3. Matrix Multiplication");
                System.out.println("4. Gaussian Elimination");
                System.out.println("5. Counting Binary");
                System.out.println("6. Factorial");
                System.out.println("7. Tower of Hanoi");
                System.out.println("8. Fibonacci");
                System.out.println("9. Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Maximum Element
                        System.out.println("Enter the number of elements:");
                        int n1 = scanner.nextInt();
                        double[] array1 = new double[n1];
                        System.out.println("Enter the elements:");
                        for (int i = 0; i < n1; i++) {
                            array1[i] = scanner.nextDouble();
                        }
                        System.out.println("Maximum element: " + MaxElement.maxElement(array1));
                        break;

                    case 2:
                        // Element Uniqueness
                        System.out.println("Enter the number of elements:");
                        int n2 = scanner.nextInt();
                        double[] array2 = new double[n2];
                        System.out.println("Enter the elements:");
                        for (int i = 0; i < n2; i++) {
                            array2[i] = scanner.nextDouble();
                        }
                        System.out.println("Elements are unique: " + UniqueElements.uniqueElements(array2));
                        break;

                    case 3:
                        // Matrix Multiplication
                        System.out.println("Enter the size of the matrices (n x n):");
                        int n3 = scanner.nextInt();
                        double[][] A = new double[n3][n3];
                        double[][] B = new double[n3][n3];
                        System.out.println("Enter the elements of matrix A:");
                        for (int i = 0; i < n3; i++) {
                            for (int j = 0; j < n3; j++) {
                                A[i][j] = scanner.nextDouble();
                            }
                        }
                        System.out.println("Enter the elements of matrix B:");
                        for (int i = 0; i < n3; i++) {
                            for (int j = 0; j < n3; j++) {
                                B[i][j] = scanner.nextDouble();
                            }
                        }
                        double[][] C = MatrixMultiplication.matrixMultiplication(A, B);
                        System.out.println("Resultant matrix C:");
                        for (double[] row : C) {
                            for (double val : row) {
                                System.out.print(val + " ");
                            }
                            System.out.println();
                        }
                        break;

                    case 4:
                        // Gaussian Elimination
                        System.out.println("Enter the size of the matrix (n x (n+1)):");
                        int n4 = scanner.nextInt();
                        double[][] matrix = new double[n4][n4 + 1];
                        System.out.println("Enter the elements of the matrix:");
                        for (int i = 0; i < n4; i++) {
                            for (int j = 0; j <= n4; j++) {
                                matrix[i][j] = scanner.nextDouble();
                            }
                        }
                        GaussianElimination.gaussianElimination(matrix);
                        System.out.println("Matrix after Gaussian Elimination:");
                        for (double[] row : matrix) {
                            for (double val : row) {
                                System.out.print(val + " ");
                            }
                            System.out.println();
                        }
                        break;

                    case 5:
                        // Counting Binary
                        System.out.println("Enter a positive decimal integer:");
                        int n5 = scanner.nextInt();
                        System.out.println("Number of binary digits in " + n5 + ": " + BinaryCount.binaryCount(n5));
                        break;

                    case 6:
                        // Factorial
                        System.out.println("Enter a nonnegative integer:");
                        int n6 = scanner.nextInt();
                        System.out.println("Factorial of " + n6 + ": " + Factorial.factorial(n6));
                        break;

                    case 7:
                        // Tower of Hanoi
                        System.out.println("Enter the number of disks:");
                        int n7 = scanner.nextInt();
                        System.out.println("Tower of Hanoi moves:");
                        TowerOfHanoi.towerOfHanoi(n7, 'A', 'B', 'C');
                        break;

                    case 8:
                        // Fibonacci
                        System.out.println("Enter the index of the Fibonacci number to generate:");
                        int n8 = scanner.nextInt();
                        System.out.println("Fibonacci number at index " + n8 + ": " + Fibonacci.fibonacci(n8));
                        break;

                    case 9:
                        // Exit
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }

                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter the correct type of input.");
                scanner.nextLine();  // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}

class MaxElement {
    public static double maxElement(double[] A) {
        double maxval = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > maxval) {
                maxval = A[i];
            }
        }
        return maxval;
    }
}

class UniqueElements {
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
}

class MatrixMultiplication {
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
}

class GaussianElimination {
    public static void gaussianElimination(double[][] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double factor = A[j][i] / A[i][i];
                for (int k = i; k < A[0].length; k++) {
                    A[j][k] -= factor * A[i][k];
                }
            }
        }
    }
}

class BinaryCount {
    public static int binaryCount(int n) {
        int count = 1;
        while (n > 1) {
            count++;
            n /= 2;
        }
        return count;
    }
}

class Factorial {
    public static int factorial(int n) {
        if (n == 0) return 1;
        else return factorial(n - 1) * n;
    }
}

class TowerOfHanoi {
    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk from " + source + " to " + destination);
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }
}

class Fibonacci {
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int nextFib = a + b;
            a = b;
            b = nextFib;
        }
        return b;
    }
}
