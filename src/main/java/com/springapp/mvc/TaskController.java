package com.springapp.mvc;

import com.sun.org.apache.xpath.internal.operations.Mod;
import entity.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.TaskRepository;

import java.util.List;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTask(Model model){
        List<Tasks> tasks = this.taskRepository.listAll();
        model.addAttribute("tasks", tasks);
        return "index";
    }

}
