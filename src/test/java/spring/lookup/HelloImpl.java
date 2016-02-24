package spring.lookup;


public class HelloImpl implements Hello{
	
	
	private Printer printer;
	
	

	public Printer getPrinter() {
		return printer;
	}



	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	@Override
	public Printer createPrinter(){
		return null;
	}


	@Override
	public Printer sayHello() {
		return printer;
	}

}
