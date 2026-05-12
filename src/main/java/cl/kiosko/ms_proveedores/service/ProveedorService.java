package cl.kiosko.ms_proveedores.service;

import cl.kiosko.ms_proveedores.DTO.ProveedorDTO;
import cl.kiosko.ms_proveedores.model.Proveedor;
import cl.kiosko.ms_proveedores.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository repo;

    public ProveedorService(ProveedorRepository repo) {
        this.repo = repo;
    }

    public List<Proveedor> listar() {
        return repo.findAll();
    }

    public Proveedor obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    public Proveedor crear(ProveedorDTO dto) {
        Proveedor proveedor = Proveedor.builder()
                .nombreEmpresa(dto.getNombreEmpresa())
                .rut(dto.getRut())
                .direccion(dto.getDireccion())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .producto(dto.getProducto())
                .build();

        return repo.save(proveedor);
    }

    public Proveedor actualizar(Long id, ProveedorDTO dto) {
        Proveedor proveedor = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        proveedor.setNombreEmpresa(dto.getNombreEmpresa());
        proveedor.setRut(dto.getRut());
        proveedor.setDireccion(dto.getDireccion());
        proveedor.setTelefono(dto.getTelefono());
        proveedor.setEmail(dto.getEmail());
        proveedor.setProducto(dto.getProducto());

        return repo.save(proveedor);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Proveedor no existe");
        }
        repo.deleteById(id);
    }
}