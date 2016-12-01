package de.bit.camel.security;

/**
 * 
 * @author Rami TORKHANI
 */
public interface TestValues {
	String EMP_ID_ALICE = "10001";
	
	String EMP_ID_BOB = "10002";
	
    String COMPLETE_RESULT_ALICE = "empId 10001, name Alice, jobTitle Proprete, department , entryDate 01.01.2008";

    String COMPLETE_RESULT_BOB = "empId 10002, name Bob, jobTitle Etat Civil, department IT, entryDate 01.06.2005";
    
    String ENDPOINT = "cxf:bean:EmpInfoService";
}
