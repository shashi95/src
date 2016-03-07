package org.action.kafka;

public class Singletonmsg {
	
	
	
	private static String doc;
	
	private static Singletonmsg msg = new Singletonmsg();
	
	public static Singletonmsg getInstance()
	{
		return msg;
	}
	
	public String getMsg()
	{
		
		return doc;
	}
	public void setDoc(String doc1)
	{
		this.doc=doc1;
	}

}
