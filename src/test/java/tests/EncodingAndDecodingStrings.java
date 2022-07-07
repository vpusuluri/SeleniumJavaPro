package tests;

import org.apache.commons.codec.binary.Base64;

public class EncodingAndDecodingStrings 
{

	public static void main(String[] args)
	{
		String str = "test123";
		byte[] encodedString= Base64.encodeBase64(str.getBytes());
		System.out.println("Encoded String = "  + new String(encodedString));
		
		byte[] decodeString= Base64.decodeBase64(encodedString);
		System.out.println("Decode String = " + new String(decodeString));

	}

}

