
//ִ������Ľӿ�
interface Command {
	void execute();
}

//���������
class Tv{
	public int currentChannel = 0;
	void trunOn(){
		System.out.print("The television is on.\n");
	}
	void trunOff(){
		System.out.print("The television is off.\n");
	}
	void changeChannel(int channel){
		currentChannel=channel;
		System.out.print("Now TV channel is  "+ channel);
	}
}

//��������
class CommandOn implements Command{
	private Tv myTv;
	public CommandOn(Tv tv)
	{
		myTv = tv;
	}
	public void execute(){
		myTv.trunOn();
	}
}

//��������
class CommandOff implements Command{
	private Tv myTv;
	public CommandOff(Tv tv)
	{
		myTv = tv;
	}
	public void execute(){
		myTv.trunOff();
	}
}

//�л�Ƶ������
class CommandChange implements Command{
	private Tv myTv;
	private int channel;
	public  CommandChange(Tv tv,int channel)
	{
		myTv = tv;
		this.channel = channel;
	}
	public void execute(){
		myTv.changeChannel(this.channel);;
	}
}

//ң����,���Կ�����invoker
class Control{
	private Command onCom,offCom,changeCom;
	public Control(Command on,Command off,Command channel){
		onCom = on;
		offCom = off;
		changeCom = channel;
	}
	
	public void TurnOn()
	{
		onCom.execute();
	}
	
	public void TurnOff()
	{
		offCom.execute();
	}
	
	
	public void changeChannel()
	{
		changeCom.execute();
	}
}

public class command_test{
	
	public static void main(String[] args)
	{
		Tv my_tv = new Tv();
		CommandOn on  = new CommandOn(my_tv);
		CommandOff off  = new CommandOff(my_tv);
		CommandChange change = new CommandChange(my_tv,2);
		Control control1 = new Control(on,off,change);
		control1.TurnOn();
		control1.TurnOff();
		control1.changeChannel();
	}
	
	
//	control1 = 1;
	
}


