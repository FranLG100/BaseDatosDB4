package pruebas;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObjectSet os;
		
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				"alumnos.db4o");
				try{
					//almacenarAlumnos(bd);
					muestraAlumnos(bd);
					//borrarAlumnoporNombre(bd, "Juan Gamez");
					//actualizarNotaAlumno(bd, "Emilio Anaya", 10);
				}
				finally{
					bd.close();
				}
				
				
		
	}
	
	
	public static void almacenarAlumnos(ObjectContainer bd){
		alumno a1=new alumno("Juan Gamez", 23, 8.75);
		bd.store(a1);
		System.out.println(a1.getNombre()+" Almacenado");
		alumno a2=new alumno("Emilio Anaya", 24, 6.25);
		bd.store(a2);
		System.out.println(a2.getNombre()+" Almacenado");
		alumno a3=new alumno("Angeles blanco", 26, 7);
		bd.store(a3);
		System.out.println(a3.getNombre()+" Almacenado");
		}
	
	public static void mostrarResultado(ObjectSet res){
		System.out.println("Recuperados "+res.size()+" Objetos");
		while(res.hasNext()){
		System.out.println(res.next());
		}
	}
		
	public static void muestraAlumnos (ObjectContainer bd){
			alumno a=new alumno(null, 0, 0);
			ObjectSet res= bd.queryByExample(a);
			mostrarResultado(res);
		}
	
	public static void borrarAlumnoporNombre(ObjectContainer bd, String nombre){
		ObjectSet res=bd.queryByExample(new alumno(nombre, 0, 0));
		alumno a=(alumno)res.next();
		bd.delete(a);
		muestraAlumnos(bd);
	}
	
	public static void actualizarNotaAlumno(ObjectContainer bd, String nombre, double nota){
		ObjectSet res=bd.queryByExample(new alumno(nombre, 0, 0));
		alumno a=(alumno)res.next();
		a.setNota(nota);
		bd.store(a);
		muestraAlumnos(bd);
		}

}
