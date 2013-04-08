package core;

public class PasswordManager {

	static private String key = 
			"ioegbnapocnqnuigaepifnaengposqnxojazpcpqcoezjgzjebvozeg";
	static private int[] gap = 
		{12,5,22,3,15,5,12,4,10,2,8,13,17,12,10,15,
		15,23,4,12,8,1,19,1,6,14,8,5,4,7,1,6,22,25,12};

	public static String encrypt (String password){
		char[] passwordEncrypted = new char[2*password.length()];
		int i = 0;
		while (i < password.length()){
			passwordEncrypted[2*i] = (char) (key.charAt(i)-gap[i]);
			passwordEncrypted[2*i+1] = (char) (password.charAt(i)-gap[i]);
			i++;
		}
		return new String(passwordEncrypted);
	}

	public static String decrypt (String passwordEncrypted){
		char [] password = new char[passwordEncrypted.length()/2];
		int i = 0;
		while (i < passwordEncrypted.length()){
			if (i%2 != 0)
				password[i/2] = (char)(passwordEncrypted.charAt(i) + gap[i/2]);
			i++;
		}
		return new String (password);
	}

}

