public class Registro {

String dni;
ProductoFinanciero [] producto;

    public Registro(String dni, ProductoFinanciero producto[]) {

        this.dni = dni;
        producto = new ProductoFinanciero[10];

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ProductoFinanciero[] getProducto() {
        return producto;
    }

    public void setProducto(ProductoFinanciero[] producto) {
        this.producto = producto;
    }



}
