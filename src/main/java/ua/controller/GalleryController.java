package ua.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryController {
	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String showGallery(Model model) {
		String uploadPath = System.getenv("OPENSHIFT_DATA_DIR") != null ? System.getenv("OPENSHIFT_DATA_DIR") : System.getenv("Temp");
		File f = new File(uploadPath);
		ArrayList<String> images = new ArrayList<String>(Arrays.asList(f.list()));
		
		model.addAttribute("images", images);
		return "gallery";
	}
}
