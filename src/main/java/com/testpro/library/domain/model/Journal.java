package com.testpro.library.domain.model;

/**
 * Created by Pigas on 11.05.2017.
 */
public final class Journal {
    public enum State {inSight, isGiven, isSpoiled, isUnderRestoration, isCommingSoon}         //Перечисление состояний (в наличии, на руках, испорчена, реставрируется, скоро поступит в библиотеку)

    private final long id;                      //ID
    private final Library forLib;               //Название библиотеки, которой принадлежит журнал
    private final Book book;                    //Название книги
    private final String dayTaken;              //Время когда взял на руки
    private final String dayReturn;             //Время когда вернул на руки
    private final Reeder reeder;                //Читатель
    private final State state;                  //Состояние

    public Journal(final long id, final Library forLib, final Book book, final String dayTaken,
                   final String dayReturn, final Reeder reeder, final State state) {
        this.id = id;
        this.forLib = forLib;
        this.book = book;
        this.dayTaken = dayTaken;
        this.dayReturn = dayReturn;
        this.reeder = reeder;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public Library getForLib() {
        return forLib;
    }

    public Book getBook() {
        return book;
    }

    public String getDayTaken() {
        return dayTaken;
    }

    public String getDayReturn() {
        return dayReturn;
    }

    public Reeder getReeder() {
        return reeder;
    }

    public State getState() {
        return state;
    }
}
