package paquete;
import java.util.Scanner;

public interface Cliente{
	
	//Declaraciones.
	Scanner sc = new Scanner(System.in);
	String mensaje = "";
	
	//Solicita los datos del cliente para envi�rselos al servidor.
	public String LogIn();
	//Cierre de sesi�n
	public String LogOut();
	//Una de las operaciones a implementar
	public String Operacion1();
	//Otra de las operaciones a implementar
	public String Operacion2();
	//Env�a datos al servidor.
	public String Enviar(String mensaje);
	//Recive datos del servidor.
	public void Recivir(String datos);
}