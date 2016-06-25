package ua.dashan.workout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements WorkoutListFragment.WorkoutListListener {

    @Override
    public void itemClicked(long id) {
       /* Получить ссылку на фрейм, содержащий WorkoutDetailFragment. Он будет существовать, если приложение выполняется
        на устройстве с большим экраном.*/
        View fragmentContainer=findViewById(R.id.frag_container);
        if (fragmentContainer!=null){
       /* Замена фрагмента во время выполнения происходит в виде тран-
                закции фрагмента — набора изменений, относящихся к фрагменту,
        которые должны применяться как единое целое.*/
        WorkoutDetailsFragment workoutDetailsFragment=new WorkoutDetailsFragment();
        //Создание транзакции фрагмента начинается с получения объекта FragmentTransaction от диспетчера фрагментов
        //beginTransaction() - Начало транзакции фрагмента
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        workoutDetailsFragment.setWorkout(id);
        transaction.replace(R.id.frag_container,workoutDetailsFragment);
       /* вызов метода addToBackStack() помещает транзакцию в стек возврата.
                Это делается для того, чтобы пользователь мог вернуться к предыдущему состоянию
        фрагмента нажатием кнопки Назад.*/
       /* Метод addToBackStack() получает один пара-
                метр — строку с именем, используемую для идентификации транзакции*/
       /* В большинстве случаев получать транзакцию вам не придется, поэтому
        при вызове передается null.*/
        transaction.addToBackStack(null);
        //закрепить транзакцию
        transaction.commit();}
        else {
           /* Если фрейм отсутствует, значит,приложение выполняется на устройстве
            с малым экраном. В этом случае следует запустить активность DetailActivity
            и передать ей идентификатор комплекса.*/
            Intent intent=new Intent(this,DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID,(int)id);
            startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Для получения ссылки на фрагмент следует сначала получить ссылку на диспетчера фрагментов ак-
                тивности при помощи метода getFragmentManager(). Затем метод
        findFragmentById() используется для получения ссылки на фрагмент*/
       // WorkoutDetailsFragment workoutDetailsFragment=(WorkoutDetailsFragment)getFragmentManager().findFragmentById(R.id.detail_frag);
       /* Приказываем WorkoutDetailFragment вывести подробную информацию о произвольно
        выбранном комплексе, чтобы убедиться в том, что все работает.*/
        //workoutDetailsFragment.setWorkout(1);

    }
}
