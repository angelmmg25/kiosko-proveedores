package cl.kiosko.ms_proveedores.controller;

import cl.kiosko.ms_proveedores.DTO.OrdenCompraDTO;
import cl.kiosko.ms_proveedores.model.OrdenCompra;
import cl.kiosko.ms_proveedores.service.OrdenCompraService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ordenes")
public class OrdenCompraController {

    private final OrdenCompraService service;

    public OrdenCompraController(OrdenCompraService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrdenCompra> listar() {
        return service.listar();
    }

    @PostMapping
    public OrdenCompra crear(@Valid @RequestBody OrdenCompraDTO dto) {
        return service.crear(dto);
    }

    @GetMapping("/{id}/proveedor")
    public List<OrdenCompra> porProveedor(@PathVariable Long id) {
        return service.porProveedor(id);
    }
}