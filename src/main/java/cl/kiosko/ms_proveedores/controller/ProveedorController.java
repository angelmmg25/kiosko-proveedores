package cl.kiosko.ms_proveedores.controller;

import cl.kiosko.ms_proveedores.DTO.ProveedorDTO;
import cl.kiosko.ms_proveedores.model.Proveedor;
import cl.kiosko.ms_proveedores.service.ProveedorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {

    private final ProveedorService service;

    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Proveedor> listar() {
        return service.listar();
    }

    @PostMapping
    public Proveedor crear(@Valid @RequestBody ProveedorDTO dto) {
        return service.crear(dto);
    }

    @GetMapping("/{id}")
    public Proveedor obtener(@PathVariable Long id) {
        return service.obtener(id);
    }
}