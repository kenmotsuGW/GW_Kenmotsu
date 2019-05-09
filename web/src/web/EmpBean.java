package web;

public class EmpBean {
	private String name = null;
	private int age = 0;

	//ageの値を返す
	public int getAge() {
		return age;
	}
	//ageを引数の値に代入する
	public void setAge(int age) {
		this.age = age;
	}
	//nameの値を返す
	public String getName() {
		return name;
	}
	//nameを引数の値に代入する
	public void setName(String name) {
		this.name = name;
	}
}
