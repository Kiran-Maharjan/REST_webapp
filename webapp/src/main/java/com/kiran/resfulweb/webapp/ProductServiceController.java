package com.kiran.resfulweb.webapp;

import com.kiran.resfulweb.webapp.model.Product;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {

    private static Map<String, Product> productRepo=new HashMap<>();

    static{
        productRepo.put("1",new Product("1","Honey"));
        productRepo.put("2",new Product("2","Almond"));
        productRepo.put("3",new Product("3","Butter"));
    }

    //Delete
    @RequestMapping(value="/products/{id}",method= RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id ){
        productRepo.remove(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
    //Update
    @RequestMapping(value="/products/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id,product);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
    //Add
    @RequestMapping(value="/products",method=RequestMethod.POST)
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        productRepo.put(product.getId(),product);
        return new ResponseEntity<>("Added Successfully",HttpStatus.OK);
    }
    //Retrive
    @RequestMapping(value="/products",method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>(productRepo.values(),HttpStatus.OK);
    }
}
