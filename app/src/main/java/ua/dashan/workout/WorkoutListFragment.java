package ua.dashan.workout;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


//класс для отображения списка названий упражнений
public class WorkoutListFragment extends ListFragment {
    //Добавить слушателя к фрагменту.
    static interface WorkoutListListener{
        void itemClicked(long id);
    };
    private WorkoutListListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[]names=new String[Workout.workouts.length];
        for(int i=0;i<names.length;i++){
            //Создать массив строк с названиями комплексов упражнений
            names[i]=Workout.workouts[i].getName();
        }
        //Создать адаптер массива
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(inflater.getContext()//нельзя использовать this в Fragment, используем это
                ,android.R.layout.simple_list_item_1,names);
        //Связать адаптер массива со списковым представлением
        setListAdapter(adapter);
        return super.onCreateView(inflater,container,savedInstanceState);
    }
//Вызывается при присоединении фрагмента к активности.
    @Override
    public void onAttach(Activity activity) {//если не работает то вместо Context поставить Activity
        super.onAttach(activity);
        this.listener=(WorkoutListListener)activity;
    }
   // Сообщить слушателю о том,что на одном из вариантов ListView был сделан щелчок.
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(listener!=null){
            listener.itemClicked(id);
        }
    }
}
