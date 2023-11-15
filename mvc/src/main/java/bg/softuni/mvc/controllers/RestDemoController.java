package bg.softuni.mvc.controllers;

import bg.softuni.mvc.dtos.UserShortInfoDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class RestDemoController {
    @GetMapping("")
    public String index(){
        return "user/login";
    }
    @GetMapping("/dto")
    public UserShortInfoDTO getDTO(){
        return  new UserShortInfoDTO("demo-user");
    }
    @PostMapping("/create")
    public void create(@RequestBody UserShortInfoDTO userDTO){
        System.out.println(userDTO.getUsername());
    }
    @GetMapping("/404")
    public ResponseEntity exception(){
        throw new EntityNotFoundException("custom message");
    }
}
