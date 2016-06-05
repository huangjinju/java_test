
class adaptee {
	public void specrequest(){
		System.out.print("���⹦�ܵ�����\n");	
	}
}

interface target {
	void request();
	
};

class ConcreteTarget implements target
{
	public void request()
	{
		System.out.print("��ͨ���ܵ�����\n");
	}
};
/*
class Adapter extends adaptee implements target{
	public void request()
	{
		super.specrequest();
	}
}





public class adapter_main{
	public static void main(String[] args){
		//ʹ����ͨ����
		target comm_target = new ConcreteTarget();
		comm_target.request();
		
		//ʹ�����⹦��
		target spe_adapter = new Adapter();
		spe_adapter.request();
		
		return ;
	}
}

*/


class Adapter implements target {
	private adaptee m_adaptee ;
	
	public Adapter(adaptee my_adaptee){
		m_adaptee = my_adaptee;
	}
	
	public void request(){
		m_adaptee.specrequest();
	}
	
}



public class adapter_main{
	public static void main(String[] args){
		target com_target = new ConcreteTarget();
		com_target.request();
		
		target  spe_target = new Adapter(new adaptee());
		spe_target.request();
		
		
	}
	
}





