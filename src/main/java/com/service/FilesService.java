package com.service;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

import org.apache.commons.io.filefilter.WildcardFileFilter;

public class FilesService {
	
	public static final ArrayList<String> getFilesByWildcard(File path, String wildcard){
		ArrayList<String> res = new ArrayList<String>();
		FileFilter fileFilter = new WildcardFileFilter(wildcard);
		File[] files = path.listFiles(fileFilter);
		for (int i = 0; i < files.length; i++) {
			res.add(files[i].getName());
		}
		return res;
	}

}
