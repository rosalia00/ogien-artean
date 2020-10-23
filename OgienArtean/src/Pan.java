import java.util.ArrayList;

public class Pan extends Producto {
		ArrayList<String> ingredientes;
		boolean sal;
		
		public ArrayList<String> getIngredientes() {
			return ingredientes;
		}
		public boolean getSal() {
			return sal;
		}
		public void setIngredientes(ArrayList<String> ingredientes) {
			this.ingredientes = ingredientes;
		}
		public void setSal(boolean sal) {
			this.sal = sal;
		}
		
		public Pan(String nombre, double precio, boolean celiaco, ArrayList<String> ingredientes, boolean sal) {
			super(nombre, precio, celiaco);
			this.ingredientes = ingredientes;
			this.sal = sal;
		}
		
		public Pan() {
			super();
			this.ingredientes = null;
			this.sal = false;
		}
		
		
	
}
