package by.htp.less15.service;

import java.util.ArrayList;
import java.util.List;

import by.htp.less15.bean.Date;
import by.htp.less15.bean.Train;

public class TrainLogic {

	public Train findTrainByNumber(List<Train> trains, int trainNumber) {

		for (Train train : trains) {
			if (train.getNumber() == trainNumber) {
				return train;
			}
		}
		return null;
	}

	public void sortByNumber(List<Train> trains) {

		for (int i = 0; i < trains.size() - 1; i++) {
			int minTrainNumber = trains.get(i).getNumber();
			int minTrainNumberIndex = i;

			for (int j = i + 1; j < trains.size(); j++) {
				Train currentTrain = trains.get(j);
				
				if(minTrainNumber > currentTrain.getNumber()) {
					minTrainNumber = currentTrain.getNumber();
					minTrainNumberIndex = j;
				}

			}
			
			Train temp1 = trains.get(i);
			Train temp2 = trains.get(minTrainNumberIndex);
			
			trains.set(i, temp2);
			trains.set(minTrainNumberIndex, temp1);	
			
		}
		
	}
	
	public void sortByStation(List<Train> trains) {
		
		for (int i = 0; i < trains.size() - 1; i++) {
			String minNameOfStation = trains.get(i).getDestinationStation();
			int minNameOfStationIndex = i;
			
			for (int j = i + 1; j < trains.size(); j++) {
				Train currentTrain = trains.get(j);
				
				if (minNameOfStation.compareToIgnoreCase(currentTrain.getDestinationStation()) > 0) {
					minNameOfStation = currentTrain.getDestinationStation();
					minNameOfStationIndex = j;
				}
			}
			
			Train temp1 = trains.get(i);
			Train temp2 = trains.get(minNameOfStationIndex);
			
			trains.set(i, temp2);
			trains.set(minNameOfStationIndex, temp1);
		}
	}
	
	public List<Integer> findDublicateStations(List<Train> trains, int from) {
		List<Integer> result = new ArrayList<Integer>();; 
		boolean b = false;
		int start = from;
		
		// цикл находит первый повторяющийся элемент коллекции на участке [from, trains.size() - 1]
		for (int i = from; i < trains.size() - 1; i++) {
			
			if(trains.get(i).getDestinationStation().equals(trains.get(i + 1).getDestinationStation())) {
				start = i;
				result.add(start);
				result.add(start);
				b = true;
				break;
			} 
		}
		
		// оператор возвращает null, если в коллекции в заднном дипазоне отсутствуют дубликаты
		if(!b) {
			return null;
		}
		
		// оператор присваивает элементу коллекции result[1] последний повторяющийся элемент 
		// заданной коллеции равный result[0]
		for (int i = result.get(0); i < trains.size(); i++) {
			if(trains.get(i).getDestinationStation() == trains.get(start).getDestinationStation()) {
				result.set(1,  i);
			}
		}
		return result;
		
	}
	
	/*
	 * метод сортирует заданную коллекцию по дате, используя метод toLong класса Date
	 */
	public void sortByDate(List<Train> trains, int start, int end) {
		for(int i = start; i <= end; i++) {
			Date minDate = trains.get(i).getDate();
			int minDateIndex = i;
			
			for (int j = i + 1; j <= end; j++) {
				Date currentTrainDate = trains.get(j).getDate();
				
				if (toLong(currentTrainDate) < toLong(minDate)) {
					minDate = currentTrainDate;
					minDateIndex = j;
				}
			}
			
			Train temp1 = trains.get(i);
			Train temp2 = trains.get(minDateIndex);
			
			trains.set(i, temp2);
			trains.set(minDateIndex, temp1);
		}
 
	}
	
	public void sortByStationAndDate(List<Train> trains) {
		int start = 0;
		List<Integer> range;
		
		sortByStation(trains);
		range = findDublicateStations(trains, start);
			
		while (range != null) {
			sortByDate(trains, range.get(0), range.get(1));
			start = range.get(1);
			range = findDublicateStations(trains, start + 1);
		}
	}
	
	public long toLong(Date date) {
		long result;
		long step = 100L;
		
		result = date.getYear();
		result = step * result + date.getMonth();
		result = step * result + date.getDay();
		result = step * result + date.getHour();
		result = step * result + date.getMinute();
		return result;
	}
}


