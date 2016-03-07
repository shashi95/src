package org.action.kafka;

import kafka.javaapi.producer.Producer;

public class Sproducer {
	private static Producer<Integer, String> producer;
	private static Sproducer inst= new Sproducer();
	public void setProducer(Producer<Integer, String> producer)
	{
		this.producer=producer;
	}
	public static Sproducer getInstance()
	{
		return inst;
	}
	
	
	public  Producer<Integer, String> getProducer()
	{
		return this.producer;
	}

}
