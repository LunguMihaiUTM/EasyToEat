package agin.llc1.llc1.controller;

import agin.llc1.llc1.dto.MenuDTO;
import agin.llc1.llc1.service.serviceImpl.GetMenuServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController {

    final GetMenuServiceImpl getMenuService;

    @GetMapping("/get")
    public ResponseEntity<MenuDTO> getMenu() {
        return ResponseEntity.ok(getMenuService.getMenu());
    }
}
