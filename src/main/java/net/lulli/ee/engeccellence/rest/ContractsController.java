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
    public String addContracts(@RequestBody Contract contract) {
        contractsService.addContract(contract);
        return "Data Inserted Successfully";
    }

    @GetMapping("/contracts/{id}")
    public List<Contract> getContract(@PathVariable String id) {
        return contractsService.getAllContracts();
    }


    @PutMapping("/contracts/{id}")
    public String updateContracts(@PathVariable String id, @RequestBody Contract updatedContract) {
        return contractsService.updateContract(id, updatedContract);
    }

    @DeleteMapping("/contracts/{id}")
    public String deleteContracts(@PathVariable String id) {
        return contractsService.deleteContract(id);
    }
}
