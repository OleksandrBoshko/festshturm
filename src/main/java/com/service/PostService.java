package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.Post;
import com.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static final Map<String, String> slagMapping = new HashMap<String, String>() {
		{
			put("home", "Штурм Фест");
			put("main-scene", "Головна сцена");
			put("second-scene", "Мала сцена");
			put("literary-scene", "Літературна сцена");
			put("fair", "Ярмарок");
			put("food-territory", "Територія їжі");
			put("cossack-area", "Козацька галявина");
			put("children-playground", "Дитячий майданчик");
			put("night-film-show", "Нічний кінопоказ");
			put("ecoclub", "Екоклуб");
			put("participants", "Учасники");
			put("tickets", "Квитки");
			put("how-to-get-to", "Як дістатись");
			put("rules", "Правила");
			put("residency", "Проживання");
			put("faq", "Часті питання");
			put("gallery", "Галерея");
			put("news", "Новини");
			put("partners", "Партнери");
			put("contacts", "Контакти");
		}
	};

	public void save(int id, String text, String slug) {
		if (id == 0) {
			if (postRepository.findOneBySlug(slug) == null) {
				String subject = slagMapping.get(slug);
				Post post = new Post(text, slug, subject);
				postRepository.save(post);
			}
		} else {
			Post post = postRepository.findOneById(id);
			post.setText(text);
			postRepository.save(post);
		}
	}
	
	public void saveIter(String text, String slug) {
		String subject = slagMapping.get(slug);
		Post post = new Post(text, slug, subject);
		postRepository.save(post);
	}

	public Iterable<Post> getAll() {
		return postRepository.findAll();
	}

	public Post findOneBySlug(String slug) {
		return postRepository.findOneBySlug(slug);
	}

	public void delete(String id) {
		postRepository.delete(Integer.parseInt(id));
	}

	public Post findOneById(String id) {
		return postRepository.findOneById(Integer.parseInt(id));
	}

	public Iterable<Post> findPostsBySlug(String slug) {
		return postRepository.findPostsBySlug(slug);
	}
}
