package q2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class LifeGame {

	
	
	
	private static final String message = "Do you want to continue?";



	public void start()
	{
		
		LifeMatrix lifeMatrix = new LifeMatrix(10, 10);
		
		DrawMatrix dm = new DrawMatrix(lifeMatrix);
		
		JFrame app = new JFrame();
		app.add(dm);
		app.setSize(520, 530);
		app.setVisible(true);
		app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

			
		while (true) {
			
			int choice = JOptionPane.showConfirmDialog(null, message);


			switch (choice) {
			
			case 0:
				lifeMatrix.calculateNextGeneration();
				dm.repaint();
				break;

			default:
				System.exit(1);
			

				

			}

		}
		
	}
	
	
	
	public static void main(String[] args)
	{
		new LifeGame().start();
	}
}
