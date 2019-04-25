
package com.example.finalcatdemo.services.gcp.datastore;

import com.example.finalcatdemo.services.gcp.domain.Cat;
import com.google.cloud.datastore.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.cloud.datastore.*;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CatService {


    private Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    private static final String ENTITY_KIND = "Cat";
    private final KeyFactory keyFactory = datastore.newKeyFactory().setKind(ENTITY_KIND);

    public Key createCat(Cat cat){
        Key key = datastore.allocateId(keyFactory.newKey());
        Entity catEntity = Entity.newBuilder(key)
                .set(Cat.CAT_NAME, cat.getCat_name())
                .set(Cat.IMAGE_URL,cat.getImageUrl())
                .build();
        datastore.put(catEntity);
        return key;
    }

    public List<Cat> getAllCats(String cat_name){
        Query<Entity> query = Query.newEntityQueryBuilder()
                .setKind(ENTITY_KIND)
                .setFilter(StructuredQuery.PropertyFilter.eq(Cat.CAT_NAME, cat_name))
                .build();
        Iterator<Entity> entities = datastore.run(query);
        return buildCats(entities);
    }

	
/* private List<Cat> buildCat(Iterator<Entity> entities) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	private List<Cat> buildCats(Iterator<Entity> entities){
        List<Cat> cats = new ArrayList<>();
        entities.forEachRemaining(entity-> cats.add(entityToCat(entity)));
        return cats;
    }

    private Cat entityToCat(Entity entity){
        return new Cat.Builder()
                .withCatName(entity.getString(Cat.CAT_NAME))
               
                .withImageUrl(entity.getString(Cat.IMAGE_URL))
                .withId(entity.getKey().getId())
                .build();
    }
}
