package ua.controller;

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
import com.service.PostService;

@Controller
public class IterableController {

	@Autowired 
	private PostService postService;
	
	@RequestMapping("/iterable/{slug}")
	public String showPost(Model model, @PathVariable String slug) {
		Iterable<Post> posts = postService.findPostsBySlug(slug);
		String subject = "";
		if (posts.iterator().hasNext()){
			subject = posts.iterator().next().getSubject();
		}
		model.addAttribute("subject", subject);
		model.addAttribute("posts", posts);
		return "iterable";
	}
	
	@RequestMapping(value = "/iterable/save-iterable-post/{slug}", method = RequestMethod.POST)
	public String savePost(@RequestParam String text, Principal principal, @PathVariable String slug){
		postService.saveIter( text, slug);
		return "redirect:/iterable/{slug}";
		
	}
		
	@RequestMapping(value = "/iterable/delete-iterable-post/{slug}/{id}")
	public String deletePost(@PathVariable String id, @PathVariable String slug) {
		if (postService.findOneById(id)!=null) {
			postService.delete(id);
			return "redirect:/iterable/{slug}";
		} else {
			return "redirect:/iterable/{slug}";
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
