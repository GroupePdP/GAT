package test;

import org.junit.Before;
import org.junit.Test;
import core.*;
import static org.junit.Assert.assertEquals;

public class PasswordTest {
	
	String pass1, pass2, pass3, pass4;
	String encrypt1,encrypt2,encrypt3,encrypt4;
	String decrypt1,decrypt2,decrypt3,decrypt4;
	

	@Before
	public void initialize() {
		
		pass1 = "eignozigzegnizgz";
		pass2 = "" + Math.random();
		pass3 = "Afeinef454AIfe";
		pass4 = "eignenéàç" + Math.random();
		
		encrypt1 = PasswordManager.encrypt(pass1);
		encrypt2 = PasswordManager.encrypt(pass2);
		encrypt3 = PasswordManager.encrypt(pass3);
		encrypt4 = PasswordManager.encrypt(pass4);
		
		decrypt1 = PasswordManager.decrypt(encrypt1);
		decrypt2 = PasswordManager.decrypt(encrypt2);
		decrypt3 = PasswordManager.decrypt(encrypt3);
		decrypt4 = PasswordManager.decrypt(encrypt4);
		
		
		
		
	}
	
	@Test
	public void testMdp1(){
		assertEquals(pass1, decrypt1);		
	}
	
	@Test
	public void testMdp2(){
		assertEquals(pass2, decrypt2);	
	}
	
	@Test
	public void testMdp3(){
		assertEquals(pass3, decrypt3);	
	}
	
	@Test
	public void testMdp4(){
		assertEquals(pass3, decrypt3);	
	}

}
