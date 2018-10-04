package com.example.opilane.menukings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    public static final int MENU_NAME = Menu.FIRST + 1;
    public static final int MENU_TEXT = Menu.FIRST + 2;
    public static final int MENU_NEXT = Menu.FIRST + 3;

    private List<King> kings = (new Kings()).getKings();
    private ListView view;
    private EditText from, to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        from = findViewById(R.id.txtfrom);
        to = findViewById(R.id.txtTo);
        view = findViewById(R.id.lstKings);

        disable(from);
        disable(to);

        view.setAdapter(new ArrayAdapter<King>(this, android.R.layout.simple_spinner_item, kings));
        //event handler that has another listener which is an interface that defines two methods
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                update(position);
            }
        });
        //registeerid listview komponendi context
        registerForContextMenu(view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.add(Menu.NONE, MENU_NAME, Menu.NONE, "King");
        menu.add(Menu.NONE, MENU_TEXT, Menu.NONE, "Description");
        menu.add(Menu.NONE, MENU_NEXT, Menu.NONE, "Next");

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
                //TODO:3 siit olid sul need kaks asja puudu, sellepärast ei kuvanud sul kirjelduse teksti vaid lihtsalt tühja alertdialog akent. Pead builder'iler ikkagi ütlema, et ta end kuvaks
                builder.show();
                return true;
            case MENU_NEXT:
                Intent intent=new Intent(MainActivity.this, SelectKing.class);
                startActivity(intent);
                return true;
        }
        return super.onContextItemSelected(item);
    }

    private void update(int position) {
        int a = kings.get(position).getFrom();
        int b = kings.get(position).getTo();
        from.setText(a == 0? "" : "" +a);
        to.setText(b==9999 ? "" : "" +b);
    }

    //disable method that'll disable both of the input fields so that user can't enter text
    private void disable(EditText view) {
        view.setOnKeyListener(null);
        view.setEnabled(false);
    }
}