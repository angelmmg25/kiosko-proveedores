package cl.kiosko.ms_proveedores.service;

import cl.kiosko.ms_proveedores.DTO.OrdenCompraDTO;
import cl.kiosko.ms_proveedores.model.OrdenCompra;
import cl.kiosko.ms_proveedores.model.Proveedor;
import cl.kiosko.ms_proveedores.repository.OrdenCompraRepository;
import cl.kiosko.ms_proveedores.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraService {
    @Autowired

    private final OrdenCompraRepository ordenRepo;
    private final ProveedorRepository proveedorRepo;

    public OrdenCompraService(OrdenCompraRepository ordenRepo, ProveedorRepository proveedorRepo) {
        this.ordenRepo = ordenRepo;
        this.proveedorRepo = proveedorRepo;
    }

    public List<OrdenCompra> listar() {
        return ordenRepo.findAll();
    }

    public OrdenCompra crear(OrdenCompraDTO dto) {
        Proveedor proveedor = proveedorRepo.findById(dto.getProveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no existe"));

        OrdenCompra orden = OrdenCompra.builder()
                .descripcion(dto.getDescripcion())
                .cantidad(dto.getCantidad())
                .precioUnitario(dto.getPrecioUnitario())
                .proveedor(proveedor)
                .build();

        return ordenRepo.save(orden);
    }

    public List<OrdenCompra> porProveedor(Long proveedorId) {
        return ordenRepo.findByProveedorId(proveedorId);
    }
}