import java.net.InetSocketAddress; 
public class InetSocket
	{ 
	public static void main(String[] args) 
		{ 
		// Creando una InetSocketAddress con un hostname y puerto 
		InetSocketAddress socketAddress1 = new InetSocketAddress("localhost", 8080); 
		// Creando una InetSocketAddress con una dirección IP y puerto 
		InetSocketAddress socketAddress2 = new InetSocketAddress("192.168.1.1", 5622); 		
		System.out.println("Hostname: " + socketAddress1.getHostName()); 				
		System.out.println("IP: " + socketAddress2.getAddress()); 
		System.out.println("Puerto: " + socketAddress1.getPort()); 
		} 
	}