
package lesson6.server.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lesson6.server.model.Admin;
import lesson6.server.repositories.AdminRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Api("admin controller")
public class AdminController {
    final
    AdminRepository adminRepository;


    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/admins")
    @ApiOperation("get all admins")
    public ResponseEntity<List<Admin>> getAdmins() {
        return ResponseEntity.ok(adminRepository.findAll());
    }

    @GetMapping("/admins/{id}")
    @ApiOperation("get admin by id")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long id) {

        return adminRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
