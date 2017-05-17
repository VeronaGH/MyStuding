package com.testpro.library.domain.service;

import com.testpro.library.domain.model.Author;
import com.testpro.library.domain.mongodb.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pigas on 16.05.2017.
 */
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void init() {
        authorRepository.deleteAll();

        //Добавление 5 авторов
        authorRepository.save(new Author(1,
                "Paul",
                "Jenkins",
                1985,
                "United States of America",
                "Long, long, long story with happy end...",
                true));

        authorRepository.save(new Author(2,
                "Luke",
                "Mirigam",
                1961,
                "United States of America",
                "Long, long, long story without pappy end...",
                false));

        authorRepository.save(new Author(3,
                "David",
                "Ferko",
                1955,
                "United Kingdom of Grate Britain",
                "Middle hand novel autor.",
                false));

        authorRepository.save(new Author(4,
                "Mihail",
                "Veller",
                1967,
                "Soviet Republic",
                "Genius author of soviet prose",
                true));

        authorRepository.save(new Author(5,
                "Omar",
                "Haiam",
                1000,
                "Arabian East",
                "Genius ancient Arabic author",
                false));

        authorRepository.save(new Author(6,
                "David",
                "Fresto",
                1985,
                "New Zeland",
                "Quiet boy from a remote province",
                true));

        authorRepository.save(new Author(7,
                "Mishel",
                "Fresto",
                1980,
                "New Zeland",
                "A brother of a quiet boy from a remote province",
                true));
        }

        public void check(){
            //Вывод на печать всего что есть в базе
            int l = 0;
            System.out.println("Извлечение из таблици всех записей");
            for (Author author : authorRepository.findAll()) {
                l++;
                System.out.print("Запись №" + l + ": ");
                System.out.println(author.toString());
            }
            l = 0;
            System.out.println("Извлечение из таблици записи по имени 'David': ");
            for (Author author : authorRepository.findAllByName("David")) {
                l++;
                System.out.print("Запись №" + l + ": ");
                System.out.println(author.toString());
            }

            l = 0;
            System.out.println("Извлечение из таблици записи по фамилии 'Fresto': ");
            for (Author author : authorRepository.findAllBySurname("Fresto")) {
                l++;
                System.out.print("Запись №" + l + ": ");
                System.out.println(author.toString());
            }

            l = 0;
            System.out.println("Извлечение из таблици записи по параметрам:" +
                    " год рождения, Имя, Фамилия (Omar Haiam, 1000): ");
            System.out.println(authorRepository.findByNameAndSurnameAndYearOfBirth("Omar",
                    "Haiam", 1000).toString());

            l = 0;
            System.out.println("Извлечение из таблици записи по году рождения 1985: ");
            for (Author author : authorRepository.findAllByYearOfBirth(1985)){
                l++;
                System.out.print("Запись №" + l + ": ");
                System.out.println(author.toString());
            }

            l = 0;
            System.out.println("Извлечение из таблици записи по стране происхождения: ");
            for (Author author : authorRepository.findAllByCitizenship("United States of America")){
                l++;
                System.out.print("Запись №" + l + ": ");
                System.out.println(author.toString());
            }
        }
    }
