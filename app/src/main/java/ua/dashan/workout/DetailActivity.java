package ua.dashan.workout;


import android.app.Activity;
import android.os.Bundle;


public class DetailActivity extends Activity {
    /*Если приложе-
        ние выполняется на телефоне, активность MainActivity
        должна запускать DetailActivity при помощи интента.
        Интент включает идентификатор комплекса упражнений,
        выбранного пользователем, в составе дополнительной
        информации. Активность DetailActivity должна пере-
        дать его фрагменту WorkoutDetailFragment при помощи
        метода setWorkout()*/
    public static final String EXTRA_WORKOUT_ID="id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //Получить ссылку на фрагмент.
        WorkoutDetailsFragment workoutDetailsFragment=(WorkoutDetailsFragment)getFragmentManager().findFragmentById(R.id.detail_frag);
        //Получить идентификатор комплекса, выбранного пользователем, из интента.
        int workoutId=(int)getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        //Передать идентификатор комплекса фрагменту
        workoutDetailsFragment.setWorkout(workoutId);
    }
}
