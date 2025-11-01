import java.util.Objects;

import enums.Standard;

public class Student {
	
	public Student(int Id, String name,Standard standard)
	{
		this.Id = Id;
		this.name = name;
		this.standard = standard;
		
	}

	private int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Standard getStandard() {
		return standard;
	}
	public void setStandard(Standard standard) {
		this.standard = standard;
	}
	private String name;
	private Standard standard;
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", standard=" + standard + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id, name, standard);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Id == other.Id && Objects.equals(name, other.name) && standard == other.standard;
	}
}
