package example.design.deeplinkin.com.myapplication;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by Guest User on 11/23/2017.
 */

public class PhoneViewHolder extends ChildViewHolder {

    private TextView phoneName;

    public PhoneViewHolder(View itemView) {
        super(itemView);

        phoneName = (TextView) itemView.findViewById(R.id.phone_name);
    }

    public void onBind(Phone phone, ExpandableGroup group) {
        phoneName.setText(phone.getName());
        if (group.getTitle().equals("Android")) {
            phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.up_arrow, 0, 0, 0);
        } else if (group.getTitle().equals("iOS")) {
            phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.up_arrow, 0, 0, 0);
        } else {
            phoneName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.up_arrow, 0, 0, 0);
        }
    }
}
