package paquete;
import java.util.Scanner;

public interface Cliente{
	
	//Declaraciones.
	Scanner sc = new Scanner(System.in);
	String mensaje = "";
	
	//Solicita los datos del cliente para enviárselos al servidor.
	public String LogIn();
	//Cierre de sesión
	public String LogOut();
	//Una de las operaciones a implementar
	public String Operacion1();
	//Otra de las operaciones a implementar
	public String Operacion2();
	//Envía datos al servidor.
	public String Enviar(String mensaje);
	//Recive datos del servidor.
	public void Recivir(String datos);
}