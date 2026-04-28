package cl.kiosko.ms_proveedores.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDTO {

    @NotBlank(message = "")
    private String nombreEmpresa;

    @NotBlank
    private String rut;

    private String direccion;
    private String telefono;

    @Email
    private String email;

    private String producto;
}