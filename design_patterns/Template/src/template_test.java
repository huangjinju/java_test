abstract class AbstractPerson{
	public void perpareGotoSchool(){
		dressUp();
		eatBreakfast();
		takeThings();
	}
	protected abstract void dressUp();
	protected abstract void eatBreakfast();
	protected abstract void takeThings();
}

class Student extends AbstractPerson{
	protected void dressUp(){
		System.out.print("穿校服\n");
	}
	
	protected void eatBreakfast(){
		System.out.print("吃妈妈做好的早饭\n");
	}
	
	protected void takeThings(){
		System.out.print("背上书包，带上家庭作业以及红领巾\n");
	}
	
}

class Teacher extends AbstractPerson{
	protected void dressUp(){
		System.out.print("穿工作服\n");
	}
	
	protected void eatBreakfast(){
		System.out.print("做早饭，照顾孩子吃早饭\n");
	}
	
	protected void takeThings(){
		System.out.print("带上昨晚准备的考卷\n");
	}
}

public class template_test {
	public static void main(String[] args){
		
		AbstractPerson student = new Student();
		student.perpareGotoSchool();
				
		AbstractPerson teacher = new Teacher();
		teacher.perpareGotoSchool();
		

		
	}
	
}




