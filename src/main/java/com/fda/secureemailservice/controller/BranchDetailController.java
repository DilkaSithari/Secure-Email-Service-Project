package com.fda.secureemailservice.controller;

import com.fda.secureemailservice.model.BranchDetail;

import com.fda.secureemailservice.service.BranchDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/branchDetail")
public class BranchDetailController {
    @Autowired
    BranchDetailService branchDetailService;

    @GetMapping("/all")
    public List<BranchDetail> findAll(){
        return branchDetailService.findAll();
    }

    @PostMapping("/add")
   public void addBranchDetail(@RequestBody BranchDetail branchDetail){
        branchDetailService.addBranchDetail(branchDetail);
   }

   @GetMapping("{branchCode}")
   public List<BranchDetail> findByBranchCode(@PathVariable("branchCode") int branchCode){
        return branchDetailService.findByBranchCode(branchCode);
   }
   @PutMapping("update/{branchCode}")
   public void updateBranchDetail(@RequestBody BranchDetail branchDetail, @PathVariable("branchCode") int branchCode ){
        branchDetailService.updateBranchDetail(branchCode ,branchDetail);
   }
   @GetMapping("delete/{branchCode}")
   public int deleteBranchDetail(@PathVariable("branchCode") int branchCode){
        return branchDetailService.deleteBranchDetail(branchCode);

   }
}
