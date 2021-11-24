package com.itmuch.contentcenter.controller;

import com.itmuch.contentcenter.domain.dto.ShareDTO;
import com.itmuch.contentcenter.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/share")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {

    @Autowired
    private final ShareService shareService;

    @GetMapping("/{id}")
    public ShareDTO getById(@PathVariable Integer id){

        return this.shareService.findById(id);

    }




}
