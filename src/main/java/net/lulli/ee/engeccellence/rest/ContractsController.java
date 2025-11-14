package net.lulli.ee.engeccellence.rest;

import net.lulli.ee.engeccellence.dto.Contract;
import net.lulli.ee.engeccellence.service.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ContractsController {
    private final ContractsService contractsService;

    public ContractsController(@Autowired ContractsService contractsService) {
        this.contractsService = contractsService;
    }

    @GetMapping("/contracts")
    public List<Contract> getAllContracts() {
        return contractsService.getAllContracts();
    }

    @PostMapping("/contracts")
    public String addContract(@RequestBody Contract contract) {
        contractsService.addContract(contract);
        return "Data Inserted Successfully";
    }

    @GetMapping("/contracts/{id}")
    public List<Contract> getContract(@PathVariable String id) {
        return contractsService.getAllContracts();
    }

    @PutMapping("/contracts/{id}")
    public void updateContract(@PathVariable String id, @RequestBody Contract updatedContract) {
        contractsService.updateContract(id, updatedContract);
    }

    @DeleteMapping("/contracts/{id}")
    public void deleteContract(@PathVariable String id) {
        contractsService.deleteContract(id);
    }
}
