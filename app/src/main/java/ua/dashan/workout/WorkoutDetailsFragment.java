package ua.dashan.workout;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


//класс для отображения детальной инфы о упражнении
public class WorkoutDetailsFragment extends Fragment {
    //Идентификатор комплекса упражнений, выбранного пользователем.а
private long workoutId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            workoutId=savedInstanceState.getLong("workoutId");
        }else {
            //код для добавления секундомера(добавляем фрагмент в фрагмент)
            //Возвращает ссылку на диспетчера фрагментов для фрагмента
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            StopWatchFragment stopWatchFragment = new StopWatchFragment();
            //Заменить фрагмент во фрейме
            ft.replace(R.id.stopwatch_container, stopWatchFragment);
            ft.addToBackStack(null);
            //Выбрать стиль анимации перехода.
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            //Закрепить транзакцию
            ft.commit();
        }





        //Макет фрагмента назначается вызовом
        return inflater.inflate(R.layout.fragment_workout_details, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        /*Метод getView() получает корневой объект View фрагмента. Далее полученный
        объект используется для полуения ссылок на надписи, предназначенные для названия
        и описания комплекса упражнений.*/
        View view=getView();
        TextView title=(TextView)view.findViewById(R.id.textTitle);
        Workout workouts=Workout.workouts[(int)workoutId];
       title.setText( workouts.getName());
        TextView description=(TextView)view.findViewById(R.id.textDescription);
        description.setText(workouts.getDescription());

    }

    //Метод для присваивания идентификатора. Метод используется активностью для передачи значения иден-
    //тификатора фрагменту.
    public void setWorkout(long id ){
        this.workoutId=id;
    }

    @Override
    /*Сохранить значение workoutId в объекте savedInstanceState
    типа Bundle перед уничтожением фрагмента. Позднее сохра-
    ненное значение читается в методе onCreateView(). Это нужно чтобы запоминались данные при перевороте экрана*/
    public void onSaveInstanceState(Bundle outState) {
        outState.putLong("workoutId",workoutId);
    }
}
