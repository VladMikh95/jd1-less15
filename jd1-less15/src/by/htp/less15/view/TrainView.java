package by.htp.less15.view;

import java.util.List;

import by.htp.less15.bean.Train;

public class TrainView {

	public void print(Train train) {
		System.out.print("TRAIN: " + train.getNumber() + " " + train.getDestinationStation() 
				+  " " + train.getDate() + "\n");
	}

	public void print(List<Train> trains) {
		for (Train train : trains) {
			print(train);
		}

	}

}
