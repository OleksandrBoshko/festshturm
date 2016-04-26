package ua.controller;

import java.io.File;
import java.io.FileFilter;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryController {
	
	private final ArrayList<String> getFilesByWildcard(File path, String wildcard){
		ArrayList<String> res = new ArrayList<String>();
		FileFilter fileFilter = new WildcardFileFilter(wildcard);
		File[] files = path.listFiles(fileFilter);
		for (int i = 0; i < files.length; i++) {
			res.add(files[i].getName());
		}
		return res;
	}
	
	
	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String showGallery(Model model, Principal principal) {

		String uploadPath = System.getenv("OPENSHIFT_DATA_DIR") != null ? System.getenv("OPENSHIFT_DATA_DIR") : System.getenv("Temp");
		
		File f = new File(uploadPath);
		ArrayList<String> images = new ArrayList<String>();
		
		if(principal != null){
			
			
			images.addAll(getFilesByWildcard(f, "photo*.jpg"));
			images.addAll(getFilesByWildcard(f, "picture*.jpg"));
			
			
			
		} else {
			images = getFilesByWildcard(f, "photo*.jpg");
		}
//		System.out.println(principal.getName());
		
		model.addAttribute("images", images);
		return "gallery";
	}
}
