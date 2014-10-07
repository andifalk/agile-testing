package tdd.samples.rules;

public interface MyService {
	String operationA(String value) throws MyExceptionA;
	String operationB(String value) throws MyExceptionB;
	String operationC(String value) throws MyExceptionC;
}
