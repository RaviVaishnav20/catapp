
package com.example.finalcatdemo.api;

import com.example.finalcatdemo.services.gcp.datastore.CatService;

import com.example.finalcatdemo.services.gcp.domain.Cat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/api/kitten")
public class CatEndpoint {

    @Autowired
    private CatService catService;


    @GetMapping(value = "{kitten}")
    public ResponseEntity<ObjectNode> getAllQuestions(@PathVariable String kitten) {
         ObjectMapper mapper = new ObjectMapper();
         ObjectNode root = mapper.createObjectNode();
         root.set("cat", mapper.convertValue(catService.getAllCats(kitten), JsonNode.class));
        return new ResponseEntity<ObjectNode>(root,HttpStatus.OK);
    }
    

}
