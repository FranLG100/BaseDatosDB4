package ie42;

import java.util.ArrayList;
import java.util.HashMap;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Ventas {
	private int codventa;
	private Articulos codarti;
	private Clientes numcli ;
	private int univen;
	private String fecha;
	
	
	public Ventas() {}
	
	public Ventas(int codventa, Articulos codarti, Clientes numcli, int univen, String fecha) {
		super();
		this.codventa = codventa;
		this.codarti = codarti;
		this.numcli = numcli;
		this.univen = univen;
		this.fecha = fecha;
	}

	public int getCodventa() {
		return codventa;
	}

	public void setCodventa(int codventa) {
		this.codventa = codventa;
	}

	public Articulos getCodarti() {
		return codarti;
	}

	public void setCodarti(Articulos codarti) {
		this.codarti = codarti;
	}

	public Clientes getNumcli() {
		return numcli;
	}

	public void setNumcli(Clientes numcli) {
		this.numcli = numcli;
	}

	public int getUniven() {
		return univen;
	}

	public void setUniven(int univen) {
		this.univen = univen;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void insertarVenta(Ventas venta) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				"articulos.db4o");
				try{
					System.out.println(venta.getCodventa()+" Almacenado");
					bd.store(venta);
				}
				finally{
					bd.close();
				}
	}
	
	public void insertarPorDefecto() {
		ArrayList<Ventas> ventas=new ArrayList<Ventas>();
		Articulos ar1 = new Articulos(1,"Mesas", 30, (float)100.5);
		Articulos ar2 = new Articulos(2,"Pupitres", 10, (float)150.7);
		Articulos ar3 = new Articulos(6,"Cuadernos", 100, (float)4.5);
		Clientes cli1 = new Clientes(1,"Antonio Ruiz","Talavera");
		Clientes cli2 = new Clientes(2,"La Alameda S.L.","Talavera");
		Clientes cli6 = new Clientes(15,"Bar Girasol","Oropesa");
		Clientes cli7 = new Clientes(9,"Escuela Mayores","Talavera");
		Ventas v1 = new Ventas (1,ar1,cli1,5,"05/06/2014");
		Ventas v2 = new Ventas (2,ar1,cli2,4,"15/06/2014");
		Ventas v3 = new Ventas (3,ar1,cli6,3,"25/06/2014");
		Ventas v4 = new Ventas (4,ar2,cli6,5,"03/07/2014");
		Ventas v5 = new Ventas (5,ar2,cli7,4,"11/08/2014");
		Ventas v6 = new Ventas (6,ar3,cli1,3,"25/04/2014");
		ventas.add(v1);
		ventas.add(v2);
		ventas.add(v3);
		ventas.add(v4);
		ventas.add(v5);
		ventas.add(v6);
		
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				"articulos.db4o");
				try{
					for (Ventas venta : ventas) {
						System.out.println(venta.getCodventa()+" Almacenado");
						bd.store(venta);
					}
				}
				finally{
					bd.close();
				}
	}
	
	public HashMap<Integer,Ventas> obtenerVentasMap(){
		HashMap<Integer,Ventas> ventas=new HashMap<Integer,Ventas>();
		Ventas venta;
		
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				"articulos.db4o");
		try{
			ObjectSet res=bd.queryByExample(new Articulos(0, null, 0, 0));
			while(res.hasNext()){
				venta=(Ventas)res.next();
				ventas.put(venta.getCodventa(),venta);
				}
			}
				finally{
					bd.close();
				}
			
		return ventas;
	}
	
	public ArrayList<Ventas> obtenerVentas(){
		ArrayList<Ventas> ventas=new ArrayList<Ventas>();
		Ventas venta;
		
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				"articulos.db4o");
		try{
			ObjectSet res=bd.queryByExample(new Ventas(0, null, null, 0, null));
			while(res.hasNext()){
				ventas.add((Ventas)res.next());
				}
			}
				finally{
					bd.close();
				}
			
		return ventas;
	}
	
	@Override
	public String toString() {
		return codventa+" - "+codarti.getCodarti()+" - "+numcli.getNumcli()+" - "+univen+" - "+fecha;
	}
	
}
