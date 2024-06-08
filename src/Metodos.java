import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Metodos {
	ArrayList<String> listaProductos = new ArrayList<>();
	ArrayList<Integer> listaCantidad = new ArrayList<>();
	
	// Este es el metodo principal, me va a generar el menú y me va a llamar el metodo necesario para la petición del cliente.
	// funciona bien.
	
	public void construirMenu () {
		
		int menu = 0;
		
		do {
			
			menu = Integer.parseInt(JOptionPane.showInputDialog("**********MENU PRINCIPAL**********\n\n"
					+ "1. Agregar Producto\n"
					+ "2. Buscar Producto por Nombre\n"
					+ "3. Actualizar Cantidad de Producto\n"
					+ "4. Eliminar Producto\n"
					+ "5. Mostrar Inventario\n"
					+ "6. Salir"));
			
			switch (menu) {
			case 1:
				agregarProducto();
				break;
			case 2:
				if (listaProductos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No puedes seleccionar esta opción "
							+ "sin haber registrado por lo menos un producto");
				} else {
					buscarProducto();
				}
				break;
			case 3:
				if (listaProductos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No puedes seleccionar esta opción "
							+ "sin haber registrado por lo menos un producto");
				} else {
					actualizarCantidadProducto();
				}
				break;
			case 4:
				if (listaProductos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No puedes seleccionar esta opción "
							+ "sin haber registrado por lo menos un producto");
				} else {
					eliminarProducto();
				}
				break;
			case 5:
				if (listaProductos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No puedes seleccionar esta opción "
							+ "sin haber registrado por lo menos un producto");
				} else {
					System.out.println("**********Inventario**********\n");
					mostrarInventario();
				}
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Usted ha salido del programa");
				break;
			default:
				JOptionPane.showMessageDialog(null, "El valor que ha seleccionado no pertenece a ninguna opción");
				break;
			}
			
		} while (menu != 6);
		
	}
	
	// Este metodo permite agregar nuevos productos.
	
	private void agregarProducto() {
		
		System.out.println("*****Agregar un Nuevo Producto*****\n");
		int numProductos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos que va a registrar"));
		
		for (int i = 0; i < numProductos; i++) {
			String producto = JOptionPane.showInputDialog("Ingrese el producto " + (i+1));
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de " + producto));
			if (listaProductos.contains(producto)) {
				JOptionPane.showMessageDialog(null, "El producto que intenta registrar ya existe en la base de datos, "
						+ "por favor ingrese un nuevo producto");
				i--;
			} else {
				
				listaProductos.add(producto);
				listaCantidad.add(cantidad);
			}
		}
		System.out.println("Registro el producto de manera exitosa\n");
		mostrarInventario();
		
	}
	
	// Este metodo permite buscar productos.
	// problemas con la iteración, se muestra el mensaje el producto no existe varias veces...
	
	private void buscarProducto() {
		
		System.out.println("*****Buscar producto por Nombre*****\n");
		String producto = JOptionPane.showInputDialog("Ingrese el producto que desea buscar");
		
		for (int i = 0; i < listaProductos.size(); i++) {
			if (listaProductos.get(i).equals(producto)) {
				JOptionPane.showMessageDialog(null, "Se encontró el producto " + listaProductos.get(i)
						+ ". Cantidad: " + listaCantidad.get(i));
			} else {
				JOptionPane.showMessageDialog(null, "El producto " + producto + " no existe.");
			}
		}		
		mostrarInventario();
	}
	
	// Este metodo permite actualizar la cantidad de los productos.
	// problemas con la iteración, se muestra el mensaje el producto no existe varias veces...
	
	private void actualizarCantidadProducto() {
		
		System.out.println("*****Actualizar la Cantidad de un Producto*****\n");		
		String producto = JOptionPane.showInputDialog("Ingrese el nombre del producto que desea actualizar");
		
		for (int i = 0; i < listaProductos.size(); i++) {
			if (listaProductos.get(i).equals(producto)) {
				
				int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad para " + producto));
				listaCantidad.set(i, cantidad);
				
			} else {
				System.out.println("EL producto no existe\n");
			}
		}
		mostrarInventario();
		
	}
	
	// Este metodo permite eliminar productos.
	// problemas con la iteración, se muestra el mensaje el producto no existe varias veces...
	
	private void eliminarProducto() {
		
		System.out.println("*****Eliminar un Producto*****\n");
		String producto = JOptionPane.showInputDialog("Ingrese el nombre del producto que desea eliminar");
		
		for (int i = 0; i < listaProductos.size(); i++) {
			if (listaProductos.get(i).equals(producto)) {
				
				listaProductos.remove(i);
				listaCantidad.remove(i);
				
			} else {
				System.out.println("EL producto no existe\n");
			}
		}
		mostrarInventario();
		
	}
	
	// Este metodo permite ver el inventario actual.
	// Funciona bien.
	
	private void mostrarInventario() {
		
		for (int i = 0; i < listaProductos.size(); i++) {
			System.out.println("Producto: " + listaProductos.get(i) + ". Cantidad: " + listaCantidad.get(i));
		}
		System.out.println("");
	}

}
