public class Matrix {
public static void main(String[] args) {
int [] [] matrix = {{1, 2, 3}, {7, 4, 2}};
for (int i = 0; i < matrix.length; i++) {
for (int j = 0; j < matrix[i].length; j++) {
System.out.print(matrix[i][j] + "\t");
}
System.out.println();
}
}
}
