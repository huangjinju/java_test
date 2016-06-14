
class SchoolGirl{
	String name;
	SchoolGirl(String her_name){
		name = her_name;
	}
	
}

interface IGiveGift{
	
	 void GiveChocolate();
	 void GiveFlower();
	 void GiveDoll();  //��ż
}


class Pursuer  implements IGiveGift {
	
	SchoolGirl mm ;
	
	Pursuer(SchoolGirl school_mm){
		mm = school_mm;
	}
	
	public void GiveChocolate(){
		System.out.print(mm.name+"�����ɿ���\n");
	}
	
	public void GiveFlower(){
		System.out.print(mm.name+"�����ʻ�\n");
	}
	
	public void GiveDoll(){
		System.out.print(mm.name+"������ż\n");
	}
}

class Proxy  implements IGiveGift{
	Pursuer gg;
	
	Proxy(SchoolGirl mm){
		gg = new Pursuer(mm);
	}
	
	public void GiveChocolate(){
		gg.GiveChocolate();
	}
	
	public void GiveFlower(){
		gg.GiveFlower();
	}
	
	public void GiveDoll(){
		gg.GiveDoll();
	}
}

public class proxy_main{
	

	public static void main(String[] args) {
		SchoolGirl mm = new SchoolGirl("lijiaojiao");
		Proxy daili = new Proxy(mm);
		daili.GiveDoll();
		daili.GiveChocolate();
		daili.GiveFlower();
	}

}

