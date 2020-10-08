import java.util.ArrayList;

public class Pan extends Producto {
		String tipoHarina;

		public String getTipoHarina() {
			return tipoHarina;
		}

		public void setTipoHarina(String tipoHarina) {
			this.tipoHarina = tipoHarina;
		}

		public Pan(String nombre, double precio, double pesoUnidad, ArrayList<String> ingredientes, String tipoHarina) {
			super(nombre, precio, pesoUnidad, ingredientes);
			this.tipoHarina = tipoHarina;
		}
		

		public Pan() {
			super();
			this.tipoHarina = "";
		}

		@Override
		public String toString() {
			return "Pan [tipoHarina=" + tipoHarina + "]";
		}
		
		
		
		
	
}
