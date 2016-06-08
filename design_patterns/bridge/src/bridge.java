

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
		System.out.print("���˿���");
		a_road.run();
	}
}

class WoMan extends AbstractPeople {
	void run(){
		System.out.print("Ů�˿���");
		a_road.run();
	}
}


class StreetRoad extends AbstractRoad {
	void run(){
		a_car.run();
		System.out.print("�ڽֵ�����ʻ\n");
	}
}

class SpeedWay extends AbstractRoad {
	void run(){
		a_car.run();
		System.out.print("�ڸ�������ʻ\n");
	}
}

class Car extends AbstractCar{
	void run(){
		System.out.print("С����");
	}
}

class Bus extends AbstractCar{
	void run(){
		System.out.print("��������");
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