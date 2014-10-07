package tdd.samples.verification;

public class VerifyObject {
	public void callA() {
		System.out.println("callA");
		callB();
	}
	
	public void callB() {
		System.out.println("callB");
		callC();
		callCWithParam("a", 5);
	}
	
	public void callC() {
		System.out.println("callC");
		// do nothing
	}
	
	public void callCWithParam(String a, int b) {
		System.out.println("callCWithParam");
		// do nothing
	}
	
	
	public void callD() {
		System.out.println("callD");
	}
}
