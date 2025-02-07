package peaksoft.springbootanddatajpa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springbootanddatajpa.entities.User;
import peaksoft.springbootanddatajpa.service.CarService;
import peaksoft.springbootanddatajpa.service.UserService;

@Controller
@RequestMapping("/api/users")
public class UserAPI {
    private final UserService userService;
    private final CarService carService;

    @Autowired
    public UserAPI(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }

    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("users",userService.getAll());
        model.addAttribute("cars",carService.getAllCars());
        return "/users";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user",new User());
        return "/createUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute User user){
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        userService.save(user);
        return "redirect:/api/users";
    }

    @PostMapping("/assign/{userId}")
    public String assignCarToUser(@PathVariable("userId") Long userId, @RequestParam("carId") Long carId){
        userService.assignCarToUser(userId,carId);
        return "redirect:/api/users";
    }
}
