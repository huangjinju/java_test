import java.util.*;


interface Watcher {
	public void update();
}


class Police implements Watcher {
	public void update(){
		System.out.print("���䳵���ж������커��\n");
	}
}

class Thief implements Watcher {
	public void update(){
		System.out.print("���䳵���ж���ǿ��׼������\n");
	}
}

class Security implements Watcher {
	public void update(){
		System.out.print("���䳵���ж���������������\n");
	}
}

interface Watched {
	public void addWatcher(Watcher w);
	public void delWatcher(Watcher w);
	public void notifyWatcher();
}

class Transporter implements Watched{
	private List<Watcher> list = new ArrayList<Watcher>();

	
	public void addWatcher(Watcher w){
		list.add(w);
	}
	
	public void delWatcher(Watcher w){
		list.remove(w);
	}
	
	public void notifyWatcher(){
		for(Watcher wt : list){
			wt.update();
		}
	}
}

public class observer{
	public static void main(String[] args){
		Transporter transporter  = new Transporter();
		Police  police = new Police();
		Thief thief = new Thief();
		Security security = new Security();
		
		transporter.addWatcher(police);
		transporter.addWatcher(thief);
		transporter.addWatcher(security);
		
		transporter.notifyWatcher();
		
	}
}




