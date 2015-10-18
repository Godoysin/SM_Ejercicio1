package paquete;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Temperatura{
	
	//Declaración de los parametros.
	protected int temperatura;
	
	//Paso de valores a los parámetros.
	public Temperatura(int t){
		
		this.temperatura=t;
	}
	
	//Leo una cadena de bytes y los paso a valores.
	public Temperatura(DataInputStream dis){
		
		try{
			this.temperatura=dis.readInt();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			this.temperatura=0;
			e.printStackTrace();
		}
	}
	
	//Escribe cadael parámetro como 4 bytes.
	public void toByteArray(DataOutputStream dos){
		
		try{
			dos.writeInt(this.temperatura);
		} 
		catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Convierte los datos numéricos en un String.
	public String toString(){
		
		return Integer.toString(temperatura);
	}
}