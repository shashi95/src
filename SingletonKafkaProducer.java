package org.action.kafka;
import java.io.BufferedReader;
import java.io.InputStreamReader;
   import java.util.Properties;

   import kafka.javaapi.producer.Producer;
   import kafka.producer.KeyedMessage;
   import kafka.producer.ProducerConfig;

    public class SingletonKafkaProducer {
       private static Producer<Integer, String> producer;
       private static final String topic= "mytopic";

       public void initialize(){
             Properties producerProps = new Properties();
             producerProps.put("metadata.broker.list", "localhost:9092");
             producerProps.put("serializer.class", "kafka.serializer.StringEncoder");
             producerProps.put("request.required.acks", "1");
             ProducerConfig producerConfig = new ProducerConfig(producerProps);
             producer = new Producer<Integer, String>(producerConfig);
             Sproducer sp=Sproducer.getInstance();
             sp.setProducer(producer);
       }
       private static SingletonKafkaProducer kafkap=new SingletonKafkaProducer();
       
       public static SingletonKafkaProducer getInstance()
       {
    	   return kafkap;
       }
       
       public void close()
       {
    	   producer.close();
       }
       public void publishMesssage(String msg2) throws Exception{            
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));               
        while (true){
             System.out.print("Enter message to send to kafka broker (Press 'Y' to close producer): ");
             String msg = null;
             Singletonmsg newmsg = Singletonmsg.getInstance();
             
             String xyz=newmsg.getMsg();
             msg = reader.readLine(); // Read message from console
           //Define topic name and message
             //SinitializeProducer sp=SinitializeProducer.getInstance();
             //producer=sp.getproducer();
             Sproducer sp1=Sproducer.getInstance();
             Producer<Integer, String> pr=sp1.getProducer();
           KeyedMessage<Integer, String> keyedMsg = new KeyedMessage<Integer, String>(topic, msg2);
           producer.send(keyedMsg);           // This publishes message on given topic
          // pr.send(keyedMsg);
          // if("Y".equals(msg2)){ break; }
           System.out.println("--> Message [" + msg2 + "] sent. Check message on Consumer's program console");
         }
         //return;
       }

       public  static void main(String [] args) throws Exception {
             SingletonKafkaProducer kafkaProducer = new SingletonKafkaProducer();
             // Initialize producer
             kafkaProducer.initialize();            
             // Publish message
             kafkaProducer.publishMesssage("hello123");
             //Close the producer
             producer.close();
       }
   }
