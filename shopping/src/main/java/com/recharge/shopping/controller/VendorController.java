package com.recharge.shopping.controller;


import com.recharge.shopping.entity.Vendor;
import com.recharge.shopping.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @GetMapping
    public Page<Vendor> getVendors(
        @RequestParam(required = false, defaultValue = "") String search,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "firstName") String sortBy,
        @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        return vendorService.searchVendors(search, page, size, sortBy, sortDirection);
    }
}
