package ie42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Articulos articulo=new Articulos();
		Clientes cliente=new Clientes();
		Ventas venta=new Ventas();
		ArrayList<Articulos> articulos=new ArrayList<Articulos>();
		HashMap<Integer,Articulos> articulosMap=new HashMap<Integer,Articulos>();
		HashMap<Integer,Clientes> clientesMap=new HashMap<Integer,Clientes>();
		HashMap<Integer,Ventas> ventasMap=new HashMap<Integer,Ventas>();
		ArrayList<Clientes> clientes=new ArrayList<Clientes>();
		ArrayList<Ventas> ventas=new ArrayList<Ventas>();
		
		//EJERCICIO 1
		System.out.println("EJERCICIO 1");
		System.out.println("****************************************");
		
		ventasMap=venta.obtenerVentasMap();
		articulosMap=articulo.obtenerArticulosMap();
		
		
		//COMENTAR PARA TAPAR
		articulo.obtenerDatosArticulos(ventasMap, articulosMap);
		
		//*************************************************************/
		
		
		//EJERCICIO 2
		System.out.println("\n\n\n****************************************");
		System.out.println("EJERCICIO 2");
		System.out.println("****************************************");
				
		ventasMap=venta.obtenerVentasMap();
		articulosMap=articulo.obtenerArticulosMap();
				
				
		//COMENTAR PARA TAPAR
		venta.obtenerDatosVentas(ventasMap);
		//*************************************************************/
					
		//EJERCICIO 3
		System.out.println("\n\n\n****************************************");
		System.out.println("EJERCICIO 3");
		System.out.println("****************************************");
					
		ventasMap=venta.obtenerVentasMap();
		articulosMap=articulo.obtenerArticulosMap();
					
		//�NO ES EL MISMO QUE EL EJERCICIO 1?
		//COMENTAR PARA TAPAR
		articulo.obtenerDatosArticulos(ventasMap, articulosMap);
		//*************************************************************/
		
				
		//EJERCICIO 4
		System.out.println("\n\n\n****************************************");
		System.out.println("EJERCICIO 4");
		System.out.println("****************************************");
					
		ventasMap=venta.obtenerVentasMap();
		articulosMap=articulo.obtenerArticulosMap();
		clientesMap=cliente.obtenerClientesMap();
		
		cliente.obtenerDatosClientes(clientesMap, ventasMap);
					//*************************************************************/	
				
		//EJERCICIO 5
		System.out.println("\n\n\n****************************************");
		System.out.println("EJERCICIO 5");
		System.out.println("****************************************");
				
		ventasMap=venta.obtenerVentasMap();
		articulosMap=articulo.obtenerArticulosMap();
		clientesMap=cliente.obtenerClientesMap();
		//articulos=articulo.obtenerArticulos();
		//Collections.sort(articulos, Comparator.comparing(Articulos::getPvp));	
			
		articulo.articuloMasVendido(ventasMap, articulosMap);
		articulo.mediaPorArticulo(ventasMap, articulosMap);
		cliente.clienteMasGaston(clientesMap, ventasMap);
		cliente.clienteQueMasCompra(clientesMap, ventasMap);
		
						//*************************************************************/
		//iniciarBBDD();
		
		//articulo.insertarPorDefecto();
		//cliente.insertarPorDefecto();
		//venta.insertarPorDefecto();
		
		/*articulosMap=articulo.obtenerArticulosMap();
		clientesMap=cliente.obtenerClientesMap();
		ventasMap=venta.obtenerVentasMap();
		
		
		articulosMap.forEach((k,v)->{
			System.out.println(v);
			});
		
		System.out.println(("--------------"));
		
		clientesMap.forEach((k,v)->{
			System.out.println(v);
			});
		
		System.out.println(("--------------"));
		
		ventasMap.forEach((k,v)->{
			System.out.println(v);
			});*/
		
		/*clientes = cliente.obtenerClientes();

		for (Clientes cli : clientes) {
			System.out.println(cli.toString());
		}*/
		
		
		/*ventas = venta.obtenerVentas();

		
		for (Ventas ven : ventas) {
			System.out.println(ven.toString());
		}*/
		
		//articulo.pintarArticulos();
	}
	
	public static void iniciarBBDD() {
		Articulos articulo=new Articulos();
		Clientes cliente=new Clientes();
		Ventas venta=new Ventas();
		
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
		
		ArrayList<Clientes> clientes=new ArrayList<Clientes>();
		Clientes cli1 = new Clientes(1,"Antonio Ruiz","Talavera");
		Clientes cli2 = new Clientes(2,"La Alameda S.L.","Talavera");
		Clientes cli3 = new Clientes(7,"Los molinos CB","Madrid");
		Clientes cli4 = new Clientes(8,"Pedro Moran S.L.","Talavera");
		Clientes cli5 = new Clientes(12,"Azulejos Martin S.L.","Talavera");
		Clientes cli6 = new Clientes(15,"Bar Girasol","Oropesa");
		Clientes cli7 = new Clientes(9,"Escuela Mayores","Talavera");
		Clientes cli8 = new Clientes(17,"Galeria Madrid S.L.","Madrid");
		Clientes cli9 = new Clientes(19,"El corte Chino","Talavera");
		Clientes cli10 = new Clientes(20,"UNICAS S.A.","Oropesa");
		Clientes cli11 = new Clientes(21,"Deportivo SAS","Talavera");
		Clientes cli12 = new Clientes(22,"Academia Padel","Madrid");
		clientes.add(cli1);
		clientes.add(cli2);
		clientes.add(cli3);
		clientes.add(cli4);
		clientes.add(cli5);
		clientes.add(cli6);
		clientes.add(cli7);
		clientes.add(cli8);
		clientes.add(cli9);
		clientes.add(cli10);
		clientes.add(cli11);
		clientes.add(cli12);
		
		ArrayList<Ventas> ventas=new ArrayList<Ventas>();
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
		
		for (Articulos art : articulos) {
			articulo.insertarArticulo(art);
		}
		
		for (Clientes cli : clientes) {
			cliente.insertarCliente(cli);
		}
		
		for (Ventas vent : ventas) {
			venta.insertarVenta(vent);
		}
	}

}
