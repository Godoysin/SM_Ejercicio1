package paquete;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Servidor{
	
	static Scanner sc = new Scanner(System.in);
	static List<String> luser = new ArrayList<String>();
	static List<String> lpass = new ArrayList<String>();
	
	//Esta función está implementada solo para hacer pruebas.
	//public static void main(String[] args){
		
		//Hay que llamar las dos primeras funciones para inicializarlas
		//y Datos() da inicio al programa.
		//ListaUsuarios();
		//ListaClave();
		//Datos();
	//}
	
	//Coje el usuario y contraseña.
	//Esta función corresponde al cliente
	//public static void Datos(){
		
		//System.out.println("Introduce tu usuario");
		//user = sc.next();
		//System.out.println("Introduce tu clave");
		//pass = sc.next();
		//Llama a la función que comprueba usuario y clave.
		//Autentificar(user,pass);
	//}
	
	//Comprueba la validez del usuario y clave introducidos
	//comparándolos con la base de datos.
	public static String Autentificar(String user, String pass){
		
		//Funciones locales.
		boolean flag = false;
		String save = "", autentificar = "";
		
		//Utiliza el tamaño de la lista de usuarios para ir recorriendo ambas listas
		//por eso es muy importante que ambas tengan el mismo tamaño.
		for(int i=0;i<luser.size();i++){
			
			//Comprueba que coincidan usuario y clave.
			if(luser.get(i).compareTo(user)==0&&lpass.get(i).compareTo(pass)==0){
				
				//TODO Si la autentificación es exitosa, mostrarlo
				//System.out.println("Éxito en la autentificación");
				//flag impide que entre en la sentencia siguiente.
				flag = true;
				autentificar = Funcion();
			}
		}
		//Si el usuario y la clave están mal entra aquí.
		if(flag == false){
			
			//TODO Indicar que se ha producido un error y obtener respuesta.
			//System.out.println("Se ha producido un error con la autentificación");
			//System.out.println("¿Desea volver a intentarlo? S/N");
			//save = sc.next();
			do{
				//TODO Preguntar al cliente y obtener la respuesta
				//System.out.println("¿Desea solicitar otra función? S/N");
				//save = sc.next();
				
				//Si se solicita repetir la autentificación.
				if(Objects.equals(save, "S")){
					
					//TODO Solicitar el cliente que vuelva a untroducir usuario y clave.
				}
				//Si no quiere, se cierra la conexión.
				if(Objects.equals(save, "N")){
					
					autentificar="EX";
				}
				//Si hay un error, se repite el bucle hasta que lo soluciones
				if(Objects.equals(save, "S")==false&&Objects.equals(save, "N")==false){
					
					save="error";
				}
			}while(save=="error");
		}
		return autentificar;
	}
	
	//TODO apañar esto.
	public static String Funcion(){
		
		String funcion = "";
		String save = "";
		
		//TODO pedir que elija una función y obtener la respuesta.
		//System.out.println("Elija la funcion de Suma o la de Ecuación de la recta S/E");
		//save = sc.next();
		
		//Si se solicita la función de suma
		if(Objects.equals(save, "S")){
			
			funcion="SU";
		}
		//Si se solicita la ecuación de la recta.
		if(Objects.equals(save, "E")){
			
			funcion="EC";
		}
		//Caso de error
		if(Objects.equals(save, "S")==false&&Objects.equals(save, "E")==false){
			
			do{
				//TODO informar al cliente del fallo y obtener su respuesta.
				//System.out.println("Se ha producido un error en la eleccion");
				//System.out.println("¿Desea volver a intentarlo? S/N");
				//save = sc.next();
				
				//Si solicita repetir, se vuelve e llamar a la función para que repita el proceso.
				if(Objects.equals(save, "S")){
					
					Funcion();
				}
				//Si no quiere se cierra la conexión.
				if(Objects.equals(save, "N")){
					
					funcion="EX";
				}
				//Si hay un error, se repite el bucle hasta que lo soluciones
				if(Objects.equals(save, "S")==false&&Objects.equals(save, "N")==false){
					
					save="error";
				}
			}while(save=="error");
		}
		return funcion;
	}
	
	//Función de suma
	public static int Suma(int a, int b){
		
		int suma;
		suma=a+b;
		return suma;
	}
	
	//Funcion ecuacion de la recta
	public static String Ecuacion(int x1, int y1, int x2, int y2){
		
		int pendiente = 0, b = 0;
		String ec = "";
		
		pendiente = ((y2-y1)/(x2-x1));
		b = -pendiente*x1+y1;
		ec = "La ecuación de la recta es: y = "+Objects.toString(pendiente)+"x + "+Objects.toString(b);
		return ec;
	}

	//Base de datos de usuarios.
	public static void ListaUsuarios(){
		
		luser.add("Pepi");
		luser.add("David");
	}
	
	//Base de datos de claves.
	public static void ListaClave(){
		
		lpass.add("123456");
		lpass.add("654321");
	}
	
	//Añadir usuario y clave
	public static void Añadir(){
		
		System.out.println("Introduce el usuario");
		luser.add(sc.next());
		System.out.println("Introduce la clave");
		lpass.add(sc.next());
	}
	
	public static String Repetir(){
		
		String save = "", repetir = "";
		
		do{
			//TODO Preguntar al cliente y obtener la respuesta
			//System.out.println("¿Desea solicitar otra función? S/N");
			//save = sc.next();
			
			//Si solicita repetir, se vuelve e llamar a la función para que repita el proceso.
			if(Objects.equals(save, "S")){
				
				repetir=Funcion();
			}
			//Si no quiere se cierra la conexión.
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
	
	//Envía datos al cliente
	//TODO revisar la entrada y salida de parámetros.
	public static void Enviar(String datos){
			
	}
		
	//Recive datos del cliente.
	//TODO revisar la entrada y salida de parámetros.
	public static void Recivir(String datos){
			
	}
	
	//Maquina de estados
	//TODO hay que implementar todo el tema de envío y recepción de datos entre servidor y cliente.
	public static void Maquina(){
		
		String estado = "", user = "", pass = "";
		int a = 0, b = 0;
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		
		switch(estado){
		
		//Aquí se reciben los datos de usuario y clave.
		case "RE":
			
			//TODO Solicitar al cliente usuario y contraseña y obtener los resultados.
			//Si se reciven correctamente:
			estado="AU";
			break;
			
		//Aquí se comprueba que el usuario y la clave sean correctos.
		case "AU":
			
			estado=Autentificar(user,pass);
			break;
			
		//Tanto en la función de suma como en la de ecuación se podría implementar algo que
		//tuviese que ver con la toma de datos de las clases Temperatura y Humedad.
			
		//Se solicita la función de suma.
		case "SU":
			
			//TODO Solicitar los números y mostrar resultado.
			Suma(a,b);
			estado=Repetir();
			break;
			
		//Se solicita la función ecuación de la recta.
		case "EC":
			
			//TODO Solicitar los puntos y mostrar resultado.
			Ecuacion(x1,y1,x2,y2);
			estado=Repetir();
			break;
			
		//Cierre de la conexión.
		case "EX":
			//TODO Cierre de la conexión.
			break;
			
		//Caso de error
		default:
			//TODO implementar solución a posibles errores.
			break;
		}
	}
}