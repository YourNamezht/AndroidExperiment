package com.akid.androidexperiment.program.program4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.akid.androidexperiment.R;

public class MyContextMenu extends AppCompatActivity {

    final static int CONTEXT_MENU_1 = Menu.FIRST;
    final static int CONTEXT_MENU_2 = Menu.FIRST+1;
    final static int CONTEXT_MENU_3 = Menu.FIRST+2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_context_menu);
        setTitle(R.string.program4_activity_name_4);

        textView = (TextView) findViewById(R.id.label);
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("快捷菜单标题");
        menu.add(0, CONTEXT_MENU_1, 0,"菜单子项1");
        menu.add(0, CONTEXT_MENU_2, 1,"菜单子项2");
        menu.add(0, CONTEXT_MENU_3, 2,"菜单子项3");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){
            case CONTEXT_MENU_1:
                textView.setText("菜单子项1");
                textView.setTextColor(getColor(R.color.qmui_config_color_blue));
                return true;
            case CONTEXT_MENU_2:
                textView.setText("菜单子项2");
                textView.setTextColor(getColor(R.color.qmui_config_color_blue));
                return true;
            case CONTEXT_MENU_3:
                textView.setText("菜单子项3");
                textView.setTextColor(getColor(R.color.qmui_config_color_blue));
                return true;
        }
        return false;
    }
}
