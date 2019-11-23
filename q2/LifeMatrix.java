package q2;

public class LifeMatrix {

	private int[][] matrix;

	public LifeMatrix(int rows, int columns) {

		this.matrix = new int[rows][columns];
		fillMatrixWithRandomNumbers();
	}
	
	public int[][] getLifeMatrix() {
		return matrix;
	}

	public void setLifeMatrix(int[][] matrix) {
		this.matrix = matrix;
	}


	private void fillMatrixWithRandomNumbers() {

		for (int row = 0; row < this.matrix.length; row++) {

			for (int column = 0; column < this.matrix[row].length; column++) {
				int randomNumber = (int) Math.round(Math.random());
				this.matrix[row][column] = randomNumber;

			}

		}

	}

	public void calculateNextGeneration() {

		int[][] nextGeneration = new int[this.getLifeMatrix().length][this.getLifeMatrix().length];

		for (int i = 0; i < nextGeneration.length; i++) {
			
			for (int j = 0; j < nextGeneration[i].length; j++) {
				
				int howManyNeighboursALive = counter(i, j);
				
				if(howManyNeighboursALive <= 1 || howManyNeighboursALive >= 4)
				{
					nextGeneration[i][j] = 0;
				}
				else if(howManyNeighboursALive == 3)
				{
					nextGeneration[i][j] = 1;
				}
				else
				 nextGeneration[i][j] = this.getLifeMatrix()[i][j];

			}
			
		}

		this.setLifeMatrix(nextGeneration);

	}

	public int counter(int row, int column)
	{

		int counter = 0;

		for (int i = row - 1; i <= row + 1; i++) {
			
			for (int j = column - 1; j <= column + 1; j++) {
				
				try {
					
					if (this.matrix[i][j] == 1 && (i != row || j != column)) {
						
						counter++;
					}
				} 
				catch (ArrayIndexOutOfBoundsException f) {
					
					continue;
					
				}
			}
		}
		return counter;
	}




}
