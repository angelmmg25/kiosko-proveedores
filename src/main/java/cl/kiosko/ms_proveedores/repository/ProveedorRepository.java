package cl.kiosko.ms_proveedores.repository;

import cl.kiosko.ms_proveedores.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}