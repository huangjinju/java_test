interface PersonBuilder {
	void buildHead();
	void buildBody();
	void buildFoot();
	Person buildPerson();
}


class Person{
	private String head;
	private String body;
	private String foot;
	
	public String getHead(){
		return head;
	}
	
	public void setHead(String head){
		this.head = head;
	}
	
	public String getBody(){
		return body;
	}
	
	public void setBody(String body){
		this.body = body;
	}
	
	public String  getFoot(){
		return foot;
	}
	
	public void setFoot(String foot){
		this.foot = foot;
	}
}

	class Man extends Person {
		public Man(){
			System.out.print("��ʼ��������\n");
		}
	}

	class Woman extends Person{
		public Woman(){
			System.out.print("��ʼ����Ů��\n");
		}
	}

	class Manbuild implements PersonBuilder{
		Person person;
		
		Manbuild(){
			person = new Man();
		}
		
		public void buildHead(){
			person.setHead("�������˵�ͷ\n");
		}
		public void buildBody(){
			person.setBody("�������˵�����\n");
		}
		public void buildFoot(){
			person.setFoot("�������˵Ľ�\n");
		}
		
		public Person buildPerson(){
			return person;
		}
		
	}

	class Womanbuild implements PersonBuilder{
		Person person;
		
		Womanbuild(){
			person = new Woman();
		}
		
		
		public void buildHead(){
			person.setHead("����Ů�˵�ͷ\n");
		}
		public void buildBody(){
			person.setBody("����Ů�˵�����\n");
		}
		public void buildFoot(){
			person.setFoot("����Ů�˵Ľ�\n");
		}
		
		public Person buildPerson(){
			return person;
		}
		
	}

/*director*/
class PersonDirector{
	public Person constructPerson(PersonBuilder pb){
		pb.buildBody();
		pb.buildFoot();
		pb.buildHead();
		return pb.buildPerson();
	}
}
	
public class builder_test {
	public static void main(String[] argv){
		PersonDirector pd = new PersonDirector();
		Person womanPerson =  pd.constructPerson(new Womanbuild());
		Person manPerson = pd.constructPerson(new Manbuild());
	}
	
}





