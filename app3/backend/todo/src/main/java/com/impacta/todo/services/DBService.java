package com.impacta.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impacta.todo.domain.Todo;
import com.impacta.todo.repositories.TodoRepository;

@Service
public class DBService {

	@Autowired
	private TodoRepository todoRepository;

	public void instanciaDB() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Todo t1 = new Todo(null, "Estudos", "Estudar Spring + Angular", sdf.parse("25/03/2021"), false);
		Todo t2 = new Todo(null, "Saude", "Meditar", sdf.parse("25/03/2021"), false);
		Todo t3 = new Todo(null, "Estudos", "Boostrap + CSS", sdf.parse("25/03/2021"), true);
		Todo t4 = new Todo(null, "Saude", "Caminhada", sdf.parse("25/03/2021"), true);

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}

}
