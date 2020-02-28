package by.htp.less15.main;

import java.util.List;

import by.htp.less15.bean.Train;
import by.htp.less15.service.TrainLogic;
import by.htp.less15.view.TrainConsoleInput;
import by.htp.less15.view.TrainView;

public class Main {

	public static void main(String[] args) {
		TrainView view = new TrainView();
		TrainConsoleInput input = new TrainConsoleInput();

		TrainLogic logic = new TrainLogic();

		List<Train> trains;
		trains = input.create();

		view.print(trains);

		System.out.println("--------------");

		logic.sortByNumber(trains);

		view.print(trains);
		
		System.out.println("--------------");
		
		logic.sortByStationAndDate(trains);
		
		view.print(trains);

	}

}
