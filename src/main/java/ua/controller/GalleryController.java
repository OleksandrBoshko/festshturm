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

import com.service.FilesService;

@Controller
public class GalleryController {
	
	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String showGallery(Model model, Principal principal) {

		String uploadPath = System.getenv("OPENSHIFT_DATA_DIR") != null ? System.getenv("OPENSHIFT_DATA_DIR") : System.getenv("Temp");
		
		File f = new File(uploadPath);
		ArrayList<String> images = new ArrayList<String>();
		
		if(principal != null){
			images.addAll(FilesService.getFilesByWildcard(f, "photo*.jpg"));
			images.addAll(FilesService.getFilesByWildcard(f, "picture*.jpg"));
			
		} else {
			images = FilesService.getFilesByWildcard(f, "photo*.jpg");
		}
		model.addAttribute("images", images);
		return "gallery";
	}
}
