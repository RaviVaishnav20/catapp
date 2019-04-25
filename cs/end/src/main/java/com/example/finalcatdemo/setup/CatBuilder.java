/*
 * Copyright 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.finalcatdemo.setup;

import com.example.finalcatdemo.services.gcp.datastore.CatService;
import com.example.finalcatdemo.services.gcp.domain.Cat;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class CatBuilder {

    static List<Cat> buildQuestions(){
       List<Cat> cats = new ArrayList<>();

       Cat cat = new Cat.Builder()
               
               .withCatName("kaaat")
               .withImageUrl("")
               .build();
       cats.add(cat);

       cat = new Cat.Builder()
               
    		     
               .withCatName("kaaat")
               .withImageUrl("")
               .build();
       cats.add(cat);

        cat = new Cat.Builder()
        	     
                .withCatName("kaaat")
                .withImageUrl("")
                .build();
        cats.add(cat);
        cat = new Cat.Builder()
        	     
                .withCatName("kaaat")
                .withImageUrl("")
                .build();
        cats.add(cat);
       return cats;
    }

    public static void main(String ... args){
        out.println("Entity Factory Creating Initial Cats");

        CatService catService = new CatService();

        buildQuestions().forEach(cat -> catService.createCat(cat));

        out.println("Cat Storaged for GCP");
        catService.getAllCats("gcp").forEach(out::println);
        out.println("Cat Stored for Places");
        catService.getAllCats("places").forEach(out::println);
    }
}
