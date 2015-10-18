package paquete;
import java.util.Objects;
import java.util.Scanner;

public class Cliente{
	
	//Declaraciones.
	static Scanner sc = new Scanner(System.in);
	
	//Esto est� solo para hacer pruebas de funcionamiento.
	//public static void main(String[] args){
	
			//System.out.println(Datos());
	//}
	
	//Solicita los datos del cliente para envi�rselos al servidor.
	public static String Datos(){
		
		String datos = "", user = "", pass = "";
		
		System.out.println("Introduzca su usuario");
		user = sc.next();
		System.out.println("Introduzca su clave");
		pass = sc.next();
		datos = user + " " + pass;
		return datos;
	}
	
	//Solicita los n�meros para que los sume el servidor.
	//TODO revisar la entrada y salida de par�metros.
	public static String Suma(){
		
		String suma = "";
		int a = 0, b = 0;
		
		System.out.println("Introduce el primer sumando");
		a = sc.nextInt();
		System.out.println("Introduce el segundo sumando");
		b = sc.nextInt();
		
		//TODO implementar correcci�n de posibles fallos.
		
		suma = Objects.toString(a) + " " + Objects.toString(b);
		return suma;
	}
	
	//Solicita los puntos para que el servidor calcule la ecuaci�n de la recta.
	//TODO revisar la entrada y salida de par�metros.
	public static String Ecuacion(){
		
		String ecuacion = "";
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		
		System.out.println("Introduce la X del primer punto");
		x1 = sc.nextInt();
		System.out.println("Introduce la Y del primer punto");
		y1 = sc.nextInt();
		System.out.println("Introduce la X del segundo punto");
		x2 = sc.nextInt();
		System.out.println("Introduce la Y del segundo punto");
		y2 = sc.nextInt();
		
		//TODO implementar correcci�n de posibles fallos.
		
		ecuacion = Objects.toString(x1) + " " + Objects.toString(y1) + " " + Objects.toString(x2) + " " + Objects.toString(y2);
		return ecuacion;
	}
	
	public static String Eleccion(){
		
		String save = "", eleccion = "";
		
		System.out.println("Elija la funcion de Suma o la de Ecuaci�n de la recta S/E");
		save = sc.next();
		//Si se solicita la funci�n de suma
		if(Objects.equals(save, "S")){
					
			eleccion="SU";
		}
		//Si se solicita la ecuaci�n de la recta.
		if(Objects.equals(save, "E")){
					
			eleccion="EC";
		}
		//Caso de error
		if(Objects.equals(save, "S")==false&&Objects.equals(save, "E")==false){
					
			do{
				//TODO Enviar la decisi�n al servidor.
				System.out.println("Se ha producido un error en la eleccion");
				System.out.println("�Desea volver a intentarlo? S/N");
				save = sc.next();
						
				//Si solicita repetir, se vuelve e llamar a la funci�n para que repita el proceso.
				if(Objects.equals(save, "S")){
							
					
				}
				//Si no quiere se cierra la conexi�n.
				if(Objects.equals(save, "N")){
							
					eleccion="EX";
				}
				//Si hay un error, se repite el bucle hasta que lo soluciones
				if(Objects.equals(save, "S")==false&&Objects.equals(save, "N")==false){
							
					save="error";
				}
			}while(save=="error");
		}
		return eleccion;
	}
	
	public static String Repetir(){
		
		String save = "", repetir = "";
		
		do{
			//TODO Enviar al servidor la respuesta
			System.out.println("�Desea solicitar otra funci�n? S/N");
			save = sc.next();
			
			//Si solicita repetir, se vuelve e llamar a la funci�n para que repita el proceso.
			if(Objects.equals(save, "S")){
				
				repetir=Eleccion();
			}
			//Si no quiere se cierra la conexi�n.
			if(Objects.equals(save, "N")){
				
				repetir="EX";
			}
			//Si hay un error, se repite el bucle hasta que lo soluciones
			if(Objects.equals(save, "S")==false&&Objects.equals(save, "N")==false){
				
				save="error";
			}
		}while(save=="error");
		return repetir;
	}
	
	//Env�a datos al servidor.
	//TODO revisar la entrada y salida de par�metros.
	public static void Enviar(String datos){
		
	}
	
	//Recive datos del servidor.
	//TODO revisar la entrada y salida de par�metros.
	public static void Recivir(String datos){
		
	}
	
	public static void Maquina(){
		
		String estado = "", user = "", pass = "";
		String datos = "";
		String suma = "";
		String ecuacion = "";
		
		switch(estado){
		
		//Aqu� se env�an usuario y clave.
		case "RE":
			
			//TODO Enviar usuario y clave.
			datos = Datos();
			//Si se env�an correctamente:
			estado="AU";
			break;
			
		//Aqu� se espera la comprovaci�n del usuario y la clave.
		case "AU":
			
			//TODO Esperar la aceptaci�n de usuario y clave.
			//Si es correcto
			estado = Eleccion();
			break;
			
		//Tanto en la funci�n de suma como en la de ecuaci�n se podr�a implementar algo que
		//tuviese que ver con la toma de datos de las clases Temperatura y Humedad.
			
		//Se solicita la funci�n de suma.
		case "SU":
			
			//TODO Enviar los n�meros y obtener resultado.
			suma = Suma();
			Repetir();
			break;
			
		//Se solicita la funci�n ecuaci�n de la recta.
		case "EC":
			
			//TODO Enviar los puntos y obtener resultado.
			ecuacion = Ecuacion();
			Repetir();
			break;
			
		//Cierre de la conexi�n.
		case "EX":
			//TODO Cierre de la conexi�n.
			break;
			
		//Caso de error
		default:
			//TODO implementar soluci�n a posibles errores.
			break;
		}
	}
}