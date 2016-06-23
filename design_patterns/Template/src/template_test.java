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
		System.out.print("��У��\n");
	}
	
	protected void eatBreakfast(){
		System.out.print("���������õ��緹\n");
	}
	
	protected void takeThings(){
		System.out.print("������������ϼ�ͥ��ҵ�Լ������\n");
	}
	
}

class Teacher extends AbstractPerson{
	protected void dressUp(){
		System.out.print("��������\n");
	}
	
	protected void eatBreakfast(){
		System.out.print("���緹���չ˺��ӳ��緹\n");
	}
	
	protected void takeThings(){
		System.out.print("��������׼���Ŀ���\n");
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




