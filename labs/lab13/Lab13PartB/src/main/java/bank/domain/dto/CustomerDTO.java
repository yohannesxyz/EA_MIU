package bank.domain.dto;


public class CustomerDTO  {

	private String name;

	public CustomerDTO() {
	}

	public CustomerDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
