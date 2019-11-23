package q2;

import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel;

public class DrawMatrix extends JPanel {

	private LifeMatrix lifeMatrix;

	public DrawMatrix(LifeMatrix lifeMatrix) {
		
		this.lifeMatrix = lifeMatrix;
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();
		int row = 0;

		for (int i = 0; i <= 450; i += 50) {

			int column = 0;

			for (int j = 0; j <= 450; j += 50) {

				if (this.lifeMatrix.getLifeMatrix()[row][column] == 0) {

					
					g.setColor(Color.BLACK);
					g.fillRect(i, j, width, height);
					g.setColor(Color.GREEN);
					g.drawRect(i, j, width, height);
				

				} else {

					
					g.clearRect(i, j, width, height);
					g.setColor(Color.GREEN);
					g.drawRect(i, j, width, height);
					
				}

				column++;

			}

			row++;

		}

	}



}
