package com.example.opilane.menukings;


//see teeb King classi võimalikuks, võimaldab saada objectid kätte

import java.util.ArrayList;
import java.util.List;

//second part of the data resource, the class Kings makes King object available
public class Kings {
    //geting list
    private List<King> list = new ArrayList();

    //adding multidimensional array values into the list

    public Kings() {
        for (String[] arr : data)
            list.add(new King(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),arr[3]));
    }

    public List<King> getKings() {
        return list;
    }

    //our multidimensional array
//TODO: 2 kopeerisin sulle julmalt teksti siia, kui selle Henry VIII kirjelduse lahti teed siis näed, et hoolimata sellest et sul seal pikk romaan on, siis on seda võimalik skrollida (alertdialog võimaldab seda, ei pea ise midagi juurde leiutama).
    private static final String[][] data = {
            {"Henry VIII", "1509", "1547", "When Richard III fell at the Battle of Bosworth, his crown was picked up and placed on the head of Henry Tudor. He married Elizabeth of York and so united the two warring houses, York and Lancaster. He was a skillful politician but avaricious. The material wealth of the country increased greatly. During Henry’s reign playing cards were invented and the portrait of his wife Elizabeth has appeared eight times on every pack of cards for nearly 500 years. When Richard III fell at the Battle of Bosworth, his crown was picked up and placed on the head of Henry Tudor. He married Elizabeth of York and so united the two warring houses, York and Lancaster. He was a skillful politician but avaricious. The material wealth of the country increased greatly. During Henry’s reign playing cards were invented and the portrait of his wife Elizabeth has appeared eight times on every pack of cards for nearly 500 years.When Richard III fell at the Battle of Bosworth, his crown was picked up and placed on the head of Henry Tudor. He married Elizabeth of York and so united the two warring houses, York and Lancaster. He was a skillful politician but avaricious. The material wealth of the country increased greatly. During Henry’s reign playing cards were invented and the portrait of his wife Elizabeth has appeared eight times on every pack of cards for nearly 500 years.When Richard III fell at the Battle of Bosworth, his crown was picked up and placed on the head of Henry Tudor. He married Elizabeth of York and so united the two warring houses, York and Lancaster. He was a skillful politician but avaricious. The material wealth of the country increased greatly. During Henry’s reign playing cards were invented and the portrait of his wife Elizabeth has appeared eight times on every pack of cards for nearly 500 years."},
            {"Edward VI", "1547", "1553","jdoedoewjdoewidj"},
            {"Mary I", "1553", "1558","fjldkfjlekfjfdsl"},
            {"Elizabeth I", "1558", "1603","jfdwejfwlekfjwelkfjwelkfj"},
            {"James I", "1603", "1625","fjiwejfoiwejoiew"}
    };
}