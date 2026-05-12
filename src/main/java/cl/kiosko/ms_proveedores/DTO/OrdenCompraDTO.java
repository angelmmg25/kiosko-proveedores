package cl.kiosko.ms_proveedores.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class OrdenCompraDTO {

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int cantidad;

    @Positive(message = "El precio unitario debe ser mayor a 0")
    private double precioUnitario;

    @NotNull(message = "El proveedor es obligatorio")
    private Long proveedorId;
}