package paquete;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Mensaje{
	
	protected static int secuencia;
	private String mensaje = "";
	private Temperatura data1 = null;
	private Humedad data2 = null;
	protected int secuenciaRecibida = 0;
	
	//Crea un mensaje a partir de valos de temperatura y humedad y 
	//les asigna una secuencia numérica.
	public Mensaje(int t, double h){
		
		mensaje=Integer.toString(secuencia)+" "+Integer.toString(t)+" "+Double.toString(h);
		secuencia++;
	}
	
	//Pasa los datos a un Array de bytes.
	public byte[] toByteArray(){
		
		//Esta clase crea un stream de salida en el que los datos se escriben
		//en forma de bytes.
		ByteArrayOutputStream bos = new ByteArrayOutputStream(5);
		//Esta clase permite escribir tipos primitivos de Java como stream de salida.
		DataOutputStream dos = new DataOutputStream(bos);
		try{
			
			dos.writeInt(secuencia);
			data1.toByteArray(dos);
			data2.toByteArray(dos);
			dos.close();
			return bos.toByteArray();
		} 
		catch(IOException e){
			
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Mensaje(String datos, byte[] bytedata){
		
		//Permite leer los bytes del stream.
		ByteArrayInputStream bais = new ByteArrayInputStream(bytedata);
		//Permite leer tipos primitivos de Java desde un stream de entrada.
		DataInputStream dis = new DataInputStream(bais);
		try{
			
			this.secuenciaRecibida = dis.readInt();
		}
		catch(IOException ex){
			
		}
		String[] campos = datos.split(" ");
		if(campos.length == 3){
			secuenciaRecibida = Integer.parseInt(campos[0]);
			data1 = new Temperatura(Integer.parseInt(campos[1]));
			data2 = new Humedad(Double.parseDouble(campos[2]));
		}
	}
	
	//Devuelve el mensaje creado.
	public String getMensaje(){
		
		return mensaje;
	}
	
	//Le pasa el valor al mensaje
	public void setMensaje(String mns){
		
		this.mensaje = mns;
	}
}