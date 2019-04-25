
package com.example.finalcatdemo.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.finalcatdemo.services.gcp.cloudstorage.ImageService;
import com.example.finalcatdemo.services.gcp.datastore.CatService;
import com.example.finalcatdemo.services.gcp.domain.Cat;

import java.io.IOException;

@Controller
public class CatController {

    @Autowired
    private CatService catService;
    @Autowired
    private ImageService imageService;

    @GetMapping("/cats/add")
    public String getForm(Model model) {
        model.addAttribute("cat", new Cat());
        return "new_question";
    }

    @PostMapping("/cats/add")
    public String submitCat(Cat cat) throws IOException {
        String imageUrl = imageService.saveImage(cat.getImage());
        cat.setImageUrl(imageUrl);
        System.out.println("Image URL is "+imageUrl);
        catService.createCat(cat);
        return "redirect:/";
    }
}