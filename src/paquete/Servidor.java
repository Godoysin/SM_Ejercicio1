package paquete;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Servidor{
	
	//Posibles utilidades
	//Scanner sc = new Scanner(System.in);
	//List<String> lista = new ArrayList<String>();
	
	//Declaraciones
	protected String datos = "";
	protected String mensaje = "";
	
	//Maquina de estados
	public void Maquina(){
		
		//Funciones locales
		String estado = "";
		Boolean fin_conex = false, fin = false;
		
		do{
			
			//Lo primero que hago siempre es recibir el mensaje del cliente.
			Recibir(mensaje);
			//y en la primera iteraci�n fuerzo a entrar en el primer estado.
			estado = "Inicio";
			
			do{
				//Inicio de la maquina de estados.
				switch(estado){
				
				//Aqu� se reciben los datos de usuario y clave.
				case "Inicio":
					
					//Lo primero que hago siempre es recibir el mensaje del cliente.
					Recibir(mensaje);
					//TODO Procesar los datos.
					
					//Si el proceso es afirmativo:
					estado="Autentificar";
					break;
						
				//Aqu� se comprueba que el usuario y la clave sean correctos.
				case "Autentificar":
					
					//Lo primero que hago siempre es recibir el mensaje del cliente.
					Recibir(mensaje);
					//TODO Procesar los datos.
					
					if(Autentificar(datos)==true){
						
						//Indicar que ha habido �xito.
						//Se pasa al siguiente estado.
						estado = Elegir();
					}
					else{
						
						//Indicar que ha fallado.
						//Ver si quiere repetir o cerrar sesi�n.
					}
					break;
						
				//Estado del primer servicio.
				case "Servicio1":
					
					Servicio1();
					//Si solicita seguir usando el servidor.
					if(Repetir() == true){
						
						estado = Elegir();
					}
					else{
						
						//Solicita dejar de usar el servidor.
						fin = true;
						fin_conex = true;
					}
					break;
						
				//Estado del segundo servicio.
				case "Servicio2":
					
					Servicio2();
					//Si solicita seguir usando el servidor.
					if(Repetir() == true){
						
						estado = Elegir();
					}
					else{
						
						//Solicita dejar de usar el servidor.
						fin = true;
						fin_conex = true;
					}
					break;
						
				//Caso de error
				default:
					//TODO Implementar soluci�n a posibles errores.
					break;
				}
			//Fin de la m�quina de estados.
			}while(fin=true);
			
		}while(fin_conex=true);
		
	}
	
	//Comprueba la validez del usuario y clave introducidos
	//compar�ndolos con la base de datos.
	public Boolean Autentificar(String datos){
		
		//Funciones locales.
		boolean autentificar = false;
		
		//TODO Procesar los datos.
		
		//Si la autentidicaci�n es afirmativa: autentificar = true;
		//Si la autentidicaci�n es negativa autentificar = false;
		
		return autentificar;
	}
	
	//Esta es la funci�n que regula los servicios que el cliente puede pedir al servidor.
	public String Elegir(){
		
		String funcion = "";
		
		//Lo primero que hago siempre es recibir el mensaje del cliente.
		Recibir(mensaje);
		//TODO Procesar los datos
		
		//Ahora habria que mostrar al cliente la oferta de servicios, pedirle que solicite uno
		//y recibir la respuesta.
		
		return funcion;
	}
	
	//Funci�n del primer servicio
	public void Servicio1(){
		
		//Lo primero que hago siempre es recibir el mensaje del cliente.
		Recibir(mensaje);
		//TODO Procesar los datos.
		
		//En funci�n de lo que se procese, actuar en consecuencia.
	}
	
	//Funci�n del segundo servicio
	public void Servicio2(){
		
		//Lo primero que hago siempre es recibir el mensaje del cliente.
		Recibir(mensaje);
		//TODO Procesar los datos.
			
		//En funci�n de lo que se procese, actuar en consecuencia.
	}
	
	//Esta clase pregunta al cliente si quiere volver a usar el servio, usar otro o salir.
	public Boolean Repetir(){
		
		Boolean repetir = false;
		Boolean error = true;
		
		//No salimos del bucle hasta que tengamos una respuesta satisfactoria.
		do{
			//TODO Preguntamos al cliente que quiere hacer.
			Enviar(datos);
			Recibir(mensaje);
			
			//Si solicita repetir:
			repetir = true;
			error = false;
			
			//Si no quiere se cierra la conexi�n.
			repetir = false;
			error = false;
			
			//Si hay un error, se repite el bucle hasta que se solucione.
			
		}while(error = true);
		return repetir;
	}
	
	//Env�a datos al cliente
	//TODO revisar la entrada y salida de par�metros.
	public void Enviar(String datos){
			
	}
		
	//Recive datos del cliente.
	//TODO revisar la entrada y salida de par�metros.
	public void Recibir(String mensaje){
		
		this.datos=mensaje;
	}
	
	
}