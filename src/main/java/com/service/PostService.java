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
			put("home", "����� ����");
			put("main-scene", "������� �����");
			put("second-scene", "���� �����");
			put("literary-scene", "˳��������� �����");
			put("fair", "�������");
			put("food-territory", "�������� ��");
			put("cossack-area", "�������� ��������");
			put("children-playground", "������� ���������");
			put("night-film-show", "ͳ���� ��������");
			put("ecoclub", "�������");
			put("participants", "��������");
			put("tickets", "������");
			put("how-to-get-to", "�� ��������");
			put("rules", "�������");
			put("residency", "����������");
			put("faq", "���� �������");
			put("gallery", "�������");
			put("news", "������");
			put("partners", "��������");
			put("contacts", "��������");
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
