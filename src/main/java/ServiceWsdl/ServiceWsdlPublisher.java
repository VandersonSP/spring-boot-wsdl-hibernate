package ServiceWsdl;

import javax.xml.ws.Endpoint;
import ServiceWsdl.ServiceWsdlImpl;

public class ServiceWsdlPublisher {

	public static void main(String[] args){

		Endpoint.publish(
				"http://localhost:9000/ws/insert", new ServiceWsdlImpl());
		System.out.println(
				"\nWeb service published @ http://localhost:9000/ws/insert");
		System.out.println("You may call the web service now");
	}
}