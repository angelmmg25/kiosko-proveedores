package cl.kiosko.ms_proveedores.repository;

import cl.kiosko.ms_proveedores.model.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {

    List<OrdenCompra> findByProveedorId(Long proveedorId);
}