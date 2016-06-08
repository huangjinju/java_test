interface SalesPromotionStrategy{			//��������
	void SpStrategy(); 
	
}

class SpStrategy50  implements SalesPromotionStrategy{					//5�۴�������
	public void SpStrategy()
	{
		System.out.print("5�۴�������\n");
	}
}

class SpStrategy70  implements SalesPromotionStrategy{					//7�۴�������
	public void SpStrategy()
	{
		System.out.print("7�۴�������\n");
	}
}

class SpStrategy80  implements SalesPromotionStrategy{					//8�۴�������
	public void SpStrategy()
	{
		System.out.print("8�۴�������\n");
	}
}

class Context {
	SalesPromotionStrategy sps;
	
	public Context(SalesPromotionStrategy cur_sps){
		sps = cur_sps;
	}
	
	public void SpStrategy_do(){
		sps.SpStrategy();
	}
}


public class SalesPromotion{
	public static void main(String[] args)
	{
		System.out.print("�����ǵ�һ��:");	
		Context contest1  = new Context(new SpStrategy50());
		contest1.SpStrategy_do();
		
		System.out.print("�����ǵڶ���:");	
		Context contest2  = new Context(new SpStrategy70());
		contest2.SpStrategy_do();

		System.out.print("�����ǵ�����:");	
		Context contest3  = new Context(new SpStrategy80());
		contest3.SpStrategy_do();
	}
}





