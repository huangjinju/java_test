interface SalesPromotionStrategy{			//促销策略
	void SpStrategy(); 
	
}

class SpStrategy50  implements SalesPromotionStrategy{					//5折促销策略
	public void SpStrategy()
	{
		System.out.print("5折促销策略\n");
	}
}

class SpStrategy70  implements SalesPromotionStrategy{					//7折促销策略
	public void SpStrategy()
	{
		System.out.print("7折促销策略\n");
	}
}

class SpStrategy80  implements SalesPromotionStrategy{					//8折促销策略
	public void SpStrategy()
	{
		System.out.print("8折促销策略\n");
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
		System.out.print("现在是第一天:");	
		Context contest1  = new Context(new SpStrategy50());
		contest1.SpStrategy_do();
		
		System.out.print("现在是第二天:");	
		Context contest2  = new Context(new SpStrategy70());
		contest2.SpStrategy_do();

		System.out.print("现在是第三天:");	
		Context contest3  = new Context(new SpStrategy80());
		contest3.SpStrategy_do();
	}
}





