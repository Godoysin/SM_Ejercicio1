package paquete;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Humedad{
	
	//Declaración de los parametros.
	protected double humedad;
	
	//Paso de valores a los parámetros.
	public Humedad(double h){
		
		this.humedad=h;
	}
	
	//Leo una cadena de bytes y los paso a valores.
	public Humedad(DataInputStream dis){
		
		try{
			this.humedad=dis.readDouble();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			this.humedad=0;
			e.printStackTrace();
		}
	}
	
	//Escribe el parámetro como 4 bytes.
	public void toByteArray (DataOutputStream dos){
		
		try{
			dos.writeDouble(this.humedad);
		} 
		catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Convierte los datos numéricos en un String.
	public String toString(){
		
		return Double.toString(humedad);
	}
}