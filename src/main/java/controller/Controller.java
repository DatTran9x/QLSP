package controller;


import model.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IProductService;
import service.ProductService;

@org.springframework.stereotype.Controller
public class Controller {
    private static final IProductService ps = new ProductService();

    @GetMapping("/home")
    public ModelAndView show(){
        ModelAndView mav = new ModelAndView("/homepage");
        mav.addObject("list",ps.show());
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView mav =  new ModelAndView("/create");
        mav.addObject("product",new Product());
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product){
        ps.add(product);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable int id){
        int index = ps.find(id);
        Product product = ps.getProduct(index);
        ModelAndView mav = new ModelAndView("/edit");
        mav.addObject("product",product);
        return mav;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id,@ModelAttribute Product product){
        int index = ps.find(id);
        ps.edit(index,product);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable int id){
        int index = ps.find(id);
        Product product = ps.getProduct(index);
        ModelAndView mav = new ModelAndView("delete");
        mav.addObject("product",product);
        return mav;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        int index = ps.find(id);
        ps.delete(index);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable int id){
        int index = ps.find(id);
        Product product = ps.getProduct(index);
        ModelAndView mav = new ModelAndView("/details");
        mav.addObject("product",product);
        return mav;
    }

    @GetMapping("/search")
    public ModelAndView find(@RequestParam String name){
        Product product = ps.findByName(name);
        ModelAndView mav = new ModelAndView("/details");
        mav.addObject("product",product);
        return mav;
    }
}
