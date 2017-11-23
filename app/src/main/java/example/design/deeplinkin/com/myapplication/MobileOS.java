package example.design.deeplinkin.com.myapplication;

import android.annotation.SuppressLint;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Guest User on 11/23/2017.
 */
@SuppressLint("ParcelCreator")
public class MobileOS extends ExpandableGroup<Phone> {

    public MobileOS(String title, List<Phone> items) {
        super(title, items);
    }
}
