import controller.DestinationController;
import controller.VacationController;
import entity.Destination;
import entity.Vacation;
import gui.MainWindow;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGui();
			}
		}) ;

//		Destination destination = new Destination(0, "California");
//		Vacation vacation = new Vacation(0, "SF and LA", 2000, 14, "fun", 10, destination);
//		DestinationController destinationController = new DestinationController();
//		VacationController vacationController = new VacationController();
//
//		destinationController.CreateDestination(destination.getDestination_id(), destination.getDestinationName());
//		vacationController.createVacation(0, "SF and LA", 2000, 14, "fun", 10, destination);
	}

	public static void runGui() {

		MainWindow mainWindow = new MainWindow();
		JFrame frame = new JFrame("My First GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(mainWindow.getMainPanel());
		frame.pack();
		frame.setVisible(true);
		mainWindow.getMainPanel().setVisible(true);

	}
}
