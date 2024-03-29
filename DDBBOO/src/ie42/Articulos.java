package ie42;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import pruebas.alumno;

public class Articulos {
	
	private int codarti;
	private String denom;
	private int stock;
	private float pvp;
	private ArrayList<Ventas> compras;
	
	public Articulos() {}
	
	public Articulos(int codarti, String denom, int stock, float pvp) {
		super();
		this.codarti = codarti;
		this.denom = denom;
		this.stock = stock;
		this.pvp = pvp;
	}

	public int getCodarti() {
		return codarti;
	}

	public void setCodarti(int codarti) {
		this.codarti = codarti;
	}

	public String getDenom() {
		return denom;
	}

	public void setDenom(String denom) {
		this.denom = denom;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	public ArrayList<Ventas> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Ventas> compras) {
		compras = compras;
	}
	
	public int obtenerCompras(HashMap<Integer,Ventas> ventas) {
		compras=new ArrayList<Ventas>();
		ventas.forEach((k,v)->{
			if(v.getCodarti().getCodarti()==this.getCodarti()) {
				compras.add(v);
				}
			});
		//System.out.println("El articulo "+denom+" se ha comprado "+compras.size()+" veces");
		return compras.size();
	}
	
	public int obtenerNArticulosVendidos(HashMap<Integer,Ventas> ventas) {
		int nArticulos=0;
		for (Entry<Integer, Ventas> vent : ventas.entrySet()) {
			if(vent.getValue().getCodarti().codarti==this.codarti) {
				nArticulos+=vent.getValue().getUniven();
				}
			}
		//System.out.println("El articulo "+denom+" se ha comprado "+compras.size()+" veces");
		return nArticulos;
	}
	
	public int obtenerComprasId(HashMap<Integer,Ventas> ventas, int idVenta) {
		int nArticulos=0;
		for (Entry<Integer, Ventas> v : ventas.entrySet()) {
			if(v.getValue().getCodarti().getCodarti()==this.getCodarti() && v.getValue().getCodventa()==idVenta) {
				nArticulos=v.getValue().getUniven();
				}
			}
		//System.out.println("El articulo "+denom+" se ha comprado "+compras.size()+" veces");
		return nArticulos;
	}
	
	public void insertarArticulo(Articulos articulo) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				"articulos.db4o");
				try{
						System.out.println(articulo.getDenom()+" Almacenado");
						bd.store(articulo);
					}
				finally{
					bd.close();
				}
	}
	
	public void insertarPorDefecto() {
		ArrayList<Articulos> articulos=new ArrayList<Articulos>();
		Articulos ar1 = new Articulos(1,"Mesas", 30, (float)100.5);
		Articulos ar2 = new Articulos(2,"Pupitres", 10, (float)150.7);
		Articulos ar3 = new Articulos(6,"Cuadernos", 100, (float)4.5);
		Articulos ar4 = new Articulos(8,"Tabletas", 10, (float)175.4);
		Articulos ar5 = new Articulos(9,"Boligrafos", 100, (float)3.5);
		Articulos ar6 = new Articulos(10,"Lapiceros", 300, (float)2.5);
		Articulos ar7 = new Articulos(14,"Sillas", 30, (float)120.5);
		Articulos ar8 = new Articulos(16,"Portatil", 25, (float)400.5);
		Articulos ar11 = new Articulos(17,"Espejo bano", 20, (float)100.5);
		Articulos ar21 = new Articulos(18,"Reloj cocina", 10, (float)20.7);
		Articulos ar31 = new Articulos(20,"Tarjetero", 50, (float)14.5);
		Articulos ar41 = new Articulos(22,"Estuches", 110, (float)20.4);
		Articulos ar51 = new Articulos(23,"Libro BD", 10, (float)23.5);
		Articulos ar61 = new Articulos(24,"Tijeras", 30, (float)5.0);
		Articulos ar71 = new Articulos(25,"Cubiertos", 130, (float)10.5);
		Articulos ar81 = new Articulos(26,"Teclado", 25, (float)40.5);
		articulos.add(ar1);
		articulos.add(ar2);
		articulos.add(ar3);
		articulos.add(ar4);
		articulos.add(ar5);
		articulos.add(ar6);
		articulos.add(ar7);
		articulos.add(ar8);
		articulos.add(ar11);
		articulos.add(ar21);
		articulos.add(ar31);
		articulos.add(ar41);
		articulos.add(ar51);
		articulos.add(ar61);
		articulos.add(ar71);
		articulos.add(ar81);
		
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				"articulos.db4o");
				try{
					for (Articulos articulo : articulos) {
						System.out.println(articulo.getDenom()+" Almacenado");
						bd.store(articulo);
					}
				}
				finally{
					bd.close();
				}
	}
	
	public ArrayList<Articulos> obtenerArticulos(){
		ArrayList<Articulos> articulos=new ArrayList<Articulos>();
		Articulos articulo;
		
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				"articulos.db4o");
		try{
			ObjectSet res=bd.queryByExample(new Articulos(0, null, 0, 0));
			while(res.hasNext()){
				articulos.add((Articulos)res.next());
				}
			}
				finally{
					bd.close();
				}
			
		return articulos;
	}
	
	public HashMap<Integer,Articulos> obtenerArticulosMap(){
		HashMap<Integer,Articulos> articulos=new HashMap<Integer,Articulos>();
		Articulos articulo;
		
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				"articulos.db4o");
		try{
			ObjectSet res=bd.queryByExample(new Articulos(0, null, 0, 0));
			while(res.hasNext()){
				articulo=(Articulos)res.next();
				articulos.put(articulo.getCodarti(),articulo);
				}
			}
				finally{
					bd.close();
				}
			
		return articulos;
	}
	
	public void pintarArticulos() {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				"articulos.db4o");
		try{
			ObjectSet res=bd.queryByExample(new Articulos(0, null, 0, 0));
			while(res.hasNext()){
				System.out.println(res.next());
				}
			}
				finally{
					bd.close();
				}
	}
	
	@Override
	public String toString() {
		return codarti+" - "+denom+" - "+stock+" - "+pvp;
	}
	
	public void obtenerDatosArticulos(HashMap<Integer,Ventas> ventasMap, HashMap<Integer,Articulos> articulosMap ) {
		int totalSumaUnive=0;
		int totalSumaVent=0;
		float sumaImporte=0;
		System.out.println("CODARTI – DENOMINACION – STOCK – PVP – SUMA_UNIVEN – SUMA_IMPORTE – NUM_VENTAS");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		for (Entry<Integer, Articulos> art : articulosMap.entrySet()) {
			totalSumaUnive+=art.getValue().obtenerNArticulosVendidos(ventasMap);
			totalSumaVent+=art.getValue().obtenerCompras(ventasMap);
			sumaImporte+=art.getValue().obtenerCompras(ventasMap)*art.getValue().getPvp();
			
			System.out.println(art.getValue().toString()+" - "+
			art.getValue().obtenerNArticulosVendidos(ventasMap)+" - "+
			art.getValue().obtenerNArticulosVendidos(ventasMap)*art.getValue().getPvp()+" - "+
			art.getValue().obtenerCompras(ventasMap));
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("TOTAL SUMA_UNIVEN: "+totalSumaUnive);
		System.out.println("TOTAL SUMA_IMPORTE: "+sumaImporte);
		System.out.println("TOTAL NUM_VENTAS: "+totalSumaVent);
	}
	
	public void articuloMasVendido(HashMap<Integer,Ventas> ventasMap, HashMap<Integer,Articulos> articulosMap) {
		System.out.println("ARTICULO MAS VENDIDO: ");
		int masComprado=0;
		for (Entry<Integer, Articulos> art : articulosMap.entrySet()) {
			if(art.getValue().obtenerCompras(ventasMap)>masComprado)
				masComprado=art.getValue().obtenerCompras(ventasMap);
		}
		for (Entry<Integer, Articulos> art : articulosMap.entrySet()) {
			if(art.getValue().obtenerCompras(ventasMap)==masComprado)
				System.out.println(art.getValue().getCodarti()+" - "+art.getValue().getDenom()+"    VECES VENDIDO: "+masComprado);
		}
	}
	
	public void mediaPorArticulo(HashMap<Integer,Ventas> ventasMap, HashMap<Integer,Articulos> articulosMap) {
		System.out.println("\n\nMEDIA IMPORTE POR ARTICULOS: ");
		int mediaPorVenta=0;
		for (Entry<Integer, Articulos> art : articulosMap.entrySet()) {
			//Como todas las ventas son unitarias, no tengo ningún método que saque n de productos por venta.
			//Por eso, lo normal es que la media que mueva es su precio.
			if(art.getValue().obtenerCompras(ventasMap)>0)
			System.out.println(art.getValue().getCodarti()+" - "+art.getValue().getDenom()+"    Vendido en: "+
			art.getValue().obtenerCompras(ventasMap)+" compras, moviendo una media de "+
			(art.getValue().getPvp()*art.getValue().obtenerNArticulosVendidos(ventasMap))/art.getValue().obtenerCompras(ventasMap)+" por venta");
		}
	}
	
}
