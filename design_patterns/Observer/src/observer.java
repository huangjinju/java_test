import java.util.*;


interface Watcher {
	public void update();
}


class Police implements Watcher {
	public void update(){
		System.out.print("运输车有行动，警察护航\n");
	}
}

class Thief implements Watcher {
	public void update(){
		System.out.print("运输车有行动，强盗准备动手\n");
	}
}

class Security implements Watcher {
	public void update(){
		System.out.print("运输车有行动，保镖请贴身保护\n");
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




