package by.htp.less15.view;

import java.util.ArrayList;
import java.util.List;

import by.htp.less15.bean.Date;
import by.htp.less15.bean.Train;

public class TrainConsoleInput {

	public List<Train> create() {
		List<Train> trains = new ArrayList<Train>();
		
		Train tr = new Train(123, "Minsk", new Date(2020,2,12,12,12));
		trains.add(tr);
		
		tr = new Train(455, "Moskva", new Date(2020,2,14,12,12));
		trains.add(tr);
		
		tr = new Train(12, "Mogilev", new Date(2020,2,12,12,12));
		trains.add(tr);
		
		tr = new Train(346, "Moskva", new Date(2020,2,12,23,12));
		trains.add(tr);
		
		tr = new Train(498, "Mogilev", new Date(2020,2,12,12,20));
		trains.add(tr);
		

		
		return trains;
		
	}

}
