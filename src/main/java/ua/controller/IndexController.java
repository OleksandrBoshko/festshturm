package ua.controller;

import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Post;
import com.service.FilesService;
import com.service.PostService;

@Controller
public class IndexController {

	@Autowired 
	private PostService postService;

	@RequestMapping("/")
	public String showHome(Model model) {
		return "redirect:/show/home";
	}
	
	@RequestMapping("/show/{slug}")
	public String showPost(Model model, @PathVariable String slug) {
		boolean showSlider = slug.equals("home") ? true : false;
		if (showSlider){
			String uploadPath = System.getenv("OPENSHIFT_DATA_DIR") != null ? System.getenv("OPENSHIFT_DATA_DIR") : System.getenv("Temp");
			File f = new File(uploadPath);
			ArrayList<String> images = new ArrayList<String>();
			images.addAll(FilesService.getFilesByWildcard(f, "picture*.jpg"));
			model.addAttribute("images", images);
			
		}
		model.addAttribute("showSlider", showSlider);
		model.addAttribute("post", postService.findOneBySlug(slug));
		return "index";
	}
	
	@RequestMapping(value = "/show/save-post/{slug}", method = RequestMethod.POST)
	public String savePost(@RequestParam String text, Principal principal, @PathVariable String slug, @RequestParam(required=false, defaultValue="0") int id){
			postService.save(id, text, slug);
			return "redirect:/show/{slug}";
	}
		
	@RequestMapping(value = "/show/deletePost/{slug}/{id}")
	public String deletePost(@PathVariable String id, @PathVariable String slug) {
		if (postService.findOneById(id)!=null) {
			postService.delete(id);
			return "redirect:/show/{slug}";
		} else {
			return "redirect:/show/{slug}";
		}
	}
	
////	/news
//	@RequestMapping("/show/{slug}")
//	public String indexView(Model model, @PathVariable String slug) {
//		List<Post> posts = new ArrayList<Post>();
//		posts.add(postService.findOneBySlug(slug));
//		model.addAttribute("posts", posts);
////		if (slug=="main") {
////			posts.add(postService.findOneBySubject(slug));
////			model.addAttribute("posts", posts);
////		}
//		return "index";
//	}

}
