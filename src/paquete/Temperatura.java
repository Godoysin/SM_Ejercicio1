package paquete;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Temperatura{
	
	//Declaraci�n de los parametros.
	protected int temperatura;
	
	//Paso de valores a los par�metros.
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
	
	//Escribe cadael par�metro como 4 bytes.
	public void toByteArray(DataOutputStream dos){
		
		try{
			dos.writeInt(this.temperatura);
		} 
		catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Convierte los datos num�ricos en un String.
	public String toString(){
		
		return Integer.toString(temperatura);
	}
}