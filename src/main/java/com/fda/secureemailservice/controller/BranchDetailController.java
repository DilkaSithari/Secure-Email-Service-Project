package com.fda.secureemailservice.controller;

import com.fda.secureemailservice.model.BranchDetail;
import com.fda.secureemailservice.repository.BranchDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/branchDetail")
public class BranchDetailController {
    private final BranchDetailRepo branchDetailRepo;

    @Autowired
    public BranchDetailController(BranchDetailRepo branchDetailRepo) {
        this.branchDetailRepo = branchDetailRepo;
    }
    @PostMapping("/add")
   public void addBranchDetail(@RequestBody BranchDetail branchDetail){
        branchDetailRepo.addBranchDetail(branchDetail);
   }
   @GetMapping("/all")
   public List<BranchDetail> findAll(){
        return branchDetailRepo.findAll();
   }
   @GetMapping("{branchCode}")
   public List<BranchDetail> findByBranchCode(@PathVariable("branchCode") int branchCode){
        return branchDetailRepo.findByBranchCode(branchCode);
   }
   @PutMapping("update/{branchCode}")
   public int updateBranchDetail(@RequestBody BranchDetail branchDetail,@PathVariable("branchCode") int branchCode){
        return branchDetailRepo.updateBranchDetail(branchCode,branchDetail);
   }
   @GetMapping("delete/{branchCode}")
   public void deleteBranchDetail(@PathVariable("branchCode") int branchCode){
        branchDetailRepo.deleteBranchDetail(branchCode);
   }
}
