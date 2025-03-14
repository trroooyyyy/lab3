package org.rekonvald.lab3.controller.address;

import lombok.RequiredArgsConstructor;
import org.rekonvald.lab3.entity.Address;
import org.rekonvald.lab3.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createAddress(address));
    }

    @PutMapping("/address")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.updateAddress(address));
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}