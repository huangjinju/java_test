

abstract class AbstractCar {
	abstract void run();
}

abstract class AbstractRoad {
	AbstractCar a_car;
	void run(){
		
	}
}

abstract class AbstractPeople {
	AbstractRoad a_road;
	void run(){
		
	}
}

class Man extends AbstractPeople {
	void run(){
		System.out.print("男人开着");
		a_road.run();
	}
}

class WoMan extends AbstractPeople {
	void run(){
		System.out.print("女人开着");
		a_road.run();
	}
}


class StreetRoad extends AbstractRoad {
	void run(){
		a_car.run();
		System.out.print("在街道上行驶\n");
	}
}

class SpeedWay extends AbstractRoad {
	void run(){
		a_car.run();
		System.out.print("在高速上行驶\n");
	}
}

class Car extends AbstractCar{
	void run(){
		System.out.print("小汽车");
	}
}

class Bus extends AbstractCar{
	void run(){
		System.out.print("公共汽车");
	}
}


public class bridge {
	public static void main(String[] args){
		AbstractRoad street_road = new StreetRoad();
		street_road.a_car = new Car();
		street_road.run();
		
		AbstractPeople man = new Man();
		AbstractRoad speed_way = new SpeedWay();
		speed_way.a_car = new Bus();
		 man.a_road = speed_way;
		man.run();	
	}
}