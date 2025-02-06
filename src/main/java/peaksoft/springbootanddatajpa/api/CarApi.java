package peaksoft.springbootanddatajpa.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.springbootanddatajpa.service.CarService;

@Controller
@RequestMapping("/api/cars")
public class CarApi {
    private final CarService carService;

    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{userId}")
    private String getCarsByUserId(@PathVariable("userId") Long userId, Model model) {
        System.out.println(carService.getCarByUseId(userId));
        model.addAttribute("cars", carService.getCarByUseId(userId));
        return "/cars";
    }
}
