
abstract class State
{
	public abstract void WriteProgram(Work w);

}

class Work{
	private State current;
	public Work(){
		current = new ForenoonState();
	}
	private double hour;
	public double getHour()
	{
		return hour;

	};
	
	public void setHour(double h)
	{
		hour = h;
	};
	
	
	private boolean finish = false;
	
	public boolean GetTaskFinishedState()
	{
		return finish;
	}
	
	public void SetTaskFinishedState(boolean f)
	{
		finish = f;
	}
	
	
	public void SetState(State s)
	{
		current = s;
	}
	
	public void WriteProgram()
	{
		current.WriteProgram(this);
	}
	
}


class ForenoonState extends State{
	public  void WriteProgram(Work w)
	{
		if(w.getHour()<12){
			System.out.print("��ǰʱ�䣺"+w.getHour()+" �㣬���繤��������ٱ�\n");
		}
		else{
			w.SetState(new NoonState());w.WriteProgram();
		}
	}
}



class NoonState extends State{
	public  void WriteProgram(Work w)
	{
		if(w.getHour()<13){
			System.out.print("��ǰʱ�䣺"+w.getHour()+" �㣬���ˣ��緹������������;\n");
		}
		else{
			w.SetState(new AfternoonState());w.WriteProgram();
		}
	}
}


class AfternoonState extends State{
	public  void WriteProgram(Work w)
	{
		if(w.getHour()<17){
			System.out.print("��ǰʱ�䣺"+w.getHour()+" �㣬����״̬����������Ŭ��\n");
		}
		else{
			w.SetState(new EveningState());w.WriteProgram();
		}
	}
}


class EveningState extends State{
	public  void WriteProgram(Work w)
	{
		if(w.GetTaskFinishedState())
		{
			w.SetState(new RestState());w.WriteProgram();
		}
		else
		{
			if(w.getHour()<21){
				System.out.print("��ǰʱ�䣺"+w.getHour()+" �㣬�Ӱ�Ŷ��ƣ��֮��\n");
			}
			else{
				w.SetState(new SleepingState());w.WriteProgram();
			}
		}
	}
}


class SleepingState extends State{
	public  void WriteProgram(Work w)
	{
		System.out.print("��ǰʱ�䣺"+w.getHour()+" �㣬�����ˣ�˯����\n");
	}
}


class RestState extends State{
	public  void WriteProgram(Work w)
	{
		System.out.print("��ǰʱ�䣺"+w.getHour()+" �°�ؼ���\n");
	}
}
public class StateTest{

public static void main(String[] args){
	Work emergencyProjects = new Work();
	emergencyProjects.setHour(9);
	emergencyProjects.WriteProgram();
	emergencyProjects.setHour(10);
	emergencyProjects.WriteProgram();
	emergencyProjects.setHour(12);
	emergencyProjects.WriteProgram();
	emergencyProjects.setHour(13);
	emergencyProjects.WriteProgram();
	emergencyProjects.setHour(14);
	//emergencyProjects.WriteProgram();
	emergencyProjects.setHour(17);


	//emergencyProjects.SetTaskFinishedState(true);
	emergencyProjects.SetTaskFinishedState(false);
	emergencyProjects.WriteProgram();
	emergencyProjects.setHour(19);
	emergencyProjects.WriteProgram();
	emergencyProjects.setHour(22);
	emergencyProjects.WriteProgram();
	
	
}

}

