package ua.dashan.workout;


public class Workout {
    private String name;
    private String description;
    public static final Workout[]workouts={
            new Workout("Тренировка 1","Бурпи 15 повторов, Киппинг 15 повторов, Подъемы ног 15 повторов"),
            new Workout("Тренировка 2","Бурпи с весом 15 повторов, Взрывные отжимания 15 повторов, Подъемы ног 15 повторов"),
            new Workout("Тренировка 3","Бурпи с весом 20 повторов, Бег 200 метров, Подъемы ног 15 повторов")
    };

    private Workout(String name,String description){
        this.name=name;
        this.description=description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
