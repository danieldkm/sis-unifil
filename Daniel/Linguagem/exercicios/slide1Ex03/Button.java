package slide1Ex03;

public class Button {
	private String label;
	private String color;
	
	public void setLabel(String label) {
		this.label = label;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String dePress(){
		return "Nao Pressionado";
	}
	
	public String unPress(){
		return "Pressionado";
	}
	
}
