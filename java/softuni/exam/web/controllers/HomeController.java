package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.MechanicsService;
import softuni.exam.service.PartsService;
import softuni.exam.service.TasksService;
import softuni.exam.service.CarsService;

@Controller
public class HomeController extends BaseController {

    private final PartsService partService;
    private final TasksService tasksService;
    private final CarsService carService;
    private final MechanicsService mechanicService;

    @Autowired
    public HomeController(PartsService partService, TasksService tasksService, CarsService carService, MechanicsService mechanicService) {
        this.partService = partService;
        this.tasksService = tasksService;
        this.carService = carService;
        this.mechanicService = mechanicService;
    }


    @GetMapping("/")
    public ModelAndView index() {
        boolean areImported = this.partService.areImported() &&
                this.carService.areImported() &&
                this.partService.areImported() &&
                this.tasksService.areImported();

        return super.view("index", "areImported", areImported);
    }
}
