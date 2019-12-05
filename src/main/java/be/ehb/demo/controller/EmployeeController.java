package be.ehb.demo.controller;


import be.ehb.demo.model.Employee;
import be.ehb.demo.model.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeDAO empdao;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity werknemer(@RequestParam(value = "id") int id,
                                    @RequestParam(value = "naam")String naam,
                                    @RequestParam(value = "email")String email,
                                    @RequestParam(value = "telefoonNr")int telefoonNr){
        Employee nieuweWerknemer = new Employee();
        nieuweWerknemer.setNaam(naam);
        nieuweWerknemer.setId(id);

        empdao.save(nieuweWerknemer);

        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(value = "/{x}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Employee> zoekWerknemerOpId(@PathVariable(value = "id")int id){
        return empdao.findById(id);
    }
    @RequestMapping(value = "/{naam = x}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Employee> zoekWerknemerOpNaam(@PathVariable(value = "naam")String naam) {
        return empdao.findByNaam(naam);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Employee> toonWerknemer() {
        return empdao.findAll();
    }


}
