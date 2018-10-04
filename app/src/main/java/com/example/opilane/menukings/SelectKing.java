package com.example.opilane.menukings;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class SelectKing extends AppCompatActivity {
//need kaks kontanti defineerivad menu itemid. peavad olema unikaalsed integerid
    public static final int MENU_NAME = Menu.FIRST + 1;
    public static final int MENU_TEXT = Menu.FIRST + 2;
    public static final int MENU_RESET = Menu.FIRST + 3;
    public static final int MENU_REMOVE = Menu.FIRST + 4;

    private List<King> kings ;
    private ListView view;
    private ArrayAdapter<King> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_king);
        view = findViewById(R.id.lstKings);
        reset();
        //registeerid listview komponendi context menuga
        registerForContextMenu(view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.add(Menu.NONE, MENU_NAME, Menu.NONE, "King");
        menu.add(Menu.NONE, MENU_TEXT, Menu.NONE, "Description");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        King king = kings.get(menuInfo.position);
        switch (item.getItemId()){
            case MENU_NAME:
                Toast.makeText(this, king.getKing(), Toast.LENGTH_LONG).show();
                return true;
            case MENU_TEXT:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(king.getName());
                builder.setMessage(king.getText());
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MENU_REMOVE, Menu.NONE, "remove");
        menu.add(Menu.NONE, MENU_RESET, Menu.NONE, "reset");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_RESET:
                reset();
                return true;
            case MENU_REMOVE:
                remove();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void remove(){
        SparseBooleanArray checkItems = view.getCheckedItemPositions();
        if (checkItems!= null){
            for (int i = checkItems.size()-1 ; i>0 ; --i){
                if (checkItems.valueAt(i)){
                    King king = kings.get(checkItems.keyAt(i));
                    adapter.remove(king);
                }
            }
        }
    }
    public void reset(){
        kings = (new Kings()).getKings();
        view.setAdapter(adapter = new ArrayAdapter<>(this, android.R.layout. simple_list_item_multiple_choice, kings));
    }
}