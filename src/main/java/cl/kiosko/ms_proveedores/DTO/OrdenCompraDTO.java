package cl.kiosko.ms_proveedores.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class OrdenCompraDTO {

    @NotBlank
    private String descripcion;

    @Min(1)
    private int cantidad;

    @Positive
    private double precioUnitario;

    @NotNull
    private Long proveedorId;
}