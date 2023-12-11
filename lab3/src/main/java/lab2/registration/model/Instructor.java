package lab2.model;

import java.util.List;

/**
 * Класс для информации о преподавателе
 */
public class Instructor extends Person {

    /**
     * Идентификаторы курсов, которые может вести преподаватель
     */
    List<Integer> canTeach;

    // TODO: добавить геттеры и сеттеры
    public List<Integer> getCanTeach() {
        return canTeach;
    }

    public void setCanTeach(List<Integer> canTeach) {
        this.canTeach = canTeach;
    }
}
