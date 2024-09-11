package pe.edu.upc.taytagrupo5.dtos;

public class CantidadRecetasFinalizadasClienteDTO {
    private String full_name;
    private int quantity;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
