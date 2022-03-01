package lab10;

public class Main {

	public static void ScalarMatrix(int[][] matrix) {
		//boolean flag = false;
		MultiLinkedList mll = new MultiLinkedList();
			
		// bu kýsýmda matrixi listeye yerleþtiriyorum.
		for (int i = 0; i < matrix.length; i++) { // row
			mll.addNumbertoRow(i);
			for (int j = 0; j < matrix[0].length; j++) { // column
				mll.addNumbertoColumn(i,matrix[i][j]);
			}
		}
		mll.display();

		if(mll.size() == mll.sizeRow() * mll.sizeRow()) { // square matrix olup olmadýðýný kontrol eder.
			if(mll.Scalar()) // diagonal elemanlarý ayný, geri kalan yerlerin de 0 olmasýný kontrol eder
				System.out.println("true");
			else {
				System.out.println("false");
			}
		}
		else { // square matrix deðilse
			System.out.println("Not Square Matrix");
			System.out.println("false");
		}
		
	}
	public static void main(String[] args) {
		
		int[][] matrix = {{55,0,0,0,0},{0,55,0,0,0},{0,0,55,0,0},{0,0,0,55,0},{0,0,0,0,55}};
		int[][] matrix2 = {{18,0,0,0},{0,18,0,0},{0,0,18,0},{0,0,0,18}};
		
		int[][] matrix3 =  {{6,0,0,0,0,0},{0,6,0,0,0,0},{0,0,6,0,0,5},{0,0,0,6,0,0},{0,0,0,0,6,0},{0,0,0,0,0,6}};
		int[][] matrix4 =  {{6,0,0,0,0,0},{0,6,0,0,0,0},{0,0,6,0,0,0},{0,0,0,6,0,0},{0,0,0,0,7,0},{0,0,0,0,0,6}};
		
	
		
		ScalarMatrix(matrix);
		System.out.println();
		ScalarMatrix(matrix2);
		System.out.println();
		ScalarMatrix(matrix3);
		System.out.println();
		ScalarMatrix(matrix4);
	}

}
