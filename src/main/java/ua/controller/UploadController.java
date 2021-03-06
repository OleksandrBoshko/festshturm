package ua.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	public static final String uploadPath = System.getenv("OPENSHIFT_DATA_DIR") != null ? System.getenv("OPENSHIFT_DATA_DIR") : System.getenv("Temp");
		
	@RequestMapping(value = "/upload", headers = "content-type=multipart/*", method = RequestMethod.POST)
	public String uploadFile(@RequestParam(value = "image", required = false) MultipartFile image, Principal principal, String imageType){
		String prefix = imageType.equals("photo") ? "photo" : "picture";
		
		if (!image.isEmpty()) {
			// Client File Name
            String name = image.getOriginalFilename();
            System.out.println("Client File Name = " + name);
 
            if (name != null && name.length() > 0) {
                try {
                    byte[] bytes = image.getBytes();
 
                    // Create the file on server
                    
                    File serverFile = new File(uploadPath
                             +File.separator + prefix + "-" + Long.toString(System.currentTimeMillis()) + "-" + name);
 
                    // Stream to write data to file in server.
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(serverFile));
                    stream.write(bytes);
                    stream.close();
        
                    System.out.println("Write file: " + serverFile);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name);
                }
            }
		}
		return "redirect:/gallery";
	}
	
	@RequestMapping(value = "/upload/file-delete", method = RequestMethod.GET)
	public String deleteFile(@RequestParam String image) {
		System.out.println("hello");
		File file = new File(uploadPath + File.separator + image);
		boolean r = file.delete();
		System.out.println(uploadPath + File.separator + image);
		
		return "redirect:/gallery";
	}
	
}

