package MVCPac;

public class MVC_Main {

	public static void main(String[] args) {
		SampleBean sb = new SampleBean();
		System.out.println(sb.getSalary());
		sb.setSalary(10);
		System.out.println(sb.getSalary());
	}

}
